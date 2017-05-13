package com.phuc.tintuctonghop.pageradapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phuc.tintuctonghop.fragments.Fragment24h;

public class Adapter24h extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    final static String[] article = new String[]{"Trang chủ", "Bóng đá", "An ninh - Hình sự", "Thời trang", "Tài chính – Bất động sản", "Ẩm thực", "Làm đẹp", "Phim", "Ca nhạc - MTV", "Thế giới"};
    final String[] link = new String[]{"http://www.24h.com.vn/upload/rss/trangchu24h.rss",
            "http://www.24h.com.vn/upload/rss/bongda.rss",
            "http://www.24h.com.vn/upload/rss/anninhhinhsu.rss",
            "http://www.24h.com.vn/upload/rss/thoitrang.rss",
            "http://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss",
            "http://www.24h.com.vn/upload/rss/amthuc.rss",
            "http://www.24h.com.vn/upload/rss/lamdep.rss",
            "http://www.24h.com.vn/upload/rss/phim.rss",
            "http://www.24h.com.vn/upload/rss/canhacmtv.rss",
            "http://www.24h.com.vn/upload/rss/tintucquocte.rss"
    };

    public Adapter24h(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        for(int i = 0; i < link.length; i++){
            if(i == position) {
                Fragment24h tab = new Fragment24h();
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