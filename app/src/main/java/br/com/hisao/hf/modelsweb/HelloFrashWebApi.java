package br.com.hisao.hf.modelsweb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by viniciushisao.
 */

public class HelloFrashWebApi {
    private static final String BASE_URL = "https://api.hellofresh.com/";

    private static HelloFreshApiInterface helloFreshApiInterface;

    private HelloFrashWebApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        helloFreshApiInterface = retrofit.create(HelloFreshApiInterface.class);
    }

    public static HelloFreshApiInterface getHelloFreshApiInterface() {
        if (helloFreshApiInterface == null) {
            new HelloFrashWebApi();
        }
        return helloFreshApiInterface;
    }

}
