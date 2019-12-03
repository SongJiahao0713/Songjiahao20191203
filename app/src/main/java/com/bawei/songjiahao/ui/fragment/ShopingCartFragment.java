package com.bawei.songjiahao.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.songjiahao.Base.BaseFragment;
import com.bawei.songjiahao.R;
import com.bawei.songjiahao.adapter.MyAdapter;
import com.bawei.songjiahao.contract.INewContract;
import com.bawei.songjiahao.model.shopBean.ShopBean;
import com.bawei.songjiahao.presenter.Presenter;
import com.bawei.songjiahao.ui.activity.MainActivity;

import java.util.List;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class ShopingCartFragment extends BaseFragment implements INewContract.iView {

    private Button shop_bt;
    private GridView gv;

    @Override
    protected void initView(View inflate) {
        gv = inflate.findViewById(R.id.gv);
        shop_bt = inflate.findViewById(R.id.shop_bt);
        shop_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.gotoFirst();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shoppingcar;
    }

    @Override
    protected void initData() {
        Presenter presenter = new Presenter(this);
        presenter.getList("http://blog.zhaoliang5156.cn/api/mall/mall.json");
    }

    @Override
    public void access(ShopBean shopBean) {
        List<ShopBean.ShopGridDataBean> shopGridData = shopBean.getShopGridData();
        MyAdapter myAdapter = new MyAdapter(shopGridData);
        gv.setAdapter(myAdapter);
    }

    @Override
    public void failure(Throwable throwable) {
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
    }
}
