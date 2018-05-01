package com.example.manel.KidsBook.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manel.KidsBook.Entities.Mediascene;
import com.example.manel.KidsBook.Model.ListMediascene;
import com.example.manel.KidsBook.R;

public class MediasceneAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private int idCnt;

    public MediasceneAdapter(Context context, int idCnt) {
        this.context = context;
        this.idCnt = idCnt;
    }

    private  Mediascene[] listMs ;

    public  Mediascene[] getlistMs(){
        listMs =  new ListMediascene(idCnt,context).doInBackground();
        return listMs;
   }

    @Override
    public int getCount() {
        int count=0;
        //Log.e("tablengthidla",""+idCnt);
        try{
            count=getlistMs().length;
        }catch (Exception e){
            Log.e("erreur in adapter",""+e);
            Toast.makeText(context, "Something went wrong, Verify your connexion", Toast.LENGTH_LONG).show();
            Toast.makeText(context, ""+e, Toast.LENGTH_LONG).show();
        }
        return  count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.mediascene_list, container, false);
        TextView txtid = (TextView) view.findViewById(R.id.idMs);
        TextView textMs = (TextView) view.findViewById(R.id.textMs);
        ImageView imgMs = (ImageView) view.findViewById(R.id.imgMs);

        txtid.setText(String.valueOf(getlistMs()[position].getIdMediascene()));
        //txtid.setText(""+1);
        textMs.setText(getlistMs()[position].getTexte());
        byte[] img = getlistMs()[position].getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        imgMs.setImageBitmap(bitmap);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
        //super.destroyItem(container, position, object);
    }
}
