<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Totoroo'Shop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="admin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="admin/css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="admin/css/style.css" rel="stylesheet">
        <style>
            .left-side {
                float: left;
                width: 50%;
            }

            .right-side {
                float: right;
                width: 50%;
            }
        </style>

    <div class="left-side">
        <!-- Các phần tử trong left-side -->
    </div>

    <div class="right-side">
        <!-- Các phần tử trong right-side -->
    </div>

</head>

<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <%@include file="component/SideBarAdmin.jsp" %>

        <!-- Content Start -->
        <div class="content">
            <%@include file="component/navbarAdmin.jsp" %>
            <!-- Blank Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="container-fluid pt-4 px-4">
                    <div class="row g-4">
                        <div class="">
                            <div class="bg-secondary rounded h-100 p-4">
                                <h6 class="mb-4">Update Product</h6>
                                <form action="maincontroller" method="POST" enctype="multipart/form-data">
                                    <div class="left-side">
                                        <div class="col-md-6">
                                            <label class="form-label">Product Name</label>
                                            <input type="text" class="form-control col-4" name="name" value="${p.getPname()}"required >
                                        </div>
                                        <div class="col-md-6">  
                                            <label class="form-label">Category</label>
                                            <select class="form-select form-select-sm col-md-3" aria-label=".form-select-sm example" name="cate" required>
                                                <c:forEach var="c" items="${cate}">
                                                    <option  class="form-label" value="${c.getCategoryID()}">${c.getName()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Quantity </label>
                                            <input type="number" class="form-control col-3" name="quantity" value="${p.getQuantity()}" required="">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">Price </label>
                                            <input type="number" class="form-control col-3" name="price" value="${p.getPrice()}" required >
                                        </div>
                                    </div>
                                    <div class="right-side">

                                        <div class="col-md-6">  
                                            <label class="form-label">Ram</label>
                                            <select class="form-select form-select-sm col-md-3" aria-label=".form-select-sm example" name="ram">
                                                <option  class="form-label" value="4GB">4GB</option>
                                                <option  class="form-label" value="8GB">8GB</option>
                                                <option  class="form-label" value="16GB">16GB</option>
                                                <option  class="form-label" value="32GB">32GB</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">  
                                            <label class="form-label">Storage</label>
                                            <select class="form-select form-select-sm col-md-3" aria-label=".form-select-sm example" name="storage">
                                                <option  class="form-label" value="256GB">256GB</option>
                                                <option  class="form-label" value="512GB">512GB</option>
                                                <option  class="form-label" value="1TB">1TB</option>
                                                <option  class="form-label" value="2TB">2TB</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">  
                                            <label class="form-label">CPU Brand</label>
                                            <select class="form-select form-select-sm col-md-3" aria-label=".form-select-sm example" name="cpu">
                                                <option  class="form-label" value="AMD">AMD</option>
                                                <option  class="form-label" value="Intel">Intel</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">  
                                            <label class="form-label">VGA Brand</label>
                                            <input type="text" class="form-control col-3" name="vga" value="${p. getVga()}" >
                                        </div>
                                    </div>
                                    <div class="col-md-6" id="module">
                                        <div class="mb-3">
                                            <label for="formFile" class="form-label">Image</label>
                                            <input class="form-control bg-dark" type="file" name="image"id="formFile">

                                        </div>
                                    </div>
                                    <input name="action" value="UpdateProduct" hidden="" />
                                    <input name="productID" value="${productID}" hidden="" />
                                    <p class="text-danger">${mess}</p>
                                    <button  type="submit" class="btn btn-primary">Update</button>
                                </form>
                            </div>
                        </div> 
                    </div>
                </div>

            </div>

            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="admin/lib/chart/chart.min.js"></script>
        <script src="admin/lib/easing/easing.min.js"></script>
        <script src="admin/lib/waypoints/waypoints.min.js"></script>
        <script src="admin/lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="admin/lib/tempusdominus/js/moment.min.js"></script>
        <script src="admin/lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Template Javascript -->
        <script src="admin/js/main.js"></script>  
</body>

</html>