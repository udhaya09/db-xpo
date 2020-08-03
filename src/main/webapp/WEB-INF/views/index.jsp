<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Welcome ${pageContext.request.userPrincipal.name}</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Starter Page</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-6">
           <div class="card card-primary card-outline">
              <div class="card-header">
                <h5 class="m-0">Existing Connections</h5>
              </div>
              <div class="card-body">
                <h6 class="card-title">Select existing connection</h6>

                <p class="card-text">And paste the query and then export report in Excel format.</p>
                <a href="#" class="btn btn-primary" id="enable-query-execute-form">Select</a>
                
                <hr>
                
                <form action="/export/download-excel" method="POST" role="form" id="query-execute-form" style="display:none;">
                
                	<div class="row">
                    <div class="col-sm-12">
                      <!-- select -->
                      <div class="form-group">
                        <label>Select DB-Connection</label>
                        <select class="form-control" name="connectionId">
                         <option value="0">--Select--</option>									
						<c:forEach items="${dbconnections}" var="dbconnection">
							<option value="${dbconnection.id}">${dbconnection.connectionName}</option>	
						</c:forEach>
                        </select>
                      </div>
                    </div>
                    </div>
                    
                      <div class="row">
                    <div class="col-sm-12">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Report Name</label>
                        <input type="text" class="form-control" placeholder="Connection" name="reportName">
                      </div>
                    </div>
                 
                  </div>
                    
                    <div class="row">
                    <div class="col-sm-12">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>Query to Exceute</label>
                        <textarea class="form-control" rows="5" placeholder="Paste your query" name="query"></textarea>
                      </div>
                    </div>
                  <input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
                  </div>
                  
                  <div class="row">
                  	 <div class="col-sm-6">
                  	 </div>
                  	 <div class="col-sm-6">                  	 	
                  	 	<button type="submit" class="btn btn-primary float-right">Download Excel</button>                  	 	
                  	 </div>
                  	  
                  </div>
                
                </form>
                
              </div>
            </div>
         

           
          </div>
          <!-- /.col-md-6 -->
          <div class="col-lg-6">
            <div class="card card-primary card-outline">
              <div class="card-header">
                <h5 class="m-0">New DB Connection</h5>
              </div>
              <div class="card-body">
                <h6 class="card-title">Create new connection</h6>

                <p class="card-text">And use it anytime by just pasting the query</p>
                <a href="#" class="btn btn-primary" id="enable-new-con-form">Go Ahead</a>
                
                <hr>
                
                <form action="/connections/save-new-connection" method="POST" role="form" id="new-connection-form" style="display:none;">
                
                	<div class="row">
                    <div class="col-sm-12">
                      <!-- select -->
                      <div class="form-group">
                        <label>Select DB-Engine</label>
                        <select class="form-control" name="dbEngine">
                         <option value="0">--Select--</option>									
						<c:forEach items="${dbengines}" var="dbengine">
							<option value="${dbengine.id}">${dbengine.dbEngineName}</option>	
						</c:forEach>
                        </select>
                      </div>
                    </div>
                    </div>
                    
                    <div class="row">
                    <div class="col-sm-12">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Connection Name</label>
                        <input type="text" class="form-control" placeholder="Connection" name="connectionName">
                      </div>
                    </div>
                 
                  </div>
                    
                    <div class="row">
                    <div class="col-sm-6">
                      <!-- text input -->
                      <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" placeholder="Username" name="userName">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label>Password</label>
                        <input type="text" class="form-control" placeholder="Password" name="password">
                      </div>
                    </div>
                  </div>
                  
                  <div class="row">
                    <div class="col-sm-12">
                      <!-- textarea -->
                      <div class="form-group">
                        <label>DB Connection URL</label>
                        <textarea class="form-control" rows="2" placeholder="DB Connection URL" name="dbUrl"></textarea>
                      </div>
                    </div>
                  <input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
                  </div>
                  
                  <div class="row">
                  	 <div class="col-sm-6">
                  	 </div>
                  	 <div class="col-sm-6">
                  	 	<button type="submit" class="btn btn-primary float-right">Submit</button>
                  	 </div>
                  	  
                  </div>
                
                </form>
                
              </div>
              
              
              
              
            </div>

        
          </div>
          <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->