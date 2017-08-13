package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import de.mchllngr.androidplayground.module.savingData.data.SavedInFragment;
import timber.log.Timber;

/*
 * TODO //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * - Check if createNewModel is called to often / at the wrong time.
 * - Check why giving data to a previous fragment already works even if it should not be possible at the moment (because not yet implement).
 *      -> All 3 fragments get the same instance from getModel(). That's how the data gets given backwards, but I dont know why the instance survives.
 * TODO //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
public abstract class BaseSavingDataModelFragment extends Fragment {

    private static final String KEY_MODEL = "MODEL";

    @Nullable private SavedInFragment model;

    // TODO maybe use getView() == null for this ?
    private boolean isViewCreated = false;

    protected abstract void onSaveData(boolean isViewCreated);

    protected abstract void onRestoreData(boolean isViewCreated);

    protected static void addModelToBundle(Bundle bundle, SavedInFragment model) {
        if (bundle != null && model != null) bundle.putParcelable(KEY_MODEL, model);
    }

    private void restoreModelFromSavedInstanceStateOrArguments(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_MODEL))
            model = savedInstanceState.getParcelable(KEY_MODEL);
        else if (getArguments() != null && getArguments().containsKey(KEY_MODEL))
            model = getArguments().getParcelable(KEY_MODEL);

        // TODO as "default else"
//        else
//            createNewModel();
        // TODO or "only if still null"
        if (model == null)
            createNewModel();
    }

    private void createNewModel() {
        if (model == null) {
            Timber.w("WARNING: created new model (model was null)");
            model = new SavedInFragment();
        } else {
            Timber.w("WARNING: createNewModel was called, but model was not null");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restoreModelFromSavedInstanceStateOrArguments(savedInstanceState);
        isViewCreated = true;
    }

    @Override
    public void onDestroyView() {
        isViewCreated = false;
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        addModelToBundle(outState, getModel(true));
    }

    @Override
    public void onStart() {
        super.onStart();
        onRestoreData(isViewCreated);
    }

    @Override
    public void onStop() {
        onSaveData(isViewCreated);
        super.onStop();
    }

    @NonNull
    protected SavedInFragment getModel(boolean safeBeforeReturning) {
        if (model == null) restoreModelFromSavedInstanceStateOrArguments(null);
        if (safeBeforeReturning) onSaveData(isViewCreated);
        return model;
    }

    protected boolean isViewCreated() {
        return isViewCreated;
    }
}
