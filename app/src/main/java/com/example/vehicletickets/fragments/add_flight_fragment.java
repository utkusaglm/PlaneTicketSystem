package com.example.vehicletickets.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.vehicletickets.R;
import com.example.vehicletickets.fragments.add_flight_fragmentDirections;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class add_flight_fragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private Spinner spinnerselect_departure;
    private Spinner spinnerselect_arrival_location;
    private Spinner spinnerclass_add_flight;

    final Calendar myCalendar = Calendar.getInstance();
    EditText edittext;
    EditText edittextTravller;

    private static final String[] paths = {"Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
            "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};

    private static final String[] pathForClass = {"Economy", "Premium"};

    public add_flight_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_flight_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinnerselect_departure = (Spinner) view.findViewById(R.id.select_departure);
        spinnerselect_arrival_location = (Spinner) view.findViewById(R.id.select_arrival_location);
        spinnerclass_add_flight = (Spinner) view.findViewById(R.id.class_add_flight);


        ArrayAdapter<String> adapterspinnerselect_departure = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, paths);

        ArrayAdapter<String> adapterspinnerselect_arrival_location = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, paths);

        ArrayAdapter<String> adapterspinnerclass_add_flight = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, pathForClass);


        adapterspinnerselect_departure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerselect_departure.setAdapter(adapterspinnerselect_departure);
        spinnerselect_departure.setOnItemSelectedListener(this);

        adapterspinnerselect_arrival_location.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerselect_arrival_location.setAdapter(adapterspinnerselect_arrival_location);
        spinnerselect_arrival_location.setOnItemSelectedListener(this);

        adapterspinnerclass_add_flight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerclass_add_flight.setAdapter(adapterspinnerclass_add_flight);
        spinnerclass_add_flight.setOnItemSelectedListener(this);

        ImageButton button = view.findViewById(R.id.go_forward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_flight_fragmentDirections.ActionAddFlightFragmentToAddSelectFlightFragment action=add_flight_fragmentDirections.actionAddFlightFragmentToAddSelectFlightFragment();
                action.setArrivalLocation(spinnerselect_arrival_location.getSelectedItem().toString());
                action.setDepartureLocation(spinnerselect_departure.getSelectedItem().toString());
                action.setClassType(spinnerclass_add_flight.getSelectedItem().toString());
                action.setDate(edittext.getText().toString());
                action.setNumTraveller(Integer.parseInt(edittextTravller.getText().toString()));

                Navigation.findNavController(view).navigate(action);

            }
        });


        edittext = (EditText) view.findViewById(R.id.select_date);
        edittextTravller = (EditText) view.findViewById(R.id.no_of_travellers);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}