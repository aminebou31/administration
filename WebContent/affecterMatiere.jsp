<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Inscription</title>

<!-- Icons font CSS-->
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
<meta name="description"
	content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
<meta name="robots" content="noindex,nofollow">
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
<%
/*if (session.getAttribute("user") == null) {
	response.sendRedirect("view.jsp");
}*/
%>


<body>
<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
<header class="topbar" data-navbarbg="skin5">
			<jsp:include page="Header.jsp"/>
		</header>
<jsp:include page="leftSideBar.jsp"/>
<div class="page-wrapper">
	
		<div class="wrapper wrapper--w960">
			<form action="affecterMat" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label>Mati??re</label> <input name="nom_mat" type="text"
								class="form-control" required>
						</div>
						
					</div>
					<div class="modal-footer">
					<input name="id_etu" type="hidden" value="${id_etu}"/>
					

						<input type="submit" class="btn btn-default" data-dismiss="modal"> 
					</div>
				</form>
	</div>
	</div>
</div>
	<!-- Jquery JS-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="otherFiles/global.js"></script>

</body>

</html>