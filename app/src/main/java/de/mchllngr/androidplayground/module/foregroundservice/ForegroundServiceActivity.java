package de.mchllngr.androidplayground.module.foregroundservice;

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
import de.mchllngr.androidplayground.module.blank.BlankPresenter;
import de.mchllngr.androidplayground.module.blank.BlankView;

public class ForegroundServiceActivity extends BaseActivity<BlankView, BlankPresenter> implements BlankView {

    @BindView(R.id.toolbar) Toolbar toolbar;

    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, ForegroundServiceActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    @Override
    public BlankPresenter createPresenter() {
        return new BlankPresenter();
    }

    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionBarTitle(R.string.foreground_service_activity_name);
    }

    @OnClick(R.id.start)
    public void onStartClick() {
        Intent startIntent = new Intent(this, ForegroundService.class);
        startIntent.setAction(ForegroundService.START_ACTION);
        startService(startIntent);
    }

    @OnClick(R.id.stop)
    public void onStopClick() {
        Intent stopIntent = new Intent(this, ForegroundService.class);
        stopIntent.setAction(ForegroundService.STOP_ACTION);
        startService(stopIntent);
    }
}
