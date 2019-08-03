package com.yuntang.juney.demoone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

/**
 * Created by admini
 * on 2019/8/3
 */
public class CustomDrawableView extends View {

    private ShapeDrawable drawable;

    public CustomDrawableView(Context context) {
        super(context);

        int x = 10;
        int y = 10;
        int width = 300;
        int height = 300;

        drawable = new ShapeDrawable(new OvalShape());

        drawable.getPaint().setColor(0x00ffff);

        drawable.setBounds(x, y, x + width, y + height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
