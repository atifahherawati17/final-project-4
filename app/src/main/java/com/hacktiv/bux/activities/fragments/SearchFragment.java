package com.hacktiv.bux.activities.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hacktiv.bux.R;
import com.hacktiv.bux.activities.BusScheduleActivity;
import com.hacktiv.bux.activities.MainActivity;
import com.hacktiv.bux.activities.PickDateActivity;
import com.hacktiv.bux.activities.SearchDepartureActivity;
import com.hacktiv.bux.activities.SearchDestinationActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private TextView departureCity, arrivalCity, setPassengers, pickDate, totalPassengers;
    private Button cancelBtn, selectBtn, searchBuxBtn;
    private SeekBar passengersSeekBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        departureCity = view.findViewById(R.id.departureCity);
        arrivalCity = view.findViewById(R.id.arrivalCity);
        setPassengers = view.findViewById(R.id.setPassengers);
        pickDate = view.findViewById(R.id.pickDate);
        searchBuxBtn = view.findViewById(R.id.searchBusBtn);


        if(getArguments() != null){
            String date = getArguments().getString("date");
            String passengers = getArguments().getString("passengers");
            if(!date.isEmpty() && date != null){
                pickDate.setText(date);
                pickDate.setTextColor(getResources().getColor(R.color.blue));
            }

            if(!passengers.isEmpty() && passengers != null){
                System.out.println("passengers : " + passengers);
                setPassengers.setText(passengers);
                setPassengers.setTextColor(getResources().getColor(R.color.blue));
            }
        }

        searchBuxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                intent = new Intent(getContext(), BusScheduleActivity.class);
                startActivity(intent);
            }
        });

        departureCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchDepartureActivity.class));
            }
        });

        arrivalCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchDestinationActivity.class));
            }
        });

        setPassengers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), PickDateActivity.class);
                i.putExtra("passengers", setPassengers.getText().toString().trim());

                startActivity(i);
            }
        });

        return view;
    }

    private void showDialog(){
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.set_seet_layout);

        cancelBtn = dialog.findViewById(R.id.cancelBtn);
        selectBtn = dialog.findViewById(R.id.selectBtn);
        passengersSeekBar = dialog.findViewById(R.id.passengersSeekBar);
        totalPassengers = dialog.findViewById(R.id.totalPassengers);


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setPassengers.setText(totalPassengers.getText().toString().trim());
                setPassengers.setTextColor(getResources().getColor(R.color.blue));
                dialog.dismiss();
            }
        });

        passengersSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                totalPassengers.setText(String.valueOf(i+1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

}