<%@ tag description="Layout" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Paint Branch Alarm Console</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-switch.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <nav class="navbar navbar-inverse">
        <div class="navbar-header">
            <sec:authorize access="hasRole('ROLE_USER')">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#alarm-navbar">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </sec:authorize>
            <a class="navbar-brand" href="#">Alarm Console</a>
        </div>
        <sec:authorize access="hasRole('ROLE_USER')">
            <div class="collapse navbar-collapse" id="alarm-navbar">
                <p class="navbar-text navbar-right">
                    Hello, <sec:authentication property="principal"/>
                    <a href="j_spring_security_logout" class="btn btn-default btn-xs">Log out</a>
                </p>
            </div>
        </sec:authorize>
    </nav>
    <div class="container">
        <jsp:doBody/>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-switch.min.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>
