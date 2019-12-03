package com.bawei.songjiahao.model;

import com.bawei.songjiahao.Utils.NetUtil;
import com.bawei.songjiahao.contract.INewContract;
import com.bawei.songjiahao.model.shopBean.ShopBean;
import com.google.gson.Gson;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class Model implements INewContract.iModel {
    @Override
    public void getList(String httpUrl, final ModelCallBack modelCallBack) {
        NetUtil.getInstance().getJson(httpUrl, new NetUtil.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
                modelCallBack.access(shopBean);
            }
        });
    }
}
