package br.com.hisao.hf.modelsweb;

import java.util.List;

import br.com.hisao.hf.models.Receipe;
import br.com.hisao.hf.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HelloFreshApiInterface {

    @GET("users/{username}")
    void getUser(@Path("username") String username, Callback<User> cb);


    @GET("https://raw.githubusercontent.com/hellofreshdevtests/viniciushisao-android-test/master/recipes.json?token=AJrTg9JL2K2RfeBJHoOKpLT5Wc4E_ZOTks5Yi-gRwA%3D%3D")
    Call<List<Receipe>> getReceipes();

    @GET("group/{id}/users")
    void groupList(@Path("id") int groupId, @Query("sort") String sort, Callback<List<User>> cb);

    @POST("users/new")
    void createUser(@Body User user, Callback<User> cb);
}