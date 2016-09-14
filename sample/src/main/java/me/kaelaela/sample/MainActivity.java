package me.kaelaela.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;

import me.kaelaela.sample.adapter.TestAdapter;
import me.kaelaela.sample.ui.CategoryFragment;
import me.kaelaela.sample.ui.HomeFragment;
import me.kaelaela.sample.ui.MyFragment;
import me.kaelaela.verticalviewpager.VerticalViewPager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RadioGroup mRadioGroup;
    private VerticalViewPager mViewPager;
    private int selectPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        initView();
        initViewPager();
        initEvent();
    }



    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_main_leftmenu);

    }

    private void initViewPager() {

        mViewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();


        ArrayList<Fragment> fragmentList = new ArrayList<>();
        TestAdapter adapter = new TestAdapter(fm,fragmentList);

        HomeFragment home =new HomeFragment();
        CategoryFragment cate =new CategoryFragment();
        MyFragment my =new MyFragment();

        fragmentList.add(home);
        fragmentList.add(cate);
        fragmentList.add(my);

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(0);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectPos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

    private void initEvent() {
        onLeftMenuFocusChange();

    }


    /**
     * 左侧菜单选择切换
     */
    private void onLeftMenuFocusChange() {

        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {

            mRadioGroup.getChildAt(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {

                    switch (v.getId()) {

                        case R.id.rb_theme1_main_home:

                            Log.d(TAG,"  SELECT POS " +selectPos);

                            if(selectPos!=0){

                                mViewPager.setCurrentItem(0);
                            }

                            break;
                        case R.id.rb_theme1_main_category:

                            mViewPager.setCurrentItem(1);
                            break;
                        case R.id.rb_theme1_main_my:

                            mViewPager.setCurrentItem(2);
                            break;
                    }
                }
            });
        }


    }
}
