package com.phuc.tintuctonghop;

/**
 * Created by Phuc on 5/4/2017.
 */

public class NavigationItem {

    String article;
    int iconId;
    public NavigationItem(String article, int iconId) {
        this.article = article;
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }

    public String getArticle() {
        return article;
    }

}
