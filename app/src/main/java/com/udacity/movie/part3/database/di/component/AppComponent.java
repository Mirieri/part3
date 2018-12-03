package com.udacity.movie.part3.database.di.component;

import android.app.Application;


import com.udacity.movie.part3.MoviesApp;
import com.udacity.movie.part3.database.di.module.ActivityModule;
import com.udacity.movie.part3.database.di.module.AppModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MoviesApp app);
}
