package com.example.gottgried.rxdagger2_maps.api;

import com.example.gottgried.rxdagger2_maps.pojo.Result;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Gottgried on 26.06.2018.
 */

public interface MapApiService {

    @GET("/response.json")
    Observable<List<Result>> getMaps();

}
