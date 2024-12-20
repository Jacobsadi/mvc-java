<script>
    function showThankYouMessage() {
        // Prevent the default form submission
        event.preventDefault();
        
        // Get the box08 element
        var box = document.getElementById('box08');
    
        // Set the innerHTML of the box to the thank-you message
        box.innerHTML = `
            <div class="confirmation-box">
                <h1>THANK YOU</h1>
                <p>FOR YOUR SUBMISSION</p>
                <div class="reference-number">Reference Number: MBIP001 / 0015</div>
                <div class="check-account">You can check your submission thru "My Account"</div>
                <button onclick="dismissThankYouMessage()" class="dismiss-btn">DISMISS</button>
            </div>
        `;
    }
    
    function dismissThankYouMessage() {
        // Get the box08 element
        var box = document.getElementById('box08');
    
        // Set the innerHTML of the box back to the default message or empty
        box.innerHTML = '<div class="py-2">Select an option from the dashboard.</div>';
    }
    </script>
    