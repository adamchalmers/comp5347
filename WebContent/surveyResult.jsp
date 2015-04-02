<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- This is the template of a jsp for displaying the result -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey Result -- JSTL</title>
<link rel="stylesheet" type="text/css" href="css/surveystyle.css" media="screen" />

</head>
<body>
<h3 style="color:${style};">${message}</h3>

<h5> For Female Respondents</h5>
<ul><c:forEach var="product" items="${productList}" varStatus="status">
	<li><strong>${product}</strong>: ${model.getPref(1, status.count-1)}</li>
</c:forEach></ul>

<h5> For Male Respondents</h5>
<ul><c:forEach var="product" items="${productList}" varStatus="status">
	<li><strong>${product}</strong>: ${model.getPref(0, status.count-1)}</li>
</c:forEach></ul>
${output}

</body>
</html>