function validateSignup(event) {
    event.preventDefault(); // Prevent the form from submitting

    // Validation logic for the signup form
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const nickname = document.getElementById('nickname').value;

    // Perform additional validation if needed

    // For demonstration purposes, show an alert if the form is valid
    alert(`Signup Successful!\nUsername: ${username}\nPassword: ${password}\nNickname: ${nickname}`);
    // Jump to index page
    window.location.href = 'index.jsp';
}

function validateUsername() {
    const usernameInput = document.getElementById('username');
    const usernameValue = usernameInput.value;

    // Check if the username matches the pattern
    const usernamePattern = /^[a-zA-Z][a-zA-Z0-9]{4,}$/;
    const isValid = usernamePattern.test(usernameValue);

    // Update the input style based on validity
    updateInputStyle(usernameInput, isValid);

    // Display corresponding error message
    displayErrorMessage('username-error', isValid, 'Username must be at least 5 characters and should start with a letter, only letters and numbers are allowed.');
}

function validatePassword() {
    const passwordInput = document.getElementById('password');
    const passwordValue = passwordInput.value;

    // Check if the password matches the pattern
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\da-zA-Z]).{8,}$/;
    const isValid = passwordPattern.test(passwordValue);

    // Update the input style based on validity
    updateInputStyle(passwordInput, isValid);

    // Display corresponding error message
    displayErrorMessage('password-error', isValid, 'Password must be at least 8 characters and a combination of uppercase and lowercase letters, numbers, and symbols.');
}

function updateInputStyle(inputElement, isValid) {
    // Add or remove a class to update the input style based on validity
    if (isValid) {
        inputElement.classList.remove('invalid');
    } else {
        inputElement.classList.add('invalid');
    }
}

function displayErrorMessage(errorElementId, isValid, errorMessage) {
    // Display or hide the error message based on validity
    const errorElement = document.getElementById(errorElementId);
    if (!isValid) {
        errorElement.textContent = errorMessage;
    } else {
        errorElement.textContent = '';
    }
}
