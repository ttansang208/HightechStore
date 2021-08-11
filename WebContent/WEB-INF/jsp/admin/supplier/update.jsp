<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">Edit Supplier Information</h3>
	</div>
	<s:form method="post" commandName="supplier"
		action="${pageContext.request.contextPath }/admin/supplier/update.html">
		<div class="box-body">
			<div hidden="hidden">
				<s:input type="text" path="id" required="required"
					value="${supplier.id }" />
			</div>
			<div class="form-group">
				<label for="txtName">Name</label>
				<s:input type="text" path="name" required="required"
					class="form-control" id="txtName" value="${supplier.name }" />
			</div>
			<div class="form-group">
				<label for="txtaddress">Address</label>
				<s:input type="text" path="address" required="required"
					class="form-control" id="txtaddress" value="${supplier.address }" />
			</div>
			<div class="form-group">
				<label for="txtphoneNumber">Phone number</label>
				<s:input type="text" path="phoneNumber" required="required"
					class="form-control" id="txtphoneNumber"
					value="${supplier.phoneNumber }" />
			</div>
			<div class="form-group">
				<label>Status</label>
				<s:checkbox path="status" required="required"
					value="${supplier.status }" />
			</div>
		</div>
		<div class="box-footer">
			<a href="${pageContext.request.contextPath }/admin/supplier.html"><button
					class="btn btn-primary" onclick=" return confirm('Are you sure ?')">Update</button></a>
		</div>
	</s:form>
</div>
