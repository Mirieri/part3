package com.udacity.movie.part3.api.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.udacity.movie.part3.database.entity.GenreEntity;

import java.util.List;

public class GenreResponse {

    @SerializedName("genres")
    @Expose
    private List<GenreEntity> genres = null;

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }
}
