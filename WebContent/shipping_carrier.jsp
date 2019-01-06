<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.carrierview== null}">
   
 <jsp:forward page="shipping?hidden=carrier_view"></jsp:forward>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ include file="initialization.jsp" %>

<body>
	<%@ include file="header.jsp" %>
		

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
				<%@include file="sidebar.jsp" %>

				

				<div class="main-content">
					<%@include file="navigation.jsp" %>
					
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								
									<div class="col-xs-7">
										<div class="table-responsive">
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>Shipping Carriers</th>

														<th>Action</th>
													</tr>
												</thead>

												<tbody>
													<c:forEach var="r" items="${sessionScope.carrierview }">
													<tr>
														

														<td>${r.shipping }</td>
														
														<td><a href="shipping?hidden=delete&id=${r.id}">Delete</a></td>

													</tr>
													</c:forEach>	
													<c:remove var="carrierview" scope="session" />												
													 
												</tbody>
											</table>
										</div><!-- /.table-responsive -->
									</div>
									
									<div class="col-sm-7">

										<div class="widget-box">
											<div class="widget-header">
												<h4>Add New Shipping Carrier</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<form action="shipping" method="post" parsley-validate>
													<input type = "hidden" value="carrierinsert" name="hidden">
														<!-- <legend>Form</legend> -->

														<fieldset>
															<label>Shipping name : </label>

															<input type="text" placeholder="FedEx" name="shipcompany" required/>

														</fieldset>

														<div class="form-actions center">
															<button type="submit" class="btn btn-sm btn-success">
																Submit
																<i class="icon-arrow-right icon-on-right bigger-110"></i>
															</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
			

</body>
</html>