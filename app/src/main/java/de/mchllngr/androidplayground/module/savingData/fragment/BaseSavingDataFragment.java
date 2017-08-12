package de.mchllngr.androidplayground.module.savingData.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.base.BaseActivity;
import de.mchllngr.androidplayground.util.FragmentStarter;

public abstract class BaseSavingDataFragment extends Fragment {

    @BindView(R.id.et_static) protected EditText etStatic;
    @BindView(R.id.btn_saving_data) Button button;

    @StringRes
    protected abstract int getFragmentName();

    protected abstract void onButtonClicked();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saving_data, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).setActionBarTitle(getFragmentName());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        // disable button when on SavingDataThreeFragment
        button.setEnabled(!(this instanceof SavingDataThreeFragment));
    }

    protected void openFragment(Fragment fragment, String tag) {
        FragmentStarter.startFragment(getFragmentManager(), fragment, tag, R.id.fl_fragment_container);
    }

    @OnClick(R.id.btn_saving_data)
    public void onClick() {
        onButtonClicked();
    }
}
