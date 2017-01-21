package br.com.hisao.hf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import br.com.hisao.hf.util.Log;
import br.com.hisao.hf.models.Receipe;
import br.com.hisao.hf.modelsweb.HelloFrashWebApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://api.myservice.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Call<List<Receipe>> listCall = HelloFrashWebApi.getHelloFreshApiInterface().getReceipes();
        listCall.enqueue(new Callback<List<Receipe>>() {
            @Override
            public void onResponse(Call<List<Receipe>> call, Response<List<Receipe>> response) {
                for (Receipe receipe : response.body()) {
                    Log.d("MainActivity:onResponse:51 " + receipe.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Receipe>> call, Throwable t) {
                Log.d("MainActivity:onFailure:54 " + t.getMessage());
            }
        });
    }
}
