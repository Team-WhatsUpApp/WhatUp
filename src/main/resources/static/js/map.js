/**
 * Created by mosesfranco on 7/14/17.
 */

(function(){
    "use strict";

    var map;
    var lat = 29.416667;
    var lon = -98.5;
    var zoom = 11;
    var haveSearched;
    var madeUrl = '';

    //

    function getLocation() {
        if (navigator.geolocation) {
            setTimeout(function () {
                navigator.geolocation.getCurrentPosition(showPosition);
            }, 5000)
        } else {
            console.log("Didn't consent to using location");
        }
    }

    function showPosition(position) {
        lat = position.coords.latitude;
        lon = position.coords.longitude;
        zoom = 13;

        if (!haveSearched) {
            haveSearched = true;
            initialize();
        }
    }

    function getData(url) {
        $.ajax({
            url: madeUrl,
            type: "GET",
            async: false,
            success: function (data) {
                console.log("ajaxdata: " + data);
                $.each(data, function (key, location) {
                    var myLatLng = {lat: location.y, lng: location.x};
                    var marker = new google.maps.Marker({
                        position: myLatLng,
                        map: map
//                        label: location.name
                    });
                    marker.setMap(map);
                    var contentString = '<div class="marker">' +
                        '<div id="markerInfo">' +
                        '<b class="name">' + location.name + '</b>' +
                        '<p><span>' + location.address + '</span><br/>' +
                        '<a href="tel:' + location.phone + '"><span>Call</span></a><br/>' +
                        '<a href="' + location.url + '"><span>Yelp</span></a><br/>' +
                        '<a href="/places/' + location.id + '"><span>More</span></a><br/>' +
//                        '<a target="_blank" href="https://maps.google.com/maps/dir/api=1?&amp;query=' + location.x + ',' + location.y + '&amp;z=16&amp;t=m&amp;hl=en-US&amp;gl=US&amp;mapclient=apiv3"><span>View on Google Maps</span></a>' +
                        '</p>' +
                        '</div>' +
                        '</div>';
                    var infowindow = new google.maps.InfoWindow({
                        content: contentString
//                        label: location.displayName

                    });
                    marker.addListener('click', function () {
                        infowindow.open(map, marker);
                    });
                });
                /*var locMarker = new google.maps.Marker({
                 position: new google.maps.LatLng(lat, lon),
                 map: map,
                 label: "Current position"
                 });*/
                // locMarker.setIcon('http://maps.google.com/mapfiles/ms/icons/blue-dot.png')
            }
        });
        // getLocation();
    }

    google.maps.event.addDomListener(window, 'load', initialize);

    function initialize() {
        // getLocation();
        var mapProp = {
            center: new google.maps.LatLng(lat, lon),
            zoom: zoom,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
        madeUrl = '/locations.json/' + lon + '/' + lat + '/20';
        getData();
    }


})();