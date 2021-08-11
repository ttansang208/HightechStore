<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">New Category</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
	<form method="post">
		<div class="box-body">
			<div class="form-group">
				<label>Parent Category</label>
				<select name="parent" >
				<option value="" ></option>
					<c:forEach var="p" items="${pr }">
						<option value="${p.id }">${p.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="txtproducerName">Name</label> <input type="text"
					class="form-control" name="Name"/>
			</div>

		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<input type="submit" class="btn btn-primary" value="Save"
				formaction="${pageContext.request.contextPath }/admin/category/create.html">
			<input type="submit" value="Cancel" class="btn btn-default"
				formaction="${pageContext.request.contextPath }/admin/category.html">
		</div>
	</form>
</div>