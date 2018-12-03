package com.udacity.movie.part3.repository;

import android.arch.lifecycle.LiveData;


import com.udacity.movie.part3.database.entity.CastEntity;
import com.udacity.movie.part3.database.entity.FavMovieEntity;
import com.udacity.movie.part3.database.entity.GenreEntity;
import com.udacity.movie.part3.database.entity.MovieEntity;
import com.udacity.movie.part3.database.entity.ReviewEntity;
import com.udacity.movie.part3.database.entity.VideoEntity;

import java.util.List;

public interface AppRepositoryInterface {
    LiveData<com.udacity.movie.part3.utils.Resource<List<GenreEntity>>> loadGenres(List<Integer> genreIds);

    LiveData<com.udacity.movie.part3.utils.Resource<List<MovieEntity>>> loadMovies(boolean forceLoad, String sortBy);

    LiveData<MovieEntity> loadMoviesById(int movieId);

    LiveData<com.udacity.movie.part3.utils.Resource<List<CastEntity>>> loadCast(int movieId);

    LiveData<com.udacity.movie.part3.utils.Resource<List<VideoEntity>>> loadVideos(int movieId);

    LiveData<com.udacity.movie.part3.utils.Resource<List<ReviewEntity>>> loadReviews(int movieId);

    void saveFavouriteMovie(FavMovieEntity favMovieEntity);

    void saveFavMovieCast(List<CastEntity> favMovieCastEntities);

    void saveFavMovieReviews(List<ReviewEntity> favMovieReviewEntities);

    void saveFavMovieVideos(List<VideoEntity> favMovieVideoEntities);

    LiveData<List<FavMovieEntity>> loadFavMoviesFromDb();

    LiveData<FavMovieEntity> loadFavMovieById(int movieId);

    LiveData<List<CastEntity>> getCastsById(List<Integer> castIds);

    LiveData<List<ReviewEntity>> getReviewsByMovie(int favMovieId);

    LiveData<List<VideoEntity>> getVideosByMovie(int favMovieId);

    LiveData<Integer> deleteMovieById(int favMovieId);
}
