package de.mchllngr.androidplayground.module.fragmentTheme.fragment;

import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.widget.Toast;

import de.mchllngr.androidplayground.R;

public class FragmentThemeThreeFragment extends BaseFragmentThemeFragment {

    @Override
    @StringRes
    protected int getFragmentName() {
        return R.string.fragment_theme_fragment_three_name;
    }

    @Override
    @StyleRes
    protected int getFragmentTheme() {
        return R.style.FragmentTheme_Three_Theme;
    }

    @Override
    protected void onButtonClicked() {
        Toast.makeText(getContext(), "No next fragment!", Toast.LENGTH_SHORT).show();
    }
}
