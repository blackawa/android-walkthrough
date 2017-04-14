package jp.blackawa.example.qiitareader

import jp.blackawa.example.qiitareader.entity.PostEntity
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface QiitaService {
    @GET("items")
    fun listItems(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Observable<List<PostEntity>>
}
