package com.weatherdesigndemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.weatherdesigndemo.AutoScroll.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;


public class AutoScrollingSlider extends AppCompatActivity {

    AutoScrollViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Context ctx;
    ArrayList<Game> imagesModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_scrolling_slider);

        ctx = AutoScrollingSlider.this;

        // set dummy images
        settingDummyData();

        viewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(ctx, imagesModelList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.startAutoScroll();
    }

    private void settingDummyData() {
        imagesModelList = new ArrayList<>();
        imagesModelList.add(new Game(R.drawable.assassins_creed, "Assassin Creed 3"));
        imagesModelList.add(new Game(R.drawable.avatar_3d, "Avatar 3D"));
        imagesModelList.add(new Game(R.drawable.call_of_duty_black_ops_3, "Call Of Duty Black Ops 3"));
        imagesModelList.add(new Game(R.drawable.dota_2, "DotA 2"));
        imagesModelList.add(new Game(R.drawable.halo_5, "Halo 5"));
        imagesModelList.add(new Game(R.drawable.left_4_dead_2, "Left 4 Dead 2"));
        imagesModelList.add(new Game(R.drawable.starcraft, "StarCraft"));
        imagesModelList.add(new Game(R.drawable.the_witcher_3, "The Witcher 3"));
        imagesModelList.add(new Game(R.drawable.tomb_raider, "Tom raider 3"));
        imagesModelList.add(new Game(R.drawable.need_for_speed_most_wanted, "Need for Speed Most Wanted"));
    }

    public class ViewPagerAdapter extends PagerAdapter {
        private Context context;
        private List<Game> imagesModelList;

        public ViewPagerAdapter(Context context, List<Game> imagesModelList) {
            this.context = context;
            this.imagesModelList = imagesModelList;
        }

        @Override
        public int getCount() {
            return imagesModelList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.inflator_image_switcher, container, false);
            ImageView mImageView = (ImageView) view.findViewById(R.id.iv_viewpager_item);
//            mImageView.setScaleType(NetworkImageView.ScaleType.CENTER_CROP);
//            mImageView.setImageUrl(imagesModelList.get(i).getImagePath(), MyApplication.getImageLoaderInstance());
            mImageView.setImageResource(imagesModelList.get(i).getImagesource());
            container.addView(view);
            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag) {
                        flag = false;
                        Common.SlideUP(recycleViewImagesDetail, context);
                        recycleViewImagesDetail.setVisibility(View.GONE);
                    } else {
                        flag = true;
                        Common.SlideDown(recycleViewImagesDetail, context);
                        recycleViewImagesDetail.setVisibility(View.VISIBLE);
                    }
                }
            });*/
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int i, Object obj) {
            container.removeView((LinearLayout) obj);
        }
    }
}
