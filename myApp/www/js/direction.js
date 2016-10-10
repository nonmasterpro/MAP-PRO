/**
 * Created by non on 9/24/2016.
 */


function initMap() {
  var directionsService = new google.maps.DirectionsService;
  var directionsDisplay = new google.maps.DirectionsRenderer;
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 14,
    center: {lat: 18.801737 , lng: 98.967562}
  });


  var image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
  var beachMarker = new google.maps.Marker({
    position: {lat: 18.801737, lng: 98.967562},
    map: map,
    icon: image
  });
  beachMarker.addListener('click', function() {
    aad.open(map, beachMarker);
  });

   var contentString = '<div id="content">'+
    '<div id="siteNotice">'+
    '</div>'+
    '<h1 id="firstHeading" class="firstHeading">Chiang Mai Zoo</h1>'+
    '<div id="bodyContent">'+
    '<p><b>Description</b>, also referred to as ' +
     '<br><b>Type</b>, is a large ' +
     '<br><b>Contact</b>, is a large ' +
     '<br><b>Website</b> <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
  'https://en.wikipedia.org/w/index.php?title=Uluru</a>'+
     '<button style="float: right" class="button button-royal"  onclick="" > View Details</button>'+
    '</div>'+
    '</div>';

  var infowindow = new google.maps.InfoWindow({
    content: contentString,
    maxWidth: 300
  });
  var image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
  var marker = new google.maps.Marker({
    position: {lat: 18.808887, lng: 98.947907},
    map: map,
    icon: image,
    title: 'Uluru (Ayers Rock)'
  });
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });


/////////////////////////////////////////////////////

  directionsDisplay.setMap(map);

  var onChangeHandler = function() {
    calculateAndDisplayRoute(directionsService, directionsDisplay);
  };
  document.getElementById('start').addEventListener('change', onChangeHandler);
  document.getElementById('end').addEventListener('change', onChangeHandler);
}

function calculateAndDisplayRoute(directionsService, directionsDisplay) {
  directionsService.route({
    origin: document.getElementById('start').value,
    destination: document.getElementById('end').value,
    travelMode: 'DRIVING'
  }, function(response, status) {
    if (status === 'OK') {
      directionsDisplay.setDirections(response);
    } else {
      //window.alert('Directions request failed due to ' + status);
    }
  });
}
