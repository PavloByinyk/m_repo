package com.example.gottgried.mvvm_ac.reposetories;

import com.example.gottgried.mvvm_ac.pojo.ApiResponse;

/**
 * Created by Gottgried on 22.07.2018.
 */

public interface IssueRepository {

    LiveData<ApiResponse> getIssues(String owner, String repo);

}
