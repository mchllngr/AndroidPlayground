package de.mchllngr.androidplayground.module.fragmentTheme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.base.BaseActivity;
import de.mchllngr.androidplayground.module.fragmentTheme.fragment.FragmentThemeOneFragment;
import de.mchllngr.androidplayground.util.FragmentStarter;

/**
 * {@link android.app.Activity} for setting a Theme for each Fragment.
 * <p>
 * See https://stackoverflow.com/a/15496425/4567591
 */
public class FragmentThemeActivity extends BaseActivity<FragmentThemeView, FragmentThemePresenter> implements FragmentThemeView {

    @BindView(R.id.toolbar) Toolbar toolbar;

    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, FragmentThemeActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    @Override
    public FragmentThemePresenter createPresenter() {
        return new FragmentThemePresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_theme);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionBarTitle(R.string.fragment_theme_activity_name);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            FragmentStarter.startFragment(getSupportFragmentManager(), new FragmentThemeOneFragment(), "FragmentThemeOneFragment", R.id.fl_fragment_container);
    }

    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
