package com.phuc.tintuctonghop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class News {
    String title;
    String iconLink;
    String link;
    String pubTime;
    String pubDate;

    public News(String title, String iconLink, String link, String pubTime, String pubDate) {
        this.title = title;
        this.iconLink = iconLink;
        this.link = link;
        this.pubTime = pubTime;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getIconLink() {
        return iconLink;
    }

    public String getLink() {
        return link;
    }

    public String getPubTime(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String now = timeFormat.format(new Date(System.currentTimeMillis()));
        String dateNow = now.substring(0, 10);
        String timeNow = now.substring(11, 16);

        if(dateNow.equals(pubDate)) {
            return (Integer.parseInt(timeNow.substring(0, 2)) - Integer.parseInt(pubTime.substring(0, 2))) + "h trước";
        }
        else {
            return pubDate;
        }
    }
}
