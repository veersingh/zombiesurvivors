
Below are Endpoints:
GET http://localhost:8090/robots/            // To get all robots list 
GET http://localhost:8090/robots/{category}  // To get robots list based on category

POST http://localhost:8090/survivors/     To  add survivors
 JSON Request Body:
 {
    "id":"surv06",
    "name":"Adde Michale ",
    "age": 35,
    "gender": "Male",
    "location": {
      "latitude": 2411.21,
      "longitude": 2590.31
    },
    "resources": {
      "water": 5,
      "food": 6,
      "ammunition": 11,
      "medication": 3
    }
  }

GET http://localhost:8090/survivors     // To get all Survivors list
GET http://localhost:8090/survivors/infected     // To get all Infected Survivors list
GET http://localhost:8090/survivors/noninfected    // To get all Non Infected Survivors list

PUT http://localhost:8090/survivors/{survivor_id}    // to update location of survivor
Request body  {
   "latitude": 3011,
   "longitude": 2090
 }
PUT http://localhost:8090/survivors/infected/{survivor_id}//   to update survivor as infected

GET http://localhost:8090/survivors/reports/infected_in_percent   to get Percentage of infected survivors

GET http://localhost:8090/survivors/reports/noninfected_in_percent   to get Percentage of non infected survivors 
