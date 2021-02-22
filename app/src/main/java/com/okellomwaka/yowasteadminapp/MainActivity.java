package com.okellomwaka.yowasteadminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.main_navView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //Load Defualt fragment /activity
      if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashboardFragment()).commit();
              navigationView.setCheckedItem(R.id.dashboard);
        }


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
        super.onBackPressed();}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DashboardFragment()).commit();
                break;
            case R.id.users:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UsersFragment()).commit();
                break;
            case R.id.companies:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CompaniesFragment()).commit();
                break;
            case R.id.feedback:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FeedBackFragment()).commit();
                break;
            case R.id.subscription:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SubscriptionsFragment()).commit();
                break;
            case R.id.special_subscriptions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SpecialCollectionsFragment()).commit();
                break;
            case R.id.promo_codes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PromoCodesFragment()).commit();
                break;
            case R.id.jobs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new JobsFragment()).commit();
                break;
            case R.id.send_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SendMessageFragment()).commit();
                break;
            case R.id.transactions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TransactionsFragment()).commit();
                break;
            default:
                Toast.makeText(this, "No Link Selected", Toast.LENGTH_SHORT).show();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}