package com.phuc.tintuctonghop.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.phuc.tintuctonghop.ListNewsAdapter;
import com.phuc.tintuctonghop.MyHelper;
import com.phuc.tintuctonghop.News;
import com.phuc.tintuctonghop.R;
import com.phuc.tintuctonghop.ReadNewsActivity;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentDanTri extends Fragment {

    ArrayList<News> newses = new ArrayList<>();
    ListNewsAdapter adapter;

    ListView newsLV;
    String link;

    public FragmentDanTri() {
        // Required empty public constructor
    }

    public void setLink(String link){
        this.link = link;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        newsLV = (ListView) view.findViewById(R.id.lv_news);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadData().execute(link);
            }
        });

        newsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ReadNewsActivity.class);
                intent.putExtra("link", newses.get(i).getLink());
                startActivity(intent);
            }
        });
        return view;
    }

    class ReadData extends AsyncTask<String, Integer, String> {
        MyHelper helper = new MyHelper ();

        @Override
        protected String doInBackground(String... strings) {
            return helper.readDataFromURL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            Document document = helper.getDocument(s);
            NodeList titleList = document.getElementsByTagName("title");
            NodeList desList = document.getElementsByTagName("description");
            NodeList linkList = document.getElementsByTagName("link");
            NodeList pubDateList = document.getElementsByTagName("pubDate");

            for(int i = 0; i < titleList.getLength() - 1; i++){
                String cDataDes = "";
                if(desList.item(i + 1) != null){
                    cDataDes += desList.item(i + 1).getTextContent();
                }
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*?");
                Matcher matcher = p.matcher(cDataDes);
                String iconLink = "";
                if(matcher.find()){
                    iconLink = matcher.group(1);
                }
                String title = titleList.item(i + 1).getTextContent();
                String link = linkList.item(i + 1).getTextContent();
                String pubDateTime = pubDateList.item(i + 1).getTextContent() + "";
                String pubTime = "";
                String pubDate = "";
                if(!(pubDateTime.equals(""))){
                    pubTime += pubDateTime.substring(17, 22);
                    pubDate += helper.convertTime(pubDateTime.substring(5, 16));
                }

                newses.add(new News(title, iconLink, link, pubTime, pubDate));
                adapter = new ListNewsAdapter(getActivity(), R.layout.news_item, newses);
                newsLV.setAdapter(adapter);
            }
        }
    }
}