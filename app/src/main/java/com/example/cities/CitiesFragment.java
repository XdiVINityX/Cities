package com.example.cities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CitiesFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }


    private void initList(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] sities = getResources().getStringArray(R.array.cities);

        for (int i = 0; i < sities.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(sities[i]);
            textView.setTextSize(30);
            linearLayout.addView(textView);

            final int index = i;
            textView.setOnClickListener(v -> {
                showCoatOfArms(index);
            });
        }
    }
    private void showCoatOfArms(int index) {
        //Если портрентная
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(index);
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_for_CoatOfArms, coatOfArmsFragment)
                    .addToBackStack("")
                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .commit();
        } else {
            //Если ландшавная
            CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(index);
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_for_CoatOfArms, coatOfArmsFragment)
                    .addToBackStack("")
                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .commit();
        }
    }
}








