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
<body class = "workinghours">
  <h2>Select your free time to work on your projects and tasks</h2>
  <form action="/newworkhours" method="post" class = "row" id="workHoursSection">
    <div id="workHourRow">
      <div class = "two columns">
        <label for= "day" >Days:</label>
        <input type="text" id="day" class= "seven columns" name="day" required="required" pattern="[1-7]">
      </div>
      <div class = "five columns">
        <label for= "start_time" >From:</label>
        <input type="time" name="start_time" class= "ten columns" id= "start_time" required="required">
      </div>
      <div class = "five columns" >
        <label for= "end_time" >To:</label>
        <input type="time" name="end_time" class= "ten columns" id= "end_time" required="required">
      </div>
    </div>

    <div class="row " id="submitSection">
      <button class = "  two columns button-primary center-big " id="add"  onclick="addWorkHour();return false;">+</button>
      <button class = "two columns button-primary center-big " value="submit">&#x2713</button>
    </div>
  </form>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/loadWorkHours.js"></script>
</body>
</html>