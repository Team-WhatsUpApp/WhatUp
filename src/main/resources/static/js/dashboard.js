/**
 * Created by jsr on 7/11/17.
 */
(function() {

    "use strict";

    // create global info window variable for closing the window

    var currentInfoWindow = null;

    // ===========================DRAWING MAP===========================


    var mapOptions = {
        zoom: 10,
        center: {
            lat: 29.42569,
            lng: -98.48503
        },
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    // Render the map
    var map = new google.maps.Map(document.getElementById("map-display"), mapOptions);






    // ===========================LOOPING THROUGH RESTAURANTS===========================

//        // single entry object
//        var goodEats = {
//            name: "Chama Gaucho",
//            address: "18318 Sonterra Pl, San Antonio, TX 78258",
//            info: "<h3>Chama Gaucho</h3>The best steak period!"
//        };
//
//        // test the entry
//        markIt(goodEats);
//
//
    // many entries
    var restaurants = [

        {
            name: "Chama Gaucho",
            address: "18318 Sonterra Pl, San Antonio, TX 78258",
            info: "<h3>Chama Gaucho</h3>The best steak period!"
        },
        {
            name: "Supper",
            address: "136 E Grayson St, San Antonio, TX 78215",
            info: "<h3>Supper</h3>The best supper period!"
        },
        {
            name: "Whiskey Cake",
            address: "The Shops At La Cantera, 15900 Via La Cantera #21200, San Antonio, TX 78256",
            info: "<h3>Whiskey Cake</h3>The best cake period!"
        }

    ];




    // loop through array of JS objects and pass in each object to marker function

    restaurants.forEach(function(restaurant){
        markIt(restaurant);
    });



    // ===========================FUNCTION to GEOCODE and CREATE MARKER===========================

    function markIt(someObject) {
        var geocoder = new google.maps.Geocoder();

        geocoder.geocode({address: someObject.address}, function(results, status) {

            if (status === "OK") {
                var coordinates = {};
                coordinates.lat = results[0].geometry.location.lat();
                coordinates.lng = results[0].geometry.location.lng();

                addAMarker(coordinates, someObject);

            }

        }) ;

    }




    // ===========================FUNCTION to ADD MARKERS===========================

    function addAMarker(position, someObject) {

        var marker = new google.maps.Marker({
            position: position,
            animation: google.maps.Animation.DROP,
            icon: "food.png",
            map: map
        });

        var infowindow = new google.maps.InfoWindow({
            content: someObject.info
        });

        marker.addListener("click", function() {
            if (currentInfoWindow) {
                currentInfoWindow.close();
            }
            infowindow.open(map, marker);
            map.setCenter(marker.position);
            currentInfoWindow = infowindow;

        });

    }



    // initialize the map


})();
