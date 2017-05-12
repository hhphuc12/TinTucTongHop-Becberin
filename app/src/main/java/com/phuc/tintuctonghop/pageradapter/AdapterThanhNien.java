package com.phuc.tintuctonghop.pageradapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phuc.tintuctonghop.fragments.FragmentThanhNien;

public class AdapterThanhNien extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    final static String[] article = new String[]{"Trang chủ", "Thời sự", "Tôi viết", "Thế giới", "Văn hóa", "Thể thao", "Đời sống", "Kinh doanh", "Giới trẻ", "Giáo dục", "Công nghệ", "Game", "Sức khỏe", "Xe", "Video"};
    final String[] link = new String[]{
            "http://thanhnien.vn/rss/home.rss",
            "http://thanhnien.vn/rss/chinh-tri-xa-hoi.rss",
            "http://thanhnien.vn/rss/toi-viet.rss",
            "http://thanhnien.vn/rss/the-gioi.rss",
            "http://thanhnien.vn/rss/van-hoa-nghe-thuat.rss",
            "http://thethao.thanhnien.vn/rss/home.rss",
            "http://thanhnien.vn/rss/doi-song.rss",
            "http://thanhnien.vn/rss/kinh-te.rss",
            "http://thanhnien.vn/rss/the-gioi-tre.rss",
            "http://thanhnien.vn/rss/giao-duc.rss",
            "http://thanhnien.vn/rss/cong-nghe-thong-tin.rss",
            "http://game.thanhnien.vn/rss/home.rss",
            "http://thanhnien.vn/rss/doi-song/suc-khoe.rss",
            "http://xe.thanhnien.vn/rss/home.rss",
            "http://video.thanhnien.vn/rss/home.rss",
    };

    public AdapterThanhNien(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        for(int i = 0; i < link.length; i++){
            if(i == position) {
                FragmentThanhNien tab = new FragmentThanhNien();
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