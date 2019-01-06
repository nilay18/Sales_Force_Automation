<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:if test="${sessionScope.suppload== null}">
   
 <jsp:forward page="order?hidden=load"></jsp:forward>
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
								
				<div class="page-header">
							<h1>
								New Order
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
							
								<form class="form-horizontal" role="form" action="order" method="post" parsley-validate>
										<input type="hidden" name = "hidden" value = "insert"/>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Order Supplier &nbsp;</label>
											<span class="input-icon">
											<select name="supplier">
																								<c:forEach items="${sessionScope.suppload}" var="r">
																								<option><c:out value="${r.supplier}"></c:out></option>
																								</c:forEach>
																								<c:remove var="suppload" scope="session" />
																								
																
											</select>
											</span>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Issue Date</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="YYYY-MM-DD" name="issuedate" parsley-type="dateIso" required/>
												<i class="icon-calendar blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Expected Receipt Date</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="YYYY-MM-DD" name="receiptdate" parsley-type="dateIso" required/>
												<i class="icon-calendar blue"></i>
											</span>
										</div>
									</div>

									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Shipped By &nbsp;</label>
											<span class="input-icon">
											<select name="shipby">
																								<c:forEach items="${sessionScope.shipload}" var="s">
																								<option><c:out value="${s.shipping}"></c:out></option>
																								</c:forEach>
																								<c:remove var="shipload" scope="session" />
											</select>
											</span>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item &nbsp;</label>
											<span class="input-icon">
											<select name="item">								
																								<c:forEach items="${sessionScope.itemload}" var="i">
																								<option ><c:out value="${i.iname}"></c:out>
																								
																								</option>
																								</c:forEach>
																								<c:remove var="itemload" scope="session" />
																								
																							
																
											</select>
											</span>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Quantity</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="25" name="quantity" parsley-type="digits" required/>
												<i class="icon-plus blue"></i>
											</span>
										</div>
									</div>
									

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Order Note</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<textarea class="form-control" id="form-field-8" placeholder="Type order note here" name="t1"></textarea>
											</span>
										</div>
									</div>
									
									
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="submit">
												<i class="icon-ok bigger-110"></i>
												Order
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												Reset
											</button>
										</div>
									</div>
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