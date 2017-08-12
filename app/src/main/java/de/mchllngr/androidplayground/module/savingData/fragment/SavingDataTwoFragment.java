package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.StringRes;

import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.module.savingData.data.SavedInFragment;
import de.mchllngr.androidplayground.module.savingData.data.SavedStatic;

public class SavingDataTwoFragment extends BaseSavingDataFragment {

    public static SavingDataTwoFragment newInstance(SavedInFragment savedInFragment) {
        Bundle args = new Bundle();
        addSavedInFragmentToBundle(args, savedInFragment);
        SavingDataTwoFragment fragment = new SavingDataTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.saving_data_fragment_two_name;
    }

    @Override
    protected void onButtonClicked() {
        openFragment(SavingDataThreeFragment.newInstance(getDataSavedInFragment(true)), "SavingDataThreeFragment");
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
