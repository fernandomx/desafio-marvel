/*
 * *
 *  * Created by Fernando Meregali  on 07/10/20 22:37
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 07/10/20 22:17
 *
 */

package com.app.marvelsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.app.marvelsapp.R;
import com.app.marvelsapp.ui.home.characters.CharactersFragment;
import com.app.marvelsapp.ui.home.favorites.FavoritesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUp();
    }

    private void setUp() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
                switch (item.getItemId()) {
                    case R.id.characters:
                        if (!(currentFragment instanceof CharactersFragment)) {
                            fragment = CharactersFragment.newInstance();
                        }else {
                            fragment = currentFragment;
                        }
                        break;
                    case R.id.favorites:
                        if (!(currentFragment instanceof FavoritesFragment)) {
                            fragment = FavoritesFragment.newInstance();
                        }else {
                            fragment = currentFragment;
                        }
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Character").commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.characters);
    }
}
