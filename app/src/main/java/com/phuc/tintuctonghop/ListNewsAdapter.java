package com.phuc.tintuctonghop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Created by Phuc on 4/1/2017.
=======
 * Created by Thanh An on 13/05/2017.
>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
 */

public class ListNewsAdapter extends ArrayAdapter<News> {
    Context context = null;
    ArrayList<News> newses = null;
    int layoutId;

    public ListNewsAdapter(Context context, int layoutId, ArrayList<News> newses){
        super(context, layoutId, newses);
        this.context = context;
        this.layoutId = layoutId;
        this.newses = newses;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layoutId, null);
        if(newses.size()>0 && position>=0)
        {
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            ImageView icon = (ImageView) convertView.findViewById(R.id.iv_thumnail);
            TextView tvDes = (TextView) convertView.findViewById(R.id.tv_pub_time);

            News news = newses.get(position);

            tvTitle.setText(news.getTitle());
            String iconLink = news.getIconLink() + "";
            if(iconLink != ""){
                Picasso.with(getContext()).load(news.getIconLink()).into(icon);
            }
            else {
                icon.setImageResource(R.drawable.logo_news);
            }
            tvDes.setText(news.getPubTime());
        }

        return convertView;
    }
}