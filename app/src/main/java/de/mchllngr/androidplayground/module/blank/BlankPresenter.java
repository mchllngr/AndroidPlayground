package de.mchllngr.androidplayground.module.blank;

import de.mchllngr.androidplayground.base.BasePresenter;

/**
 * {@link com.hannesdorfmann.mosby3.mvp.MvpPresenter} for the {@link BlankActivity}
 */
@SuppressWarnings("ConstantConditions")
public class BlankPresenter extends BasePresenter<BlankView> {

//    /**
//     * {@link Example}-class for an example for Dagger2-injection.
//     */
//    @Inject Example exampleInject;

    @Override
    public void attachView(BlankView view) {
        super.attachView(view);
        getApplicationComponent().inject(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
