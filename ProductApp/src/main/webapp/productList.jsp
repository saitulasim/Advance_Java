<%@page import="com.sathya.ProductDao"  import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.0/dist/css/bootstrap.min.css" rel="stylesheet"></link>
<title>Product List</title>
</head>
<body>
<h1 class ="text-success text-conter"> List Of Available Products</h1>
<a href="add-product.html"class="btn btn-success" class ="text-success text italic"> Save Product</a>
<br>
<input  type="text" placeholder="Search">
<br>
<c:if test="${saveResult==1}">
<h2 class= "text-success text-center"> Data Inserted Successfully...</h2>
</c:if>
<br>
<c:if test="${deleteResult==1}">
<h2 class= "text-danger text-center"> Data Deleted Successfully...</h2>
</c:if>
<br>
<c:if test="${deleteResult==0}">
<h2 class= "text-danger text-center"> Data Delete Failed...</h2>
</c:if>
	<table class="table table-bordered table-striped" >
	<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Cost</th>
				<th>Product Brand</th>
				<th>Made In</th>
				<th>Manufacture Date</th>
				<th>Expiry Date</th>
				<th>Image</th>
				<th>Actions</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="<%= new ProductDao().getAllProducts() %>">
				<tr>
					<td>${product.proId}</td>
					<td>${product.proName}</td>
					<td>${product.proPrice}</td>
					<td>${product.proBrand}</td>
					<td>${product.proMadeIn}</td>
					<td>${product.proMfgDate}</td>
					<td>${product.proExpDate}</td>
					<td> <img alt="Product Image" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" style="max-width: 100px; max-height:100px">
					<td>
					<a class ="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete </a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
<!-- <td> <img alt="Product image" src="data:image/jpeg;base64,${product.imageWork}" style="max-width: 100px; max-height:100px"></td> -->