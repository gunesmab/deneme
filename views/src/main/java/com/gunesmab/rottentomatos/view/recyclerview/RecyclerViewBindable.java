package com.gunesmab.rottentomatos.view.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class RecyclerViewBindable extends RecyclerView {

    public RecyclerViewBindable(@NonNull final Context context) {
        super(context);
    }

    public RecyclerViewBindable(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewBindable(@NonNull final Context context,
                                @Nullable final AttributeSet attrs,
                                final int defStyle) {
        super(context, attrs, defStyle);
    }
}
