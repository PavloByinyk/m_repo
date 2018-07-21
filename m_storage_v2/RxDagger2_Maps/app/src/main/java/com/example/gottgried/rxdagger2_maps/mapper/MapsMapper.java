package com.example.gottgried.rxdagger2_maps.mapper;

import com.example.gottgried.rxdagger2_maps.pojo.MapsResponse;
import com.example.gottgried.rxdagger2_maps.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Gottgried on 21.07.2018.
 */

public class MapsMapper {

    @Inject
    public MapsMapper() {
    }

    public List<Result> mapMaps(MapsResponse mapsResponse){
        List<Result> maps= new ArrayList<>();

        if(mapsResponse != null){
            return mapsResponse.getResult();
        }else {
            return new ArrayList<>();
        }

    }
}
