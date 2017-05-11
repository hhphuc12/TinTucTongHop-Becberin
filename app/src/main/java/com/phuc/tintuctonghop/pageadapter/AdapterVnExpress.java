package com.phuc.tintuctonghop.pageadapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.phuc.tintuctonghop.fragments.FragmentVnExpress;

/**
 * Created by Thanh An on 11/05/2017.
 */

public class AdapterVnExpress extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    final static String[] article = new String[]{"Trang chủ", "Thời sự", "Thế giới", "Kinh doanh", "Startup", "Giải trí", "Thể Thao", "Pháp luật", "Giáo dục", "Sức khỏe", "Gia đình", "Du lịch", "Khoa học", "Số hóa", "Xe", "Cộng đồng", "Tâm sự", "Cười"};
    final String[] link = new String[]{
            "http://vnexpress.net/rss/tin-moi-nhat.rss",
            "http://vnexpress.net/rss/thoi-su.rss",
            "http://vnexpress.net/rss/the-gioi.rss",
            "http://vnexpress.net/rss/kinh-doanh.rss",
            "http://vnexpress.net/rss/startup.rss",
            "http://vnexpress.net/rss/giai-tri.rss",
            "http://vnexpress.net/rss/the-thao.rss",
            "http://vnexpress.net/rss/phap-luat.rss",
            "http://vnexpress.net/rss/giao-duc.rss",
            "http://vnexpress.net/rss/suc-khoe.rss",
            "http://vnexpress.net/rss/gia-dinh.rss",
            "http://vnexpress.net/rss/du-lich.rss",
            "http://vnexpress.net/rss/khoa-hoc.rss",
            "http://vnexpress.net/rss/so-hoa.rss",
            "http://vnexpress.net/rss/oto-xe-may.rss",
            "http://vnexpress.net/rss/cong-dong.rss",
            "http://vnexpress.net/rss/tam-su.rss",
            "http://vnexpress.net/rss/cuoi.rss"
    };

    public AdapterVnExpress(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        for(int i = 0; i < link.length; i++){
            if(i == position) {
                FragmentVnExpress tab = new FragmentVnExpress();
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