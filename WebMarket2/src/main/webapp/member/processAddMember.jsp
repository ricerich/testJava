<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id 		= request.getParameter("id");
	String password = request.getParameter("password");
	String name		= request.getParameter("name");
	String gender	= request.getParameter("gender");
	String year 	= request.getParameter("birthyy");
	String month 	= request.getParameterValues("birthmm")[0];
	String day 		= request.getParameter("birthdd");
	
	String mail1 	= request.getParameter("mail1");
	String mail2 	= request.getParameterValues("mail2")[0];
	
	String phone 	= request.getParameter("phone");
	String address 	= request.getParameter("address");
	
	String birth 	= year + "/" + month + "/" + day;
	String mail 	= mail1 + "@" + mail2;

	Date currentDatetime = new Date(System.currentTimeMillis());
	java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
	java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
%>

<sql:setDataSource var="dataSource"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	driver="oracle.jdbc.driver.OracleDriver" user="webmarket" password="webmarket" />

<c:catch var="e">
	<sql:update dataSource="${dataSource}" var="resultSet">
	   INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
	    <sql:param value="<%=id%>" />
		<sql:param value="<%=password%>" />
		<sql:param value="<%=name%>" />
		<sql:param value="<%=gender%>" />
		<sql:param value="<%=birth%>" />
		<sql:param value="<%=mail%>" />
		<sql:param value="<%=phone%>" />
		<sql:param value="<%=address%>" />
		<sql:param value="<%=timestamp%>" />
	</sql:update>
</c:catch>

<c:if test="${resultSet>=1}">
	<c:redirect url="resultMember.jsp?msg=1" />
</c:if>

<c:if test="${e != null }" ><!-- 실제 출력되는지 확인 -->

	<c:redirect url="resultMember.jsp?msg=3" />

</c:if>





<%-- <c:if test="${resultSet == null}"> --%>
<%-- 	<c:redirect url="resultMember.jsp?msg=3" /> --%>
<%-- </c:if> --%>

<%-- <c:choose> --%>
<%-- 	<c:when test="${resultSet>=1}"> --%>
<%-- 		<c:redirect url="resultMember.jsp?msg=1" /> --%>
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<%-- 		<c:redirect url="resultMember.jsp?msg=3" /> --%>
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>




