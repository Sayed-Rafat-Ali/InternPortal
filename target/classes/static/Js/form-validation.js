// register.js

function validateRegisterForm() {
    const name = document.querySelector('input[name="name"]').value.trim();
    const email = document.querySelector('input[name="email"]').value.trim();
    const phoneno = document.querySelector('input[name="phoneno"]').value.trim();
    const password = document.querySelector('input[name="password"]').value;

    // Check for empty fields
    if (!name || !email || !phoneno || !password) {
        alert("All fields are required.");
        return false;
    }

    // Phone number validation
    const phoneRegex = /^\d{10}$/;
    if (!phoneRegex.test(phoneno)) {
        alert("Phone number must be exactly 10 digits.");
        return false;
    }

    // Password length validation
    if (password.length < 6) {
        alert("Password must be at least 6 characters.");
        return false;
    }

    return true;
}


// Validate Login Form
function validateLoginForm() {
    const email = document.querySelector('input[name="email"]').value.trim();
    const password = document.querySelector('input[name="password"]').value;

    if (email === '' || password === '') {
        alert("Email and Password are required.");
        return false;
    }

    return true;
}
