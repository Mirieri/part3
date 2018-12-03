package com.udacity.movie.part3.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.udacity.movie.part3.database.converter.IntegerListConvertor;
import com.udacity.movie.part3.database.dao.MoviesDao;
import com.udacity.movie.part3.database.entity.CastEntity;
import com.udacity.movie.part3.database.entity.FavMovieEntity;
import com.udacity.movie.part3.database.entity.GenreEntity;
import com.udacity.movie.part3.database.entity.MovieEntity;
import com.udacity.movie.part3.database.entity.ReviewEntity;
import com.udacity.movie.part3.database.entity.VideoEntity;


@Database(entities = {
        MovieEntity.class,
        GenreEntity.class,
        FavMovieEntity.class,
        CastEntity.class,
        ReviewEntity.class,
        VideoEntity.class},
        version = 1, exportSchema = false)
@TypeConverters({IntegerListConvertor.class})
public abstract class MoviesDb extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MoviesDb INSTANCE;

    // --- DAO ---
    public abstract MoviesDao moviesDao();

}
