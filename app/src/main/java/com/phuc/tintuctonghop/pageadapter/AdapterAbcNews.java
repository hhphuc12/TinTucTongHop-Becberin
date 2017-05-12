package com.phuc.tintuctonghop.pageadapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phuc.tintuctonghop.fragments.FragmentAbcNews;

/**
 * Created by Thanh An on 12/05/2017.
 */

public class AdapterAbcNews extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    final static String[] article = new String[]{"Just In", "Top Stories", "World", "Australia", "Business", "Entertainment", "Sport", "The Drum"};
    final String[] link = new String[]{
            "http://www.abc.net.au/news/feed/51120/rss.xml",
            "http://www.abc.net.au/news/feed/45910/rss.xml",
            "http://www.abc.net.au/news/feed/52278/rss.xml",
            "http://www.abc.net.au/news/feed/46182/rss.xml",
            "http://www.abc.net.au/news/feed/51892/rss.xml",
            "http://www.abc.net.au/news/feed/46800/rss.xml",
            "http://www.abc.net.au/news/feed/45924/rss.xml",
            "http://www.abc.net.au/news/feed/1054578/rss.xml",
    };

    public AdapterAbcNews(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        for(int i = 0; i < link.length; i++){
            if(i == position) {
                FragmentAbcNews tab = new FragmentAbcNews();
                tab.setLink(link[i]);
                return tab;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    public static void initTabs(TabLayout tabLayout){
        for(int i = 0; i < article.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(article[i]));
        }
    }
}