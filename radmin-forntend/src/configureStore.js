import {createStore, applyMiddleware, compose} from 'redux'
import rootReducer from './reducers'
import createSagaMiddleware from 'redux-saga'
import rootSaga from './sagas'
import { loadingBarMiddleware } from 'react-redux-loading-bar'
import { createBrowserHistory } from 'history'
import { routerMiddleware } from 'connected-react-router'


const win = window;
const sagaMiddleware = createSagaMiddleware();
const middlewares = [loadingBarMiddleware()];
const history = createBrowserHistory()

let storeEnhancers;
if (process.env.NODE_ENV === 'production') {
    storeEnhancers = compose(
        applyMiddleware(routerMiddleware(history),...middlewares, sagaMiddleware)
    );
} else {
    storeEnhancers = compose(
        applyMiddleware(routerMiddleware(history),...middlewares, sagaMiddleware),
        (win && win.devToolsExtension) ? win.devToolsExtension() : (f) => f,
    );
}
export {history}
export default function configureStore(initialState = {}) {
    const store = createStore(rootReducer(history), initialState, storeEnhancers);
    sagaMiddleware.run(rootSaga);
    if (module.hot && process.env.NODE_ENV !== 'production') {
        // Enable Webpack hot module replacement for reducers
        module.hot.accept('./reducers', () => {
            const nextRootReducer = require('./reducers/index');
            store.replaceReducer(nextRootReducer);
        });
    }
    return store;
}
