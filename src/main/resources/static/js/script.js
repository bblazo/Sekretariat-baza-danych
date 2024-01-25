function successfullyLogout() {
    alert("Zostałeś pomyślnie wylogowany");
}


function validatePESELtype() {
    var inputField = document.getElementById('peselInput');
    var errorMessage = document.getElementById('errorMessage');
    var submitButton = document.getElementById('submitButton');

    // Check if the input is a valid integer
    if (!/^\d+$/.test(inputField.value)) {
        // Show error message and disable the submit button
        errorMessage.innerHTML = 'Wartość musi zawierać tylko cyfry.';
        errorMessage.style.color = 'red';
        submitButton.disabled = true;
    } else {
        // Clear error message and enable the submit button
        errorMessage.innerHTML = '';
        submitButton.disabled = false;

    }
}

function validate_nr_tel_type() {
    var inputField = document.getElementById('nr_tel_Input');
    var errorMessage = document.getElementById('error');
    var submitButton = document.getElementById('submitButton');

    // Check if the input is a valid integer
    if (!/^\d+$/.test(inputField.value)) {
        // Show error message and disable the submit button
        errorMessage.innerHTML = 'Wartość musi zawierać tylko cyfry.';
        errorMessage.style.color = 'red';
        submitButton.disabled = true;
    } else {
        // Clear error message and enable the submit button
        errorMessage.innerHTML = '';
        submitButton.disabled = false;
    }
}


$(function(){
    var dtToday = new Date();

    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();

    var maxDate = year + '-' + month + '-' + day;

    // or instead:
    // var maxDate = dtToday.toISOString().substr(0, 10);


    $('#yourDateInputId').attr('max', maxDate);
});


$(function(){
    var dtToday = new Date();

    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();

    var maxDate = year + '-' + month + '-' + day;

    // Initialize datepicker on the specified input
    $('#yourDateInputId').attr('max', maxDate).datepicker();

    // Display date picker when the specified div is clicked
    $('#datePickerContainer').on('click', function() {
        $('#yourDateInputId').datepicker('show');
    });
});


