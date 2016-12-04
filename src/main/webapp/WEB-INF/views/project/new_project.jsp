<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://smart.com.br/tags" prefix="smart"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="pragma" content="no-cache" />

<title>Project</title>

<smart:bower_css path="bootstrap/dist/css/bootstrap.css" />
<smart:bower_css path="bootstrap-tagsinput/dist/bootstrap-tagsinput.css" />

</head>

<body>

  <div class="container">
    <h1>Create your project</h1>

    <form:form method="post" action="${spring:mvcUrl('PC#save').build()}" modelAttribute="projectEntry">

      <form:hidden path="id" />

      <div class="panel panel-default">
        <div class="panel-body">
          <div class="row">
            <div class="form-group col-md-3">
                <form:input cssClass="form-control" placeholder="Project name" path="name" />
            </div>
          </div>
        </div>
      </div>

      <div class="panel panel-default">
        <div class="panel-heading">Activities definitions</div>
        <div class="panel-body activityList">

          <div class="row activity-container">
            <div class="col-md-2">
              <input type="text" class="form-control inputRowName" placeholder="Name" />
            </div>
            <div class="col-md-6">
              <input type="text" class="form-control inputRowDescription" placeholder="Description" />
            </div>
            <div class="col-md-2">
                <a href="#" class="btn btn-info" id="add_activity">Add</a>
            </div>
          </div>

          <div class="row activityRow">
              <br/>
              <div class="col-md-2 name">
              </div>
              <div class="col-md-6 description">
              </div>
              <div class="col-md-2 deleteBox">
              </div>
          </div>

        </div>

      </div>

      <div id="actions" class="row">
        <div class="col-md-12">
          <button type="submit" class="btn btn-primary">Save</button>
          <a href="<c:url value='/'/>" class="btn btn-default">Cancel</a>
        </div>
      </div>

    </form:form>
  </div>

</body>

<smart:bower_js path="jquery/dist/jquery.js" />
<smart:bower_js path="vanilla-masker/lib/vanilla-masker.js" />
<smart:bower_js path="bootstrap/dist/js/bootstrap.js" />
<smart:bower_js path="bootstrap-tagsinput/dist/bootstrap-tagsinput.js" />
<script type="text/javascript" src="/assets/js/components.js"></script>

<script type="text/javascript">
deepworking.smartList.create({
    container: '.activityList',
    row: '.activityRow',
    allowDelete: true,
    addButton: '#add_activity'
});
</script>

</html>
