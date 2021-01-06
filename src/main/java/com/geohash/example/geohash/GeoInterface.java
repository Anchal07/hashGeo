package com.geohash.example.geohash;

import java.util.List;
import java.util.Map;

public interface GeoInterface {

    String geohashForPairDavid(Double lat, Double lng);

    Map<LatLngDto, String> geoHashForAlist(List<LatLngDto> latLngDtoList);

    Map<LatLngDto, String> geoHashComplete(List<LatLngDto> latLngDtoList);

}
