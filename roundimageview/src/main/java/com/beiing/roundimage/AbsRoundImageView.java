package com.beiing.roundimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
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
import android.graphics.drawable.ColorDrawable;
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

    private static final PorterDuffXfermode xFermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private RectF rect;

    private Paint mBitmapPaint;

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
        mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmapPaint.setStyle(Paint.Style.FILL);
        mBitmapPaint.setColor(borderColor);

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
        Drawable mDrawable = getDrawable();
        if(!isInEditMode() && mDrawable != null){
//            Bitmap bitmap = getBitmapFromDrawable(mDrawable);
            //拿到Drawable
            Drawable drawable = getDrawable();
            //获取drawable的宽和高
            int dWidth = drawable.getIntrinsicWidth();
            int dHeight = drawable.getIntrinsicHeight();
            Bitmap bitmap;
            if (drawable != null) {
                //创建bitmap
                bitmap = Bitmap.createBitmap(getWidth(), getHeight(),
                        Bitmap.Config.ARGB_8888);
                float scale = 1.0f;
                //创建画布
                Canvas drawCanvas = new Canvas(bitmap);
                drawable.draw(drawCanvas);


                Bitmap roundBm = getRoundBitmap();
                mBitmapPaint.reset();
                mBitmapPaint.setFilterBitmap(false);
                mBitmapPaint.setXfermode(xFermode);
                //绘制形状
                drawCanvas.drawBitmap(roundBm, 0, 0, mBitmapPaint);
                mBitmapPaint.setXfermode(null);
                //将准备好的bitmap绘制出来
                canvas.drawBitmap(bitmap, 0, 0, mBitmapPaint);
            }



//            //1.绘制形状
//            canvas.drawARGB(0, 0, 0, 0);
//            final int color = 0xffffffff;
//            mBitmapPaint.setColor(color);
//            canvas.drawPath(roundPath, mBitmapPaint);
//
//            mBitmapPaint.reset();
//            mBitmapPaint.setFilterBitmap(false);
//            mBitmapPaint.setXfermode(xFermode);
//
//            //2.绘制图片
////            canvas.drawBitmap(bitmap, 0, 0,  mBitmapPaint);
//
//            mBitmapPaint.setXfermode(null);


            drawBorder(canvas);
        }





//        if (!isInEditMode() && mDrawable instanceof BitmapDrawable) {
//            Paint paint = ((BitmapDrawable) mDrawable).getPaint();
//            Rect bitmapBounds = mDrawable.getBounds();
//            rect.set(bitmapBounds);
//            int saveCount = canvas.saveLayer(rect, null,
//                    Canvas.MATRIX_SAVE_FLAG |
//                            Canvas.CLIP_SAVE_FLAG |
//                            Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
//                            Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
//                            Canvas.CLIP_TO_LAYER_SAVE_FLAG);
//            getImageMatrix().mapRect(rect);
//
//            //src-in : 显示重叠部分上层  ->先绘制形状，再绘制图片
//            paint.setAntiAlias(true);
//            canvas.drawARGB(0, 0, 0, 0);
//            final int color = 0xffffffff;
//            paint.setColor(color);
//            //1.绘制形状
//            canvas.drawPath(roundPath, paint);
//            Xfermode oldMode = paint.getXfermode();
//            paint.setXfermode(xFermode);
//            //2.绘制图片
//            super.onDraw(canvas);
//            paint.setXfermode(oldMode);
//            canvas.restoreToCount(saveCount);
//
//            //绘制边框
//            drawBorder(canvas);
//        }


    }


    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        try {
            Bitmap bitmap;
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 绘制形状
     * @return
     */
    public Bitmap getRoundBitmap()
    {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);

        canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2,
                    paint);

        return bitmap;
    }

    public float dp2px(float dpValue){
        float density = getContext().getResources().getDisplayMetrics().density;
        return dpValue * density;
    }

}
























