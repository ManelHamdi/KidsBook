package com.example.manel.KidsBook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.manel.KidsBook.Model.ConteMOD;
import com.example.manel.KidsBook.Model.ListConte;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private GifImageView gifImageView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayoutManager = new GridLayoutManager(context,3);
        gifImageView = (GifImageView) findViewById(R.id.gifprogresse);
        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.conteRecyclerView);
        layoutManager = gridLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        try {
            new ListConte(context, adapter, recyclerView, gridLayoutManager, gifImageView).execute();
        }catch (Exception e){
            Toast.makeText(context,"Verify your connectivity", Toast.LENGTH_LONG).show();
        }
    }
}
