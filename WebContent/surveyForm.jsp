<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumer Next Mobile Survey -- JSTL and EL</title>
<link rel="stylesheet" type="text/css" href="css/surveystyle.css" media="screen" />
</head>
<body>
<h2>Welcome to the Mobile Purchashing Survey</h2>
<form method = "POST" action="survey">
<h4>Your Gender: </h4>

<label>
<input type="radio" name="gender" value=1 checked="checked"/>
Female
</label> <br />

<label>
<input type="radio" name="gender" value=0 />
Male
</label> <br />

<h4>What would be your next mobile?</h4>
<c:forEach var="product" items= "${applicationScope.productList}" 
	varStatus="productCount">
<label>
	<input type="radio" name="vote" value="${productCount.count-1}"  />
	${product}
</label> <br />
</c:forEach>


<input type="submit" value="Submit Vote" />
<input type="reset" value="Clear Vote Form" />
</form>

</body>
</html>