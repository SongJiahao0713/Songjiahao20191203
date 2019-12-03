package com.bawei.songjiahao.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.songjiahao.Base.BaseFragment;
import com.bawei.songjiahao.R;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class OtherFragment extends BaseFragment {

    private TextView other;

    @Override
    protected void initView(View inflate) {
        other = inflate.findViewById(R.id.other_tv);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_other;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String key = arguments.getString("key");
        other.setText(key);
    }

    public static OtherFragment getInstance(String value) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",value);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
