package com.udacity.movie.part3.api;

import android.arch.lifecycle.LiveData;


import com.udacity.movie.part3.api.model.CastResponse;
import com.udacity.movie.part3.api.model.GenreResponse;
import com.udacity.movie.part3.api.model.MoviesResponse;
import com.udacity.movie.part3.api.model.ReviewResponse;
import com.udacity.movie.part3.api.model.VideoResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/{type}")
    LiveData<ApiResponse<MoviesResponse>> getMovies(@Path(value = "type", encoded = true) String type,
                                                    @Query("language") String language,
                                                    @Query("page") int page);

    @GET("genre/movie/list")
    LiveData<ApiResponse<GenreResponse>> getGenres(@Query("language") String language);

    @GET("movie/{movieId}/credits")
    LiveData<ApiResponse<CastResponse>> getCast(@Path(value = "movieId", encoded = true) int movieId,
                                                @Query("language") String language);

    @GET("movie/{movieId}/videos")
    LiveData<ApiResponse<VideoResponse>> getVideos(@Path(value = "movieId", encoded = true) int movieId,
                                                   @Query("language") String language);

    @GET("movie/{movieId}/reviews")
    LiveData<ApiResponse<ReviewResponse>> getReviews(@Path(value = "movieId", encoded = true) int movieId,
                                                     @Query("language") String language);
}
