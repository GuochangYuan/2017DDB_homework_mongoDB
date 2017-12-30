<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <title>505 error</title>
		<style>
		body {background: #f9fee8;margin: 0; padding: 20px; text-align:center; font-family:Arial, Helvetica, sans-serif; font-size:14px; color:#666666;}
		.error_page {width: 600px; padding: 50px; margin: auto;}
		.error_page h1 {margin: 20px 0 0;}
		.error_page p {margin: 10px 0; padding: 0;}		
		a {color: #9caa6d; text-decoration:none;}
		a:hover {color: #9caa6d; text-decoration:underline;}
		</style>
		 <script language="javascript">
				function showDetail()
				{
					var elm = document.getElementById('detail_system_error_msg');
					if(elm.style.display == '') {
						elm.style.display = 'none';
					}else {
						elm.style.display = '';
					}
				}
			</script>
</head>
 
<body class="login">
<%
		//Exception from JSP didn't log yet ,should log it here.
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		LogFactory.getLog(requestUri).error(exception.getMessage(), exception);
	%>
  <div class="error_page">
    <img alt="Kidmondo_face_sad" src="${ctx }commons/error.jpg" />
    <h1>We're sorry...</h1>
    <p>The page or journal you are looking for is be have errors.(500 错误了！)</p>
    <p><a href="${ctx}" onclick="history.back();">Return to the backpage</a> | <a href="#" onclick="showDetail();"> Print the error message </a></p>
  </div>
  <div id="detail_system_error_msg" style="display:none;text-align:left">
		<pre><%exception.printStackTrace(new java.io.PrintWriter(out));%></pre>
	</div>
</body>
</html>
