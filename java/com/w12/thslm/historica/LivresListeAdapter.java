package com.w12.thslm.historica;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class LivresListeAdapter extends ArrayAdapter<Livres>{
    private Context mContext;
    private int mResource;
    private int lastPosition=-1;

    static class ViewHolder{
        TextView Titre;
        TextView Description;             /**  Pages **/
        TextView Auteur;
        ImageView Image;

    }

    public LivresListeAdapter(Context context, int resource, ArrayList<Livres> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {


        String titre=getItem(position).getTitre();
        String auteur=getItem(position).getAuteur();
        String desc=getItem(position).getDescription();
        String link=getItem(position).getImgURL();
        final View result;
        ViewHolder vh;


            if(convertView==null){

                LayoutInflater inflater= LayoutInflater.from(mContext);
                convertView=inflater.inflate(mResource,parent,false);
                 vh=new ViewHolder();
                vh.Auteur=(TextView) convertView.findViewById(R.id.idauteur);
                vh.Titre=(TextView) convertView.findViewById(R.id.idtitle);
                vh.Description=(TextView) convertView.findViewById(R.id.iddesc);
                vh.Image=(ImageView)convertView.findViewById(R.id.idimage);
                result=convertView;
                convertView.setTag(vh);
            }else{
                vh=(ViewHolder)convertView.getTag();
                result=convertView;
            }





        Animation anim=AnimationUtils.loadAnimation(mContext,R.anim.slid_left);
        result.setAnimation(anim);

                /**
                 *
                 * the old animation
                 *
                 */
        /*  Animation anim= AnimationUtils.loadAnimation(mContext,
              (position>lastPosition)?R.anim.load_down :R.anim.load_up);
        result.startAnimation(anim);
        lastPosition=position;
                */
        vh.Auteur.setText(auteur);
        vh.Titre.setText(titre);
        vh.Description.setText(desc);

        int resId=mContext.getResources().getIdentifier(link,null,mContext.getPackageName());


        vh.Image.setImageResource(resId);




        return convertView;


    }




}