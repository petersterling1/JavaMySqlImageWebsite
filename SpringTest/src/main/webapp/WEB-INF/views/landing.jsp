<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

	<head>
		<title>Landing Page</title>

    	<meta name="viewport" content="width=device-width, initial-scale=1">

    	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
    	
    	<!-- 
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		 -->
		 
	</head>
	
	<body>


   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input placeholder="Email" class="form-control" type="text">
            </div>
            <div class="form-group">
              <input placeholder="Password" class="form-control" type="password">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Testing!</h1>
        <!--<p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>-->
        
		<h1>
		<!--Thank you for joining, It'll be fun-->
		</h1>


<!--registration form-->
  
  
  <div class="bs-example">
    <form class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail" class="control-label col-xs-2">Username</label>
            <div class="col-xs-10">
                <input type="email" class="form-control" name="username" placeholder="Username">
            </div>
        </div>
        
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Password</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>
        
        
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">First Name</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="firstname" placeholder="First Name">
            </div>
        </div>
        
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Last Name</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="lastname" placeholder="Last Name">
            </div>
        </div>

   
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Address</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="address" placeholder="Address">
            </div>
        </div>

   
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Email</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="email" placeholder="Email">
            </div>
        </div>

   
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Phone</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" name="phone" placeholder="Phone">
            </div>
        </div>




        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </div>
    </form>
</div>

<!--registration form-->
  
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Company 2014</p>
      </footer>
    </div> <!-- /container -->


		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="js/bootstrap.js"></script>

	</body>

</html>

