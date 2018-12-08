
var ren_index = function () {
    var editor;
    function getTime(clazz){
            var time = new Date();//获取系统当前时间
            var year = time.getFullYear();
            var month = time.getMonth()+1;
            var date= time.getDate();//系统时间月份中的日
            var day = time.getDay();//系统时间中的星期值
            var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
            var week = weeks[day];//显示为星期几
            var hour = time.getHours();
            var minutes = time.getMinutes();
            var seconds = time.getSeconds();
           // console.log(seconds);
            if(month<10){
                month = "0"+month;
            }
            if(date<10){
                date = "0"+date;
            }
            if(hour<10){
                hour = "0"+hour;
            }
            if(minutes<10){
                minutes = "0"+minutes;
            }
            if(seconds<10){
                seconds = "0"+seconds;
            }
            //var newDate = year+"年"+month+"月"+date+"日"+week+hour+":"+minutes+":"+seconds;
           var time = year+"年"+month+"月"+date+"日"+week+hour+":"+minutes+":"+seconds;
            $("."+clazz).html(time);
    }
    /**
     * @author tugenhua
     * @email tugenhua@126.com
     * 一行一行文字向上滚动js
     * 运用了Jquery中的animate动画方法
     * 运用了一个小技巧 滚动的高度和每个li的高度一样
     * 先找到外层ul的容器 然后相对于外层的容器进行向上滚动 ul没有设置他的高度 默认情况下是n个li×li的高度 向上是marginTop： -li.height(每个li的高度);
     * 当滚动到最后一个li时候 那么最外层的容器应该滚动到0了 那么我就把第一个li加到ul里面去 这样就实现了循环滚动
     * 而不会滚动到最后一个就停止下来了
     */
    function autoScroll(obj){
        $(obj).find(".list").animate({
            marginTop : "-20px"
        },1000,function(){
            $(this).css({marginTop : "0px"}).find("li:first").appendTo(this);
        })
    }
    function initEditorMd(clazz) {

        editor = editormd(clazz, {
            width: "100%",
            atLink    : false,//禁用@链接
            emailLink : false,//禁用email
            height: 640,
            syncScrolling: "single",
            path: "/editor/lib/",
            saveHTMLToTextarea: true
        });
    }
    function initSaveBtn(clazz) {
        $('#'+clazz).click(function () {
            var title = $(".input-file-title").val();
            var content = editor.getHTML();
            var tags = $(".input-file-tags").val();;
            var data = {
                title:title,
                content:content,
                tags:tags
            }
            console.log(editor.getHTML())
            $.ajax({
                url: "/article/insert",
                method:'POST',
                data:data,
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }, success: function (data) {
                    try {
                        if(data.code == 0){
                           // layer.alert("保存成功");
                            window.location.href="/article/"+data.data;
                        }
                        if(fn != null )fn.call(this, data);
                    } catch (exception) {
//                                alert(data);
                    }
                }
            });
        })
    }

    return{
        initTime:function (clazz) {
            getTime(clazz);
            setTimeout('ren_index.initTime("DateTime")',1000)
        },
        CanvasParticle:function () {
            //配置背景粒子
            var config = {
                vx : 7, //小球x轴速度,正为右，负为左
                vy : 7, //小球y轴速度
                height : 2, //小球高宽，其实为正方形，所以不宜太大
                width : 2,
                count : 200, //点个数
                color : "121, 162, 185", //点颜色
                stroke : "130,255,255", //线条颜色
                dist : 6000, //点吸附距离
                e_dist : 20000, //鼠标吸附加速距离
                max_conn : 10
                //点到点最大连接数
            };
            //调用
            CanvasParticle(config);
        },
//         initAjax:function(classAttr){
//             $('a').click(function () {
//                 $.ajax({
//                     url: this.href,
//                     error: function (XMLHttpRequest, textStatus, errorThrown) {
//                         alert(XMLHttpRequest.responseText);
//                     }, success: function (data) {
//                         try {
//                             $("." + classAttr).html(data);
//                             if(fn != null )fn.call(this, data);
//                         } catch (exception) {
// //                                alert(data);
//                         }
//                     }
//                 });
//                 return false;
//             });
//         },
        initAutoScroll:function(clazz){
            autoScroll("."+clazz);
            setInterval('ren_index.initAutoScroll("scroll")',5000)
        },
        initEditorMd:function (clazz) {

            initEditorMd(clazz);
        },
        initSaveBtn:function(clazz){
            initSaveBtn(clazz);

        }
    }
}()