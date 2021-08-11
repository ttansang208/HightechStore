<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="icon"
	href="${pageContext.request.contextPath }/assets/favicon.ico"
	type="image/x-icon">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/css/bootstraps/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/dist/css/AdminLTE.min.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/dist/css/skin-blue.min.css">
	
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/dist/css/skins/skin-blue.min.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/morris.js/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/jvectormap/jquery-jvectormap.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/css/bootstraps/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/css/bootstraps/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="${pageContext.request.contextPath }/admin/index.html"
				class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
				class="logo-mini"><b>Hide</b></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b><i class="fa fa-home"></i> High
						Tech Store</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>

				<c:set var="s" value="0"></c:set>
				<div class="navbar-custom-menu">
					<c:forEach var="p" items="${sessionScope.imports }">
						<c:if test="${p.product.id != null }">
							<c:set var="s" value="${s+1 }"></c:set>
						</c:if>
					</c:forEach>
					<c:if test="${s != 0 }">
						<ul class="nav navbar-nav">
							<li><a
								href="${pageContext.request.contextPath }/admin/import/temp.html"><i
									class="fa fa-exchange fa-2x"></i></a></li>
						</ul>
					</c:if>
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/j_spring_security_logout" />"><i
								class="fa fa-sign-out fa-2x" aria-hidden="true" title="Logout"></i></a></li>
					</ul>

				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar" style="height: auto;">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img
							src="${pageContext.request.contextPath }/assets/user/images/UnknownProfile.png"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${pageContext.request.userPrincipal.name}</p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>

				<!-- sidebar menu: : style can be found in sidebar.less -->

				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">MAIN NAVIGATION</li>

					<li><a
						href="${pageContext.request.contextPath }/admin/product.html">
							<i class="fa fa-television"></i> <span>Product</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/superadmin/account.html">
							<i class="fa fa-user-circle"></i> <span>Account</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/admin/import.html">
							<i class="fa fa-edit"></i> <span>Import</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/admin/orders.html">
							<i class="fa fa-laptop"></i> <span>Order</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>


					<li><a
						href="${pageContext.request.contextPath }/admin/photo.html"> <i
							class="fa fa-file-image-o"></i> <span>Product Photo</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/admin/category.html">
							<i class="fa fa-book"></i> <span>Category</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<a href="${pageContext.request.contextPath }/admin/producer.html">
						<li><i class="fa fa-industry"></i> <span>Producer</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a>

					<li><a
						href="${pageContext.request.contextPath }/admin/supplier.html">
							<i class="fa fa-truck"></i> <span>Supplier</span> <span
							class="pull-right-container"> </span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/admin/payment.html">
							<i class="fa fa-money"></i> <span>Payment</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/admin/contact.html">
							<i class="fa fa-phone"></i> <span>Contact</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

					<li><a
						href="${pageContext.request.contextPath }/admin/role.html"> <i
							class="fa fa-users"></i> <span>Role</span> <span
							class="pull-right-container"> <i class=""></i>
						</span>
					</a></li>

				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content">

				<tiles:insertAttribute name="admin_content"></tiles:insertAttribute>


			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 1.0.0
			</div>
			<strong>Copyright &copy; 2018 <a
				href="${pageContext.request.contextPath }/home.html">High Tech
					Store</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-user bg-yellow"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Frodo Updated His
										Profile</h4>

									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Nora Joined Mailing
										List</h4>

									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Cron Job 254
										Executed</h4>

									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Update Resume <span class="label label-success pull-right">95%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Laravel Integration <span
										class="label label-warning pull-right">50%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Back End Framework <span class="label label-primary pull-right">68%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Allow mail
								redirect <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Expose author
								name in posts <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Show me as
								online <input type="checkbox" class="pull-right" checked>
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Turn off
								notifications <input type="checkbox" class="pull-right">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Delete chat
								history <a href="javascript:void(0)" class="text-red pull-right"><i
									class="fa fa-trash-o"></i></a>
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/css/bootstraps/dist/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/raphael/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/admin/morris.js/morris.min.js"></script>
	<!-- Sparkline -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/jquery-knob/dist/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/moment/min/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/admin/css/bootstraps/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- datepicker -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/css/bootstraps/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script
		src="d${pageContext.request.contextPath }/assets/admin/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="${pageContext.request.contextPath }/assets/admin/dist/js/demo.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/admin/jquery/password.js"></script>
</body>
</html>
