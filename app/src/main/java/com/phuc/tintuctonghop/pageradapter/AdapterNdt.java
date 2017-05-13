package com.phuc.tintuctonghop.pageradapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phuc.tintuctonghop.fragments.FragmentNdt;

public class AdapterNdt extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    final static String[] article = new String[]{"Trang chủ", "Video", "Thời sự", "Đa chiều", "Thế giới", "Kinh doanh", "Pháp luật", "Đời sống", "Giải trí", "Công nghệ", "Thể thao"};
    final String[] link = new String[]{
            "http://www.nguoiduatin.vn/trang-chu.rss",
            "http://www.nguoiduatin.vn/rss/video.rss",
            "http://www.nguoiduatin.vn/rss/thoi-su.rss",
            "http://www.nguoiduatin.vn/rss/da-chieu.rss",
            "http://www.nguoiduatin.vn/rss/the-gioi.rss",
            "http://www.nguoiduatin.vn/rss/kinh-doanh.rss",
            "http://www.nguoiduatin.vn/rss/phap-luat.rss",
            "http://www.nguoiduatin.vn/rss/doi-song.rss",
            "http://www.nguoiduatin.vn/rss/giai-tri.rss",
            "http://www.nguoiduatin.vn/rss/cong-nghe.rss",
            "http://www.nguoiduatin.vn/rss/the-thao.rss"
    };

    public AdapterNdt(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        for(int i = 0; i < link.length; i++){
            if(i == position) {
                FragmentNdt tab = new FragmentNdt();
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