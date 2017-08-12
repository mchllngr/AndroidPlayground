package de.mchllngr.androidplayground.util;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Helper-class for starting a {@link Fragment}.
 */
public class FragmentStarter {

    /**
     * Starts a {@link Fragment}.
     *
     * @param fragmentManager   {@link FragmentManager} to use
     * @param fragment          {@link Fragment} to start
     * @param tag               {@link String} as tag
     * @param fragmentContainer {@link IdRes} of a container to load the {@link Fragment} into
     */
    public static void startFragment(@NonNull FragmentManager fragmentManager,
                                     Fragment fragment,
                                     String tag,
                                     @IdRes int fragmentContainer) {
        if (fragment != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            if (ft.isAddToBackStackAllowed())
                ft.addToBackStack(tag);
            ft.replace(fragmentContainer, fragment, tag);
            ft.commit();
        }
    }
}
