package me.kaelaela.sample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import me.kaelaela.sample.R;
import me.kaelaela.sample.utils.AnimateFactory;


/**
 * 创建者     demo
 * 创建时间   2016/6/28 18:05
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class TvImageView extends ImageView implements View.OnFocusChangeListener {

    private Rect mRect;
    private Boolean mScaleable;
    private int mKeyNumber;
    private Drawable mBorderDrawable;
    private Paint mPaint;
    private Rect mBound;
    private int borderSize = 20;



    public TvImageView(Context context) {
        super(context);
        init();
    }


    public TvImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

     //   TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TvImgeView);
        //伸缩
//        mScaleable = a.getBoolean(R.styleable.TvImgeView_scaleable, true);
        mScaleable =true;

    //    mKeyNumber = a.getInteger(R.styleable.TvImgeView_ivnumber, -1);
        mKeyNumber =-1;

    //    int berderResId = a.getResourceId(R.styleable.TvImgeView_borderDrawable, R.drawable.border_highlight);
        mBorderDrawable = getResources().getDrawable(R.drawable.select_border);

        //边框颜色
     // int numberColor = a.getColor(R.styleable.TvImgeView_ivnumbercolor, Color.WHITE);
        int numberColor =Color.WHITE;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);  //抗锯齿
        mPaint.setTextSize(25);
        mPaint.setColor(numberColor);


    }


    private void init() {
        setFocusable(true);
        setClickable(true);
        setWillNotDraw(false);
        mRect = new Rect();
        mBound = new Rect();
        this.setOnFocusChangeListener(this);

    }

    /**
     * 切换动画
     *
     * @param v
     * @param hasFocus
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!mScaleable) {   //不可伸缩
            return;
        }

        if (hasFocus) {
            AnimateFactory.zoomInView(v);
        } else {
            AnimateFactory.zoomOutView(v);
        }
    }


    @Override
    public void draw(Canvas canvas) {

        if (hasFocus()) {

            super.getDrawingRect(mRect);
            mBound.set(-borderSize + mRect.left, -borderSize + mRect.top, borderSize + mRect.right, borderSize + mRect.bottom);
            mBorderDrawable.setBounds(mBound);
            canvas.save();
            if (mBorderDrawable != null) {
                mBorderDrawable.draw(canvas);

            }
            canvas.restore();

        }

        super.draw(canvas);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        if (mKeyNumber >= 0) {
            super.getDrawingRect(mRect);
            drawBottomNumberText(canvas, "" + mKeyNumber, mPaint);
        }

        super.onDraw(canvas);
    }

    protected void drawBottomNumberText(Canvas canvas, String text, Paint textPaint) {

        float strWidth = textPaint.measureText(text);
        int xPos = (canvas.getWidth() / 2) - (int) strWidth / 2;
        int yPos = (int) ((canvas.getHeight()) + ((textPaint.descent() + textPaint.ascent()) / 2) / 2);
        canvas.drawText(text, xPos, yPos, textPaint);

    }

    protected void drawCenterNumberText(Canvas canvas, String text, Paint textPaint) {
        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2));
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.
        canvas.drawText(text, xPos, yPos, textPaint);
    }


}
