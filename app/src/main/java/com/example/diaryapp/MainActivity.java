package com.example.diaryapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // This Section takes care of connecting fragClasses and createing Menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// set the custome made toolbar instead of actionBar

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();// this will take care of the hamburger icon animation


        if(savedInstanceState== null) { // this condition opens the main page with three buttons
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MainPage()).commit();// here commit to open the fragPage wanted
            navigationView.setCheckedItem(R.id.nav_aboutMe); // UNCOMMENT??

        }
        // End of Section

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_aboutMe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutMeFrag()).commit();
                break;
            case R.id.nav_favoriteFruit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavoriteFruitFrag()).commit();
                break;
            case R.id.nav_favoriteBook:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavoriteBooks()).commit();
                break;
            case R.id.nav_profile:
                Toast.makeText(this,"Access Account",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_chat:
                Toast.makeText(this,"Start Chat...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this,"Share Your Ideas",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MainPage()).commit();
    }

}
