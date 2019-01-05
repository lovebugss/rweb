/**
 * Created by renjp on 2018/12/26.
 */
const {injectBabelPlugin} = require('react-app-rewired');
const rewireLess = require('react-app-rewire-less');

module.exports = function override(config, env) {
    config = injectBabelPlugin(
        ['import', {libraryName: 'antd', libraryDirectory: 'es', style: true}],
        config,
    );
    config = rewireLess.withLoaderOptions({
         modifyVars: {"@primary-color": "#40baff",
             "@box-shadow-base":"0 2px 8px #FFC25B"},
        javascriptEnabled: true,
    })(config, env);
    return config;
};