package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.StringRes;

import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.module.savingData.data.SavingDataStatic;

public class SavingDataTwoFragment extends BaseSavingDataFragment {

    public static SavingDataTwoFragment newInstance() {
        Bundle args = new Bundle();

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
        openFragment(SavingDataThreeFragment.newInstance(), "SavingDataThreeFragment");
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
