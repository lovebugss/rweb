import React from 'react';
import ReactDOM from 'react-dom';
import App from './containers/App';
import * as serviceWorker from './serviceWorker';
import {Provider} from 'react-redux';
import {AppContainer} from 'react-hot-loader';
import configureStore, {history} from './configureStore';
import {ConnectedRouter} from 'connected-react-router'
import "./index.css"

const store = configureStore();
ReactDOM.render(
    <AppContainer>
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <App />
            </ConnectedRouter>
        </Provider>
    </AppContainer>,
    document.getElementById('root'));
serviceWorker.unregister();
