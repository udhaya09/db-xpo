<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">

   <a href="/"><b>DB-XPO</b></a>

  </div>

  <div class="card">
    <div class="card-body register-card-body">
      <p class="login-box-msg">Register a new membership</p>

      <form:form method="POST" modelAttribute="userForm">
      <spring:bind path="fullName">
        <div class="input-group mb-3">
          <form:input type="text" class="form-control" placeholder="Full name" path="fullName"></form:input>          
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
          <form:errors path="fullName"></form:errors>
        </div>
        </spring:bind>
        <spring:bind path="userName">
         <div class="input-group mb-3">
          <form:input type="text" class="form-control" placeholder="Username" path="userName"></form:input>         
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
           <form:errors path="userName"></form:errors>
        </div>
        </spring:bind>
        <spring:bind path="emailAddress">
        <div class="input-group mb-3">
          <form:input type="email" class="form-control" placeholder="Email" path="emailAddress"></form:input>         
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
           <form:errors path="emailAddress"></form:errors>
        </div>
        </spring:bind>
        <spring:bind path="password">
        <div class="input-group mb-3">
          <form:input type="password" class="form-control" placeholder="Password" path="password"></form:input>
           <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
           <form:errors path="password"></form:errors>
        </div>
        </spring:bind>
        <spring:bind path="passwordConfirm">
        <div class="input-group mb-3">
          <form:input type="password" class="form-control" placeholder="Retype password" path="passwordConfirm"></form:input>         
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
           <form:errors path="passwordConfirm"></form:errors>
        </div>
        </spring:bind>
        <div class="row">
          <div class="col-8">
          
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
          </div>
          <!-- /.col -->
        </div>
     </form:form>

      <div class="social-auth-links text-center">

        <p>- OR -</p>        
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google mr-2"></i>
          Sign up using Google

        </a>
      </div>

      <a href="/login" class="text-center">I already have a membership</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->
</div>
<!-- /.register-box -->