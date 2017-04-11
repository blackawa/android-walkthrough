package jp.blackawa.example.qiitareader;

import java.util.List;

import jp.blackawa.example.qiitareader.entity.PostEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QiitaService {
    @GET("/items")
    Call<List<PostEntity>> listItems(
            @Query("page") String page,
            @Query("per_page") String perPage,
            @Query("query") String query
    );
}
