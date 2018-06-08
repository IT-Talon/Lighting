package com.trust.lighting.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;

import com.trust.lighting.R;


public class TouchableImageButton extends android.support.v7.widget.AppCompatImageButton
{
    private boolean touching;

    private boolean ignoreClickable;

    private int overlayColor;

    public TouchableImageButton(Context context)
    {
        super(context);
        init(null);
    }

    public TouchableImageButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs)
    {
        if(attrs != null)
        {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.TouchableImageButton);

            try
            {
                this.overlayColor = ta.getColor(R.styleable.TouchableImageButton_overlay_color, Color.LTGRAY);
            }
            catch(Throwable t)
            {}
            finally
            {
                ta.recycle();
            }
        }
    }

    protected void onPressChanged()
    {
        if(touching)
        {
            this.setColorFilter(overlayColor, PorterDuff.Mode.MULTIPLY);
        }
        else
        {
            this.setColorFilter(null);
        }
    }

    @Override
    public void setPressed(boolean pressed)
    {
        super.setPressed(pressed);

        if((ignoreClickable || this.isClickable()) && this.touching != pressed)
        {
            this.touching = pressed;
            this.onPressChanged();
        }
    }

    @Override
    public void setClickable(boolean clickable)
    {
        super.setClickable(clickable);
        this.setColorFilter(null);
    }

    public boolean isIgnoreClickable()
    {
        return this.ignoreClickable;
    }

    public void setIgnoreClickable(boolean ignoreClickable)
    {
        this.ignoreClickable = ignoreClickable;
    }

    public int getOverlayColor()
    {
        return overlayColor;
    }

    public void setOverlayColor(int overlayColor)
    {
        this.overlayColor = overlayColor;
    }
}