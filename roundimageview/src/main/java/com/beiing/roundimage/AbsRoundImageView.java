package com.beiing.roundimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.beiing.roundimageview.R;


/**
 * Created by chenliu on 2016/8/19.<br/>
 * 描述：
 * </br>
 */
public abstract class AbsRoundImageView extends ImageView {

    private static final PorterDuffXfermode xFermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private RectF rect;

    protected Path roundPath;

    protected Path borderPath;

    protected float borderWidth;

    protected int borderColor;

    private Paint borderPaint;

    public AbsRoundImageView(Context context) {
        this(context, null, 0);
    }

    public AbsRoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbsRoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        init();
    }

    protected void initAttrs(AttributeSet attrs){
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.AbsRoundImageView);
            borderWidth = ta.getDimension(R.styleable.AbsRoundImageView_borderWidth, 0);
            borderColor = ta.getColor(R.styleable.AbsRoundImageView_borderColor, 0);
            ta.recycle();
        }
    }

    private void init() {
        rect = new RectF();
        roundPath = new Path();
        borderPath = new Path();

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setStrokeWidth(borderWidth);

        setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(changed){
            initRoundPath();
            initBorderPath();
        }
    }

    protected abstract void initRoundPath();

    protected abstract void initBorderPath();

    private void drawBorder(Canvas canvas) {
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(borderColor);
        canvas.drawPath(borderPath, borderPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable maiDrawable = getDrawable();
        if (!isInEditMode() && maiDrawable instanceof BitmapDrawable) {
            Paint paint = ((BitmapDrawable) maiDrawable).getPaint();
            Rect bitmapBounds = maiDrawable.getBounds();
            rect.set(bitmapBounds);
            int saveCount = canvas.saveLayer(rect, null,
                    Canvas.MATRIX_SAVE_FLAG |
                            Canvas.CLIP_SAVE_FLAG |
                            Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                            Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                            Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            getImageMatrix().mapRect(rect);

            //src-in : 显示重叠部分上层  ->先绘制形状，再绘制图片
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            final int color = 0xffffffff;
            paint.setColor(color);
            //1.绘制形状
            canvas.drawPath(roundPath, paint);
            Xfermode oldMode = paint.getXfermode();
            paint.setXfermode(xFermode);
            //2.绘制图片
            super.onDraw(canvas);
            paint.setXfermode(oldMode);
            canvas.restoreToCount(saveCount);

            drawBorder(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    public float dp2px(float dpValue){
        float density = getContext().getResources().getDisplayMetrics().density;
        return dpValue * density;
    }

}
























