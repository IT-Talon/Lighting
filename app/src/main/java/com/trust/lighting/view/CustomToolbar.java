package com.trust.lighting.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.trust.lighting.R;
import com.trust.lighting.utils.LogUtil;

public class CustomToolbar extends RelativeLayout
{
    private static final String TAG = CustomToolbar.class.getSimpleName();

    private ImageView mBackIv;

    private int mBackIvMarginLeft;

    private ImageView mMenuIv;

    private TextView mTitle;

    private TextView mRightAction;

    private View mRootView;

    private int mBarColor;

    private String mBarTitleText;

    private boolean mIsBoldTitle;

    private float mBarTitleTextSize;

    private int mBarTitleTextColor;

    private String mRightButtonText;

    private float mRightButtonTextSize;

    private Drawable mBarLeftImg;

    private Drawable mBarRightImg;

    private OnBackClickListener mOnBackClickListener;

    private OnMenuClickListener mOnMenuClickListener;

    private OnTitleClickListener mOnTitleClickListener;

    public CustomToolbar(Context context)
    {
        super(context);
        initView(context);
    }

    public CustomToolbar(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initAttrs(context, attrs);
        initView(context);
    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initView(context);
    }

    @SuppressWarnings("deprecation")
    private void initAttrs(Context context, AttributeSet attrs)
    {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomToolbar, 0, 0);

