/*
 * *
 *  * Created by Fernando Meregali  on 07/10/20 23:09
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 07/10/20 23:09
 *
 */

package com.app.marvelsapp.ui.home.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.marvelsapp.R;

public class FavoritesFragment extends Fragment {

    public static FavoritesFragment newInstance() {
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        return view;
    }


}