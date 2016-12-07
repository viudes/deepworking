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
    <smart:bower_css path="bootstrap-datepicker/dist/css/bootstrap-datepicker.css" />
    <smart:bower_css path="bootstrap-tagsinput/dist/bootstrap-tagsinput.css" />
    <smart:bower_css path="bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css" />
    <smart:bower_css path="bootstrap-timepicker/css/timepicker.min.css" />

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
        <h1>${projectName} <small>Register an activity entry</small></h1>
    </div>

    <form action="/project/${projectId}/activity" method="post">
      <input type="hidden" id="projectId" value="${projectId}"/>
      <div class="row">
          <div class="form-group col-lg-2">
              <label for="date">Date</label>
              <div id="date" class="input-group date">
                  <input name="date" type="text" class="form-control" placeholder="Date of work"/>
                  <span class="input-group-addon add-on">
                    <span class="glyphicon glyphicon-calendar"/>
                  </span>
              </div>
          </div>
          <div class="col-lg-2">
              <label for="activityType">Activity type</label>
              <div class="form-group">
                <input name="activityType" id="activityType" class="typeahead form-control" type="text" placeholder="Type of activity"/>
              </div>
          </div>
      </div>

      <div class="row">
          <div class="col-lg-2">
              <dl>
                  <dt><label for="startTime">Start time</label></dt>
                  <dd>
                    <div class="input-group bootstrap-timepicker timepicker">
                      <input id="startTime" name="startTime" type="text" class="form-control input-small input-timepicker" placeholder="Hour when started">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                    </div>
                  </dd>
              </dl>
          </div>
          <div class="col-lg-2">
              <dl>
                  <dt><label for="amountHours">Amount of time</label></dt>
                  <dd><input name="amountHours" class="form-control" type="text" id="amountHours" placeholder="Minutes spent"/></dd>
              </dl>
          </div>
      </div>

      <div class="row">
        <div class="col-lg-6">
            <dl>
                <dt><label for="description">Description</label>
                <dd><input class="form-control" type="text" name="description" id="description" placeholder="Type in few words some details about this activity"></dd>
            </dl>
        </div>
      </div>

      <div id="actions" class="row">
        <div class="col-md-12">
          <button type="submit" class="btn btn-primary">Save</button>
          <a href="/project/${projectId}" class="btn btn-default">Cancel</a>
        </div>
      </div>

    </form>

  </div>
</body>

<smart:bower_js path="jquery/dist/jquery.js" />
<smart:bower_js path="bootstrap/dist/js/bootstrap.js" />
<smart:bower_js path="typeahead.js/dist/typeahead.jquery.min.js" />
<smart:bower_js path="typeahead.js/dist/typeahead.bundle.min.js" />
<smart:bower_js path="bootstrap-tagsinput/dist/bootstrap-tagsinput.js" />
<smart:bower_js path="bootstrap-datepicker/dist/js/bootstrap-datepicker.js" />
<smart:bower_js path="bootstrap-timepicker/js/bootstrap-timepicker.js" />

<script type="text/javascript" src="/assets/js/components.js"></script>

<script type="text/javascript">
  var projectId = $('#projectId').val();

  deepworking.timePicker.init($('.input-timepicker'));

  deepworking.datePicker.init($('#date'));

  deepworking.typeahead.init($("#activityType"), {
      dataSourceUri: '/project/' + projectId + '/activityTypes'
  });
</script>
</html>
