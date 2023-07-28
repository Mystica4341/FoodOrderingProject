package com.mobile.foodorderingproject.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;
import com.mobile.foodorderingproject.R;

public class Menu_Activity extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    NavigationView navView;
    Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_nav,R.string.close_nav);
        toggle.syncState();
        addEvents();
    }

    private void addControls(){
        btnCart = (Button)findViewById(R.id.btnCart);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navView = (NavigationView)findViewById(R.id.nav_view);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
    }
    private void addEvents(){
        navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.food){
                loadFragment(new FoodFrag());
                return true;
            } else if (id == R.id.drink) {
                loadFragment(new DrinkFrag());
                return true;
            } else if (id == R.id.dessert) {
                loadFragment(new DessertFrag());
                return true;
            } else if (id == R.id.combo) {
                loadFragment(new ComboFrag());
                return true;
            }
            return false;
        });
        btnCart.setOnClickListener(v -> loadFragment(new ShoppingCartFrag()));
    }

    public void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }
}