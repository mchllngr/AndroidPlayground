package de.mchllngr.androidplayground.module.fragmentTheme.fragment;

import android.support.annotation.StringRes;

import de.mchllngr.androidplayground.R;

public class FragmentThemeOneFragment extends BaseFragmentThemeFragment {

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.fragment_theme_fragment_one_name;
    }

    @Override
    protected void onButtonClicked() {
        openFragment(new FragmentThemeTwoFragment(), "FragmentThemeTwoFragment");
    }
}
