package de.mchllngr.androidplayground.module.fragmentTheme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.mchllngr.androidplayground.R;
import de.mchllngr.androidplayground.base.BaseActivity;
import de.mchllngr.androidplayground.util.FragmentStarter;

public abstract class BaseFragmentThemeFragment extends Fragment {

    @BindView(R.id.btn_fragment_theme) Button button;

    private Context contextThemeWrapper;

    @StringRes
    protected abstract int getFragmentName();

    @StyleRes
    protected abstract int getFragmentTheme();

    protected abstract void onButtonClicked();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
         * see https://stackoverflow.com/a/15496425/4567591
         */

        // create ContextThemeWrapper from the original Activity Context with the custom theme
        contextThemeWrapper = new ContextThemeWrapper(getContext(), getFragmentTheme());

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        // inflate the layout using the cloned inflater, not default inflater
        return localInflater.inflate(R.layout.fragment_fragment_theme, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).setActionBarTitle(getFragmentName());
    }

    @Override
    public void onStart() {
        super.onStart();

        // disable button when on FragmentThemeThreeFragment
        button.setEnabled(!(this instanceof FragmentThemeThreeFragment));
    }

    protected void openFragment(Fragment fragment, String tag) {
        FragmentStarter.startFragment(getFragmentManager(), fragment, tag, R.id.fl_fragment_container);
    }

    @OnClick(R.id.btn_fragment_theme)
    public void onClick() {
        onButtonClicked();
    }

    public Context getContextThemeWrapper() {
        return contextThemeWrapper;
    }
}
