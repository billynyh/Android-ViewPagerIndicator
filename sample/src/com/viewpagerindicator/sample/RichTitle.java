package com.viewpagerindicator.sample;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.viewpagerindicator.RichTitlePageIndicator;

public class RichTitle extends BaseSampleActivity {
	private static final String[] TITLES = {"handy Hong Kong", "Featured Application", "The support library's", "latest revision has", "a method called"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rich_title);

        mAdapter = new RichTitleAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (RichTitlePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        
    }
    
    class RichTitleAdapter extends TestFragmentAdapter implements RichTitlePageIndicator.TitleProvider {
        public RichTitleAdapter(FragmentManager fm) {
            super(fm);
        }
        
        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position % TITLES.length];
        }

		@Override
		public String getTitle(int pos) {
			return getPageTitle(pos).toString();
		}

		@Override
		public Bitmap getIcon(int pos) {
			
			Drawable d = getResources().getDrawable(R.drawable.sun);
			return ((BitmapDrawable)d).getBitmap();
		}
    }
}