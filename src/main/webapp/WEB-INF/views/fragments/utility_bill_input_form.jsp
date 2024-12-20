<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function showThankYouMessage() {
    var formBox = document.getElementById('formBox');
    var thankYouMessage = document.getElementById('thankYouMessage');
    
    // Hide the form
    formBox.style.display = 'none';
    
    // If the thankYouMessage doesn't exist, create it
    if (!thankYouMessage) {
        thankYouMessage = document.createElement('div');
        thankYouMessage.id = 'thankYouMessage';
        thankYouMessage.innerHTML = '<div style="text-align:center;">' +
            '<h1>THANK YOU</h1>' +
            '<p>FOR YOUR SUBMISSION</p>' +
            '<div>Reference Number: MBIP001 / 0015</div>' +
            '<div>You can check your submission thru "My Account"</div>' +
            '<button onclick="dismissThankYou()">DISMISS</button>' +
            '</div>';
        document.getElementById('box08').appendChild(thankYouMessage);
    } else {
        // Show the thank you message
        thankYouMessage.style.display = 'block';
    }
}

function dismissThankYou() {
    var thankYouMessage = document.getElementById('thankYouMessage');
    thankYouMessage.style.display = 'none';
    // Show the form again
    document.getElementById('formBox').style.display = 'block';
}
</script><h2>Environmental Data Submission Form</h2>
<!-- <form action="SubmitData" method="post" enctype="multipart/form-data"> -->
    <form id="utilityForm" onsubmit="event.preventDefault(); showThankYouMessage();">

    <label for="month">Select Month:</label>
    <select name="month" id="month" required>
        <option value="January">January</option>
        <option value="February">February</option>
        <option value="March">March</option>
        <option value="April">April</option>
        <option value="May">May</option>
        <option value="June">June</option>
        <!-- Additional months if needed -->
    </select><br><br>

    <label for="waterConsumption">Water Consumption Value (m3):</label>
    <input type="number" id="waterConsumption" name="waterConsumption" required><br><br>

    <label for="electricityConsumption">Electricity Consumption Value (kWh):</label>
    <input type="number" id="electricityConsumption" name="electricityConsumption" required><br><br>

    <label for="recycledMaterial">Accumulated amount of recycled material (kg):</label>
    <input type="number" id="recycledMaterial" name="recycledMaterial" required><br><br>

    <label for="oilCollection">Accumulated amount of oil collection (kg):</label>
    <input type="number" id="oilCollection" name="oilCollection" required><br><br>

    <label for="waterBill">Upload Water Bill:</label>
    <input type="file" id="waterBill" name="waterBill" required><br><br>

    <label for="electricityBill">Upload Electricity Bill:</label>
    <input type="file" id="electricityBill" name="electricityBill" required><br><br>

    <label for="recycledReceipt">Upload Recycled Receipt:</label>
    <input type="file" id="recycledReceipt" name="recycledReceipt" required><br><br>

    <label for="oilReceipt">Upload Oil Collection Receipt:</label>
    <input type="file" id="oilReceipt" name="oilReceipt" required><br><br>

    <input type="submit" value="Submit">
</form>
