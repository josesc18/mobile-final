package pe.com.ritmocolorsabor.api;

import retrofit2.*;

import retrofit2.converter.gson.GsonConverterFactory;

public class ClientAPI {

    private static final String BASE_URL = "http://192.168.0.104:8000/api/";

    public static Retrofit getRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
