package de.mchllngr.androidplayground.base;

import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

import de.mchllngr.androidplayground.App;
import de.mchllngr.androidplayground.injection.ApplicationComponent;

/**
 * Base-class for work concerning every {@link MvpPresenter}.
 *
 * @param <V> view-interface for this fragment
 */
public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    /**
     * Gets the dagger-component for the whole application.
     *
     * @return dagger-component from the {@link App}
     */
    @Nullable
    @SuppressWarnings("ConstantConditions")
    protected ApplicationComponent getApplicationComponent() {
        App app;
        if (isViewAttached()
                && getView().getActivity() != null
                && (app = (App) getView().getActivity().getApplication()) != null)
            return app.getApplicationComponent();

        return null;
    }
}
