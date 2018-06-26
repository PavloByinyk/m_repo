
package com.example.gottgried.rxdagger2_maps.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class MapsResponse {

    @SerializedName("Result")
    private List<Result> mResult;
    @SerializedName("Status")
    private Long mStatus;

    public List<Result> getResult() {
        return mResult;
    }

    public void setResult(List<Result> result) {
        mResult = result;
    }

    public Long getStatus() {
        return mStatus;
    }

    public void setStatus(Long status) {
        mStatus = status;
    }

}
