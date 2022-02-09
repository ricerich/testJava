<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>	   

	<%
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("id");
		String password = request.getParameter("passwd");
	%>
	<p>	아이디 : <%=userid%>
	<p>	비밀번호 : <%=password%>

	<p>이 페이지는 5초마다 새로고침 됩니다.     
		<%
			response.setIntHeader("Refresh", 50);
		%>
	<p>	<%=(new java.util.Date())%>
</body>
</html>