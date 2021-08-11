<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<div class="box">
            <div class="box-header" align="center"><h2 > ROLE INDEX</h2>
            </div>            
            <!-- /.box-header -->
            <div class="box-body">
            <a href="${pageContext.request.contextPath }/admin/role/create.html"><button type="submit" class="badge bg-green">Add New</button> </a>
              <table id="example1" class="table table-bordered table-striped" >
                <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th  style="text-align: center;">Option</th>
                </tr>
              
                </thead>
                  <c:forEach var="r" items="${listRole }"> 
                <tbody>                           
                <tr>               
                  <td>${r.id }</td>
                  <td>${r.name }</td>
                  <td  style="text-align: center;">
                  	<a href="${pageContext.request.contextPath }/admin/role/delete/${r.id }.html" onclick="return confirm('Are you sure ?') ">
                  	<span class="badge bg-red">Delete</span> </a> || 
                  	<a href="${pageContext.request.contextPath }/admin/role/update/${r.id }.html">	<span class="badge bg-yellow">Edit</span> </a> || 
                  	<a href="${pageContext.request.contextPath }/admin/role/detail/${r.id }.html">	<span class="badge bg-blue">Detail</span>  </a>               		
                  </td>                 
                </tr>
             
                </tbody> 
                    </c:forEach>         
              </table>
            </div>
            <!-- /.box-body -->
          </div>
