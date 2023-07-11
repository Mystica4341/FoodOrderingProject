package com.mobile.foodorderingproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    FrameLayout frameLayout;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls(){
        actionBar = getSupportActionBar();
        frameLayout = (FrameLayout) findViewById(R.id.frameFrag);
        bottomNav = (BottomNavigationView) findViewById(R.id.BottomNav);
    }
    private void addEvents(){
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.food){
                    loadFragment(new FoodFrag());
                    return true;
                } else if (id == R.id.drink) {
                    loadFragment(new DrinkFrag());
                    return true;
                } else if (id == R.id.desert) {
                    loadFragment(new DesertFrag());
                    return true;
                } else if (id == R.id.combo) {
                    loadFragment(new ComboFrag() );
                    return true;
                }
                return false;
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        //đẩy fragment tương ứng lên
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameFrag, fragment);
        ft.commit();
    }
}