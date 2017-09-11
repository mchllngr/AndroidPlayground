package de.mchllngr.androidplayground;

import android.support.v7.app.AppCompatDelegate;

import de.mchllngr.androidplayground.base.BaseApp;
import de.mchllngr.androidplayground.injection.ApplicationComponent;
import de.mchllngr.androidplayground.injection.ApplicationModule;
import de.mchllngr.androidplayground.injection.DaggerApplicationComponent;
import de.mchllngr.androidplayground.util.SplashScreenHelper;

/**
 * {@link App} for the {@link android.app.Application}
 */
public class App extends BaseApp {

    static {
        // Sets the default night mode to follow system.
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    /**
     * Dagger2-component used for injection.
     */
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();

        registerActivityLifecycleCallbacks(new SplashScreenHelper());
    }

    /**
     * Gets the Dagger2-component for the whole application.
     *
     * @return Dagger2-component for the whole application
     */
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
