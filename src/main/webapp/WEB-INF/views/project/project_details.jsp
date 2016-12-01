<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>

<!DOCTYPE html>
<html>
<head>
    <smart:bower_css path="bootstrap/dist/css/bootstrap.css" />
    <smart:bower_css path="bootstrap/dist/css/bootstrap-theme.css" />
    <smart:bower_css path="chartist/dist/chartist.min.css" />

    <link href="/assets/css/typeahead.css" rel="stylesheet">

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

    <div class="page-header">
        <h1>Livro de OAuth</h1>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="<c:url value='/'/>" class="btn btn-default">Home</a>
            <a href="<c:url value='/project/1/activity'/>" class="btn btn-default">Activities</a>
            <a href="<c:url value='/project/1/activity/new'/>" class="btn btn-default">New activity</a>
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">Best time to work</div>
                <div class="panel-body">
                    <div class="ct-chart-best-time ct-perfect-fourth"></div>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">Activities done</div>
                <div class="panel-body">
                    <div class="ct-chart-activities ct-perfect-fourth"></div>
                </div>
            </div>
        </div>

    </div>

  </div>
</body>

<smart:bower_js path="jquery/dist/jquery.js" />
<smart:bower_js path="bootstrap/dist/js/bootstrap.js" />
<smart:bower_js path="chartist/dist/chartist.min.js" />
<smart:bower_js path="chartist-plugin-axistitle/dist/chartist-plugin-axistitle.min.js" />

<script type="text/javascript" src="/assets/js/report_best_time.js"></script>
<script type="text/javascript" src="/assets/js/report_activities.js"></script>

</html>
