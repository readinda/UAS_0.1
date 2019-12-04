package com.natania.uas_01.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.natania.uas_01.R;
import com.natania.uas_01.fragment.DessertFragment;
import com.natania.uas_01.fragment.ProfileFragment;
import com.natania.uas_01.fragment.SeaFoodFragment;

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new DessertFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.container,fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.navigation_dessert:
                fragment = new DessertFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
            case R.id.navigation_seafood:
                fragment = new SeaFoodFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
