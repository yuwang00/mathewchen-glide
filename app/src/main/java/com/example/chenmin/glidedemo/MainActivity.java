package com.example.chenmin.glidedemo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String url = "https://pic3.zhimg.com/80/v2-25e761ec8e11b31f049e4a24401a3702_hd.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.recyclerview);
//        ArrayList<String> datas = new ArrayList<>();
//        for (int i=0;i<50;i++){
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1550216290172-360-611.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1549022307533-384-681.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1549022244899-500-892.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1549021930467-384-682.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1549022732459-439-765.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1549012946870-513-289.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1548839281344-624-351.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1548760972236-986-559.png");
//            datas.add("http://cms.gtimg.com/android_cms/dyfile/1548656758480-764-449.png");
//        }
//        MyAdapter myAdapter = new MyAdapter();
//        myAdapter.setData(datas);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlideApp.with(MainActivity.this)
                        .load(url).thumbnail().into((ImageView) findViewById(R.id.imageview_test));
            }
        });



    }

    public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        public ArrayList<String> mData = new ArrayList<>();
        public void setData(ArrayList<String> datas){
            mData.addAll(datas);
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_re,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((MyHolder)holder).setUrl(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
        }

        public void setUrl(String url){
                            GlideApp.with(MainActivity.this)
                        .load(url)
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                Log.d("mathewchen","drawable:"+((BitmapDrawable)resource).getBitmap());
                                imageView.setImageDrawable(resource);
                            }
                        });
        }
    }
}
