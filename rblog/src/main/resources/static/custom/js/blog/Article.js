//@ sourceURL=article.js;
/**
 * Created by r9796 on 2018/3/29.
 */
var Article = function () {
   function  appentHtml(id,pageNum) {
       if(!id){
           return
       }
       if(!pageNum){
           pageNum = 1;
       }
      //var temp = "";
       $.ajax({
           url: "api/article/all",
           data: "pageNumber="+pageNum,
           dataType: "html",
           success: function (data) {
               var d = JSON.parse(data)
               var arr = d.dataList;
               var temp = "";
               for (var i = 0;i<arr.length;i++){
                  temp  += "<div class=\"article white\">\n" +
                       "        <!-- 标题-->\n" +
                       "        <h2 class=\"article_title\">"+ arr[i].title+"</h2>\n" +
                       "        <div class=\"article_bar\">\n" +
                       "            <div class=\"article_tag\">\n" +
                       "                <span class=\"original\">"+arr[i].original+"</span>\n" +
                       "                <span class=\"time\"><i class=\"glyphicon glyphicon-calendar\"></i>"+arr[i].createDate+"</span>\n" +
                       "                <span class=\"author\"><i class=\"glyphicon glyphicon-user\"></i>"+arr[i].createBy+" </span>\n" +
                       "                <span class=\"tags\"><i class=\"glyphicon glyphicon-tags\"></i>"+arr[i].tags+" </span>\n" +
                       "            </div>\n" +
                       "        </div>\n" +
                       "        <div class=\"article_content\">" +
                       "        <p class=\"text\">"+arr[i].content+"</p>" +
                       "</div>\n" +
                       "    </div>";
               }
               var t =  $("#" + id).html();
               temp = temp +t;
               $("#" + id).html(temp);
           },
           // beforeSend: function (XMLHttpRequest) {
           //     // 显示遮罩层
           //     Metronic.blockUI({target: '.' + classAttr, animate: true});
           // },
           // complete: function (XMLHttpRequest, textStatus) {
           //     //请求结束方法增强处理  ,隐藏遮罩层
           //     Metronic.unblockUI('.' + classAttr);
           //     //主页面默认显示位置
           //     $(".page-footer").find(".icon-arrow-up").click();
           //     $("body").css("overflow", "auto");
           // },
           error: function (response) {
               $("." + id).html(response.responseText);
           }
       });

   }

    return{
        initArticleList:function (id,num) {
            appentHtml(id,num);
        }
    }
}();