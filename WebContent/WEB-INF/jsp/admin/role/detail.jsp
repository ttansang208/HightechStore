<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Role Detail</h3>
            </div>
            <form role="form">
              <div class="box-body">
              <div class="form-group">
                  <label for="txtproducerName">ID</label>
                  <input type="text" class="form-control" readonly="readonly" value="${role.id }">
                </div>
                <div class="form-group">
                   <label for="txtproducerAddress">Name</label>             
                  <input type="text" class="form-control" readonly="readonly" value="${role.name }"/>                        
                </div>
                </div>             
              <!-- /.box-body -->				
              
            </form>
            <div class="box-footer">              
                <a href="${pageContext.request.contextPath }/admin/role.html"><button class="btn btn-default">Back</button></a>
              </div>
          </div>