package com.bawei.songjiahao.contract;

import com.bawei.songjiahao.model.shopBean.ShopBean;

/**
 * 时间：2019/12/3 0003
 * 作者：Songjiahao
 * 类的作用：
 */
public interface INewContract {

    interface iModel{
        interface ModelCallBack{
            void access(ShopBean shopBean);
        }
        void getList(String httpUrl,ModelCallBack modelCallBack);
    }

    interface iView{
        void access(ShopBean shopBean);

        void failure(Throwable throwable);
    }

    interface iPresenter{
        void getList(String httpUrl);
    }
}
