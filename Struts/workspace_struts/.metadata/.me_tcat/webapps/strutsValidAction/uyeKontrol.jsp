<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for UyeKontrolForm form</title>
	</head>
	<body>
		<html:form action="/uyeKontrol">
			password : <html:password property="password"/><html:errors property="password"/><br/>
			user : <html:text property="user"/><html:errors property="user"/><br/>
			<html:submit/><html:cancel/><p>
			<html:errors property="yanlisGiris"/>
		</html:form>
	</body>
</html>

