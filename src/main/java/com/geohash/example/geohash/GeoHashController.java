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

    @PostMapping("/bounds/list")
    public Map<String, LatLngDto> geoHashForBoundsList(@RequestBody BoundsReqDto boundsReqDto){
        return geoInterface.geoHashForAlist(boundsReqDto.getLatLngDtoList());
    }

    @PostMapping("/bounds/complete_hash")
    public Map<LatLngDto, String> geoHashComplete(@RequestBody BoundsReqDto boundsReqDto){
        return geoInterface.geoHashComplete(boundsReqDto.getLatLngDtoList());
    }

}