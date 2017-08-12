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
 * - check if createNewSavedInFragment is called to often / at the wrong time
 * - should restoreSavedInFragmentFromSavedInstanceStateOrArguments also be called in onCreate (and every other method with savedInstanceState) to always have the latest data ?
 * - should restoreSavedInFragmentFromSavedInstanceStateOrArguments really call createNewSavedInFragment in default-else or only if savedInFragment is still null at the end of the method ?
 * - check if getting data from getDataSavedInFragment with true (for 'safeBeforeReturning') in onSaveInstanceState could be called after the view is destroyed (possible NPE)
 * - check why giving data to a previous fragment already works even if it should not be possible at the moment (because not yet implement)
 * TODO //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 */
public abstract class BaseSavingDataInFragmentFragment extends Fragment {

    private static final String KEY_SAVED_IN_FRAGMENT = "SAVED_IN_FRAGMENT";

    @Nullable private SavedInFragment savedInFragment;

    protected abstract void onSaveData();

    protected abstract void onRestoreData();

    protected static void addSavedInFragmentToBundle(Bundle bundle, SavedInFragment savedInFragment) {
        if (bundle != null && savedInFragment != null) bundle.putParcelable(KEY_SAVED_IN_FRAGMENT, savedInFragment);
    }

    private void createNewSavedInFragment(@NonNull String nullInMethod) {
        if (savedInFragment == null) {
            Timber.w("WARNING: created new savedInFragment (savedInFragment was null in '" + nullInMethod + "')");
            savedInFragment = new SavedInFragment();
        } else {
            Timber.w("WARNING: createNewSavedInFragment was called from '" + nullInMethod + "', but savedInFragment was not null");
        }
    }

    private void restoreSavedInFragmentFromSavedInstanceStateOrArguments(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_SAVED_IN_FRAGMENT))
            savedInFragment = savedInstanceState.getParcelable(KEY_SAVED_IN_FRAGMENT);
        else if (getArguments() != null && getArguments().containsKey(KEY_SAVED_IN_FRAGMENT))
            savedInFragment = getArguments().getParcelable(KEY_SAVED_IN_FRAGMENT);
        else
            createNewSavedInFragment("restoreSavedInFragmentFromSavedInstanceStateOrArguments");
    }

    @NonNull
    protected SavedInFragment getDataSavedInFragment(boolean safeBeforeReturning) {
        if (savedInFragment == null) createNewSavedInFragment("getDataSavedInFragment");
        if (safeBeforeReturning) onSaveData();
        return savedInFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        restoreSavedInFragmentFromSavedInstanceStateOrArguments(savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        addSavedInFragmentToBundle(outState, getDataSavedInFragment(true));
    }

    @Override
    public void onStart() {
        super.onStart();
        onRestoreData();
    }

    @Override
    public void onStop() {
        onSaveData();
        super.onStop();
    }
}
