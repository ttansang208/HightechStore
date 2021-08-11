<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">Account Detail</h3>
	</div>
	<!-- /.box-header -->
	<!-- form start -->
<s:form method="post" commandName="account"
            action="${pageContext.request.contextPath }/admin/account/create.html">
		<div class="box-body">
			<div class="form-group">
					<label for="txtpayment">userName</label>
				<s:input type="text" path="userName" required="required"
					class="form-control" id="txtpayment" value="${account.userName }" />
			</div>
			<div class="form-group">
				<label>Password</label>
				<s:input type="text" path="password" required="required"
					class="form-control"  value="${account.password }" />
			</div>
			<div class="form-group">
				<label>name</label>
				<s:input type="text" path="name" required="required"
					class="form-control"  value="${account.name }" />
			</div>
			<div class="form-group">
				<label>address</label>
				<s:input type="text" path="address" required="required"
					class="form-control"  value="${account.address }" />
			</div>
			<div class="form-group">
				<label>phoneNumber</label>
				<s:input type="text" path="phoneNumber" required="required"
					class="form-control"  value="${account.phoneNumber }" />
			</div>
			<div class="form-group">
				<label>email</label>
				<s:input type="text" path="email" required="required"
					class="form-control"  value="${account.email }" />
			</div>
			<div class="form-group">
				<label>joinTime</label>
				<s:input type="text" path="joinTime" required="required"
					class="form-control"  value="${account.joinTime }" />
			</div>
			<div class="form-group">
				<label>photo</label>
				<s:input type="text" path="photo" required="required"
					class="form-control"  value="${account.photo }" />
			</div>			
			<div class="form-group">
				<label>enabled</label>
				<s:input type="text" path="enabled" required="required"
					class="form-control"  value="${account.enabled }" />
			</div>
			</div>
	</s:form>
</div>
<div class="box-footer">
	<a href="${pageContext.request.contextPath }/admin/account.html"><button
			class="btn btn-primary">Back</button></a>
</div>