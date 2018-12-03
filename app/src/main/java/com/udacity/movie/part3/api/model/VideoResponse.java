package com.udacity.movie.part3.api.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.udacity.movie.part3.database.entity.VideoEntity;

import java.util.List;

public class VideoResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<VideoEntity> results;

    public VideoResponse(Integer id, List<VideoEntity> results) {
        this.id = id;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public List<VideoEntity> getResults() {
        return results;
    }
}
