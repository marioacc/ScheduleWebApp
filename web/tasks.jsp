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
<body class = "tasks">
  <h2>Enter your tasks...</h2>
  <div class = "row">
    <div class = "six columns">
      <label for= "taskname" >Name:</label>
      <input type= "text" id= "taskname" class= "eleven columns">
    </div>
    <div class = "three columns">
    <p>Select a priority for each task. Multiple tasks can have the same priority</p>
      <label for= "priority" >Name:</label>
       <select id="priority" class= "seven columns">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
      </select>
    </div>
    <div class = "three columns">
      <label for= "time" >Estimate time to complete:</label>
      <input type="datetime-local" class= "ten columns" id= "task_time">
    </div>
    <button class = "button-primary center-big">+</button>
  </div>
</body>
</html>