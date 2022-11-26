package com.example.cities;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CoatOfArmsFragment extends Fragment {

    static final String ARG_INDEX = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_coast_of_arms, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle argumenst = getArguments();
        if (argumenst != null){
            int index = argumenst.getInt(ARG_INDEX);
            ImageView imageView = view.findViewById(R.id.coat_of_arms_image_view);
            TypedArray images = getResources().obtainTypedArray(R.array.coat_of_arms_imgs);
            imageView.setImageResource(images.getResourceId(index,0));
            images.recycle();
        }
    }

    public static CoatOfArmsFragment newInstance(int index){
        CoatOfArmsFragment fragment = new CoatOfArmsFragment();
        Bundle arg = new Bundle();
        arg.putInt(ARG_INDEX,index);
        fragment.setArguments(arg);
        return fragment;
    }
}