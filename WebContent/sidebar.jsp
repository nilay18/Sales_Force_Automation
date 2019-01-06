<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>


					<ul class="nav nav-list">
						<li class="active">
							<a href="main.jsp">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Dashboard </span>
							</a>
						</li>
						

						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-exchange"></i>
								<span class="menu-text"> Inventory </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="item?hidden=load">
										<i class="icon-double-angle-right"></i>
										New Item
									</a>
								</li>
								</c:if>
								<c:if test="${sessionScope.rights == 'distributor' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="item?hidden=item_view">
										<i class="icon-double-angle-right"></i>
										Items List
									</a>
								</li>
								</c:if>
								<c:if test="${sessionScope.rights == 'distributor' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="order?hidden=load">
										<i class="icon-double-angle-right"></i>
										Order
									</a>
								</li>
								</c:if>
								<c:if test="${sessionScope.rights == 'distributor' || sessionScope.rights == 'supplier' || sessionScope.rights == 'admin' }" >
								<li>
									<a href="order?hidden=orderview">
										<i class="icon-double-angle-right"></i>
										Orders placed
									</a>
								</li>
								</c:if>
								
								
								<c:choose>
								<c:when test="${sessionScope.rights == 'admin'}">
								
								<li>
								
									<a href="order?hidden=orderview">
										<i class="icon-double-angle-right"></i>
										Orders received
									</a>
									
									
								</li>
								</c:when>
								<c:when test="${sessionScope.rights == 'supplier'}">
								
								
								<li>
								
									<a href="order?hidden=orderviewdist">
										<i class="icon-double-angle-right"></i>
										Orders received
									</a>
									
									
								</li>
								</c:when>
								
								
								</c:choose>
								

								<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="sell?hidden=load">
										<i class="icon-double-angle-right"></i>
										Sell
									</a>
								</li>
								
								<li >
									<a href="sell?hidden=sales_view">
										<i class="icon-double-angle-right"></i>
										Sales List
									</a>
								</li>
								</c:if>
							</ul>
						</li>
						<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-money"></i>
								<span class="menu-text"> Profits </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li >
									<a href="profit?hidden=profit_today">
										<i class="icon-double-angle-right"></i>
										Today Profit
									</a>
								</li>
								
								<li >
									<a href="profit?hidden=profit_yesterday">
										<i class="icon-double-angle-right"></i>
										Yesterday Profit
									</a>
								</li>

								<li >
									<a href="profit?hidden=profit_week">
										<i class="icon-double-angle-right"></i>
										Last 7 Days Profit
									</a>
								</li>
								
								<li >
									<a href="profit?hidden=profit_month">
										<i class="icon-double-angle-right"></i>
										This Month Profit
									</a>
								</li>
								
								<li >
									<a href="profit?hidden=profit_lastmonth">
										<i class="icon-double-angle-right"></i>
										Last Month Profit
									</a>
								</li>
								
								<li >
									<a href="profit?hidden=profit_year">
										<i class="icon-double-angle-right"></i>
										This Year Profit
									</a>
								</li>
								
								<li >
									<a href="profit?hidden=profit_lastyear">
										<i class="icon-double-angle-right"></i>
										Last Year Profit
									</a>
								</li>
								
							</ul>
						</li>
						</c:if>
						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> Categories </span>

								<b class="arrow icon-angle-down"></b>
							</a>
							
							<ul class="submenu">
								<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="new_cat.jsp">
										<i class="icon-double-angle-right"></i>
										New Category
									</a>
								</li>
								</c:if>
								<li >
									<a href="category?hidden=cat_view">
										<i class="icon-double-angle-right"></i>
										Categories List
									</a>
								</li>
							</ul>
						</li>

						<c:if test="${sessionScope.rights == 'admin' }" >
						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-male"></i>
								<span class="menu-text"> Suppliers </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li >
									<a href="new_supplier.jsp">
										<i class="icon-double-angle-right"></i>
										New Supplier
									</a>
								</li>

								<li >
									<a href="supplier_list.jsp">
										<i class="icon-double-angle-right"></i>
										Suppliers List
									</a>
								</li>
							</ul>
						</li>
						</c:if>
						<c:if test="${sessionScope.rights == 'supplier' }" >
						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-group"></i>
								<span class="menu-text"> Customers </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li >
									<a href="new_customer.jsp">
										<i class="icon-double-angle-right"></i>
										New Customer
									</a>
								</li>

								<li >
									<a href="customer?hidden=custom_view">
										<i class="icon-double-angle-right"></i>
										Customers List
									</a>
								</li>
							</ul>
						</li>
						</c:if>
						<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-bar-chart"></i>
								<span class="menu-text"> Reports </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<c:if test="${sessionScope.rights == 'supplier' }" >
								<li >
									<a href="report?hidden=custload">
										<i class="icon-double-angle-right"></i>
										Sales By Customer
									</a>
								</li>
								</c:if>
								<c:if test="${sessionScope.rights == 'admin' }" >
								<li >
									<a href="report?hidden=suppload">
										<i class="icon-double-angle-right"></i>
										Orders By Supplier
									</a>
								</li>
								</c:if>
								<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="report?hidden=itemloadsales">
										<i class="icon-double-angle-right"></i>
										Item Sales
									</a>
								</li>
								
								<li >
									<a href="report?hidden=itemloadorder">
										<i class="icon-double-angle-right"></i>
										Item Orders
									</a>
								</li>
								</c:if>
							</ul>
						</li>
						</c:if>
						<li >
							<a href="#" class="dropdown-toggle">
								<i class="icon-gears"></i>
								<span class="menu-text"> Settings </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<!-- <li >
									<a href="general.jsp">
										<i class="icon-double-angle-right"></i>
										General
									</a>
								</li> -->
								
								<li >
									<a href="edit_password.jsp">
										<i class="icon-double-angle-right"></i>
										Edit Password
									</a>
								</li>

								
								<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'supplier' }" >
								<li >
									<a href="shipping?hidden=carrier_view">
										<i class="icon-double-angle-right"></i>
										Shipping Carriers
									</a>
								</li>
								</c:if>								
								<!-- <li >
									<a href="unit_measure.jsp">
										<i class="icon-double-angle-right"></i>
										Unit of Measurement
									</a>
								</li> -->
								
							</ul>
							
							<li>
								<a href="logout.jsp">
									<i class="icon-off"></i>
									<span class="menu-text"> Logout </span>
								</a>
							</li>
							
						</li>
						
						<!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

</body>
</html>