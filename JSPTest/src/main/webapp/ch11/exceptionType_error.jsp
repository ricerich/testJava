<%@ page contentType="text/html; charset=utf-8"%>
<%@ page isErrorPage="true" %>
<html>
<head>
<title>Exception</title>
</head>
<body>
	exception type  오류가 발생하였습니다.
	<p>	예외 : <%=exception%>
	<p>	toString() : <%=exception.toString()%>
	<p>	getClass().getName() :	<%=exception.getClass().getName()%>
	<p>	getMessage() :	<%=exception.getMessage()%>
</body>
</html>