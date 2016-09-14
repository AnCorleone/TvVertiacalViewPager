package me.kaelaela.sample.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import me.kaelaela.sample.R;
import me.kaelaela.sample.utils.AnimateFactory;
import me.kaelaela.sample.view.FocusBorderView;

/**
 * 创建者     demo
 * 创建时间   2016/8/16 14:06
 */
public class HomeFragment  extends BaseFragment{

    private static final String TAG ="HomeFragment" ;
    private View mRootView;

    @Override
    View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        return mRootView;
    }

    @Override
    protected void initData() {
        RelativeLayout main = (RelativeLayout) mRootView.findViewById(R.id.main);
        final FocusBorderView borderView  = (FocusBorderView) mRootView.findViewById(R.id.boderviw);

        for (int i = 0; i < main.getChildCount(); i++) {

            main.getChildAt(i).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        borderView.runTranslateAnimation(v,1.2f,1.2f);

                        AnimateFactory.zoomInView(v,1.1f);
                    }else {
                        AnimateFactory.zoomOutView(v);
                    }
                }
            });
        }


//         第二种方法，使用框架
       /* BorderView border = new BorderView(getActivity());
        border.setBackgroundResource(R.drawable.older_select);
        BorderEffect effect = border.getEffect();
        effect.setScale(1.2f);
        border.attachTo(main);*/
    }


    @Override
    protected void initEvent() {

    }


}
