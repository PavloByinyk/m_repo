package com.example.gottgried.rxdagger2.service;

import com.example.gottgried.rxdagger2.model.FlowerResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Gottgried on 10.06.2018.
 */

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> getFlowers();
}
