<div class="col-md-2 bg-skyblue text-white" id="box03">
    <div class="sidebar-heading py-2">Dashboard</div>
    <ul class="nav flex-column sidebar-nav">
        <!-- User sideBar  -->   
        <div>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/participant?section=myAccount">My Account</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/participant?section=inputUtilityBill">Input Utility Bill Data</a>
              </li>
              <!-- Add more links as needed -->
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">LOG OUT</a>
              </li>
        </div>

    </ul>
</div>