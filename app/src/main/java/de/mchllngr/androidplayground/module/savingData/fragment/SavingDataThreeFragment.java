package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Toast;

import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.module.savingData.data.SavingDataStatic;

public class SavingDataThreeFragment extends BaseSavingDataFragment {

    public static SavingDataThreeFragment newInstance() {
        Bundle args = new Bundle();

        SavingDataThreeFragment fragment = new SavingDataThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.saving_data_fragment_three_name;
    }

    @Override
    protected void onButtonClicked() {
        Toast.makeText(getContext(), "No next fragment!", Toast.LENGTH_SHORT).show();
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
