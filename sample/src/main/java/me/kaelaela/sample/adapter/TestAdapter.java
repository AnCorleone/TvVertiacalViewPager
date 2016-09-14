package me.kaelaela.sample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 创建者     demo
 * 创建时间   2016/8/16 12:04
 */
public class TestAdapter  extends FragmentStatePagerAdapter {

    ArrayList<Fragment> list;
    public TestAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.list= fragmentList;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }
}
