package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.StringRes;

import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.module.savingData.data.SavingDataStatic;

public class SavingDataOneFragment extends BaseSavingDataFragment {

    public static SavingDataOneFragment newInstance() {
        Bundle args = new Bundle();

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
        openFragment(SavingDataTwoFragment.newInstance(), "SavingDataTwoFragment");
    }

    @Override
    public void onStart() {
        super.onStart();

        etStatic.setText(SavingDataStatic.staticSavedString);
    }

    @Override
    public void onStop() {
        SavingDataStatic.staticSavedString = etStatic.getText().toString();

        super.onStop();
    }
}
