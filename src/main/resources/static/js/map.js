/**
 * Created by mosesfranco on 7/14/17.
 */

(function(){
    "use strict";

    /*<![CDATA[*/
    var request = $.ajax('/locations/-98.489576/29.426786/1');
    request.done(function(locations) {
        console.log(locations);
    });
    function initMap() {
        var uluru = {lat: -25.363, lng: 131.044};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: uluru
        });
        var marker = new google.maps.Marker({
            position: uluru,
            map: map
        });
    }
})();