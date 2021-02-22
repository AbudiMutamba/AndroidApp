package com.okellomwaka.yowasteadminapp;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.tabs.TabLayout;
import com.okellomwaka.yowasteadminapp.Fragments.UsersAdminFragment;
import com.okellomwaka.yowasteadminapp.Fragments.UsersCustomersFragment;
import com.okellomwaka.yowasteadminapp.Fragments.UsersHualersFragment;
import com.okellomwaka.yowasteadminapp.adapters.UsersViewPagerAdapter;


public class UsersFragment extends Fragment {
     View myFragment;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment= inflater.inflate(R.layout.fragment_users, container, false);

        viewPager=myFragment.findViewById(R.id.usersViewPager);
        tabLayout=myFragment.findViewById(R.id.usersTabLayout);

        return  myFragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager( viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
       UsersViewPagerAdapter adapter = new UsersViewPagerAdapter(getChildFragmentManager());

       adapter.addFragment(new UsersAdminFragment(),"Admins");
       adapter.addFragment(new UsersCustomersFragment(),"Customers");
       adapter.addFragment(new UsersHualersFragment(), "Hualers");

       viewPager.setAdapter(adapter);
    }
}