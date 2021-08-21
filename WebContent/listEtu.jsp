<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

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
<link rel="apple-touch-icon" type="image/png"
	href="https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png">
<meta name="apple-mobile-web-app-title" content="CodePen">

<link rel="shortcut icon" type="image/x-icon"
	href="https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico">
<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">-->
<link rel="mask-icon" type=""
	href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg">
<title>Admin</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/ample-admin-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="plugins/images/favicon.png">
<!-- Custom CSS -->
<link href="otherFiles/css/style.min.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style>
.button {
	background-color: #1E90FF; /* Green */
	border: none;
	color: white;
	padding: 8px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 15px;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: #1E90FF;
	color: white;
}

.button1:hover {
	background-color: #00BFFF;
	color: white;
}
</style>
<script>
	window.console = window.console || function(t) {
	};
</script>



<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
			<jsp:include page="Header.jsp" />
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="leftSideBar.jsp" />
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

			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
			<div class="row">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
						<h5 class="card-title">Liste des etudiants</h5>
				<form action="filtreEtu" method="POST"> 
					<div class="col-md-6">
						<div class="position-relative form-group"> <label for="Filiere" class="">Filiere</label> <select
								id="listfiliere" name="nomFil" class="form-control">
								<c:forEach var="listFil" items="${listFil}">
									<option value="${listFil}">${listFil}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="position-relative form-group"> <label for="Semestre" class="">Semestre</label> <select
								id="listSemestre" name="nomSem" class="form-control">
								<c:forEach var="listSem" items="${listSem}">
									<option value="${listSem}">${listSem}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<div class="col-md-9">
						<div class="position-relative form-group">
							<button class="btn btn-success">Valider</button>
						</div>
					</div>
					</form>
				</div>
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<div id="example_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap no-footer">
								<div class="dt-buttons">
									<div class="dt-buttons btn-group">
										<a
											class="btn btn-default buttons-pdf buttons-html5"
											tabindex="0" aria-controls="example" href="PDFMaker"><span>PDF</span></a>
									</div>
									<div id="example_filter" class="dataTables_filter">
										<form action="ajoutEParExcel" method="POST" enctype="multipart/form-data">
									<input type="file" id="listeEtu" name="listEtuExcel"
												accept=".xls" placeholder="liste des etudiants">
									<button type="submit" class="button button1">Ajouter
										liste etudiant</button>
									</form>
									</div>
								</div>
								<div class="clear"></div>
								<h3 class="box-title">Table d'etudiants</h3>

								<a class="sidebar-link waves-effect waves-dark sidebar-link"
									href="ajouterEtu.jsp" aria-expanded="false">
									<button type="submit" class="button button1">Ajouter
										etudiant</button>
								</a>
								<div class="table-responsive">
									<table class="table text-nowrap">
										<thead>
											<tr>
												<th class="border-top-0">#</th>
												<th class="border-top-0">Nom</th>
												<th class="border-top-0">Prenom</th>
												<th class="border-top-0">CNE</th>
												<!--   <th class="border-top-0"></th>-->
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listEtu}" var="e">
												<tr>
													<td>${ e.getId_etu()}</td>
													<td>${ e.getNomFr()}</td>
													<td>${ e.getPrenomFr()}</td>
													<td>${ e.getCNE()}</td>
													<td><a href="affecterMat?id_etu=${e.getId_etu() }" ><i
								class=" fas fa-plus" aria-hidden="true"></i>Affecter</a></td>
													<td><!-- <input type="hidden" name="id" value="${e.getId_etu()}" /> -->
														<c:url var="urlet" value="editEtu">
															<c:param name="idEtudiant">${e.getId_etu() }</c:param>
														</c:url> 
														<a href="${urlet}" class="edit"><i
								class=" fas fa-edit" aria-hidden="true"></i>Modifier</a> <!--  <td><a var="p"  items="${model.etudiants}" type="submit"  href="supprimer.php?id=${p.id }">Supprimer</a></td> -->
														<!--  <td><a href="modifier.php?id=${p.id}">Edit</a></td> -->

													</td>
													<td>
													<c:url var="urlet" value="ajouterDoc">
															<c:param name="idEtudiant">${e.getId_etu() }</c:param>
														</c:url>
													<a href="${urlet}" class="btn btn-primary btn-xs dt-edit"
														style="margin-right: 16px;"> <i
								class="fas fa-plus-square" aria-hidden="true"></i>
													</a></td>
													<td><c:url var="urlet" value="deletetu">
															<c:param name="idEtudiant">${e.getId_etu() }</c:param>
														</c:url> <a href="${urlet}" style="margin-right: 16px;"> 
															<input style="background-color: red; color: black"
															type="submit" value="Suprimer">
													</a> <!--  <td><a var="p"  items="${model.etudiants}" type="submit"  href="supprimer.php?id=${p.id }">Supprimer</a></td> -->
														<!--  <td><a href="modifier.php?id=${p.id}">Edit</a></td> -->
													</td>
												</tr>
											</c:forEach>
											<tr>
										</tbody>
									</table>

								</div>
							</div>
						</div>
					</div>
					<!-- ============================================================== -->
					<!-- End PAge Content -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- Right sidebar -->
					<!-- ============================================================== -->
					<!-- .right-sidebar -->
					<!-- ============================================================== -->
					<!-- End Right sidebar -->
					<!-- ============================================================== -->
				</div>
				<!-- ============================================================== -->
				<!-- End Container fluid  -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- footer -->
				<!-- ============================================================== -->
				<footer class="footer text-center"> Copyright &copy; 2021
					All Rights Reserved by Université Moulay Ismaïl. </footer>
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
	</div>
	
	</div>
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="otherFiles/javaScript/app-style-switcher.js"></script>
	<!--Wave Effects -->
	<script src="otherFiles/javaScript/waves.js"></script>
	<!--Menu sidebar -->
	<script src="otherFiles/javaScript/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="otherFiles/javaScript/custom.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							//Only needed for the filename of export files.
							//Normally set in the title tag of your page.
							document.title = 'Simple DataTable';
							// DataTable initialisation
							$('#example')
									.DataTable(
											{
												"dom" : '<"dt-buttons"Bf><"clear">lirtp',
												"paging" : false,
												"autoWidth" : true,
												"columnDefs" : [ {
													"orderable" : false,
													"targets" : 5
												} ],
												"buttons" : [ 'colvis',
														'copyHtml5',
														'csvHtml5',
														'excelHtml5',
														'pdfHtml5', 'print' ]
											});
							//Add row button
							$('.dt-add')
									.each(
											function() {
												$(this)
														.on(
																'click',
																function(evt) {
																	//Create some data and insert it
																	var rowData = [];
																	var table = $(
																			'#example')
																			.DataTable();
																	//Store next row number in array
																	var info = table.page
																			.info();
																	rowData
																			.push(info.recordsTotal + 1);
																	//Some description
																	rowData
																			.push('New Order');
																	//Random date
																	var date1 = new Date(
																			2016,
																			01,
																			01);
																	var date2 = new Date(
																			2018,
																			12,
																			31);
																	var rndDate = new Date(
																			+date1
																					+ Math
																							.random()
																					* (date2 - date1));//.toLocaleDateString();
																	rowData
																			.push(rndDate
																					.getFullYear()
																					+ '/'
																					+ (rndDate
																							.getMonth() + 1)
																					+ '/'
																					+ rndDate
																							.getDate());
																	//Status column
																	rowData
																			.push('NEW');
																	//Amount column
																	rowData
																			.push(Math
																					.floor(Math
																							.random() * 2000) + 1);
																	//Inserting the buttons ???
																	rowData
																			.push('<button type="button" class="btn btn-primary btn-xs dt-edit" style="margin-right:16px;"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button><button type="button" class="btn btn-danger btn-xs dt-delete"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>');
																	//Looping over columns is possible
																	//var colCount = table.columns()[0].length;
																	//for(var i=0; i < colCount; i++){			}

																	//INSERT THE ROW
																	table.row
																			.add(
																					rowData)
																			.draw(
																					false);
																	//REMOVE EDIT AND DELETE EVENTS FROM ALL BUTTONS
																	$(
																			'.dt-edit')
																			.off(
																					'click');
																	$(
																			'.dt-delete')
																			.off(
																					'click');
																	//CREATE NEW CLICK EVENTS
																	$(
																			'.dt-edit')
																			.each(
																					function() {
																						$(
																								this)
																								.on(
																										'click',
																										function(
																												evt) {
																											$this = $(this);
																											var dtRow = $this
																													.parents('tr');
																											$('div.modal-body').innerHTML = '';
																											$(
																													'div.modal-body')
																													.append(
																															'Row index: '
																																	+ dtRow[0].rowIndex
																																	+ '<br/>');
																											$(
																													'div.modal-body')
																													.append(
																															'Number of columns: '
																																	+ dtRow[0].cells.length
																																	+ '<br/>');
																											for (var i = 0; i < dtRow[0].cells.length; i++) {
																												$(
																														'div.modal-body')
																														.append(
																																'Cell (column, row) '
																																		+ dtRow[0].cells[i]._DT_CellIndex.column
																																		+ ', '
																																		+ dtRow[0].cells[i]._DT_CellIndex.row
																																		+ ' => innerHTML : '
																																		+ dtRow[0].cells[i].innerHTML
																																		+ '<br/>');
																											}
																											$(
																													'#myModal')
																													.modal(
																															'show');
																										});
																					});
																	$(
																			'.dt-delete')
																			.each(
																					function() {
																						$(
																								this)
																								.on(
																										'click',
																										function(
																												evt) {
																											$this = $(this);
																											var dtRow = $this
																													.parents('tr');
																											if (confirm("Are you sure to delete this row?")) {
																												var table = $(
																														'#example')
																														.DataTable();
																												table
																														.row(
																																dtRow[0].rowIndex - 1)
																														.remove()
																														.draw(
																																false);
																											}
																										});
																					});
																});
											});
							//Edit row buttons
							$('.dt-edit')
									.each(
											function() {
												$(this)
														.on(
																'click',
																function(evt) {
																	$this = $(this);
																	var dtRow = $this
																			.parents('tr');
																	$('div.modal-body').innerHTML = '';
																	$(
																			'div.modal-body')
																			.append(
																					'Row index: '
																							+ dtRow[0].rowIndex
																							+ '<br/>');
																	$(
																			'div.modal-body')
																			.append(
																					'Number of columns: '
																							+ dtRow[0].cells.length
																							+ '<br/>');
																	for (var i = 0; i < dtRow[0].cells.length; i++) {
																		$(
																				'div.modal-body')
																				.append(
																						'Cell (column, row) '
																								+ dtRow[0].cells[i]._DT_CellIndex.column
																								+ ', '
																								+ dtRow[0].cells[i]._DT_CellIndex.row
																								+ ' => innerHTML : '
																								+ dtRow[0].cells[i].innerHTML
																								+ '<br/>');
																	}
																	$(
																			'#myModal')
																			.modal(
																					'show');
																});
											});
							//Delete buttons
							$('.dt-delete')
									.each(
											function() {
												$(this)
														.on(
																'click',
																function(evt) {
																	$this = $(this);
																	var dtRow = $this
																			.parents('tr');
																	if (confirm("Are you sure to delete this row?")) {
																		var table = $(
																				'#example')
																				.DataTable();
																		table
																				.row(
																						dtRow[0].rowIndex - 1)
																				.remove()
																				.draw(
																						false);
																	}
																});
											});
							$('#myModal').on('hidden.bs.modal', function(evt) {
								$('.modal .modal-body').empty();
							});
						});
	</script>
	<script
		src="dataTable/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js.télécharger"></script>
	<script src="dataTable/jquery.min.js.télécharger"></script>
	<script src="dataTable/jquery.dataTables.min.js.télécharger"></script>
	<script src="dataTable/dataTables.buttons.min.js.télécharger"></script>
	<script src="dataTable/buttons.colVis.min.js.télécharger"></script>
	<script src="dataTable/buttons.html5.min.js.télécharger"></script>
	<script src="dataTable/buttons.print.min.js.télécharger"></script>
	<script src="dataTable/dataTables.bootstrap.min.js.télécharger"></script>
	<script src="dataTable/buttons.bootstrap.min.js.télécharger"></script>
	<script src="dataTable/jszip.min.js.télécharger"></script>
	<script src="dataTable/vfs_fonts.js.télécharger"></script>
	<script src="dataTable/pdfmake.min.js.télécharger"></script>
	<script src="dataTable/bootstrap.min.js.télécharger"></script>
</body>

</html>