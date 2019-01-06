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
								
				<div class="page-header">
							<h1>
								Edit Item
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
							
								
		<form class="form-horizontal" role="form" action="item" method="post" parsley-validate>
		<input type= "hidden" name = "hidden" value = "update"/>
<c:forEach items="${sessionScope.edit_item}" var="r">

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Name</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="Item Name Here" name="item" value="${r.iname }" required/>
												<i class="icon-archive blue"></i>
											</span>
											<input type="hidden" name = "hidden" value = "item_insert"/>
										</div>
									</div>
									
									

									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Unit Cost</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="19.50" name="uncost" parsley-type="number" value="${r.icost }"required/>
												<i class="icon-dollar blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Unit Price</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="20.90" name="unprice" parsley-type="number" value="${r.imrp}"required/>
												<i class="icon-dollar blue"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Category &nbsp;</label>
											<span class="input-icon">
											<select name="cat">
																								<c:forEach items="${sessionScope.catload}" var="k">
																								<option><c:out value="${k.catname}"></c:out></option>
																								</c:forEach>
																								<c:remove var="catload" scope="session" />
																	
															
											</select>
											</span>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Description</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<textarea class="form-control" id="form-field-8" placeholder="Type item description here" name="t1" required><c:out value="${r.idesc}"></c:out></textarea>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Website</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" id="form-field-icon-1" placeholder="http://" name="itweb" value="${r.iwebsite}" parsley-type="url"/>
												<i class="icon-link blue"></i>
											</span>
										</div>
									</div>
									
									
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Default Supplier &nbsp;</label>
											<span class="input-icon">
											<select name="supplier">
																								<option>Appledsf</option>
																								<option>HP</option>
																								<option>IBM</option>
																								<option>Toshiba</option>
																								<option>Compaq</option>
																								<option>DLL</option>
																								<option>rodolfo seales posada</option>
																								<option>Asus</option>
																								<option>dsf</option>
																								<option>vats</option>
																								<option>Converse 1</option>
																								<option>Converse 2</option>
																								<option>test supplier</option>
																								<option></option>
																								<option>Ali & co</option>
																								<option>Glaxo</option>
																								<option>test</option>
																								<option>joao</option>
																								<option>praktis</option>
																								<option>Skywalker</option>
																								<option>ElectroShop</option>
																								<option>Ali & co</option>
																								<option>JVM Supplies Co. Ltd.,</option>
																								<option>mani</option>
																								<option>jud</option>
																								<option>Tredo Traders</option>
																								<option>koçer</option>
																								<option>Skywalker</option>
																								<option>adobe</option>
																								<option>Quliyev Raset</option>
																								<option></option>
																								<option>A-test</option>
																								<option>ibtest</option>
																
											</select>
											</span>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">Item Note</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<textarea class="form-control" id="form-field-8" placeholder="Type notes here" name="t2" ><c:out value="${r.inote}"></c:out></textarea>
											</span>
										</div>
									</div>
									</c:forEach>
									
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="submit">
												<i class="icon-ok bigger-110"></i>
												Save
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