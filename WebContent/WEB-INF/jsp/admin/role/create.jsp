<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Add new Role </h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <s:form method="post" commandName="role" action="${pageContext.request.contextPath }/admin/role/create.html">
              <div class="box-body">
                <div class="form-group">                
                  <label for="txtproducerName">Name</label>
                  <s:input type="text" class="form-control" id="txtproducerName" path="name"></s:input>
                </div>
             
              </div>
              <!-- /.box-body -->				
              <div class="box-footer"><button type="submit" class="btn btn-primary" value="Save" >Create</button></div>
            </s:form>
          </div>