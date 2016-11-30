<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>

<!DOCTYPE html>
<html>
<head>
    <smart:bower_css path="bootstrap/dist/css/bootstrap.css" />
    <smart:bower_css path="bootstrap/dist/css/bootstrap-theme.css" />
    <smart:bower_css path="bootstrap-datepicker/dist/css/bootstrap-datepicker.css" />
    <smart:bower_css path="bootstrap-tagsinput/dist/bootstrap-tagsinput.css" />
    <smart:bower_css path="bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css" />

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
        <h1>Livro de OAuth <small>Register an activity entry</small></h1>
    </div>

    <form>
      <div class="row">
          <div class="form-group col-lg-2">
              <label for="date">Date</label>
              <div id="date" class="input-group date">
                  <input type="text" class="form-control" placeholder="Date of work"/>
                  <span class="input-group-addon add-on">
                    <span class="glyphicon glyphicon-calendar"/>
                  </span>
              </div>
          </div>
          <div class="col-lg-2">
              <label for="activityType">Activity type</label>
              <div class="form-group">
                <input id="activityType" class="typeahead form-control" type="text" placeholder="Type of activity"/>
              </div>
          </div>
          <div class="col-lg-2">
              <dl>
                  <dt><label for="startTime">Start time</label></dt>
                  <dd><input class="form-control" type="text" id="startTime" placeholder="Hour when started"/></dd>
              </dl>
          </div>
          <div class="col-lg-2">
              <dl>
                  <dt><label for="amountHours">Amount of time</label></dt>
                  <dd><input class="form-control" type="text" id="amountHours" placeholder="Minutes spent"/></dd>
              </dl>
          </div>
      </div>

      <div class="row">
        <div class="col-lg-4">
            <div>
                <dl>
                  <dt><label for="activityType">Tags</label></dt>
                  <dd><input id="activityType" class="form-control" type="text" placeholder="Type related tags to this activity"/></dd>
                </dl>
            </div>
        </div>
        <div class="col-lg-6">
            <dl>
                <dt><label for="description">Description</label>
                <dd><input class="form-control" type="text" id="description" placeholder="Type in few words some details about this activity"></dd>
            </dl>
        </div>
      </div>

      <div id="actions" class="row">
        <div class="col-md-12">
          <button type="submit" class="btn btn-primary">Save</button>
          <a href="<c:url value='/project/1/activity'/>" class="btn btn-default">Cancel</a>
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

<script type="text/javascript">
  $(function() {
      $('#date').datepicker({
          format: "dd/mm/yyyy",
          titleFormat: "MM yyyy"
      }).on('changeDate', function(evt) {
          $('.datepicker-dropdown').hide();
      });
  });

  var substringMatcher = function(strs) {
    return function findMatches(q, cb) {
      var matches, substringRegex;

      // an array that will be populated with substring matches
      matches = [];

      // regex used to determine if a string contains the substring `q`
      substrRegex = new RegExp(q, 'i');

      // iterate through the pool of strings and for any string that
      // contains the substring `q`, add it to the `matches` array
      $.each(strs, function(i, str) {
        if (substrRegex.test(str)) {
          matches.push(str);
        }
      });

      cb(matches);
    };
  };
  var activityTypes = ['Leitura', 'Pesquisa', 'Escrita', 'Estrutra'];

  $("#activityType").typeahead({
    hint: true,
    highlight: true,
    minLength: 2
  }, {
    name: 'activityTypes',
    source: substringMatcher(activityTypes)
  });

</script>
</html>
