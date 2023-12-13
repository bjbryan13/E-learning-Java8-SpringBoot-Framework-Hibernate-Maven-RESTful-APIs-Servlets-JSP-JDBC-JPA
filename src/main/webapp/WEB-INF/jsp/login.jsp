<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
html {
  background-color: #56baed;
}

body {
  font-family: "Poppins", sans-serif;
  height: 100vh;
}

a {
  color: #92badd;
  display:inline-block;
  text-decoration: none;
  font-weight: 400;
}

h2 {
  text-align: center;
  font-size: 16px;
  font-weight: 600;
  text-transform: uppercase;
  display:inline-block;
  margin: 40px 8px 10px 8px; 
  color: #cccccc;
}



/* STRUCTURE */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 25px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}



/* TABS */

h2.inactive {
  color: #cccccc;
}

h2.active {
  color: #0d0d0d;
  border-bottom: 2px solid #5fbae9;
}



/* FORM TYPOGRAPHY*/

input[type=button], input[type=submit], input[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
  background-color: #39ace7;
}

input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

input[type=text] {
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}

input[type=text]:focus {
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}

input[type=text]:placeholder {
  color: #cccccc;
}



/* ANIMATIONS */

/* Simple CSS3 Fade-in-down Animation */
.fadeInDown {
  -webkit-animation-name: fadeInDown;
  animation-name: fadeInDown;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

.fadeIn.first {
  -webkit-animation-delay: 0.4s;
  -moz-animation-delay: 0.4s;
  animation-delay: 0.4s;
}

.fadeIn.second {
  -webkit-animation-delay: 0.6s;
  -moz-animation-delay: 0.6s;
  animation-delay: 0.6s;
}

.fadeIn.third {
  -webkit-animation-delay: 0.8s;
  -moz-animation-delay: 0.8s;
  animation-delay: 0.8s;
}

.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
  display: block;
  left: 0;
  bottom: -10px;
  width: 0;
  height: 2px;
  background-color: #56baed;
  content: "";
  transition: width 0.2s;
}

.underlineHover:hover {
  color: #0d0d0d;
}

.underlineHover:hover:after{
  width: 100%;
}



/* OTHERS */

*:focus {
    outline: none;
} 

#icon {
  width:60%;
}

</style>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="data:image/png;base64,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" id="icon" alt="User Icon" />
    </div>
    <BR>

    <!-- Login Form -->
    <form th:action="@{/login}" method="post">
    <div th:if="${param.error}">
						<div class="alert alert-danger">Invalid username or
							password.</div>
					</div>
					<div th:if="${param.logout}">
						<div class="alert alert-info">Usted ha sido desconectado.</div>
					</div>
      <input input type="text"
							id="username" name="username" class="form-control"
							autofocus="autofocus" placeholder="Username"  />

      <input input type="text"
							id="password" name="password" class="form-control"
							autofocus="autofocus" placeholder="password"  />


							
     <input type="submit" class="fadeIn fourth" value="Log In">
      	 <!-- <div class="form-group">
						<span>New user? <a href="/" th:href="@{/registration}">Register
								here</a></span>
					</div>-->
    <div id="formFooter">
      <a class="underlineHover" href="#">Se olvodo contraseña?</a>
    </div>
    </form>

    <!-- Remind Passowrd -->


  </div>
</div>