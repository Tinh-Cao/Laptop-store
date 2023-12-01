<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Sign Up</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/singin.css">
        <style>
            body{
                overflow-y: hidden;
            }
        </style>
    </head>
    <body class="img js-fullheight" style="background-image: url(img/1567736.png);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Register</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <form action="maincontroller" class="signin-form" method="POST">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Username"  name="username">
                                </div>
                                <c:if test="${messUser != null}">                    
                                    <p class="text-danger">${messUser}</p>
                                </c:if>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Full Name"  name="fullname">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Email"  name="mail">
                                </div>
                                <c:if test="${messMail != null}">                    
                                    <p class="text-danger">${messMail}</p>
                                </c:if>
                                <div class="form-group">
                                    <input id="password-field" type="password" class="form-control" placeholder="Password"  name="password">
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <input id="password-field" type="password" class="form-control" placeholder="Re-enter Password"  name="re-password">
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <c:if test="${messPass != null}">                    
                                    <p class="text-danger">${messPass}</p>
                                </c:if>
                                <div class="form-group">
                                    <button name="action" value="signup" type="submit" class="form-control btn btn-primary submit px-3">Sign Up</button>
                                </div>
                            </form>
                            <div id='lower-side'>
                                <p id='message'>
                                    Have a account? <p style="color: red"> <a href="signin.jsp">Login Now</a></p>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

</body>
</html>

