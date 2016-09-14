package me.kaelaela.sample.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建者     demo
 * 创建时间   2016/8/8 18:38
 */
public class AppinfoiItemDecoration extends RecyclerView.ItemDecoration {



    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //不是第一个的格子都设一个左边和底部的间距
        int pos = parent.getChildAdapterPosition(view);
        outRect.left = 10;
        if (pos != 0) {
            if (pos % 2 == 0) {  //下面一行
                outRect.bottom = 30;
                outRect.top = 5;
            } else { //上面一行
                outRect.top = 30;
                outRect.bottom = 5;
            }


        }

    }
}
