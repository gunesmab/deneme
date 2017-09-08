package com.gunesmab.rottentomatos.activity;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.gunesmab.javautils.ResourceUtil;
import com.gunesmab.rottentomatos.fragment.BaseFragment;

public abstract class BaseActivity extends AppCompatActivity {

    protected final void replaceFragment(@NonNull final BaseFragment fragment) {
        replaceFragment(getFragmentContainerResId(), fragment, null);
    }

    protected final void replaceFragment(@IdRes final int containerResId,
                                   @NonNull final BaseFragment fragment,
                                   @Nullable final String tag) {
        ResourceUtil.getInstance().checkValid(containerResId);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerResId, fragment, tag)
                .commitAllowingStateLoss();
    }

    @IdRes
    protected int getFragmentContainerResId() {
        return ResourceUtil.INVALID_RESOURCE_ID;
    }

}
