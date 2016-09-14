package me.kaelaela.sample.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


/**
 * 创建者     demo
 * 创建时间   2016/7/4 15:23
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class TvRelativeLayout extends RelativeLayout {

    private Paint mPaint;

    public TvRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public TvRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

        //边框颜色
        int numberColor = Color.WHITE;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);  //抗锯齿
        mPaint.setColor(numberColor);

    }


    private void init() {

        setFocusable(true);
        setClickable(true);
        setWillNotDraw(true);
        //this.setOnFocusChangeListener(this);
    }


  /*  @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
            AnimateFactory.zoomInView(v);


        } else {
            AnimateFactory.zoomOutView(v);
        }
    }
*/

}
