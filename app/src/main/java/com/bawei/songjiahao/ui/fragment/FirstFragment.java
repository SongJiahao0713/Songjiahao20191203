package com.bawei.songjiahao.ui.fragment;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.songjiahao.Base.BaseFragment;
import com.bawei.songjiahao.R;
import com.bawei.songjiahao.Utils.NetUtil;
import com.bawei.songjiahao.contract.INewContract;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class FirstFragment extends BaseFragment {

    private LinearLayout ll;
    private TextView first_tv;

    @Override
    protected void initView(View inflate) {
        ll = inflate.findViewById(R.id.ll);
        first_tv = inflate.findViewById(R.id.fist_tv);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initData() {
        if (NetUtil.getInstance().HasNet(getActivity())){
            ll.setVisibility(View.INVISIBLE);
            first_tv.setVisibility(View.VISIBLE);
        }else{
            ll.setVisibility(View.VISIBLE);
            first_tv.setVisibility(View.INVISIBLE);
        }

    }
}
