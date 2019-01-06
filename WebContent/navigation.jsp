<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'admin_supp' }" >
							<li>
								<i class="icon-chevron-up green home-icon"></i>
								<a href="sell?hidden=load">New Sell</a>
							</li>
							</c:if>
							<c:if test="${sessionScope.rights == 'distributor' || sessionScope.rights == 'supplier' }" >
							<li>
								<i class="icon-chevron-down green home-icon"></i>
								<a href="order?hidden=load">New Order</a>
							</li>
							</c:if>
							<c:if test="${sessionScope.rights == 'admin' || sessionScope.rights == 'admin_supp' }" >
							<li>
								<i class="icon-archive green home-icon"></i>
								<a href="item?hidden=load">New Item</a>
							</li>
							</c:if>
							<c:if test="${sessionScope.rights == 'admin_supp' }" >
							<li>
								<i class="icon-user green home-icon"></i>
								<a href="new_customer.jsp">New Customer</a>
							</li>
							</c:if>
							<c:if test="${sessionScope.rights == 'admin' }" >
							<li>
								<i class="icon-male green home-icon"></i>
								<a href="new_supplier.jsp">New Supplier</a>
							</li>
							</c:if>
						</ul>

					</div>