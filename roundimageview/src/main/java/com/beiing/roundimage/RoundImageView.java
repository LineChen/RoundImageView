//package com.beiing.roundimage;
//
//import android.content.Context;
//import android.graphics.Path;
//import android.graphics.RectF;
//import android.util.AttributeSet;
//
///**
// * Created by chenliu on 2016/8/19.<br/>
// * 描述：
// * </br>
// */
//public class RoundImageView extends AbsRoundImageView {
//
//    private float leftTopRadius;
//
//    private float rightTopRadius;
//
//    private float leftBottomRadius;
//
//    private float rightBottomRadius;
//
//
//    public RoundImageView(Context context) {
//        this(context, null, 0);
//    }
//
//    public RoundImageView(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//
//        initAttrs();
//    }
//
//    private void initAttrs() {
//
//    }
//
//    @Override
//    protected void initRoundPath() {
//        roundPath.reset();
//
//        final int width = getWidth();
//        final int height = getHeight();
//        leftTopRadius = Math.min(leftTopRadius, Math.min(width, height) * 0.5f);
//        rightTopRadius = Math.min(rightTopRadius, Math.min(width, height) * 0.5f);
//
//        RectF rect = new RectF(0, 0, width, height);
//        roundPath.addRoundRect(rect, leftTopRadius, rightTopRadius, Path.Direction.CW);
//    }
//
//    @Override
//    protected void initBorderPath() {
//        borderPath.reset();
//
//        final float halfBorderWidth = borderWidth * 0.5f;
//
//        final int width = getWidth();
//        final int height = getHeight();
//        leftTopRadius = Math.min(leftTopRadius, Math.min(width, height) * 0.5f);
//        rightTopRadius = Math.min(rightTopRadius, Math.min(width, height) * 0.5f);
//
//        RectF rect = new RectF(halfBorderWidth, halfBorderWidth,
//                width - halfBorderWidth, height - halfBorderWidth);
//        borderPath.addRoundRect(rect , leftTopRadius, rightTopRadius, Path.Direction.CW);
//    }
//}
