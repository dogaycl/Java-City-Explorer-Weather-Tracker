#  Java City Management & Route Explorer  
A modular Java application that loads structured city data from JSON, builds a graph-based model of the city, and allows route exploration, querying, and city data visualization.  
Designed with clean OOP principles and external library integration.

---

##  Overview

This project demonstrates how to build a **city simulation / management / exploration system** using:

- **Java (OOP principles)**
- **Graph structures**
- **JSON-based data input**
- **Modular class architecture**
- **External libraries (json.jar)**

The application loads `cities.json`, constructs a network of nodes (places), and optionally computes connections, paths, or interactions depending on the implemented logic.

---

##  Project Structure

Java_City_Project/
│

├── src/ # All Java source files
│ ├── Main.java # Application entry point
│ ├── City.java # Represents a city / location
│ ├── Node.java # Graph node model
│ ├── Route.java # Route model (connections)
│ ├── Graph.java # Graph structure / adjacency logic
│ ├── ... # Additional supporting classes

│

├── libs/
│ └── json.jar # External library for JSON parsing

│

└── cities.json # Dataset describing cities, routes, or nodes


---

##  Data File: `cities.json`

The project reads structured city information such as:

- City names  
- Coordinates or attributes  
- Route details  
- Connections between locations  

Example structure (simplified):

```json
{
  "cities": [
    { "id": 1, "name": "Ankara", "population": 5500000 },
    { "id": 2, "name": "Istanbul", "population": 16000000 }
  ],
  "routes": [
    { "from": 1, "to": 2, "distance": 450 }
  ]
}
