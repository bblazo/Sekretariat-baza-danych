function successfullyLogout(){
alert("Zostałeś pomyślnie wylogowany");
}
function validateInt() {
    var inputValue = document.getElementById('userInput').value;

    // Check if the input value is not an integer
    if (isNaN(inputValue) || inputValue % 1 !== 0) {
        alert('Wprowadzono błędne dane. Proszę zapisać wartość tylko za pomocą cyfr!');
    }
}

function validateIntegerInput(inputElement) {
    var errorMessageElement = inputElement.nextElementSibling; // Get the next sibling element (error message)

    var inputValue = inputElement.value.trim();
    var isValid = isInteger(inputValue);

    if (isValid) {
        errorMessageElement.textContent = ""; // Clear the error message
    } else {
        errorMessageElement.textContent = "Wartość należy wprowadzić tylko za pomocą liczb";
    }
}

function isInteger(value) {
    return Number.isInteger(parseInt(value, 10));
}

