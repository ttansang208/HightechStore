<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<title>Create</title>
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Create new Payment </h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <s:form method="post" commandName="payment"
            action="${pageContext.request.contextPath }/admin/payment/create.html">
              <div class="box-body">
                <div class="form-group">                
                  <label for="txtpayment">Payment</label>
                  <s:input type="text" class="form-control" path="payment" required="required" id="txtpayment" placeholder="Payment"/>
                </div>
                </div>
                <div class="box-footer">
                <a href="${pageContext.request.contextPath }/admin/payment/index.html" onclick="return confirm('Create new producer ?') "><button type="submit" class="btn btn-primary" value="Save">Create</button></a>
                <a href="${pageContext.request.contextPath }/admin/payment/index.html" ><button class="btn btn-default">Cancel</button></a>
              </div>
                </s:form>
    </div>