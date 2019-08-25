package com.example.gona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HomePage extends AppCompatActivity {
    ViewFlipper imgBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        imgBanner=findViewById(R.id.imgBanner);

        int slider[] = {
                R.drawable.pineapple,
                R.drawable.mango,
                R.drawable.orange,
                R.drawable.banana
        };
        for (int slide:slider){
            bannerFlipper(slide);
        }
    }
    public void bannerFlipper(int image){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(image);
        imgBanner.setAutoStart(true);
        imgBanner.setFlipInterval(6000);
        imgBanner.addView(imageView);
        imgBanner.setInAnimation(this, R.anim.fade_in);
        imgBanner.setOutAnimation(this, R.anim.fade_out);

    }
}
