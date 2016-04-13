package com.example.retrofittest;

import com.example.retrofittest.entities.RelatedTopic;
import com.example.retrofittest.entities.Result;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by evin on 4/12/16.
 */
public class RetrofitMain {

    public static void main(String... args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.duckduckgo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DuckService duckService = retrofit.create(DuckService.class);

        Call<Result> listCall = duckService.listCharacters("simpsons characters");

        Result result = null;

        try {
            result = listCall.execute().body();
        } catch (Exception e) {
            System.out.println("Error + " + e.toString());
        }

        for (RelatedTopic relatedTopic: result.getRelatedTopics()){
            System.out.println(relatedTopic);
        }

    }

    public interface DuckService {
        @GET("?format=json")
        Call<Result> listCharacters(@Query("q") String q);
        //"http://api.duckduckgo.com/?q=simpsons&format=json"

        @GET("?q=xml")
        Call<Result> listCharacters2(@Query("format") String q);
        //"http://api.duckduckgo.com/?format=simpsons&q=xml"

        @GET("/{hola}/?q=xml")
        Call<Result> listCharacters3(@Path("hola") String hola);
        //"http://api.duckduckgo.com/simpsons/?q=xml"
    }

}
