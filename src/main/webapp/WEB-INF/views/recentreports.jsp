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
                <h5 class="m-0">Recent Exports</h5>
              </div>
              <div class="card-body">
                <h6 class="card-title">We stored your recent queries</h6>

                <p class="card-text">You can use it and download the Excel easily</p>
                <a href="#" class="btn btn-primary" id="enable-exis-query">Select</a>
                
                <hr>
                
                <form action="/export/download-exist-excel" method="POST" role="form" id="exist-query-form" style="display:none;">
                
                	<div class="row">
                    <div class="col-sm-12">
                      <!-- select -->
                      <div class="form-group">
                        <label>Select Report</label>
                        <select class="form-control" name="id">
                         <option value="0">--Select--</option>									
						<c:forEach items="${reports}" var="report">
							<option value="${report.id}">${report.connection.getConnectionName()} | ${report.reportName}</option>	
						</c:forEach>
                        </select>
                      </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
                    </div>
                    
             
                  
                  <div class="row">
                  	 <div class="col-sm-6">
                  	 </div>
                  	 <div class="col-sm-6">                  	 	
                  	 	<button type="submit" class="btn btn-primary float-right" id="download-excel-existing">Download Excel</button>                  	 	
                  	 </div>
                  	  
                  </div>
                
                </form>
                
              </div>
            </div>
         

           
          </div>
          <!-- /.col-md-6 -->
          <div class="col-lg-6">
            

        
          </div>
          <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->