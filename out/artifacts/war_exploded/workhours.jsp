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
  <div class = "row" id="workHoursSection">
    <div id="workHourRow">
      <div class = "two columns">
        <label for= "weekdays" >Days:</label>
        <select id="weekdays" class= "seven columns" >
          <option value="1" selected>SUN</option>
          <option value="2">MON</option>
          <option value="3">TUE</option>
          <option value="4">WED</option>
          <option value="5">THU</option>
          <option value="6">FRI</option>
          <option value="7">SAT</option>
        </select>
      </div>
      <div class = "five columns">
        <label for= "start_time" >From:</label>
        <input type="time" class= "ten columns" id= "start_time">
      </div>
      <div class = "five columns">
        <label for= "end_time" >To:</label>
        <input type="time" class= "ten columns" id= "end_time">
      </div>
    </div>
  </div>
  <div class="row ">
    <button class = "  two columns button-primary center-big " onclick="addWorkHour()">+</button>
    <button class = "two columns button-primary center-big " onclick="sendWorkHours()">&#x2713</button>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/loadWorkHours.js"></script>
</body>
</html>