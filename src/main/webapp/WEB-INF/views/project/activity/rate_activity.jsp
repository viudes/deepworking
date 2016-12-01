<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>

<!DOCTYPE html>
<html>
<head>
    <smart:bower_css path="bootstrap/dist/css/bootstrap.min.css" />
    <smart:bower_css path="bootstrap/dist/css/bootstrap-theme.min.css" />
    <smart:bower_css path="bootstrap-select/dist/css/bootstrap-select.min.css" />

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
        <h1>Livro de OAuth <small>Rate write activity</small></h1>
    </div>

    <form>
      <div class="row">
         <div class="col-md-3">
            <dl>
              <dt><label for="rateScore">Score</label></dt>
              <dd>
              <select class="selectpicker" id="rateScore">
                  <option value="good">Good</option>
                  <option value="regular">Regular</option>
                  <option value="bad">Bad</option>
              </select>
              </dd>
            </dl>
        </div>
        <div class="col-lg-3">
            <dl>
                <dt><label for="interruptionOccurrences">Interruption occurrences</label></dt>
                <dd><input class="form-control" type="text" id="interruptionOcurrences" placeholder="How many times of interruption"/></dd>
            </dl>
        </div>
      </div>


      <div class="row">
          <div class="col-lg-8">
              <dl>
                  <dt><label for="notes">Notes</label></dt>
                  <dd><input class="form-control" type="text" id="notes" placeholder="Notes about your interruption"/></dd>
              </dl>
          </div>
      </div>

      <div id="actions" class="row">
        <div class="col-md-12">
           <button type="submit" class="btn btn-primary">Rate this activity</button>
           <a href="<c:url value='/project/1/activity'/>" class="btn btn-default">Cancel</a>
        </div>
      </div>

    </form>

  </div>
</body>

<smart:bower_js path="jquery/dist/jquery.js" />
<smart:bower_js path="bootstrap/dist/js/bootstrap.js" />
<smart:bower_js path="bootstrap-select/dist/js/bootstrap-select.min.js" />

<script type="text/javascript">
$('.selectpicker').selectpicker({
    size: 4
  });
</script>
</html>
