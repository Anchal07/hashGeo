package com.geohash.example.geohash;

import ch.hsr.geohash.WGS84Point;
import com.github.davidmoten.geo.Direction;
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
    public Map<String, LatLngDto> geoHashForAlist(List<LatLngDto> latLngDtoList, int precesion) {
        HashMap<String, LatLngDto> result = new HashMap<>();
        latLngDtoList.stream().forEach(v->{ result.put(GeoHash.encodeHash(v.getLatitude(), v.getLongitude(), precesion), v); });
        return result;
    }

    @Override
    public List<String> geoHashComplete(List<LatLngDto> latLngDtoList, int precesion) {
        List<String> geoHashesList = new ArrayList<>();

//        BoundingBox boundingBox = new BoundingBox(new WGS84Point(28.457523, 77.026344),
//                new WGS84Point());

//        Map<String, LatLngDto> geoHashLatLngDet = new HashMap<>();
//        latLngDtoList.stream().forEach(v-> geoHashLatLngDet.put(GeoHash.encodeHash(v.getLatitude(), v.getLongitude(), 5), v));

//        int i=1, initial=0;
//        while(i<geoHashesList.size()){
//            int stepBetween = (int) ch.hsr.geohash.GeoHash.stepsBetween(getGeoHashFromString(geoHashesList.get(i)),
//                    getGeoHashFromString(geoHashesList.get(initial)));
//            i++;
//            if(initial != geoHashesList.size()-1 && i==geoHashesList.size()-1){
//                initial++;
//                i += initial;
//            }
//        }
        return geoHashesList;
    }

    @Override
    public List<String> geoHashOnBasisOfQuery(Double lat, Double lng, Integer radius) {
        GeoHashCircleQuery geoHashCircleQuery = new GeoHashCircleQuery(new WGS84Point(lat, lng), radius);
        return null;
    }

    /* to create create geo hash
    Node n = null;
    db  queruy -> to check if geohash tree of bounds already present
    if present then Node n = some x data else n = null
    return func(n)
    * */

    /*
       recursive function =>
       func(Node n ){
        MAIN COMPUTATION
       }
     */

    private ch.hsr.geohash.GeoHash getGeoHashFromString(String geoHash){
        return ch.hsr.geohash.GeoHash.fromGeohashString(geoHash);
    }
}
