<%@ page contentType="text/html; charset=utf-8"%>
<%@ page errorPage="errorPage_error.jsp"%>
<html>
<head>
<title>Exception</title>
</head>
<body>

	<% 
// 		String str1;
// 		if(request.getParameter("name") == null )
// 			str1 = "";	
// 		else
// 			str1 = request.getParameter("name");

		
		//1줄 요약
		String str1 = (request.getParameter("name") == null) ? "" : request.getParameter("name");
	%>


	name 파라미터 : <%= str1.toUpperCase()%>
</body>
</html>