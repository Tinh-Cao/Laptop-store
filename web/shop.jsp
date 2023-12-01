<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Totoroo'Shop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="assest/img/favicon.ico" rel="icon">

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

    <body>    
        <%@include file="component/topbar.jsp" %>
        <%@include file="component/navbar.jsp" %>
        <!-- Breadcrumb Start -->
        <form action="filterPrice" method="POST">
            <!-- Breadcrumb Start -->
            <div class="container-fluid">
                <div class="px-xl-5">
                    <div class="row">
                        <div class="form-group col">
                            <select class="form-control" id="brandSelect" name="brand">
                                <option value="">Select Brand</option>
                                <c:forEach var="c" items="${cate}">
                                    <option value="${c.getName()}">${c.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col">
                            <select class="form-control" id="ramSelect" name="ram">
                                <option value="">Select RAM</option>
                                <option value="4GB" <% if("4gb".equals(request.getParameter("ram"))) out.print("selected"); %>>4GB</option>
                                <option value="8GB" <% if("8gb".equals(request.getParameter("ram"))) out.print("selected"); %>>8GB</option>
                                <option value="16GB" <% if("16gb".equals(request.getParameter("ram"))) out.print("selected"); %>>16GB</option>
                                <option value="32GB" <% if("32gb".equals(request.getParameter("ram"))) out.print("selected"); %>>32GB</option>
                            </select>
                        </div>
                        <div class="form-group col">
                            <select class="form-control" id="cpuSelect" name="cpu">
                                <option value="">Select CPU</option>
                                <option value="AMD" <% if("i7".equals(request.getParameter("cpu"))) out.print("selected"); %>>AMD</option>
                                <option value="Intel" <% if("i9".equals(request.getParameter("cpu"))) out.print("selected"); %>>Intel</option>
                            </select>
                        </div>
                        <div class="form-group col">
                            <select class="form-control" id="storageSelect" name="storage">
                                <option value="">Select Storage</option>
                                <option value="256GB" <% if("256gb".equals(request.getParameter("storage"))) out.print("selected"); %>>256GB</option>
                                <option value="512GB" <% if("512gb".equals(request.getParameter("storage"))) out.print("selected"); %>>512GB</option>
                                <option value="1TB" <% if("1tb".equals(request.getParameter("storage"))) out.print("selected"); %>>1TB</option>
                                <option value="2TB" <% if("2tb".equals(request.getParameter("storage"))) out.print("selected"); %>>2TB</option>
                            </select>
                        </div>
                        <div class="form-group col">
                            <input type="submit" id="submit-btn"value="Filter" class="btn btn-warning btn-rounded">
                        </div>
                    </div>
                </div>
            </div>
            <!-- Breadcrumb End -->



            <!-- Breadcrumb End -->




            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-8">
                <div class="row pb-3">
                    <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <div>
                                <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                                <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                            </div>
                            <div class="ml-2">
                                <div class="btn-group">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <input type="submit" class="dropdown-item" name="sortOrder" value="1" />
                                            <input type="submit" class="dropdown-item" name="sortOrder" value="2" />
                                        </div>
                                    </div>
                                </div>
                                <div class="btn-group ml-2">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#">10</a>
                                        <a class="dropdown-item" href="#">20</a>
                                        <a class="dropdown-item" href="#">30</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- List Product -->
                    <c:forEach var="pro" items="${product}">
                        <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                            <div class="product-item bg-light mb-4">
                                <div class="product-img position-relative overflow-hidden">
                                    <img class="img-fluid w-100" src="${pro.image}" alt="">
                                    <div class="product-action">
                                        <a class="btn btn-outline-dark btn-square" href="detailProduct?id=${pro.productID}"><i class="fa fa-shopping-cart"></i></a>
                                    </div>
                                </div>
                                <div class="text-center py-4">
                                    <a class="h6 text-decoration-none text-truncate" href="">${pro.pname}</a>
                                    <div class="d-flex align-items-center justify-content-center mt-2">
                                        <h5>$ ${pro.price}</h5><h6 class="text-muted ml-2"></h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>



                    <div class="col-12">
                        <nav>
                            <ul class="pagination justify-content-center">
                                <li class="page-item disabled"><a class="page-link" href="#">Previous</span></a></li>
                                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->


</form>
<%@include file="component/footer.jsp" %>
<!-- Footer End -->


<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="assest/lib/easing/easing.min.js"></script>
<script src="assest/lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="assest/mail/jqBootstrapValidation.min.js"></script>
<script src="assest/mail/contact.js"></script>

<!-- Template Javascript -->
<script src="assest/js/main.js"></script>
<script>
    // Get the submit button and checkboxes
    var submitButton = document.getElementById('submit-btn');
    var checkboxes = document.querySelectorAll('.custom-control-input');

    // Add event listener to each checkbox
    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener('click', function () {
            // Trigger a click event on the submit button
            submitButton.click();
        });
    });
</script>
</body>

</html>