package me.kaelaela.sample.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.kaelaela.sample.R;

/**
 * 创建者     demo
 * 创建时间   2016/8/16 14:06
 */
public class MyFragment extends BaseFragment{


    private TextView mText;

    @Override
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        mText = (TextView) rootView.findViewById(R.id.text);
        mText.setText("MyFragment");
        return rootView;
    }

    @Override
    protected void initEvent() {



    }

    @Override
    protected void initData() {

    }
}
