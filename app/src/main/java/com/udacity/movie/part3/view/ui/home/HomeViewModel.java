package com.udacity.movie.part3.view.ui.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;


import com.udacity.movie.part3.database.entity.FavMovieEntity;
import com.udacity.movie.part3.database.entity.MovieEntity;
import com.udacity.movie.part3.repository.AppRepository;

import java.util.List;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    private AppRepository moviesRepo;

    @Inject
    HomeViewModel(AppRepository moviesRepo) {
        this.moviesRepo = moviesRepo;
    }

    LiveData<com.udacity.movie.part3.utils.Resource<List<MovieEntity>>> loadMovies(boolean forceLoad, String sortBy){
        return moviesRepo.loadMovies(forceLoad, sortBy);
    }

    LiveData<List<FavMovieEntity>> loadFavMoviesFromDb(){
        return moviesRepo.loadFavMoviesFromDb();
    }
}
