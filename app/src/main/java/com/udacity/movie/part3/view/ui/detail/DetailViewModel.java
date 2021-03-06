package com.udacity.movie.part3.view.ui.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.bumptech.glide.load.engine.Resource;
import com.udacity.movie.part3.database.entity.CastEntity;
import com.udacity.movie.part3.database.entity.FavMovieEntity;
import com.udacity.movie.part3.database.entity.GenreEntity;
import com.udacity.movie.part3.database.entity.MovieEntity;
import com.udacity.movie.part3.database.entity.ReviewEntity;
import com.udacity.movie.part3.database.entity.VideoEntity;
import com.udacity.movie.part3.repository.AppRepository;

import com.udacity.movie.part3.utils.SharedPreferenceHelper;

import java.util.List;

import javax.inject.Inject;

public class DetailViewModel extends ViewModel {

    private AppRepository moviesRepo;
    private MutableLiveData<Resource<List<CastEntity>>> castResults = new MutableLiveData<>();
    private MutableLiveData<Resource<List<VideoEntity>>> videoResults = new MutableLiveData<>();
    private MutableLiveData<Resource<List<ReviewEntity>>> reviewResult = new MutableLiveData<>();
    private MutableLiveData<MovieEntity> movieResult = new MutableLiveData<>();

    @Inject
    public DetailViewModel(AppRepository moviesRepo) {
        this.moviesRepo = moviesRepo;

        moviesRepo.loadCast(SharedPreferenceHelper.getSharedPreferenceInt("mId"))
                .observeForever(listResource -> castResults.setValue(listResource));

        moviesRepo.loadReviews(SharedPreferenceHelper.getSharedPreferenceInt("mId"))
                .observeForever(listResource -> reviewResult.setValue(listResource));

        moviesRepo.loadVideos(SharedPreferenceHelper.getSharedPreferenceInt("mId"))
                .observeForever(listResource -> videoResults.setValue(listResource));

        moviesRepo.loadMoviesById(SharedPreferenceHelper.getSharedPreferenceInt("mId"))
                .observeForever(movieEntity -> movieResult.setValue(movieEntity));
    }

    LiveData<Resource<List<GenreEntity>>> getGenresById(List<Integer> genreIds) {
        return moviesRepo.loadGenres(genreIds);
    }

    public MutableLiveData<MovieEntity> getMovieResult() {
        return movieResult;
    }

    public MutableLiveData<Resource<List<CastEntity>>> getCastResults() {
        return castResults;
    }

    public MutableLiveData<Resource<List<VideoEntity>>> getVideoResults() {
        return videoResults;
    }

    public MutableLiveData<Resource<List<ReviewEntity>>> getReviewResult() {
        return reviewResult;
    }

    void saveFavMovies(FavMovieEntity favMovieEntity) {
        moviesRepo.saveFavouriteMovie(favMovieEntity);
    }

    void saveFavCast(List<CastEntity> favCast) {
        moviesRepo.saveFavMovieCast(favCast);
    }

    void saveFavReviews(List<ReviewEntity> favReviews) {
        moviesRepo.saveFavMovieReviews(favReviews);
    }

    void saveFavTrailers(List<VideoEntity> favTrailers) {
        moviesRepo.saveFavMovieVideos(favTrailers);
    }

    LiveData<FavMovieEntity> loadFavMoviesById(int favMovieId) {
        return moviesRepo.loadFavMovieById(favMovieId);
    }

    LiveData<List<CastEntity>> getFavCasts(List<Integer> castIds) {
        return moviesRepo.getCastsById(castIds);
    }

    LiveData<List<ReviewEntity>> getFavReviews(int favMovieId) {
        return moviesRepo.getReviewsByMovie(favMovieId);
    }

    LiveData<List<VideoEntity>> getFavVideos(int favMovieId) {
        return moviesRepo.getVideosByMovie(favMovieId);
    }

    LiveData<Integer> deleteMovieById(int favMovieId) {
        return moviesRepo.deleteMovieById(favMovieId);
    }
}
