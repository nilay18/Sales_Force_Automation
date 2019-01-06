<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<c:forEach items="${sessionScope.itemview_detail}" var="r">
								
				<div class="page-header">
							<h1>
								Item Details
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
							
								<form class="form-horizontal" role="form">

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Name</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" name="item" value="<c:out value="${r.iname}"></c:out>" disabled/>
												<i class="icon-archive blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Code</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1"  name="itcode" value="<c:out value="${r.id}"></c:out>" disabled/>
												<i class="icon-barcode blue"></i>
											</span>
										</div>
									</div>

									<c:if test="${sessionScope.rights == 'admin'}">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Unit Cost</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1"  name="uncost" value="<c:out value="${r.icost}"></c:out>" disabled/>
												<i class="icon-dollar blue"></i>
											</span>
										</div>
									</div>
									</c:if>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Unit Price</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" name="unprice" value="<c:out value="${r.imrp}"></c:out>" disabled/>
												<i class="icon-dollar blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Category &nbsp;</label>
											<span class="input-icon">
											<select name="cat" disabled>
												
																								<option><c:out value="${r.icategory}"></c:out></option>
																								
																						
											</select>
											</span>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Description</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<textarea class="form-control" id="form-field-8"  name="t1" disabled><c:out value="${r.idesc}"></c:out></textarea>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Website</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1"  value="<c:out value="${r.iwebsite}"></c:out>" disabled/>
												<i class="icon-link blue"></i>
											</span>
										</div>
									</div>
									
																		<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Default Supplier &nbsp;</label>
											<span class="input-icon">
											<select name="supplier" disabled>
												<option ><c:out value="${r.isupplier}"></c:out></option>
																								
																							
																
											</select>
											</span>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Note</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<textarea class="form-control" id="form-field-8" name="t2" disabled><c:out value="${r.inote}"></c:out></textarea>
											</span>
										</div>
									</div>
									</c:forEach>
									<c:remove var="itemview_detail" scope="session" />
									
									
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
