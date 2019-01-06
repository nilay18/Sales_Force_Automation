<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
								
								<c:forEach items="${sessionScope.orderview}" var="r">
								<div class="page-header">
							<h1>
								Order Details
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
							
								<form class="form-horizontal" role="form" action="functions/add_order.php" method="post">

									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Order Supplier</label>
											<div class="col-sm-9">
												<span class="input-icon">
													<input type="text" id="form-field-icon-1"  name="suppliers" value="<c:out value="${r.supplier}"></c:out>" disabled/>
													<i class="icon-male blue"></i>
												</span>
											</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Issue Date</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" name="issuedate" value="<c:out value="${r.issue}"></c:out>" disabled/>
												<i class="icon-calendar blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Expected Receipt Date</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" name="receiptdate" value="<c:out value="${r.expected}"></c:out>" disabled/>
												<i class="icon-calendar blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Shipped By</label>
											<div class="col-sm-9">
												<span class="input-icon">
													<input type="text" id="form-field-icon-1" name="shipby" value="<c:out value="${r.shipping}"></c:out>" disabled/>
													<i class="icon-fighter-jet blue"></i>
												</span>
											</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item</label>
											<div class="col-sm-9">
												<span class="input-icon">
													<input type="text" id="form-field-icon-1" name="item" value="<c:out value="${r.iname}"></c:out>" disabled/>
													<i class="icon-archive blue"></i>
												</span>
											</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Quantity</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" name="quantity" value="<c:out value="${r.quantity}"></c:out>" disabled/>
												<i class="icon-plus blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Total Cost</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" name="quantity" value="<c:out value="${r.total_cost}"></c:out>" disabled/>
												<i class="icon-dollar blue"></i>
											</span>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Order Note</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<textarea class="form-control" id="form-field-8" name="t1" disabled><c:out value="${r.note}"></c:out></textarea>
											</span>
										</div>
									</div>
									</c:forEach>
									<c:remove var="orderview" scope="session" />

								</form>								<!-- PAGE CONTENT ENDS -->
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
								