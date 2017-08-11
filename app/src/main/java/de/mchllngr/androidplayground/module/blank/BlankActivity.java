package de.mchllngr.androidplayground.module.blank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.base.BaseActivity;

/**
 * {@link android.app.Activity} for (TODO) doing something.
 */
public class BlankActivity extends BaseActivity<BlankView, BlankPresenter> implements BlankView {

    /**
     * {@link Toolbar} for this {@link android.app.Activity}.
     */
    @BindView(R.id.toolbar) Toolbar toolbar;
    /**
     * {@link FloatingActionButton} for an example with {@link ButterKnife}.
     */
    @BindView(R.id.fab) FloatingActionButton fab;

    /**
     * Static factory method that initializes and starts the {@link android.app.Activity}.
     */
    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, BlankActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    @Override
    public BlankPresenter createPresenter() {
        return new BlankPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.blank_activity_name);

        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
