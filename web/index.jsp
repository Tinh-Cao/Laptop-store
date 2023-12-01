<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DTO.*" %> 
<%@page import="DAO.*" %> 
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Totoroo'Shop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <%
        ProductDAO pd = new ProductDAO();
        List<ProductDTO> list = (List<ProductDTO>) pd.getAllProductDisplay();
    %>
    <body>

        <%@include file="component/topbar.jsp" %>
        <%@include file="component/navbar.jsp" %>

        <!-- Carousel Start -->
        <div class="container-fluid mb-3">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#header-carousel" data-slide-to="1"></li>

                        </ol>
                        <c:set var="tt" value="0"/>
                        <div class="carousel-inner">
                            <c:forEach var="post" items="${post}">
                                <c:set var="tt" value="${tt+1}"/>
                                <div class="carousel-item position-relative <c:if test="${tt == 1}">active</c:if>" style="height: 430px;">
                                        <img class="position-absolute w-100 h-100" src="image/banner/rog_zephyrus.jpg"
                                             style="object-fit: cover;">
                                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                            <div class="p-3" style="max-width: 700px;">
                                                <h4 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">${post.getTitle()}</h4>

                                            <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                               href="postDetail?id=${post.getPostID()}">More</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="carousel-item position-relative" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="image/banner/smart_watch.jpg"
                                     style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Post 2</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Post Detail</p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                           href="postDetail.jsp">More</a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="product-offer mb-30" style="height: 200px;">
                        <img class="img-fluid" src="image/Product/mac_air.png" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Save 20%</h6>
                            <h3 class="text-white mb-3">Special Offer</h3>
                            <a href="" class="btn btn-primary">Shop Now</a>
                        </div>
                    </div>
                    <div class="product-offer mb-30" style="height: 200px;">
                        <img class="img-fluid" src="image/Product/iphone_14.png" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Save 20%</h6>
                            <h3 class="text-white mb-3">Special Offer</h3>
                            <a href="" class="btn btn-primary">Shop Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Carousel End -->


        <!-- Featured Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5 pb-3">
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">Quality Product</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                        <h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featured End -->


        <!-- Categories Start -->
        <div class="container-fluid pt-5">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Categories</span></h2>
            <div class="row px-xl-5 pb-3">
                <c:forEach var="c" items="${category}">
                    <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                        <a class="text-decoration-none" href="category?id=${c.getCategoryID()}">
                            <div class="cat-item d-flex align-items-center mb-4">
                                <div class="flex-fill pl-3">
                                    <h6>${c.getName()}</h6>
                                    <small class="text-body">100 Products</small>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Categories End -->


        <!-- Products Start -->
        <div class="container-fluid pt-5 pb-3">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">New Products</span></h2>
            <div class="row px-xl-5">
                <c:forEach var="product" items="${sessionScope.listProducts}">
                    <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                        <div class="product-item bg-light mb-4">
                            <div class="product-img position-relative overflow-hidden">
                                <img class="img-fluid w-100" style="width: 300px; height: 250px" src="${product.image}" alt="">
                                <div class="product-action">
                                    <a class="btn btn-outline-dark btn-square" href="detailProduct?id=${product.productID}"><i class="fa fa-shopping-cart"></i></a>
                                </div>
                            </div>
                            <div class="text-center py-4">
                                <a class="h6 text-decoration-none text-truncate" href="detailProduct?id=${product.productID}">${product.pname}</a>
                                <div class="d-flex align-items-center justify-content-center mt-2">
                                    <h5>$ ${product.price}</h5><h6 class="text-muted ml-2"></h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Products End -->
        <!-- Pagination -->
        <div class="container-fluid">
            <div class="row justify-content-center">
               <ul class="pagination">
                <c:if test="${pageControl.page == '1'}">
                    <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">Previous</a></li>
                    </c:if>
                    <c:if test="${pageControl.page > '1'}">
                    <li class="page-item"><a class="page-link" href="home?page=${pageControl.page - 1}">Previous</a></li>
                    </c:if>
                <li class="page-item"><a class="page-link" href="${pageControl.urlPattern}page=${pageControl.page}">${pageControl.page}</a></li>
                <li class="page-item"><a class="page-link" href="${pageControl.urlPattern}page=${pageControl.page + 1}">${pageControl.page + 1}</a></li>
                <li class="page-item"><a class="page-link" href="${pageControl.urlPattern}page=${pageControl.page + 2}">${pageControl.page + 2}</a></li>
                <li class="page-item"><a class="page-link" href="${pageControl.urlPattern}page=${pageControl.page + 3}">${pageControl.page + 3}</a></li>
                <li class="page-item"><a class="page-link" href="${pageControl.urlPattern}page=${pageControl.page + 1}">Next</a></li>
            </ul>
            </div>
        </div>

        <!-- Pagination End -->



        <%@include file="component/footer.jsp" %>



        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>