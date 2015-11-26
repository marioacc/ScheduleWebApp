<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Basic Page Needs
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta charset="utf-8">
  <title>Schedulizer</title>
  <meta name="description" content="">
  <meta name="author" content="Mario, Martin y la Carlilla">

  <!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,700' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600italic,700italic,300' rel='stylesheet' type='text/css'>

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <script src="js/responsive-nav.js"></script>
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
  <link rel="stylesheet" href="css/main.css">
  <!-- Favicon
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <!--<link rel="icon" type="image/png" href="images/favicon.png">-->

</head>
<body class = "schedule">
  <h1>Hello, username</h1>
  <h1></h1>
  <div class="container">
    <div class="twelve columns">
      <h2 class="seven columns">Here's your weekly schedule</h2>
      <a
              href="/workhours">
        <img src="img/plus.svg" class="offset-by-two three columns" style="max-width: 5%; fill: #08A866" >
      </a>
    </div>
  </div>
  <table class="u-full-width">
    <thead>
      <tr>
        <th>MON</th>
        <th>TUE</th>
        <th>WED</th>
        <th>THU</th>
        <th>FRI</th>
        <th>SAT</th>
        <th>SUN</th>
      </tr>
    </thead>
    <tbody id="schedule">
    <tbody id="schedule">
    <tr>
      ${requestScope.tasks}
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">
       
          <c:if test="${task.day ==  1 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">

          <c:if test="${task.day ==  2 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">

          <c:if test="${task.day ==  3 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">

          <c:if test="${task.day ==  4 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">

          <c:if test="${task.day ==  5 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">

          <c:if test="${task.day ==  6 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="task" items="${requestScope.tasks}">

          <c:if test="${task.day ==  7 }">
            ${task.description}
            ${task.start_date}
            ${task.end_date}
          </c:if>
        </c:forEach>
      </td>

    </tr>
    </tbody>
    </tbody>
  </table>
  <!--<div class = "row">
    <div class = "one column" id= "Monday"><h3>MON</h3></div>
    <div class = "one column" id= "Tuesday"><h3>TUE</h3></div>
    <div class = "one column" id= "Wednesday"><h3>WED</h3></div>
    <div class = "one column" id= "Thursday"><h3>THU</h3></div>
    <div class = "one column" id= "Friday"><h3>FRI</h3></div>
    <div class = "one column" id= "Saturday"><h3>SAT</h3></div>
    <div class = "one column" id= "Sunday"><h3>SUN</h3></div>
  </div>-->

</body>
</html>