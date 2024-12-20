<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard_style.css">
            <title>Dashboard Admin</title>
        </head>

        <body>
            <div class="container-fluid p-0">
                <!-- Header -->
                <%@ include file="/WEB-INF/views/common/header.jsp" %>

                    <!-- Sidebar and Main Content -->
                    <div class="row flex-grow-1">
                        <%@ include file="/WEB-INF/views/common/adminSideBar.jsp" %>

                            <div class="col-md-9 bg-light" id="box08">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>REFERENCE NO.</th>

                                                <th>DATE</th>
                                                <th>WATER (L)</th>
                                                <th>ELECTRICITY (L)</th>
                                                <th>RECYCLE (Kg)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            
                                            <c:forEach var="user" items="${users}">
                                                <c:if test="${user.getWater().getWaterUsage() > 0 || user.getElectricity().getElectricityUsage() > 0 || user.getRecycle().getRecycleUsage() > 0}">
                                                    <tr>
                                                        <td>
                                                            <div>

                                                                    <div>${user.username}</div>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div>

                                                                <c:forEach var="water" items="${user.getWaterList()}">
                                                                    <div>${water.dateRecorded}</div>
                                                                </c:forEach>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div>
                                                                <c:forEach var="water" items="${user.getWaterList()}">
                                                                    <div>${water.waterUsage}</div>
                                                                </c:forEach>
                                                            </div>
                                                        </td>
                                                        
                                                        <td>
                                                            <c:choose>
                                                                <c:when test="${user.getElectricity() ne null}">
                                                                    <c:forEach var="electricity" items="${user.getElectricityList()}">
                                                                        <div>${electricity.electricityUsage}</div>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div>No electricity data available</div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        <td>HERE HERE ${user.getRecycle().getRecycleUsage()}</td>

                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    
                                </div>
                            </div>
                    </div>
            </div>

            <!-- Footer -->
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>

                <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
        </body>

        </html>