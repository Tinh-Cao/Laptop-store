<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="DAO.*" %>
<%@page import="DTO.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Totoroo - Online Shop Website </title>
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

    <body>
        <%@include file="component/topbar.jsp" %>
        <%@include file="component/navbar.jsp" %>


        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="home">Home</a>
                        <a class="breadcrumb-item text-dark" href="shop">Shop</a>
                        <span class="breadcrumb-item active">My purchase</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Cart Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="     table-responsive mb-5">
                    <table class="table table-light table-borderless table-hover text-center mb-0">
                        <thead class="thead-dark">
                            <tr>
                                <th>No</th>
                                <th>Order Date</th>
                                <th>Total price</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody class="align-middle"> 
                            <c:set var="tt" value="0"/>
                            <c:forEach items="${purchase}" var="p">
                                <c:set var="tt" value="${tt+1}"/>
                                <tr>
                                    <td>${tt}</td>
                                    <td class="align-middle">${p.getOrderDate()}</td> 
                                    <td class="align-middle">${p.getTotalPrice()}</td> 
                                    <c:if test="${p.getStatus() == 0}">
                                        <td class="align-middle"><p class="text-danger">Waiting for progressing</p></td>
                                    </c:if>
                                    <c:if test="${p.getStatus() == 1}">
                                        <td class="align-middle"><p class="text-danger">Confirmed and packed</p></td>
                                    </c:if>
                                    <c:if test="${p.getStatus() == 2}">
                                        <td class="align-middle"><p class="text-danger">Being transported</p></td>
                                    </c:if>
                                    <c:if test="${p.getStatus() == 3}">
                                        <td class="align-middle"><p class="text-danger">Delivered</p></td>
                                    </c:if>
                                    <c:if test="${p.getStatus() == 4}">
                                        <td class="align-middle"><p class="text-danger">Order has been cancel</p></td>
                                    </c:if>
                                    <c:if test="${p.getStatus() == 5}">
                                        <td class="align-middle"><p class="text-success">Order has been delivered</p></td>
                                    </c:if>
                                    <td class="align-middle"><button class="btn btn-link btn-detail" data-toggle="modal" data-target="#orderModal${tt}"> Detail</button></td>
                                </tr>
                            </c:forEach>        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <c:set var="i" value="0"/>
        <c:forEach items="${purchase}" var="p">
            <c:set var="i" value="${i+1}"/>
            <div class="modal fade" id="orderModal${i}" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="orderModalLabel">Order Detail</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table class="table table-light table-borderless table-hover text-center mb-0">
                                <tr>
                                    <th>Product Name</th>
                                    <th >Price</th>
                                    <th >Action</th>
                                </tr>
                                <c:forEach var="k" items="${odDAO.getOrderDetailByID(p.getOrderID())}">
                                    <tr>
                                        <td >${pDAO.getProductByID(k.getProduct_id()).getPname()}</td>
                                        <td>${pDAO.getProductByID(k.getProduct_id()).getPrice()}$</td>
                                        <td><a href="detailProductb ?id=${k.getProduct_id()}"> Feedback</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach> 
        <!-- Cart End -->
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
        <script>
            // Xử lý sự kiện khi nhấp vào nút "Detail"
            var btnDetails = document.getElementsByClassName("btn-detail");
            var modalBody = document.querySelector("#orderModal .modal-body");

            for (var i = 0; i < btnDetails.length; i++) {
                btnDetails[i].addEventListener("click", function () {
                    // Lấy thông tin chi tiết đơn hàng
                    var orderDetail = /* Lấy thông tin chi tiết đơn hàng tương ứng với nút nhấp */;
                            // Hiển thị thông tin chi tiết đơn hàng trong modal
                            modalBody.innerHTML = orderDetail;
                });
            }
        </script>
    </body>

</html>