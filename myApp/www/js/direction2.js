/**
 * Created by non on 9/29/2016.
 */
function initMap() {
  var origin_place_id = null;
  var destination_place_id = null;
  var travel_mode = 'WALKING';
  var map = new google.maps.Map(document.getElementById('map'), {
    mapTypeControl: false,
    center: {lat: 18.800518, lng: 98.950808},
    zoom: 16
  });



  var contentString = '<div id="content">'+
    '<div id="siteNotice">'+
    '</div>'+
    '<h1 id="firstHeading" class="firstHeading">CAMT</h1>'+
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
    position: {lat: 18.800518, lng: 98.950808},
    map: map,
    icon: image,
    title: 'Uluru (Ayers Rock)'
  });
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });

  var directionsService = new google.maps.DirectionsService;
  var directionsDisplay = new google.maps.DirectionsRenderer;
  directionsDisplay.setMap(map);

  var origin_input = document.getElementById('origin-input');
  var destination_input = document.getElementById('destination-input');
  var mode = document.getElementById('mode-selector');
  var search = document.getElementById('floating-panel');

  map.controls[google.maps.ControlPosition.TOP_LEFT].push(search);
  map.controls[google.maps.ControlPosition.LEFT].push(origin_input);
  map.controls[google.maps.ControlPosition.LEFT].push(destination_input);
  map.controls[google.maps.ControlPosition.LEFT].push(mode);

  var origin_autocomplete = new google.maps.places.Autocomplete(origin_input);
  origin_autocomplete.bindTo('bounds', map);
  var destination_autocomplete =
    new google.maps.places.Autocomplete(destination_input);
  destination_autocomplete.bindTo('bounds', map);

  // Sets a listener on a radio button to change the filter type on Places


////////////////////////////////Select route/////////////

  calculateAndDisplayRoute(directionsService, directionsDisplay);
  document.getElementById('mode-selector').addEventListener('change', function() {
    calculateAndDisplayRoute(directionsService, directionsDisplay);
  });

  function calculateAndDisplayRoute(directionsService, directionsDisplay) {
    var selectedMode = document.getElementById('mode').value;
    directionsService.route({
      origin: {'placeId': origin_place_id},  // Haight. {lat: 37.77, lng: -122.447}  origin_input
      destination: {'placeId': destination_place_id},  // Ocean Beach. {lat: 37.768, lng: -122.511}  destination_input
      // Note that Javascript allows us to access the constant
      // using square brackets and a string value as its
      // "property."
      travelMode: google.maps.TravelMode[selectedMode]
    }, function(response, status) {
      if (status == 'OK') {
        directionsDisplay.setDirections(response);
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });}

/////////////Search Geo/////////////
    var geocoder = new google.maps.Geocoder();

    document.getElementById('submit').addEventListener('click', function() {
      geocodeAddress(geocoder, map);
    });

    function geocodeAddress(geocoder, resultsMap) {
      var address = document.getElementById('address').value;
      geocoder.geocode({'address': address}, function (results, status) {
        if (status === 'OK') {
          resultsMap.setCenter(results[0].geometry.location);

        } else {
          alert('Geocode was not successful for the following reason: ' + status);
        }
      });

    }




  // Autocomplete.
  //function setupClickListener(id, mode) {
  //  var radioButton = document.getElementById(id);
  //  radioButton.addEventListener('click', function() {
  //    travel_mode = mode;
  //  });
  //}
  //setupClickListener('changemode-walking', 'WALKING');
  //setupClickListener('changemode-transit', 'TRANSIT');
  //setupClickListener('changemode-driving', 'DRIVING');
  //
  function expandViewportToFitPlace(map, place) {
    if (place.geometry.viewport) {
      map.fitBounds(place.geometry.viewport);
    } else {
      map.setCenter(place.geometry.location);
      map.setZoom(17);
    }
  }

  origin_autocomplete.addListener('place_changed', function() {
    var place = origin_autocomplete.getPlace();
    if (!place.geometry) {
      window.alert("Autocomplete's returned place contains no geometry");
      return;
    }
    expandViewportToFitPlace(map, place);

    // If the place has a geometry, store its place ID and route if we have
    // the other place ID
    origin_place_id = place.place_id;
    route(origin_place_id, destination_place_id, travel_mode,
      directionsService, directionsDisplay);
  });

  destination_autocomplete.addListener('place_changed', function() {
    var place = destination_autocomplete.getPlace();
    if (!place.geometry) {
      window.alert("Autocomplete's returned place contains no geometry");
      return;
    }
    expandViewportToFitPlace(map, place);

    // If the place has a geometry, store its place ID and route if we have
    // the other place ID
    destination_place_id = place.place_id;
    route(origin_place_id, destination_place_id, travel_mode,
      directionsService, directionsDisplay);
  });

  function route(origin_place_id, destination_place_id, travel_mode,
                 directionsService, directionsDisplay) {
    if (!origin_place_id || !destination_place_id) {
      return;
    }
    directionsService.route({
      origin: {'placeId': origin_place_id},
      destination: {'placeId': destination_place_id},
      travelMode: travel_mode
    }, function(response, status) {
      if (status === 'OK') {
        directionsDisplay.setDirections(response);
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });
  }
}
