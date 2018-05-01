package com.example.manel.KidsBook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manel.KidsBook.Entities.Conte;
import com.example.manel.KidsBook.MediasceneView;
import com.example.manel.KidsBook.R;

public class ConteAdapter extends RecyclerView.Adapter<ConteAdapter.ViewHolder> {
    public final Conte[] tabcnt;
    public final Context context;

    public ConteAdapter(Conte[] tabcnt, Context context) {
        this.tabcnt = tabcnt;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.conte_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtId.setText(String.valueOf(tabcnt[position].getIdConte()));
        holder.titreConte.setText(tabcnt[position].getTitre());
        //Bitmap bmp = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
        byte[] img = tabcnt[position].getImgconte();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img,0,img.length);
        holder.imgconte.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        int count=0;
        try{
            count=tabcnt.length;
        }catch (Exception e){
            Log.e("erreur in adapter",""+e);
            Toast.makeText(context, "Something went wrong, Verify your connexion", Toast.LENGTH_LONG).show();
        }
        return  count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titreConte;
        ImageView imgconte;
        TextView txtId;
        public ViewHolder(View itemView) {
            super(itemView);
            titreConte = (TextView) itemView.findViewById(R.id.titreconte);
            txtId = (TextView) itemView.findViewById(R.id.idcnt);
            imgconte = (ImageView) itemView.findViewById(R.id.imgConte);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MediasceneView.class);
            intent.putExtra("idConte",txtId.getText());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
