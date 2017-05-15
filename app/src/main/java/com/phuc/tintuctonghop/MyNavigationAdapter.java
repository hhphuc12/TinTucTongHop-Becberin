package com.phuc.tintuctonghop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Created by Phuc on 5/4/2017.
=======
 * Created by Thanh An on 13/05/2017.
>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
 */

public class MyNavigationAdapter extends ArrayAdapter<NavigationItem> {

    Context context = null;
    ArrayList<NavigationItem> arr = null;
    int layoutId;

    public MyNavigationAdapter(Context context, int layoutId, ArrayList<NavigationItem> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.arr = arr;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layoutId, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.icon_navigation);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_article_navigation);
        img.setImageResource(arr.get(position).getIconId());
        tv.setText(arr.get(position).getArticle());

        return convertView;
    }
}
