<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <table class="table">
        <tr>
            <td class="col-md-1">Details</td>
            <td class="col-md-2">Project</td>
            <td class="col-md-8">Activity types</td>
        </tr>

        <smart:forEach items="${projects}" var="project">
            <tr>
                <td>
                   <a class="details" href="<c:url value='/project/${project.id}'/>">
                      <span class="glyphicon glyphicon-zoom-in"></span>
                   </a>
                </td>
                <td>${project.name}</td>
                <td>${project.activityTypes}</td>
            </tr>
        </smart:forEach>

    </table>

  </div>
</body>
</html>
