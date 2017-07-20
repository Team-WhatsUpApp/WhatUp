#WhatsUP! is a new app that will give you exclusive discounts to San Antonio's unique restaurants and bars!
With an aim to help small businesses in our community


##Introduction
WhatsUp! was built with intention of helping local businesses increase traffic and patronage at their establishments 
during slow times. We imagined it as a package that could be deployed by members of the small business and local
franchise community, and be administered by volunteers of that locale, since only they know their homes as well as they 
do.The design and development of the WhatsUp package isn't a one off, and we hope to continue its development with 
changing needs.


##Setup
The application relies on a couple of technologies to run, including MySQL 5.7 on the back end, and uses Yelp Fusion and
Google Maps API to help populate the map. To begin deployment you need to acquire a key for both aforementioned APIs, and
add them to the `LocationController`, for Fusion, and `maps.js` for Maps. For the spatial function to work properly,
you need to added the proper MySQL dialects into your `application.properties`, follow the example document changing your
username and password for your database.

##Built with
* [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java 1.8
* [Spring Boot](https://projects.spring.io/spring-boot/) - Application Development
* [Nginix](https://nginx.org/en//) - HTTP server
* [Maven](https://maven.apache.org/) - Dependency Management
* [Tomcat](https://tomcat.apache.org/) - Java Servlet/EL
* [Thymeleaf](http://www.thymeleaf.org/) - Template engine
* [jQuery](https://jquery.com/) - JavaScript library 

##Future changes
- Use the [Yelp API v3 client](https://github.com/MontealegreLuis/yelpv3-java-client) to build a more consistent result
for businesses, and a more robust searching feature
- Refine user experience for consistency and increased functionality for Vendor use
###Notes
The location database is populated using a Yelp Fusion client that is experimental, but was functional for our purposes,
in the future we plan to build a page that show results for locations, and then allows them to be selected.

##Authors
Created by Josh R., Delenor Monroe, Moses Franco, Codeup Java students

##Acknowledgements
This project was built by students from [Codeup](http://codeup.com//) as part of our capstone project over a 3 week time 
frame.

Special thanks to Luis and Fer!
