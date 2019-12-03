package com.bawei.songjiahao.Base;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.songjiahao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();
}
