<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="pragma" content="no-cache" />

    <smart:bower_css path="bootstrap/dist/css/bootstrap.css" />
    <smart:bower_css path="bootstrap/dist/css/bootstrap-theme.css" />

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
        <h1>${projectName}</h1>
    </div>

    <div class="row">
        <div class="col-md-12">
            <a href="/" class="btn btn-default">Home</a>
            <a href="/project/${projectId}/activity" class="btn btn-default">Activities</a>
            <a href="/project/${projectId}/activity/new" class="btn btn-default">New activity</a>
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">Best time to work</div>
                <div class="panel-body">
                    <canvas id="chart-best-time" height="200"></canvas>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">Activities done</div>
                <div class="panel-body">
                    <canvas id="chart-activities" height="200"></canvas>
                </div>
            </div>
        </div>

    </div>

  </div>
</body>

<smart:bower_js path="jquery/dist/jquery.js" />
<smart:bower_js path="bootstrap/dist/js/bootstrap.js" />

<smart:bower_js path="chart.js/dist/Chart.bundle.min.js" />

<script type="text/javascript" src="/assets/js/report_best_time.js"></script>
<script type="text/javascript" src="/assets/js/report_activities.js"></script>

</html>
