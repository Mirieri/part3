package com.udacity.movie.part3.database.di.module;

import android.content.Context;


import com.udacity.movie.part3.database.di.interfaces.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @Provides
    @Singleton
    public Context context() {
        return context.getApplicationContext();
    }
}
