package de.mchllngr.androidplayground.module.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.base.BaseActivity;
import de.mchllngr.androidplayground.module.blank.BlankActivity;
import de.mchllngr.androidplayground.module.fragmentTheme.FragmentThemeActivity;
import de.mchllngr.androidplayground.module.savingData.SavingDataActivity;

/**
 * {@link android.app.Activity} for opening the other {@link android.app.Activity}s.
 */
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    /**
     * {@link Toolbar} for this {@link android.app.Activity}.
     */
    @BindView(R.id.toolbar) Toolbar toolbar;

    /**
     * Static factory method that initializes and starts the {@link android.app.Activity}.
     */
    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }

    @OnClick(R.id.btn_main_open_blank)
    public void openBlankActivity() {
        BlankActivity.start(this);
    }

    @OnClick(R.id.btn_main_open_saving_data)
    public void openSavingDataActivity() {
        SavingDataActivity.start(this);
    }

    @OnClick(R.id.btn_main_open_fragment_theme)
    public void openFragmentThemeActivity() {
        FragmentThemeActivity.start(this);
    }
}
