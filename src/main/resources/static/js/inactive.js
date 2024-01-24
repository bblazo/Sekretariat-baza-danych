var inactivityTimeout;
var inactivityDuration = 50000; // 5 minutes in milliseconds (adjust as needed)

function resetInactivityTimeout() {
    clearTimeout(inactivityTimeout);
    inactivityTimeout = setTimeout(logout, inactivityDuration);
}

function logout() {
    // Perform logout actions, e.g., redirect to log out URL
    alert("Z powodu zbyt długiej nieaktywności nastąpiło wylogowanie");
    // Replace the following line with actual logout code or redirect
    window.location.href = "/index";
}

// Reset the inactivity timeout whenever there is user activity
document.addEventListener("mousemove", resetInactivityTimeout);
document.addEventListener("keypress", resetInactivityTimeout);

// Initial setup when the page loads
resetInactivityTimeout();


