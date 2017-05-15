package com.phuc.tintuctonghop;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.regex.Pattern;

<<<<<<< HEAD
=======
/**
 * Created by ThanhAn on 14/05/2017.
 */

>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
class ReadData extends AsyncTask<String, Integer, String> {
    MyHelper helper = new MyHelper ();
    ArrayList<String> test = new ArrayList<>();

    @Override
    protected String doInBackground(String... strings) {
        return helper.readDataFromURL(strings[0]);
    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        Document document = helper.getDocument(s);
        NodeList itemList = document.getElementsByTagName("item");
        NodeList desList = document.getElementsByTagName("description");
        NodeList imgList = document.getElementsByTagName("img");

        for(int i = 0; i < itemList.getLength(); i++){
            //String cData = desList.item(i + 1).getTextContent();
            Element e = (Element) itemList.item(i);
            String imgTag = imgList.item(i).getAttributes().getNamedItem("src").getNodeValue() + "";
            Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
            //Matcher matcher = p.matcher(cData);
//                Matcher matcher = p.matcher(imgTag);
//                String iconLink = "";
//                if(matcher.find()){
//                    iconLink = matcher.group(1);
//                }
            String title = helper.getValue(e, "title");
            String link = helper.getValue(e, "link");
            String pubDateTime = helper.getValue(e, "pubDate");
            String pubTime = pubDateTime.substring(17, 22);
            String pubDate = helper.convertTime(pubDateTime.substring(5, 16));
            String numCmt = helper.getValue(e, "slash:comments");

//                newses.add(new News(title, imgTag, link, pubTime, pubDate, numCmt));
//                lvNewsAdapter = new MyLvAdapter(getApplicationContext(), R.layout.news_item, newses);
//                lvNews.setAdapter(lvNewsAdapter);
            test.add(imgTag);
        }
    }
    public ArrayList<String> getTest(){
        return test;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
