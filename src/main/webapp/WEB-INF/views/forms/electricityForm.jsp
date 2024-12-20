<!-- WaterForm.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_page_style.css">
  <title>${loggedInUser.username}'s Electricity Data Submission Form</title>
  <style>
    html, body {
      background: none !important;
    }
  </style>
</head>

<body>
  <h1></h1>
    <div>
        <div class="wrapper " >
            <form id="electricityForm" method="POST" action="/electricity/addelectricity">
              <h1>${loggedInUser.username}'s Electricity Data Submission Form</h1>
              <div class="input-box">
                <!-- Set readonly attribute to make the field non-editable -->
                <input type="text" id="userID" name="userID" placeholder="User ID" value="${loggedInUser.userId}" readonly required>
            </div>
              <div class="input-box">
                <input type="date" name="dateRecorded" id="dateRecorded" required>
              </div>
              <div class="input-box">
                <input type="number" name="electricityUsage" id="electricityUsage" placeholder="Electricity Usage" required>
              </div>
              <button type="submit" class="btn">Submit Electricity Data</button>
            </form>
          </div>
    </div>

</body>

</html>
