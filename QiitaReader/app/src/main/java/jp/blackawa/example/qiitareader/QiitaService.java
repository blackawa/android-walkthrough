package jp.blackawa.example.qiitareader;

import java.util.List;

import jp.blackawa.example.qiitareader.entity.PostEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface QiitaService {
    @GET("items")
    Observable<List<PostEntity>> listItems(
            @Query("page") int page,
            @Query("per_page") int perPage
    );
}
