<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

	<head>
		<title>Homepage</title>

    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	
    	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
    	
    	<!-- 
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		 -->

	</head>
	


	<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("login.html");
%>



<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">xyz</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Hi <%=userName %>, Login successful.</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          
          <!-- Jumbotron-->
          <div class="jumbotron">
          
          <!--
            <h1>Hello, world!</h1>
            <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
          -->


    <div class="container">

        <div class="row">

            <div class="col-xs-3">

                <a href="#" class="thumbnail">

                    <img src="125x125.jpg" alt="125x125">

                </a>

            </div>

            <div class="col-xs-3">

                <a href="#" class="thumbnail">

                    <img src="125x125.jpg" alt="125x125">

                </a>

            </div>

            <div class="col-xs-3">

                <a href="#" class="thumbnail">

                    <img src="125x125.jpg" alt="125x125">

                </a>

            </div>

            <div class="col-xs-3">

                <a href="#" class="thumbnail">

                    <img src="125x125.jpg" alt="125x125">

                </a>

            </div>

        </div>

    </div>


          
          </div>
          <!-- Jumbotron-->
          
          
          
          <div class="row">
                    
                    
            <!-- Thumbnail-->
            <div class="col-xs-6 col-lg-4">
            	<a href="#" class="thumbnail">
                <img src="125x125.jpg" alt="125x125">
            	</a>
            </div><!--/.col-xs-6.col-lg-4-->
			<!-- Thumbnail-->


            <!-- Thumbnail-->
            <div class="col-xs-6 col-lg-4">
            	<a href="#" class="thumbnail">
                <img src="125x125.jpg" alt="125x125">
            	</a>
            </div><!--/.col-xs-6.col-lg-4-->
			<!-- Thumbnail-->
			

            <!-- Thumbnail-->
            <div class="col-xs-6 col-lg-4">
            	<a href="#" class="thumbnail">
                <img src="125x125.jpg" alt="125x125">
            	</a>
            </div><!--/.col-xs-6.col-lg-4-->
			<!-- Thumbnail-->
			
			

            <!-- Thumbnail-->
            <div class="col-xs-6 col-lg-4">
            	<a href="#" class="thumbnail">
                <img src="125x125.jpg" alt="125x125">
            	</a>
            </div><!--/.col-xs-6.col-lg-4-->
			<!-- Thumbnail-->


            <!-- Thumbnail-->
            <div class="col-xs-6 col-lg-4">
            	<a href="#" class="thumbnail">
                <img src="125x125.jpg" alt="125x125">
            	</a>
            </div><!--/.col-xs-6.col-lg-4-->
			<!-- Thumbnail-->
			

            <!-- Thumbnail-->
            <div class="col-xs-6 col-lg-4">
            	<a href="#" class="thumbnail">
                <img src="125x125.jpg" alt="125x125">
            	</a>
            </div><!--/.col-xs-6.col-lg-4-->
			<!-- Thumbnail-->
						  
 			  
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <div class="list-group">
            <a href="#" class="list-group-item active">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
            <a href="#" class="list-group-item">Link</a>
          </div>
        </div><!--/.sidebar-offcanvas-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; Company 2014</p>
      </footer>

    </div><!--/.container-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

	<!--
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

    <script src="offcanvas.js"></script>
  	




<!-- content-->

		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="js/bootstrap.js"></script>


	</body>
</html>

