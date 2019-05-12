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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String url = "https://upload-images.jianshu.io/upload_images/2789400-fcc72af8394a0819.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/800/format/webp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlideApp.with(MainActivity.this)
                        .load(url).into((ImageView) findViewById(R.id.imageview_test));

                //with->requestManager
                //load->requestBuild
                //into->build request -> start request


                //url->model
                //imageView->target
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
