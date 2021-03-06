<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
<meta name="description"
	content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
<meta name="robots" content="noindex,nofollow">
<title>admin</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/ample-admin-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="plugins/images/favicon.png">
<!-- Custom CSS -->
<link href="plugins/bower_components/chartist/dist/chartist.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
<!-- Custom CSS -->
<link href="otherFiles/css/style.min.css" rel="stylesheet">
</head>
<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<!--  <div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>-->
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-navbarbg="skin5">
			<jsp:include page="Header.jsp"/>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="leftSideBar.jsp"/>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!--  <div class="page-breadcrumb bg-white">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Dashboard</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<div class="d-md-flex">
							<ol class="breadcrumb ms-auto">
								<li><a href="#" class="fw-normal">Dashboard</a></li>
							</ol>
							<a href="https://www.wrappixel.com/templates/ampleadmin/"
								target="_blank"
								class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Upgrade
								to Pro</a>
						</div>
					</div>
				</div>
			</div>-->
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Three charts -->
				<!-- ============================================================== -->
				<div class="row justify-content-center">
					<div class="col-lg-4 col-md-12">
						<div class="white-box analytics-info">
							<h3 class="box-title">Total Visit</h3>
							<ul class="list-inline two-part d-flex align-items-center mb-0">
								<li>
									<div id="sparklinedash">
										<canvas width="67" height="30"
											style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
									</div>
								</li>
								<li class="ms-auto"><span class="counter text-success">659</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12">
						<div class="white-box analytics-info">
							<h3 class="box-title">Total Page Views</h3>
							<ul class="list-inline two-part d-flex align-items-center mb-0">
								<li>
									<div id="sparklinedash2">
										<canvas width="67" height="30"
											style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
									</div>
								</li>
								<li class="ms-auto"><span class="counter text-purple">869</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12">
						<div class="white-box analytics-info">
							<h3 class="box-title">Unique Visitor</h3>
							<ul class="list-inline two-part d-flex align-items-center mb-0">
								<li>
									<div id="sparklinedash3">
										<canvas width="67" height="30"
											style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas>
									</div>
								</li>
								<li class="ms-auto"><span class="counter text-info">911</span>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- PRODUCTS YEARLY SALES -->
				<!-- ============================================================== -->
				
				<!-- ============================================================== -->
				<!-- Recent Comments -->
				<!-- ============================================================== -->
				<div class="row">
					<!-- .col -->
					<div class="col-md-12 col-lg-8 col-sm-12">
						<div class="card white-box p-0">
							<div class="card-body">
								<h3 class="box-title mb-0">Recent Comments</h3>
							</div>
							<div class="comment-widgets">
								<!-- Comment Row -->
								<div class="d-flex flex-row comment-row p-3 mt-0">
									<div class="p-2">
										<img src="plugins/images/users/varun.jpg" alt="user"
											width="50" class="rounded-circle">
									</div>
									<div class="comment-text ps-2 ps-md-3 w-100">
										<h5 class="font-medium">Ayman Abouhali</h5>
										<span class="mb-3 d-block">Ziad bougrine is simply dummy
											text of the printing and type setting industry.It has
											survived not only five centuries. </span>
										<div class="comment-footer d-md-flex align-items-center">
											<span class="badge bg-primary rounded">Pending</span>

											<div class="text-muted fs-2 ms-auto mt-2 mt-md-0">April
												14, 2021</div>
										</div>
									</div>
								</div>
								<!-- Comment Row -->
								<div class="d-flex flex-row comment-row p-3">
									<div class="p-2">
										<img src="plugins/images/users/genu.jpg" alt="user" width="50"
											class="rounded-circle">
									</div>
									<div class="comment-text ps-2 ps-md-3 active w-100">
										<h5 class="font-medium">Ziad bougrine</h5>
										<span class="mb-3 d-block">Ayman abouhali is simply dummy
											text of the printing and type setting industry.It has
											survived not only five centuries. </span>
										<div class="comment-footer d-md-flex align-items-center">

											<span class="badge bg-success rounded">Approved</span>

											<div class="text-muted fs-2 ms-auto mt-2 mt-md-0">April
												14, 2021</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="card white-box p-0">
							<div class="card-heading">
								<h3 class="box-title mb-0">Chat Listing</h3>
							</div>
							<div class="card-body">
								<ul class="chatonline">
									<li>
										<div class="call-chat">
											<button class="btn btn-success text-white btn-circle btn"
												type="button">
												<i class="fas fa-phone"></i>
											</button>
											<button class="btn btn-info btn-circle btn" type="button">
												<i class="far fa-comments text-white"></i>
											</button>
										</div> <a href="javascript:void(0)"
										class="d-flex align-items-center"><img
											src="plugins/images/users/varun.jpg" alt="user-img"
											class="img-circle">
											<div class="ms-2">
												<span class="text-dark">Ayman Abouhali <small
													class="d-block text-success d-block">online</small></span>
											</div> </a>
									</li>
									<li>
										<div class="call-chat">
											<button class="btn btn-success text-white btn-circle btn"
												type="button">
												<i class="fas fa-phone"></i>
											</button>
											<button class="btn btn-info btn-circle btn" type="button">
												<i class="far fa-comments text-white"></i>
											</button>
										</div> <a href="javascript:void(0)"
										class="d-flex align-items-center"><img
											src="plugins/images/users/genu.jpg" alt="user-img"
											class="img-circle">
											<div class="ms-2">
												<span class="text-dark">Ziad Bougrine <small
													class="d-block text-warning">Away</small></span>
											</div> </a>
									</li>
									<li>
										<div class="call-chat">
											<button class="btn btn-success text-white btn-circle btn"
												type="button">
												<i class="fas fa-phone"></i>
											</button>
											<button class="btn btn-info btn-circle btn" type="button">
												<i class="far fa-comments text-white"></i>
											</button>
										</div> <a href="javascript:void(0)"
										class="d-flex align-items-center"><img
											src="plugins/images/users/ritesh.jpg" alt="user-img"
											class="img-circle">
											<div class="ms-2">
												<span class="text-dark">Anas Atmani <small
													class="d-block text-danger">Busy</small></span>
											</div> </a>
									</li>
									<li>
										<div class="call-chat">
											<button class="btn btn-success text-white btn-circle btn"
												type="button">
												<i class="fas fa-phone"></i>
											</button>
											<button class="btn btn-info btn-circle btn" type="button">
												<i class="far fa-comments text-white"></i>
											</button>
										</div> <a href="javascript:void(0)"
										class="d-flex align-items-center"><img
											src="plugins/images/users/arijit.jpg" alt="user-img"
											class="img-circle">
											<div class="ms-2">
												<span class="text-dark">othmane maataoui <small
													class="d-block text-muted">Offline</small></span>
											</div> </a>
									</li>
									
								</ul>
							</div>
						</div>
					</div>
					<!-- /.col -->
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer text-center"> Copyright &copy; 2021 All Rights Reserved by Universit?? Moulay Isma??l.
            </footer>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="otherFiles/javaScript/app-style-switcher.js"></script>
	<script
		src="plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
	<!--Wave Effects -->
	<script src="otherFiles/javaScript/waves.js"></script>
	<!--Menu sidebar -->
	<script src="otherFiles/javaScript/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="otherFiles/javaScript/custom.js"></script>
	<!--This page JavaScript -->
	<!--chartis chart-->
	<script src="plugins/bower_components/chartist/dist/chartist.min.js"></script>
	<script
		src="plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
	<script src="otherFiles/javaScript/pages/dashboards/dashboard1.js"></script>
</body>

</html>