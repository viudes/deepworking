<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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

    <div class="jumbotron centerfy">
      <h1>Projects</h1>
    </div>

    <table class="table">
        <tr>
            <td></td>
            <td>Project</td>
            <td>Activities</td>
        </tr>

        <smart:forEach items="${projects}" var="project">
            <tr>
                <td>
                   <a class="details" href="<c:url value='/project/1'/>">
                      <span class="glyphicon glyphicon-zoom-in"></span>
                   </a>
                   <a class="delete" href="<c:url value='/project/1/delete'/>">
                      <span class="glyphicon glyphicon-trash"></span>
                   </a>
                </td>
                <td>${project.name}</td>
                <td>${project.labels}</td>
            </tr>
        </smart:forEach>

    </table>

  </div>
</body>
</html>
