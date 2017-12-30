<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.vma.code.domain.Tmenu"%>
<%@page import="com.vma.code.util.SystemContants"%>
<%@page import="com.vma.code.domain.HyUser"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=path%>/css/common.css">
  <link rel="stylesheet" href="<%=path%>/css/style.css">
  <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/jquery.SuperSlide.js"></script>
  <script type="text/javascript">
  $(function(){
      $(".sideMenu").slide({
         titCell:"h3", 
         targetCell:"ul",
         defaultIndex:0, 
         effect:'slideDown', 
         delayTime:'500' , 
         trigger:'click', 
         triggerTime:'150', 
         defaultPlay:true, 
         returnDefault:false,
         easing:'easeInQuint',
         endFun:function(){
              scrollWW();
         }
       });
      $(window).resize(function() {
          scrollWW();
      });
      
      $("li").click(function(){
      	$("li").removeAttr("class");
      	$(this).attr("class","on");
      });
  });
  function scrollWW(){
    if($(".side").height()<$(".sideMenu").height()){
       $(".scroll").show();
       var pos = $(".sideMenu ul:visible").position().top-38;
       $('.sideMenu').animate({top:-pos});
    }else{
       $(".scroll").hide();
       $('.sideMenu').animate({top:0});
       n=1;
    }
  } 

var n=1;
function menuScroll(num){
  var Scroll = $('.sideMenu');
  var ScrollP = $('.sideMenu').position();
  /*alert(n);
  alert(ScrollP.top);*/
  if(num==1){
     Scroll.animate({top:ScrollP.top-38});
     n = n+1;
  }else{
    if (ScrollP.top > -38 && ScrollP.top != 0) { ScrollP.top = -38; }
    if (ScrollP.top<0) {
      Scroll.animate({top:38+ScrollP.top});
    }else{
      n=1;
    }
    if(n>1){
      n = n-1;
    }
  }
}

$(function(){
	var initA = $("li").eq(0).find("a").eq(0);
	var a_href = $(initA).attr("href");
	$("#rightMain").attr("src",a_href);
	$("li").removeAttr("class");
    $("li").eq(0).attr("class","on");
});
  </script>
  <title>后台首页</title>
</head>
<body>
    <div class="top">
      <div id="top_t"> 
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
            
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="#" id="hp">&nbsp;</a>
              <a href="#" id="gy">&nbsp;</a>
              <a href="<%=path%>/security/out" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
              <%=((HyUser)session.getAttribute(SystemContants.LOGIN_USER_KEY)).getRealName()%>
            </div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">&nbsp;</div>
      </div>
    </div>
    <div class="side">
        <div class="sideMenu" style="margin:0 auto">
          <%
          List<Tmenu> menuList = (List<Tmenu>)request.getAttribute("menuList");
          for(int i = 0;i<menuList.size();i++){
           %>
           	<h3> <%=menuList.get(i).getMenuName()%></h3>
           	<ul>
           	<%
           		 List<Tmenu> sonList = menuList.get(i).getSonList();
           		 for(int j=0;j<sonList.size();j++){
           	 %>
           	 	 <li><a style="color: black;" href="<%=path%>/<%=sonList.get(j).getMenuUrl() %>" target="right"><%=sonList.get(j).getMenuName() %></a></li>
           	 <%} %>
           	</ul>
           <%} %>
       </div>
    </div>
    <div class="main">
       <iframe name="right" id="rightMain" src="https://www.baidu.com" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
    </div>
    <div class="bottom">
      <div id="bottom_bg">&nbsp;</div>
    </div>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
</body>

</html>
