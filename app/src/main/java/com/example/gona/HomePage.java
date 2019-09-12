
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
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String [] f_name, price, number;
    int [] Img_res  = {
            R.drawable.orange, R.drawable.pineapple, R.drawable.banana, R.drawable.mango, R.drawable.tomato, R.drawable.pepper
    };
    ArrayList<DataProvider> arrayList = new ArrayList<>();

    ViewFlipper imgBanner;

    /*private RecyclerView mRecyclerView;
    private PopularAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Popular> mPopulars;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        recyclerView = findViewById(R.id.recycler_view);

        f_name = getResources().getStringArray(R.array.fruits);
        price = getResources().getStringArray(R.array.prices);
        //number = getResources().getStringArray(R.array.numbers);


        int i = 0;
        for(String name : f_name){
            DataProvider dataProvider = new DataProvider(Img_res[i], name, price[i]);
            arrayList.add(dataProvider);
            i++;
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        imgBanner=findViewById(R.id.imgBanner);

        int slider[] = {
                R.drawable.tomato,
                R.drawable.mango,
                R.drawable.pepper,
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

