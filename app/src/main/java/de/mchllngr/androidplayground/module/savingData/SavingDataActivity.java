package de.mchllngr.androidplayground.module.savingData;

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
import de.mchllngr.androidplayground.module.savingData.fragment.SavingDataOneFragment;
import de.mchllngr.androidplayground.util.FragmentStarter;

/**
 * {@link android.app.Activity} for testing ways to save data across multiple screens.
 * <p>
 * Static is not an option, because static variables get deleted for example after following click-through:
 * Minimize app -> to android-settings for this app -> change one permission -> maximize app -> static variables are deleted
 **/
public class SavingDataActivity extends BaseActivity<SavingDataView, SavingDataPresenter> implements SavingDataView {

    @BindView(R.id.toolbar) Toolbar toolbar;

    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, SavingDataActivity.class);
        context.startActivity(starter);
    }

    @NonNull
    @Override
    public SavingDataPresenter createPresenter() {
        return new SavingDataPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_data);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionBarTitle(R.string.saving_data_activity_name);

        FragmentStarter.startFragment(getSupportFragmentManager(), SavingDataOneFragment.newInstance(), "SavingDataOneFragment", R.id.fl_fragment_container);
    }

    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
