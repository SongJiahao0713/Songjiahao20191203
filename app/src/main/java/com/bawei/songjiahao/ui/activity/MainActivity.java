package com.bawei.songjiahao.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.songjiahao.Base.BaseActivity;
import com.bawei.songjiahao.R;
import com.bawei.songjiahao.ui.fragment.FirstFragment;
import com.bawei.songjiahao.ui.fragment.OtherFragment;
import com.bawei.songjiahao.ui.fragment.ShopingCartFragment;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> fragmentList;

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        fragmentList = new ArrayList<>();
        ShopingCartFragment shopingCartFragment = new ShopingCartFragment();
        FirstFragment firstFragment = new FirstFragment();
        fragmentList.add(firstFragment);
        OtherFragment otherFragment1 = OtherFragment.getInstance("分类");
        fragmentList.add(otherFragment1);
        OtherFragment otherFragment2 = OtherFragment.getInstance("发现");
        fragmentList.add(otherFragment2);
        fragmentList.add(shopingCartFragment);
        OtherFragment otherFragment3 = OtherFragment.getInstance("我的");
        fragmentList.add(otherFragment3);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.first_rb:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.type_rb:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.see_rb:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.shoppingcar_rb:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.my_rb:
                        vp.setCurrentItem(4);
                        break;

                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
