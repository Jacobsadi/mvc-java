<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard_style.css">
      <title>Dashboard Participant</title>
    </head>

    <body>
      <div class="container-fluid p-0">
        <!-- Header -->
        <%@ include file="/WEB-INF/views/common/header.jsp" %>

          <!-- Announcements -->
          <div class="row" id="box02">
            <div class="col-12 bg-info text-white text-center py-3">
              <div class="announce">WELCOME TO LCS PANTAU SYSTEM</div>
            </div>
          </div>

          <!-- Sidebar and Main Content -->
          <div class="row flex-grow-1">
            <div class="col-md-3 bg-skyblue text-white" id="box03">
              <div class="sidebar-heading py-2">Dashboard</div>
              <ul class="nav flex-column sidebar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/user/regist?section=myAccount">My Account</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="javascript:void(0);" onclick="showUtilityForm()">Input Utility Bill Data</a>
                </li>
                <!-- Add more links as needed -->
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/logout">LOG OUT</a>
                </li>
              </ul>
            </div>

            <div class="col-md-9 bg-light" id="box08">
              <!-- Dynamic content based on selection will be displayed here -->
            </div>
          </div>
      </div>

      <!-- Footer -->
      <%@ include file="/WEB-INF/views/common/footer.jsp" %>

      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
      <script>
        function showUtilityForm() {
          var box08 = document.getElementById('box08');
          if (box08) {
            box08.innerHTML = `
          <ul class="nav nav-tabs" id="utilityTabs" role="tablist">
            <li class="nav-item">
              <a class="nav-link active" id="water-tab" data-toggle="tab" href="#water" role="tab" aria-controls="water" aria-selected="true">Water</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="electricity-tab" data-toggle="tab" href="#electricity" role="tab" aria-controls="electricity" aria-selected="false">Electricity</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="recycling-tab" data-toggle="tab" href="#recycling" role="tab" aria-controls="recycling" aria-selected="false">Recycling</a>
            </li>
          </ul>

          <div class="tab-content" id="utilityTabContent">
            <div class="tab-pane fade show active" id="water" role="tabpanel" aria-labelledby="water-tab">
          <jsp:include page="/WEB-INF/views/forms/waterForm.jsp" />
            </div>
            <div class="tab-pane fade" id="electricity" role="tabpanel" aria-labelledby="electricity-tab">
              <jsp:include page="/WEB-INF/views/forms/electricityForm.jsp" />
            </div>
            <div class="tab-pane fade" id="recycling" role="tabpanel" aria-labelledby="recycling-tab">
              <jsp:include page="/WEB-INF/views/forms/recyclingForm.jsp" />
            </div>
          </div>
        `;

            $('#utilityTabs a').on('click', function (e) {
              e.preventDefault();
              $(this).tab('show');
            });
          }
        }

        function showThankYouMessage() {
          var box08 = document.getElementById('box08');
          if (box08) {
            box08.innerHTML = `
          <div style="text-align:center;">
              <h1>THANK YOU</h1>
              <p>FOR YOUR SUBMISSION</p>
              <div>Reference Number: MBIP001 / 0015</div>
              <div>You can check your submission thru "My Account"</div>
              <button onclick="dismissThankYou()">DISMISS</button>
          </div>`;
          }
        }

        function dismissThankYou() {
          window.location.href = '/dashboard/participant';
        }
      </script>

    </body>

    </html>