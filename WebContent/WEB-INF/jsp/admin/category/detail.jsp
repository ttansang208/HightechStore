<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">Category Detail</h3>
	</div>
	<form role="form">
		<div class="box-body">
			<div class="form-group">
				<label for="txtproducerName">ID</label> <input type="text"
					class="form-control" readonly="readonly" value="${category.id }">
			</div>
			<div class="form-group">
				<label for="txtproducerAddress">Parent Name</label> <input type="text"
					class="form-control" readonly="readonly" value="${category.category.name }" />
			</div>
			<div class="form-group">
				<label for="txtproducerAddress">Name</label> <input type="text"
					class="form-control" readonly="readonly" value="${category.name }" />
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<a href="${pageContext.request.contextPath }/admin/category.html"><input
				type="submit" class="btn btn-default" value="Back"></a>
		</div>
	</form>
</div>