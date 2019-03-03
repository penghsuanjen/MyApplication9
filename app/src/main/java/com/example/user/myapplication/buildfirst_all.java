package com.example.user.myapplication;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class buildfirst_all extends AppCompatActivity {

    private ViewPager mSlideViewPaper;
    private LinearLayout mDotsLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button mNextBtn, mBackBtn;
    private int mCurrentPage;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildfirst_all);
        mSlideViewPaper = (ViewPager) this.findViewById(R.id.slideViewPaper);
        mDotsLayout = (LinearLayout) this.findViewById(R.id.dotsLayout);
        mNextBtn = (Button) this.findViewById(R.id.nextBtn);
        mBackBtn = (Button) this.findViewById(R.id.prevBtn);


        sliderAdapter = new SliderAdapter(this);
        mSlideViewPaper.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        mSlideViewPaper.addOnPageChangeListener(viewListenner);

     //   mSlideViewPaper.addOnLayoutChangeListener(layoutListenner);


        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPaper.setCurrentItem(mCurrentPage + 1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPaper.setCurrentItem(mCurrentPage - 1);
            }
        });

    }

    private void init() {

    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[sliderAdapter.slide_images.length];
        mDotsLayout.removeAllViews();


        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(this.getResources().getColor(R.color.colorTransparentWhite));

            mDotsLayout.addView(mDots[i]);
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListenner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            mCurrentPage = i;
            if (i == 0) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText( R.string.SVP_button0);
                mBackBtn.setText(R.string.SVP_button3);
            } else if (i == (mDots.length - 1)) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText(R.string.SVP_button1);
                mBackBtn.setText(R.string.SVP_button2);
            } else {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText(R.string.SVP_button0);
                mBackBtn.setText(R.string.SVP_button2);

            }

        }


        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    private class SliderAdapter extends PagerAdapter {
        Context context;
        LayoutInflater layoutInflater;



        public SliderAdapter(Context context){
            this.context = context;
        }

        //Arrays
        public int[] slide_images = {
                R.mipmap.b104,
                R.mipmap.b106,
                R.mipmap.b111,
                R.mipmap.b112,
                R.mipmap.d106,
                R.mipmap.d107,
                R.mipmap.d111
        };





        public String[] slide_headings = {

                getResources().getString(R.string.slide_headings1),
                getResources().getString(R.string.slide_headings2),
                getResources().getString(R.string.slide_headings3),
                getResources().getString(R.string.slide_headings4),
                getResources().getString(R.string.slide_headings5),
                getResources().getString(R.string.slide_headings6),
                getResources().getString(R.string.slide_headings7),

        };


        public String[] slide_descs = {
                getResources().getString(R.string.slide_descs1)+"B104"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
                getResources().getString(R.string.slide_descs1)+"B106"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
                getResources().getString(R.string.slide_descs1)+"B111"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
                getResources().getString(R.string.slide_descs1)+"B112"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
                getResources().getString(R.string.slide_descs1)+"D106"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
                getResources().getString(R.string.slide_descs1)+"D107"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
                getResources().getString(R.string.slide_descs1)+"D111"+getResources().getString(R.string.slide_descs2)+"%"+getResources().getString(R.string.slide_descs3),
        };


        @Override
        public int getCount() {
            return slide_headings.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view== (RelativeLayout)o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

            ImageView slideImageView=(ImageView) view.findViewById(R.id.slide_image);
            TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
            TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

            slideImageView.setImageResource(slide_images[position]);
            slideHeading.setText(slide_headings[position]);
            slideDescription.setText(slide_descs[position]);

            slideImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent cell = new Intent(v.getContext(),buildCell.class);
                   startActivity(cell);
                }
            });


            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout)object);
        }
    }


/*
    ViewPager.OnLayoutChangeListener layoutListenner = new ViewPager.OnLayoutChangeListener() {
        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {


            final ImageView iv = (ImageView) v.findViewById(R.id.slide_image);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Log.i("test",String.valueOf(mCurrentPage));
                   Log.i("test1",String.valueOf(iv.isFocused()));

                }
            });

        }
    };
*/
}