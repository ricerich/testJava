<%@ page contentType="text/html; charset=utf-8"%>
<%@ page errorPage="exception_error.jsp"%>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		
		if(b == 0)
		{
			out.println("0으로 나눌수 없어요!");
		}
		else
		{
			int c = a / b;
			out.print(num1 + " / " + num2 + " = " + c);	
		}
			
		
	%>
</body>
</html>
