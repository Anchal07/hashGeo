package com.geohash.example.geohash;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoundsReqDto {

    private List<LatLngDto> latLngDtoList;

}
