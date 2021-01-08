package com.geohash.example.geohash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@RestController
@RequestMapping("/api/v1/geohash")
public class GeoHashController {

    @Autowired
    GeoInterface geoInterface;

    @GetMapping("/get/for_one_pair")
    public String geohashForLatLngPairUsingDavid(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng){
        return geoInterface.geohashForPairDavid(lat, lng);
    }

    @PostMapping("/bounds/list/{precesion}")
    public Map<String, LatLngDto> geoHashForBoundsList(@RequestBody BoundsReqDto boundsReqDto, @PathVariable("precesion") int precesion){
        return geoInterface.geoHashForAlist(boundsReqDto.getLatLngDtoList(), precesion);
    }

    @PostMapping("/bounds/complete_hash/{precesion}")
    public List<String> geoHashComplete(@RequestBody BoundsReqDto boundsReqDto, @PathVariable("precesion") int preceison){
        List<String> stringList = geoInterface.geoHashComplete(boundsReqDto.getLatLngDtoList(), preceison);
        System.out.println("in : " + boundsReqDto.getLatLngDtoList().size()+ " out : " + stringList.size());
        return stringList;
    }

    @GetMapping("/circle/query/{lat}/{lng}/{radius}")
    public List<String> getGeoHashByQuery(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng, @PathVariable("radius") Integer radius){
        return geoInterface.geoHashOnBasisOfQuery(lat, lng, radius);
    }

}