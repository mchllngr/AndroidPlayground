package de.mchllngr.androidplayground.module.fragmentTheme.fragment;

import android.support.annotation.StringRes;
import android.widget.Toast;

import de.mchllngr.androidplayground.R;

public class FragmentThemeThreeFragment extends BaseFragmentThemeFragment {

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.fragment_theme_fragment_three_name;
    }

    @Override
    protected void onButtonClicked() {
        Toast.makeText(getContext(), "No next fragment!", Toast.LENGTH_SHORT).show();
    }
}
