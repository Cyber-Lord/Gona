package com.example.gona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    ViewFlipper imgBanner;

    private RecyclerView mRecyclerView;
    private PopularAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Popular> mPopulars;
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
        showPopularProducts();
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
    public void showPopularProducts(){
        mRecyclerView=findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mPopulars = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("popular");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    Popular popular = postSnapshot.getValue(Popular.class);
                    mPopulars.add(popular);
                }
                mAdapter=new PopularAdapter(HomePage.this, mPopulars);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomePage.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
