package com.udacity.movie.part3.database.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import com.udacity.movie.part3.database.di.interfaces.ViewModelKey;
import com.udacity.movie.part3.factory.ViewModelFactory;
import com.udacity.movie.part3.view.ui.detail.DetailViewModel;
import com.udacity.movie.part3.view.ui.home.HomeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    abstract ViewModel bindDetailViewModel(DetailViewModel detailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
