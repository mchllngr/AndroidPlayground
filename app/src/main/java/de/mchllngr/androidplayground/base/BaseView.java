package de.mchllngr.androidplayground.base;

import android.support.v4.app.FragmentActivity;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Base-interface for every view.
 */
public interface BaseView extends MvpView {

    /**
     * Allows the {@link BasePresenter} to get the associated Activity.
     *
     * @return {@link FragmentActivity}
     * @see BasePresenter
     */
    FragmentActivity getActivity();
}
