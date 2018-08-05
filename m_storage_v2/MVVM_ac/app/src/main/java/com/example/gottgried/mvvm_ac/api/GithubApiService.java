package com.example.gottgried.mvvm_ac.api;

import com.example.gottgried.mvvm_ac.pojo.Issue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Gottgried on 22.07.2018.
 */

public interface GithubApiService {

    @GET("/repos/{owner}/{repo}/issues")
    Call<List<Issue>> getIssues(@Path("owner") String owner, @Path("repo") String repo);

}
