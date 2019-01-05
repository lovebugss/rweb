项目目录结构：

````
radmin  
  |- public  
  |- src  
  |   |- components(应用级别的通用组件)  
  |   |- redux   
  |   |- components   
            feature1/
      components/  (功能拆分出的专用组件)
      feature1.js  (容器组件)
      index.js     (feature1对外暴露的接口)
  redux/
    index.js (combineReducers)
    module1.js (reducer, action types, actions creators)
    module2.js (reducer, action types, actions creators)
  index.js
