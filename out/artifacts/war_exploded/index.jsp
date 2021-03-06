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
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600italic,700italic,300' rel='stylesheet' type='text/css'>s

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
<body class = "index">
  <header>
    <h1>Schedulizer</h1>
  </header>
  <div class="row">
    <div class = "three columns">
      <h2>Log In</h2>
      <form action="/login" method="post">
        <label for="username">Username</label>
        <input class= "eleven columns" type= "email" name="username" id="username">
        <label for="password">Password</label>
        <input class= "eleven columns" name="password" type="password" id="password">
        <button class = "button-primary" type="submit" >Log In</button>

      </form>
    </div>
    <div class = "nine columns">
      <h2>Sign Up</h2>
      <form action="/signin" method="post">

        <label for="username">Username</label>
        <input class= "eleven columns" type= "text" name="username" id="username">
        <label for="password">Password</label>
        <input class= "eleven columns" type="password" name="password" id="password">
        <label for="email">Email</label>
        <input class= "eleven columns" type="email" placeholder="yourmail@nigga.com" name="email" id="password">
        <button class = "button-primary" type="submit" >Sign In</button>
      </form>
    </div>
  </div>

</body>