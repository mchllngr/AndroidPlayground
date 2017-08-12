package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.StringRes;

import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.module.savingData.data.SavedInFragment;
import de.mchllngr.androidplayground.module.savingData.data.SavedStatic;

public class SavingDataOneFragment extends BaseSavingDataFragment {

    public static SavingDataOneFragment newInstance(SavedInFragment savedInFragment) {
        Bundle args = new Bundle();
        addSavedInFragmentToBundle(args, savedInFragment);
        SavingDataOneFragment fragment = new SavingDataOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.saving_data_fragment_one_name;
    }

    @Override
    protected void onButtonClicked() {
        openFragment(SavingDataTwoFragment.newInstance(getDataSavedInFragment(true)), "SavingDataTwoFragment");
    }

    @Override
    public void onSaveData() {
        SavedStatic.staticSavedString = etStatic.getText().toString();
        getDataSavedInFragment(false).savedInFragmentString = etInFragment.getText().toString();
    }

    @Override
    public void onRestoreData() {
        etStatic.setText(SavedStatic.staticSavedString);
        etInFragment.setText(getDataSavedInFragment(false).savedInFragmentString);
    }
}
