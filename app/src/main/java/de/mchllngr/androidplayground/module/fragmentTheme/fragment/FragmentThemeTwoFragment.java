package de.mchllngr.androidplayground.module.fragmentTheme.fragment;

import android.support.annotation.StringRes;

import de.mchllngr.androidplayground.R;

public class FragmentThemeTwoFragment extends BaseFragmentThemeFragment {

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.fragment_theme_fragment_two_name;
    }

    @Override
    protected void onButtonClicked() {
        openFragment(new FragmentThemeThreeFragment(), "FragmentThemeThreeFragment");
    }
}
