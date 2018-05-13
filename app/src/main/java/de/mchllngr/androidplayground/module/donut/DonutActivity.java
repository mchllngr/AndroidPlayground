package de.mchllngr.androidplayground.module.donut;

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

/**
 * {@link android.app.Activity} for showing custom drawn Donuts as seen here https://www.youtube.com/watch?v=H05mF0qrBVA
 */
public class DonutActivity extends BaseActivity<DonutView, DonutPresenter> implements DonutView {

    /**
     * {@link Toolbar} for this {@link android.app.Activity}.
     */
    @BindView(R.id.toolbar) Toolbar toolbar;

    /**
     * Static factory method that initializes and starts the {@link android.app.Activity}.
     */
    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, DonutActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    @Override
    public DonutPresenter createPresenter() {
        return new DonutPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionBarTitle(R.string.donut_activity_name);
    }

    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
