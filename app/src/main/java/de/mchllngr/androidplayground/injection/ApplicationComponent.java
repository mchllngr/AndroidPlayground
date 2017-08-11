package de.mchllngr.androidplayground.injection;

import javax.inject.Singleton;

import dagger.Component;
import de.mchllngr.androidplayground.module.blank.BlankPresenter;

/**
 * Dagger2-component for the whole application.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BlankPresenter presenter);
}
