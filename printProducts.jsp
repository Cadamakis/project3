<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="my_css1.css" rel = "stylesheet" type = "text/css">
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>Product Print</h1><br></br>
		<h4><a href="<ip>/project3/Form.jsp">Click To Insert New Product</a></h4>
	</center>
    <div align="center">
        <table style="background-color:#00FF7F" border="1" cellpadding="5">
            <caption><h2>Products In Database</h2></caption>
            <tr>
				<th>Number</th>
                <th>Name</th>
                <th>Barcode</th>
                <th>Color</th>
                <th>Description</th>
            </tr>
            <c:forEach var="item" items="${prods}" varStatus = "loop">
                <tr>
					<td><c:out value = "${loop.index+1}"/><p></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.barcode}" /></td>
                    <td><c:out value="${item.color}" /></td>
                    <td><c:out value="${item.description}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
