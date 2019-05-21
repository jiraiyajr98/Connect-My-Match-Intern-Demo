package com.cssllc.connectmywatch;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.cssllc.connectmywatch.Adapter.SubjectsAdapter;
import com.cssllc.connectmywatch.Fragment.AnalysisFragment;
import com.cssllc.connectmywatch.Fragment.DoubtsFragment;
import com.cssllc.connectmywatch.Fragment.HomeFragment;
import com.cssllc.connectmywatch.Fragment.ProfileFragment;
import com.cssllc.connectmywatch.Fragment.TestsFragmant;
import com.cssllc.connectmywatch.POJO.Subjects;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            if(drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(Gravity.START); //CLOSE Nav Drawer!
            }else{
                drawer.openDrawer(Gravity.START); //OPEN Nav Drawer!
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_tests:
                            selectedFragment = new TestsFragmant();
                            break;
                        case R.id.nav_analysis:
                            selectedFragment = new AnalysisFragment();
                            break;

                        case R.id.nav_doubts:
                            selectedFragment = new DoubtsFragment();
                            break;

                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
    };


}



