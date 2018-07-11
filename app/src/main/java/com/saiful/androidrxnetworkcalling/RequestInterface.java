package com.saiful.androidrxnetworkcalling;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by saiful on 7/12/18.
 */

public interface RequestInterface {
    @GET("android/jsonarray/")
    Observable<List<Android>> register();
}
