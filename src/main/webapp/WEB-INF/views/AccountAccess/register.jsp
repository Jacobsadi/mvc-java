<!-- Register.jsp -->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- <link rel="stylesheet" href="../../CSS/style1.css"> -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_page_style.css">

  <title>Register Form</title>
</head>

<body>

  <!-- action="${pageContext.request.contextPath}/user/register" method="post" -->
  <div class="wrapper">
    <c:choose>
        <c:when test="${mode eq 'add'}">
            <c:set var="action" value="/user/register" />
        </c:when>
        <c:otherwise>
            <c:set var="action" value="/user/editUser" />
        </c:otherwise>
    </c:choose>

    <form id="registrationForm" action="${action}" method="post"> <!-- Make sure to add action and method -->
        <h1>LCS PANTAU SYSTEM REGISTRATION</h1>
        <div class="input-box">
            <input type="text" id="name" name="username" placeholder="Name" value="${user.username}" required>
        </div>
        <div class="input-box">
            <input type="email" id="email" name="email" placeholder="Email" value="${user.email}" required>
        </div>
        <div class="input-box">
            <input type="email" id="confirmEmail" name="confirmEmail" placeholder="Confirm Email" value="${user.email}" required>
        </div>
        <div class="input-box">
            <input type="password" id="password" name="password" placeholder="Password" required>
        </div>
        <div class="input-box">
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required>
        </div>
        <div class="input-box">
            <input type="text" id="contact" name="contact" placeholder="Contact Number" value="${user.contact}" required>
        </div>
        <div class="input-box">
            <input type="text" id="area" name="area" placeholder="Area" value="${user.area}" required>
        </div>
        <button type="submit" class="btn">${mode eq 'add' ? 'Register' : 'Update'}</button>
    </form>
  </div>


  <script>

    document.getElementById('registrationForm').addEventListener('submit', function (event) {
      event.preventDefault();


      // Collect form data
      var name = document.getElementById('name').value;
      var email = document.getElementById('email').value;
      var password = document.getElementById('password').value;
      var contact = document.getElementById('contact').value;
      var area = document.getElementById('area').value;


      // Create an object with the user's data
      var userData = {
        username: name, // Assuming username is the name, adjust if different in User model
        email: email,
        password: password,
        contact: contact,
        area: area
      };
      

      // AJAX request to send the data to the server
      fetch("${action}", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
      })
        .then(response => response.json())
        .then(data => {
          console.log('Registration successful.', data);

          // Redirect to login page or a success page
          window.location.href = '/';

          alert("Welcome to MBIP System!  your account created successfully");

        })
        .catch((error) => {
          console.error('Error:', error);
        });






      // if(email !== confirmEmail) {
      //   alert('Emails do not match.');
      //   return;
      // }



      // if(password !== confirmPassword) {
      //   alert('Passwords do not match.');
      //   return;
      // }

      // Here you can add the AJAX request to send the data to the server
      console.log('Registration successful.');


      // Assuming the AJAX request is successful, you might want to redirect to the login page or a success page
      // window.location.href = 'login.html';
    });
  </script>
</body>

</html>