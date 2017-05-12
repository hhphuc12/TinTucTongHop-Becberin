package com.phuc.tintuctonghop.pageradapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phuc.tintuctonghop.fragments.FragmentDanTri;

public class AdapterDanTri extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    final static String[] article = new String[]{"Trang chủ", "Sức khỏe", "Xã hội", "Giải trí", "Giáo dục-Khuyến học", "Thể thao", "Thế giới", "Kinh doanh", "Ô tô-Xe máy", "Sức mạnh số", "Tình yêu-Giới tính", "Chuyện lạ", "Việc làm", "Nhịp sống trẻ", "Tấm lòng nhân ái", "Pháp luật", "Bạn đọc", "Diễn đàn","Tuyển sinh", "Blog", "Văn hóa", "Du học", "Du lịch", "Đời sống", "Khoa học-Công nghệ"};
    final String[] link = new String[]{
            "http://dantri.com.vn/trangchu.rss",
            "http://dantri.com.vn/suc-khoe.rss",
            "http://dantri.com.vn/xa-hoi.rss",
            "http://dantri.com.vn/giai-tri.rss",
            "http://dantri.com.vn/giao-duc-khuyen-hoc.rss",
            "http://dantri.com.vn/the-thao.rss",
            "http://dantri.com.vn/the-gioi.rss",
            "http://dantri.com.vn/kinh-doanh.rss",
            "http://dantri.com.vn/o-to-xe-may.rss",
            "http://dantri.com.vn/suc-manh-so.rss",
            "http://dantri.com.vn/tinh-yeu-gioi-tinh.rss",
            "http://dantri.com.vn/chuyen-la.rss",
            "http://dantri.com.vn/viec-lam.rss",
            "http://dantri.com.vn/nhip-song-tre.rss",
            "http://dantri.com.vn/tam-long-nhan-ai.rss",
            "http://dantri.com.vn/phap-luat.rss",
            "http://dantri.com.vn/ban-doc.rss",
            "http://dantri.com.vn/dien-dan.rss",
            "http://dantri.com.vn/tuyen-sinh.rss",
            "http://dantri.com.vn/blog.rss",
            "http://dantri.com.vn/van-hoa.rss",
            "http://dantri.com.vn/du-hoc.rss",
            "http://dantri.com.vn/du-lich.rss",
            "http://dantri.com.vn/doi-song.rss",
            "http://dantri.com.vn/khoa-hoc-cong-nghe.rss"
    };

    public AdapterDanTri(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        for(int i = 0; i < link.length; i++){
            if(i == position) {
                FragmentDanTri tab = new FragmentDanTri();
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