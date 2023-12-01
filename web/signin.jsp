<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/singin.css">
        <style>
            body{
                overflow-y: hidden;
            }
            .ftco-section{
                padding: 4.3em 0;
            }
            .login-button.google {
                background-color: #dd4b39;
                color: white;
                border-radius: 40px;
                padding: 10px 20px;
                cursor: pointer;
                border: none;
                width: 100%;
            }
            .login-button.google a {
                text-decoration: none;
            }

            .login-button.google:hover {
                background-color: #c23321;
            }

            .google-icon {
                margin-right: 10px;
            }

            .button-text {
                vertical-align: middle;
            }
            .title{
                margin-top: 2rem;
                text-align: center;
            }
            .errorRecaptcha{
                color: red;
            }

        </style>

    </head>
    <body class="img js-fullheight" style="background-image: url(img/1567736.png);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Login</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <form action="maincontroller" class="signin-form" method="POST">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Username"  name="username">
                                </div>
                                <div class="form-group">
                                    <input id="password-field" type="password" class="form-control" placeholder="Password"  name="password">
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <input name="action" value="Login" type="submit" class="form-control btn btn-primary submit px-3">
                                </div>
                            </form>
                            <a href="maincontroller?action=top1" style="display: none">Top 1</a>
                            <div class="g-recaptcha" 
                                 data-sitekey="6LegWsomAAAAAO-syKgxjEOXI5kYl2zHar-Yquld">   
                            </div><br/>
                            <div class="errorRecaptcha"></div>
                            <p class="title">&mdash; Or Sign In With &mdash;</p>
                            <button class="login-button google">
                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile&redirect_uri=http://localhost:8084/PRJ301_JSTL_WEB_Laptop/GoogleCallbackServlet&response_type=code&client_id=427553598134-aeob396l0lg4vpl7q4va3ngdnsb26kcp.apps.googleusercontent.com">
                                    <i class=""></i><span class="button-text">Log in with Google</span>
                                </a>
                            </button>

                            <div id='lower-side'>
                                <p class="text-danger">${mess}</p>
                                <p id='message'>
                                    Not a member? <p style="color: red"> <a href="signup">Register Now</a></p>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
 
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="https://www.google.com/recaptcha/api.js"></script>
        <script>
            var loginForm = document.querySelector('.container');
            loginForm.addEventListener("submit", function (e) {
                const response = grecaptcha.getResponse();
                if (!response) {
                    e.preventDefault();
                    document.querySelector('.errorRecaptcha').innerHTML = 'Failed to verify with the RECAPTCHA server.';
                }
            })
        </script>
        <script src="https://kit.fontawesome.com/11861eee9a.js" crossorigin="anonymous"></script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

</body>
</html>

