<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="box">

	<div class="box-header" align="center">
		<h2>PRODUCT DATA TABLE</h2>
	</div>
	<!-- /.box-header -->
	<jsp:useBean id="pagedListHolder" scope="request"
		type="org.springframework.beans.support.PagedListHolder" />
	<c:url value="/admin/product.html" var="pagedLink">
		<c:param name="ph" value="~" />
	</c:url>
	<div class="box-body">
		<a
			href="${pageContext.request.contextPath }/admin/product/create.html">
			<button class="badge bg-green">Add New</button> </a>
			<br><br>
				<form method="post" action="${pageContext.request.contextPath }/admin/product/search.html">
             <button style="width: 85px; height: 27px;" class="fa fa-search">Search</button>
            <input type="text" name="keyword">	${result }
            <br>
            <br>
		<table id="example1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Category</th>
					<th>Producer</th>
					<th>quantity</th>
					<td>Status</td>
					<th>price</th>
					<th style="text-align: center;">Option</th>
				</tr>

			</thead>
			<c:forEach var="p" items="${pagedListHolder.pageList }">
				<tbody>
					<tr>
						<td>${p.id }</td>
						<td>${p.name }</td>
						<td>${p.category.name }</td>
						<td>${p.producer.name }</td>
						<td>${p.quantity }</td>
						<td>${p.status }</td>
						<td>${p.price }</td>
						<td style="text-align: center;"><a
							href="${pageContext.request.contextPath }/admin/product/update/${p.id }.html">
								<span class="badge bg-yellow">Edit</span>
						</a> || <a
							href="${pageContext.request.contextPath }/admin/product/detail/${p.id }.html">
								<span class="badge bg-blue">Detail</span>
						</a>|| <a
							href="${pageContext.request.contextPath }/admin/import/imports/${p.id }.html">
								<span class="badge bg-green">Import</span>
						</a></td>
					</tr>

				</tbody>
			</c:forEach>
		</table>
		</form>
	</div>
	
	<tg:paging pagedListHolder="${pagedListHolder}"
		pagedLink="${pagedLink}" />
	<!-- /.box-body -->
</div>