        try
        {
            mBarColor = typedArray.getColor(R.styleable.CustomToolbar_barColor, Color.BLACK);
            mBarTitleText = typedArray.getString(R.styleable.CustomToolbar_barTitleText);
            mBarTitleTextSize = typedArray.getDimension(R.styleable.CustomToolbar_barTitleTextSize, 18f);
            mBarTitleTextColor = typedArray.getColor(R.styleable.CustomToolbar_barTitleTextColor, getResources().getColor(R.color.white));
            mRightButtonText = typedArray.getString(R.styleable.CustomToolbar_barRightButtonText);
            mRightButtonTextSize = typedArray.getDimension(R.styleable.CustomToolbar_barRightButtonTextSize, 16f);
            mBarLeftImg = typedArray.getDrawable(R.styleable.CustomToolbar_barLeftImg);
            mBarRightImg = typedArray.getDrawable(R.styleable.CustomToolbar_barRightImg);
            mBackIvMarginLeft = (int) typedArray.getDimension(R.styleable.CustomToolbar_barLeftImgMarginLeft, 0);
            mIsBoldTitle = typedArray.getBoolean(R.styleable.CustomToolbar_barTitleBold, false);
        }
        catch(Exception e)
        {
            LogUtil.e(TAG, e.getMessage(), e);
        }
        finally
        {
            typedArray.recycle();
        }
    }

    private void initView(final Context context)
    {
        mRootView = LayoutInflater.from(context).inflate(R.layout.custom_toolbar, this);
        mBackIv = mRootView.findViewById(R.id.iv_toolbar_back);
        mMenuIv = mRootView.findViewById(R.id.iv_toolbar_menu);
        mTitle = mRootView.findViewById(R.id.tv_toolbar_title);
        mRightAction = mRootView.findViewById(R.id.tv_toolbar_action);

        if(mBarTitleText != null)
        {
            mTitle.setText(mBarTitleText);
        }

        if (mIsBoldTitle)
        {
            mTitle.getPaint().setFakeBoldText(true);
        }

        mTitle.setTextColor(mBarTitleTextColor);
        mTitle.setTextSize(mBarTitleTextSize);
        mTitle.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                if(mOnTitleClickListener != null)
                {
                    mOnTitleClickListener.onClick(view);
                }
            }
        });

        if(mRightButtonText != null)
        {
            mRightAction.setText(mRightButtonText);
            mRightAction.setVisibility(View.VISIBLE);
        }

        mRightAction.setTextSize(mRightButtonTextSize);
        mRootView.setBackgroundColor(mBarColor);

        if(mBarLeftImg != null)
        {
            mBackIv.setImageDrawable(mBarLeftImg);
        }

        if (mBackIvMarginLeft > 0)
        {
            ViewGroup.MarginLayoutParams params = (MarginLayoutParams)mBackIv.getLayoutParams();
            params.leftMargin = mBackIvMarginLeft;
        }

        mBackIv.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                if(mOnBackClickListener != null)
                {
                    mOnBackClickListener.onClick(view);
                }
                else if(context instanceof Activity)
                {
                    ((Activity)context).onBackPressed();
                }
            }
        });

        if(mBarRightImg != null)
        {
            mMenuIv.setImageDrawable(mBarRightImg);
            mMenuIv.setVisibility(View.VISIBLE);
        }

        mMenuIv.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                if(mOnMenuClickListener != null)
                {
                    mOnMenuClickListener.onClick(view);
                }
            }
        });

        mRightAction.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                if(mOnMenuClickListener != null)
                {
                    mOnMenuClickListener.onClick(view);
                }
            }
        });
    }

    public void setBarColor(int barColor)
    {
        mBarColor = barColor;
        mRootView.setBackgroundColor(barColor);
    }

    public void setBarTitleText(String barTitleText)
    {
        mBarTitleText = barTitleText;
        mTitle.setText(barTitleText);
    }

    public void setBarTitleText(CharSequence barTitleText)
    {
        setBarTitleText(barTitleText.toString());
    }

    public void setBarTitleTextSize(float barTitleTextSize)
    {
        mBarTitleTextSize = barTitleTextSize;
        mTitle.setTextSize(barTitleTextSize);
    }

    public void setBarTitleTextColor(int barTitleTextColor)
    {
        mBarTitleTextColor = barTitleTextColor;
        mTitle.setTextColor(barTitleTextColor);
    }

    public void setBarLeftImg(Drawable barLeftImg)
    {
        mBarLeftImg = barLeftImg;
        mBackIv.setImageDrawable(barLeftImg);
    }

    public void setBarLeftImg(int resId)
    {
        mBackIv.setImageResource(resId);
    }

    public void setBarLeftImgMarginLeft(int marginLeft)
    {
        mBackIvMarginLeft = marginLeft;
    }

    public void setBarRightImg(Drawable barRightImg)
    {
        mBarRightImg = barRightImg;
        mMenuIv.setImageDrawable(barRightImg);
        mMenuIv.setVisibility(barRightImg != null? View.VISIBLE: View.GONE);
    }

    public void setBarRightImg(int resId)
    {
        mMenuIv.setImageResource(resId);
        mMenuIv.setVisibility(resId != 0? View.VISIBLE: View.GONE);
    }

    public void setRightButtonTextSize(float textSize)
    {
        mRightButtonTextSize = textSize;
        mRightAction.setTextSize(textSize);
    }

    public void setRightButtonText(CharSequence text)
    {
        mRightButtonText = text == null? null: text.toString();
        mRightAction.setText(text);
        mRightAction.setVisibility(text != null && text.length() > 0? View.VISIBLE: View.GONE);
    }

    public void setRightButtonEnabled(boolean enable)
    {
        mRightAction.setEnabled(enable);
        mMenuIv.setEnabled(enable);
    }

    public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener)
    {
        mOnTitleClickListener = onTitleClickListener;
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener)
    {
        mOnBackClickListener = onBackClickListener;
    }

    public void setOnMenuClickListener(OnMenuClickListener onMenuClickListener)
    {
        mOnMenuClickListener = onMenuClickListener;
    }

    public void setBarBackVisibility(int visibility)
    {
        mBackIv.setVisibility(visibility);
    }

    public void setBarMenuVisibility(int visibility)
    {
        mMenuIv.setVisibility(visibility);
    }

    public void setBarTitleVisibility(int visibility)
    {
        mTitle.setVisibility(visibility);
    }

    public void setRightButtonVisibility(int visibility)
    {
        mRightAction.setVisibility(visibility);
    }

    public TextView getmRightAction() {
        return mRightAction;
    }

    public interface OnBackClickListener
    {
        void onClick(View view);
    }

    public interface OnMenuClickListener
    {
        void onClick(View view);
    }

    public interface OnTitleClickListener
    {
        void onClick(View view);
    }
}
