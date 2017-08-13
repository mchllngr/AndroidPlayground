package de.mchllngr.androidplayground.module.fragmentTheme.fragment;

import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;

import de.mchllngr.androidplayground.R;

public class FragmentThemeOneFragment extends BaseFragmentThemeFragment {

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.fragment_theme_fragment_one_name;
    }

    @Override
    @StyleRes
    protected int getFragmentTheme() {
        return R.style.FragmentTheme_One_Theme;
    }

    @Override
    protected void onButtonClicked() {
        openFragment(new FragmentThemeTwoFragment(), "FragmentThemeTwoFragment");
    }
}
