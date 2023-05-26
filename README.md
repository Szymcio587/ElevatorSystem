<h1>Elevator Management System Overview</h1>

<h3>Introduction</h3>
This project was created to simulate a simple management system for a group of elevators in a building. It provides 4 basic functionalities:
<br>- Calling an elevator and choosing the floor
<br>- Changing completely the informations for a given elevator
<br>- Checking the status of all elevators
<br>- Performing a step in a simulation

<h3>Prerequisites</h3>
To launch this application you should have:
<br>- JDK with version 11 if possible, although 8 should work fine as well
<br>- Apache Maven installed
<br>- AngularJS installed
<br>- Some IDE, I was working on IntelliJ for Java and Visual Studio for AngularJS

<h3>Run the application</h3>
To start the application follow those steps:
<br>1. Open pom.xml file and launch Spring Boot Application
<br>2. Open console and move on to src/main/frontend directory
<br>3. Type npm install
<br>4. Start the application with ng serve --open
<br>
After few seconds you should see the main page in your browser

<h3>Used algorithm</h3>

<br>To find the optimal way (which is with the lowest time spent) for an elevator to travel to all the floors required in a given moment, the program checks where is the farthest floor in each direction: up and down, and then takes the lower value of those two to indicate in which one should be going. Then, it checks all the floors in this direction, and selects the closest one first. After all floors in this direction are met, the elevator either swiches directions and goes the opposite way or, if there are no floors to visit, stays in it's final position.
<br><br>
This algorithm is called each time the list of floors to visit changes, and it can happen in two scenarions: when somebody gets out of this elevator, and so the list of floors shortens, or when somebody catches this elevator and goes inside; then the list extends. In both cases there might be a need to set a new optimal way for the elevator.S
