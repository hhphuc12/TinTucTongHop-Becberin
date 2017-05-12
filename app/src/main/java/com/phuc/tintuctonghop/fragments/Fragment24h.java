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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Fragment24h extends Fragment {

    ArrayList<News> newses = new ArrayList<>();
    ListNewsAdapter adapter;

    ListView newsLV;
    String link;

    public Fragment24h() {
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
            NodeList itemList = document.getElementsByTagName("item");
            NodeList imgList = document.getElementsByTagName("img");

            for(int i = 0; i < itemList.getLength(); i++){
                Element e = (Element) itemList.item(i);
                Node tmp = imgList.item(i);
                String iconLink = "";
                if(tmp != null){
                    iconLink += tmp.getAttributes().getNamedItem("src").getNodeValue();
                }
                String title = helper.getValue(e, "title").replace("&#34;", "\"");
                String link = helper.getValue(e, "link");
                String pubDateTime = helper.getValue(e, "pubDate");
                String pubTime = pubDateTime.substring(17, 22);
                String pubDate = helper.convertTime(pubDateTime.substring(5, 16));

                newses.add(new News(title, iconLink, link, pubTime, pubDate));
                adapter = new ListNewsAdapter(getActivity(), R.layout.news_item, newses);
                newsLV.setAdapter(adapter);
            }
        }
    }
}