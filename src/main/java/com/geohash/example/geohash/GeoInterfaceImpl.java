package com.geohash.example.geohash;

import com.github.davidmoten.geo.GeoHash;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeoInterfaceImpl implements GeoInterface{


    @Override
    public String geohashForPairDavid(Double lat, Double lng) {
        return GeoHash.encodeHash(lat, lng, 5);
    }

    @Override
    public Map<LatLngDto, String> geoHashForAlist(List<LatLngDto> latLngDtoList) {
        HashMap<LatLngDto, String> result = new HashMap<>();
        latLngDtoList.stream().forEach(v->{ result.put(v, GeoHash.encodeHash(v.getLatitude(), v.getLongitude(), 5)); });
        return result;
    }

    @Override
    public Map<LatLngDto, String> geoHashComplete(List<LatLngDto> latLngDtoList) {
        List<String> geoHashesList = new ArrayList<>();
        latLngDtoList.stream().forEach(v-> geoHashesList.add(GeoHash.encodeHash(v.getLatitude(), v.getLongitude(), 5)));
        int i=0, initial=0;
        Map<String, List<String>> hashNeighbours = new HashMap<>();
        geoHashesList.stream().forEach(v-> hashNeighbours.put(v, GeoHash.neighbours(v)));
        return null;
    }

}
