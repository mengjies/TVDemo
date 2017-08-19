package com.pbtd.tvdemo.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pbtd.tvdemo.R;


/**
 * Created by MengJie on 2017/7/25.
 */

public class CardItemView extends RelativeLayout {
    private ImageView ivPic;
    private RelativeLayout rlInfo;
    private LinearLayout rlChapter;
    private TextView tvTitle, tvDesc, tvNumber;
    private Drawable mDrawable;
    private String mTitle;
    private String mDesc;
    private String mChapterNumber;
    private int mCardType;

    public CardItemView(Context context) {
        super(context);
        initView(context);
    }

    public CardItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardItemView);
        mCardType = typedArray.getInt(R.styleable.CardItemView_card_type, 0);
        mDrawable = typedArray.getDrawable(R.styleable.CardItemView_card_image);
        mTitle = typedArray.getString(R.styleable.CardItemView_card_title);
        mDesc = typedArray.getString(R.styleable.CardItemView_card_desc);
        mChapterNumber = typedArray.getString(R.styleable.CardItemView_card_number);

        typedArray.recycle();

        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_item_info, this, true);
        ivPic = (ImageView) findViewById(R.id.iv_pic);
        rlInfo = (RelativeLayout) findViewById(R.id.rl_info);
        rlChapter = (LinearLayout) findViewById(R.id.rl_chapter);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        tvNumber = (TextView) findViewById(R.id.tv_number);

        setImageDrawable(mDrawable);
        setTitle(mTitle);
        setDesc(mDesc);
        setChapterNumber(mChapterNumber);

    }

    public void setImageResource(int resId) {
        ivPic.setImageResource(resId);
    }

    public void setImageBitmap(Bitmap bm) {
        ivPic.setImageBitmap(bm);
    }

    public void setImageDrawable(Drawable drawable) {
        ivPic.setImageDrawable(drawable);
    }

    public void setCardInfoVisibility(int visibility) {
        switch (mCardType) {
            case 1://tv
                rlChapter.setVisibility(visibility);
                rlInfo.setVisibility(visibility);
                break;
            case 2://movie
                rlInfo.setVisibility(visibility);
                break;
            default:
                break;
        }
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setDesc(String desc) {
        tvDesc.setText(desc);
    }

    public void setChapterNumber(String number) {
        tvNumber.setText(number);
    }

}
