<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>

<!DOCTYPE html>
<html>
<head>
    <smart:bower_css path="bootstrap/dist/css/bootstrap.css" />
    <smart:bower_css path="bootstrap/dist/css/bootstrap-theme.css" />

    <style>
       .centerfy img {
           margin: 0 auto;
       }
       .centerfy {
           text-align: center;
       }
    </style>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
  <div class="container">

    <div class="jumbotron centerfy">
      <h1>Start Deep Working!</h1>
      <p class="lead">Create a new project and start monitoring your
        progress discovering better approach when working</p>
      <p>
        <a class="btn btn-lg btn-success" href="/project/new" role="button">Create a new project</a>
      </p>
    </div>

    <!-- Example row of columns -->
    <div class="row">
      <div class="col-lg-6">
        <h2>Projects</h2>
        <p>Manage your projects creating new entries or monitoring reports to get insights.</p>
        <p>
          <a class="btn btn-primary" href="/project" role="button">View details
            &raquo;</a>
        </p>
      </div>

      <div class="col-lg-6">
        <h2>Define activities for your project!</h2>
        <p>Declare all activities needed to get your project done.</p>
        <p>
          <a class="btn btn-primary" href="#" role="button">Create Activities
            &raquo;</a>
        </p>
      </div>
    </div>

  </div>
</body>
</html>
