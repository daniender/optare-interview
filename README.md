This assignment is designed to understand how you work and what your preferences are. Don't feel nervous, there is no a correct answer, the source code may not compile and you can search in Google and Stackoverflow, we also do it!!

# 📘 Functional requirements

This project implements a REST API that given a location (gps coordinates) show us the weather forecast for the next 6 days in the nearest city 

`GET` `http://localhost:8080/forecasts?lat=36.96&lon=-122.02`

```json[
    {
        "place": "Santa Cruz",
        "date": "2020-10-22",
        "weather": "Heavy Cloud"
    },
    {
        "place": "Santa Cruz",
        "date": "2020-10-23",
        "weather": "Heavy Cloud"
    },
    {
        "place": "Santa Cruz",
        "date": "2020-10-24",
        "weather": "Heavy Cloud"
    },
    {
        "place": "Santa Cruz",
        "date": "2020-10-25",
        "weather": "Light Cloud"
    },
    {
        "place": "Santa Cruz",
        "date": "2020-10-26",
        "weather": "Heavy Cloud"
    },
    {
        "place": "Santa Cruz",
        "date": "2020-10-27",
        "weather": "Light Cloud"
    }
]
```

# 📋 Tasks

When you examine the project, you will discover that there is one error, some parts are hardcoded and other parts need improvements.

The information source of weather is a public API: https://www.metaweather.com/api/

#### 🔴 Your goals

* Make it work!
* Make it functional (no _hardcodes_ please)
* Refactor as good as you can in 30 minutes

#### 💡 Hints:

 * Reuse code of project
 * Build a call to the API REST to get information about the city with its longitude and latitude parameters. Check API documentation (!Hint, get first result)
 
```
$ mvn spring-boot:run
``` 


Ask to your interviewer whatever you want, we are here to help.

Good luck and have fun! 😉💪


## 🔝 Points we like

#### 🟢 Improvements
 * If you are comfortable testing, we would like to see how you approach the automation of unit and integration tests. You can cover with tests the logic implemented with junit or with any library you know.

#### 🟢 Questions 
 * How would you do the deployment of this microservice?
 * In this example, there is no database persistence. If you had to store forecast information, how would you do it?

