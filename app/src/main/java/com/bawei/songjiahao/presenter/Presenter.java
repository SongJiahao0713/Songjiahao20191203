package com.bawei.songjiahao.presenter;

import com.bawei.songjiahao.contract.INewContract;
import com.bawei.songjiahao.model.Model;
import com.bawei.songjiahao.model.shopBean.ShopBean;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public class Presenter implements INewContract.iPresenter {

    private Model model;
    INewContract.iView iView;

    public Presenter(INewContract.iView iView) {
        this.iView = iView;
    }

    @Override
    public void getList(String httpUrl) {
        model = new Model();
        model.getList(httpUrl, new INewContract.iModel.ModelCallBack() {
            @Override
            public void access(ShopBean shopBean) {
                iView.access(shopBean);
            }
        });
    }
}
