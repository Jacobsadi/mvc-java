<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
      <!-- <link rel="stylesheet" href="src\main\resources\static\css\dashboard_style.css"> -->
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
                <c:choose>
                  <c:when test="${section == 'myAccount'}">
                    <jsp:include page="/WEB-INF/views/admin/details.jsp" />
                  </c:when>
                  <c:when test="${section == 'receivedData'}">
                    <jsp:include page="/WEB-INF/views/fragments/receieved_data_from_participants.jsp" />
                  </c:when>
                  <c:when test="${section == 'carbonCalculator'}">
                    <jsp:include page="/WEB-INF/views/fragments/carbon_calculator.jsp" />
                  </c:when>
                  <c:otherwise>
                    <div class="py-2">Select an option from the dashboard.</div>
                  </c:otherwise>
                </c:choose>
              </div>
          </div>
      </div>

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    </body>

    </html>