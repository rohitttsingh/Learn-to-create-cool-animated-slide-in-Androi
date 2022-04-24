package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.viewpager);
        List<Slideritem> slideritems= new ArrayList<>();
        slideritems.add(new Slideritem(R.drawable.image1));
        slideritems.add(new Slideritem(R.drawable.image2));
        slideritems.add(new Slideritem(R.drawable.image3));
        slideritems.add(new Slideritem(R.drawable.image4));
        slideritems.add(new Slideritem(R.drawable.image5));
        slideritems.add(new Slideritem(R.drawable.image6));
        slideritems.add(new Slideritem(R.drawable.image7));
        slideritems.add(new Slideritem(R.drawable.image1));
        slideritems.add(new Slideritem(R.drawable.image2));

        viewPager2.setAdapter(new SliderAdapter(slideritems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }
}