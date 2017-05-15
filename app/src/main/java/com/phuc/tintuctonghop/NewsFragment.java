package com.phuc.tintuctonghop;

<<<<<<< HEAD

=======
>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phuc.tintuctonghop.pageradapter.Adapter24h;
import com.phuc.tintuctonghop.pageradapter.AdapterAbcNews;
import com.phuc.tintuctonghop.pageradapter.AdapterDanTri;
import com.phuc.tintuctonghop.pageradapter.AdapterNdt;
import com.phuc.tintuctonghop.pageradapter.AdapterThanhNien;
import com.phuc.tintuctonghop.pageradapter.AdapterVnExpress;

<<<<<<< HEAD
=======
/**
 * Created by ThanhAn on 13/05/2017.
 */

>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
public class NewsFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    int id;
    FragmentActivity context;

    public NewsFragment() {
        // Required empty public constructor
    }

    public void setId(int position){
        this.id = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        context = getActivity();
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        setViewpagerAdapter(id);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void setViewpagerAdapter(int id) {
        switch (id){
            case 0: {
                AdapterVnExpress.initTabs(tabLayout);
                AdapterVnExpress adapter = new AdapterVnExpress(context.getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                break;
            }
            case 1: {
                Adapter24h.initTabs(tabLayout);
                Adapter24h adapter = new Adapter24h(context.getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                break;
            }
            case 2:{
                AdapterDanTri.initTabs(tabLayout);
                AdapterDanTri adapter = new AdapterDanTri(context.getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                break;
            }
            case 3:{
                AdapterThanhNien.initTabs(tabLayout);
                AdapterThanhNien adapter = new AdapterThanhNien(context.getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                break;
            }
            case 4:{
                AdapterNdt.initTabs(tabLayout);
                AdapterNdt adapter = new AdapterNdt(context.getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                break;
            }
            case 5:{
                AdapterAbcNews.initTabs(tabLayout);
                AdapterAbcNews adapter = new AdapterAbcNews(context.getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
            }
        }
    }
}
<<<<<<< HEAD
=======

>>>>>>> 77bd9a66a06ab5b9155674a50fda0d0b303f8a3f
