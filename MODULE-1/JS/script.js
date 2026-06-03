console.log("Welcome to the Community Portal");
window.onload = function () {
    alert("Page Fully Loaded");
};
// Data Types and Operators
const eventName = "Coding Workshop";
const eventDate = "2026-07-15";
let availableSeats = 50;
let eventInfo = `${eventName} on ${eventDate}\nSeats: ${availableSeats}`;
console.log(eventInfo);
// Event Class and Prototype
class Event {
    constructor(name, category, seats, date) {
        this.name = name;
        this.category = category;
        this.seats = seats;
        this.date = date;
    }
}
// Prototype Method
Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};
// Events Array
let events = [
    new Event("Coding Workshop", "Technology", 10, "2026-07-15"),
    new Event("Music Night",     "Music",      0,  "2025-01-10"),
    new Event("Dance Fiesta",    "Dance",      20, "2026-08-20"),
    new Event("Tech Talk",       "Education", 25, "2026-10-15")
];
// Add Event using push
events.push(new Event("Art Expo", "Art", 15, "2026-09-01"));
// Display Events
const container = document.querySelector("#eventContainer");
function displayEvents(eventList) {
    container.innerHTML = "";
    eventList.forEach((event) => {
        if (event.seats > 0) {
            const card = document.createElement("div");
            card.classList.add("eventCard");
            card.innerHTML = `
                <h3>${event.name}</h3>
                <p>Category: ${event.category}</p>
                <p>Seats: ${event.seats}</p>
                <button onclick="registerUser('${event.name}')">Register</button>
            `;
            container.appendChild(card);
        }
    });
    if (container.innerHTML === "") {
        container.innerHTML = "<p>No events found.</p>";
    }
}
displayEvents(events);
// Registration Logic
function registerUser(eventName) {
    try {
        let event = events.find(e => e.name === eventName);
        if (event.seats <= 0) {
            throw new Error("No seats available");
        }
        event.seats--;
        trackRegistration(); // FIX: closure counter now actually incremented
        alert(`Registered for ${event.name}`);
        displayEvents(events);
    } catch (error) {
        console.error(error);
        alert(error.message);
    }
}
// Higher Order Function
function filterEventsByCategory(category, callback) {
    let filtered = events.filter(
        event => category === "all" || event.category === category
    );
    callback(filtered);
}
// Category Filter
document.getElementById("categoryFilter").onchange = function () {
    filterEventsByCategory(this.value, displayEvents);
};
//the active category filter when searching.
document.getElementById("searchBox").addEventListener("input", function () {
    let value = this.value.toLowerCase();
    let activeCategory = document.getElementById("categoryFilter").value;
    let filtered = events.filter(event =>
        event.name.toLowerCase().includes(value) &&
        (activeCategory === "all" || event.category === activeCategory)
    );
    displayEvents(filtered);
});
// Closure Example
function registrationTracker() {
    let total = 0;
    return function () {
        total++;
        console.log(`Total Registrations: ${total}`);
    };
}
const trackRegistration = registrationTracker();
// Object.entries Example
Object.entries(events[0]).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
});
// Array Methods
const musicEvents = events.filter(event => event.category === "Music");
console.log(musicEvents);
const formatted = events.map(event => `Workshop on ${event.name}`);
console.log(formatted);
// Form Handling
document.getElementById("registrationForm").addEventListener("submit", function (event) {
    event.preventDefault();
    let form = event.target.elements;
    let name          = form["name"].value;
    let email         = form["email"].value;
    let selectedEvent = form["event"].value;
    document.getElementById("nameError").innerHTML  = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("eventError").innerHTML = "";
    let valid = true;
    if (name === "") {
        document.getElementById("nameError").innerHTML = "Name required";
        valid = false;
    }
    if (email === "") {
        document.getElementById("emailError").innerHTML = "Email required";
        valid = false;
    }
    if (selectedEvent === "") {
        document.getElementById("eventError").innerHTML = "Select event";
        valid = false;
    }
    if (valid) {
        submitRegistration({ name, email, selectedEvent });
    }
});

// Fetch API POST Request
function submitRegistration(userData) {
    document.getElementById("loading").style.display = "block";
    document.getElementById("formMessage").innerHTML = "";
    setTimeout(() => {
        fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userData)
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            document.getElementById("formMessage").innerHTML = "Registration Successful!";
            document.getElementById("loading").style.display = "none";
        })
        .catch(error => {
            console.error(error);
            document.getElementById("formMessage").innerHTML = "Registration Failed. Please try again.";
            document.getElementById("loading").style.display = "none";
        });
    }, 2000);
}
// Async/Await Example
async function fetchEvents() {
    try {
        let response = await fetch("https://jsonplaceholder.typicode.com/posts");
        let data = await response.json();
        console.log("Fetched mock data:", data);
        // To display real events, map the response to Event instances here and call displayEvents() with the result.
    } catch (error) {
        console.error("Failed to fetch events:", error);
    }
}
fetchEvents();
// jQuery Example
$("#registerBtn").click(function () {
    $(".eventCard").fadeOut(500).fadeIn(500);
});
// Framework Benefit
console.log("Frameworks like React or Vue provide reusable components and better state management.");