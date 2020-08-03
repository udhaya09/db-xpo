<%@ include file="/WEB-INF/views/templates/include.jsp"%>

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="#" class="brand-link"> <img
		src="${pageContext.request.contextPath}/dist/img/dbx_logo.png"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-strong">DB-XPO</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<security:authorize access="isAuthenticated()">
			<!-- Sidebar user panel (optional) -->
			<div class="user-panel mt-3 pb-3 mb-3 d-flex">
				<div class="image">
					<img src="dist/img/user2-160x160.jpg"
						class="img-circle elevation-2" alt="User Image">
				</div>
				<div class="info">
					<a href="#" class="d-block">${pageContext.request.userPrincipal.name}</a>
				</div>
			</div>
		</security:authorize>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<security:authorize access="isAuthenticated()">
					
					<li class="nav-item"><a href="/" class="nav-link active">
							<i class="nav-icon fas fa-home"></i>
							<p>Home</p>
					</a></li>
					<li class="nav-item"><a href="/export/recentreports" class="nav-link"> <i
							class="nav-icon fas fa-file-export"></i>
							<p>Recent Exports</p>
					</a></li>
					<li class="nav-item"><a href="/logout" class="nav-link"> <i
							class="nav-icon fas fa-power-off"></i>
							<p>Logout</p>
					</a></li>
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
					<li class="nav-item"><a href="/login" class="nav-link"> <i
							class="nav-icon fas fa-sign-in-alt"></i>
							<p>Login</p>
					</a></li>
					<li class="nav-item"><a href="/registration" class="nav-link">
							<i class="nav-icon fas fa-user-plus"></i>
							<p>Register</p>
					</a></li>
				</security:authorize>
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>