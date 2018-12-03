package com.udacity.movie.part3.database.di.module;



import com.udacity.movie.part3.view.ui.detail.DetailActivity;
import com.udacity.movie.part3.view.ui.detail.reviews.ReviewsActivity;
import com.udacity.movie.part3.view.ui.detail.trailers.TrailerActivity;
import com.udacity.movie.part3.view.ui.home.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract HomeActivity contributeHomeActivity();

    @ContributesAndroidInjector
    abstract DetailActivity contributeDetailActivity();

    @ContributesAndroidInjector
    abstract ReviewsActivity contributeReviewsActivity();

    @ContributesAndroidInjector
    abstract TrailerActivity contributeTrailerActivity();
}