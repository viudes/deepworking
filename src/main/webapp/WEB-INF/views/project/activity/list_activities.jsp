<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <div class="page-header">
        <h1>Livro de OAuth <small>All activities</small></h1>
    </div>

    <div id="actions" class="row">
      <div class="col-md-12">
        <a href="<c:url value='/project/1'/>" class="btn btn-default">Cancel</a>
      </div>
    </div>

    <br/>

    <div class="panel panel-default">
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
                <tr>
                    <th>Rate</th>
                    <th>Date</th>
                    <th>Activity</th>
                    <th>Start time</th>
                    <th>Amount hours</th>
                    <th>Tags</th>
                    <th>Description</th>
                    <th>Score</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <a class="rate" href="<c:url value='/project/${activity.project.id}/activity/${activity.id}/rate'/>">
                          <span class="glyphicon glyphicon-star"></span>
                       </a>
                    </td>
                    <td>29/11/2016</td>
                    <td>Research</td>
                    <td>15:00</td>
                    <td>3</td>
                    <td>reading, summary, sketch</td>
                    <td>Researching about authentication</td>
                    <td>Good</td>
                </tr>
                <tr>
                    <td>
                       <a class="rate" href="<c:url value='/project/${activity.project.id}/activity/${activity.id}/rate'/>">
                          <span class="glyphicon glyphicon-star"></span>
                       </a>
                    </td>
                    <td>29/11/2016</td>
                    <td>Structure</td>
                    <td>10:00</td>
                    <td>3</td>
                    <td>reading, sketching, writing</td>
                    <td>Defining the basic structure of chapter 1</td>
                    <td>Regular</td>
                </tr>
            </tbody>
          </table>
        </div>
    </div>

  </div>
</body>

</html>
