package com.gunesmab.rottentomatos;

import android.os.Bundle;
import com.gunesmab.rottentomatos.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getFragmentContainerResId() {
        return R.id.activity_main_fragment_container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        replaceFragment();
    }
}
