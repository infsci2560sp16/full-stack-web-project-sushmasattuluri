

function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
          center: {lat: 40.349970, lng: -80.050262},
          zoom: 8
        });
        var myCenter=new google.maps.LatLng(40.349970,-80.050262);
        var marker=new google.maps.Marker({
      position:myCenter,
        });

        marker.setMap(map);

      }
