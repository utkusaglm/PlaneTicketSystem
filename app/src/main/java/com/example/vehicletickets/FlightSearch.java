package com.example.vehicletickets;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class FlightSearch extends AppCompatActivity {

    Button one;
    Button two;

    boolean returnValue;

    private Button selectDate;
    private DatePickerDialog datePickerDialog;
    private TextView dateTxt;
    private TextView dateTxt2;

    private EditText editTextArrival;
    private EditText editTextDeparture;

    private Calendar calendar;
    private int year, month, dayOfMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search);

        one=findViewById(R.id.one);
        two=findViewById(R.id.two);

        editTextArrival=findViewById(R.id.arrival_location);
        editTextDeparture=findViewById(R.id.departure_location);


//        selectDate = findViewById(R.id.one);


        dateTxt = findViewById(R.id.departure_date);
        dateTxt2 = findViewById(R.id.arrival_date);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(FlightSearch.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                dateTxt.setText(day + "/" + month + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

//        selectDate = findViewById(R.id.two);

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(FlightSearch.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                dateTxt2.setText(day + "/" + month + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

    }

    public void return_flight(View view) {
        two.setVisibility(View.VISIBLE);
        dateTxt2.setVisibility(View.VISIBLE);
        returnValue=false;
    }

    public void oneWay_flight(View view) {
        two.setVisibility(View.INVISIBLE);
        dateTxt2.setVisibility(View.INVISIBLE);
        returnValue=true;

    }


    public void seeFlights(View view) {

        if (returnValue){
            String arrival="";
            String depature="";
            arrival=editTextArrival.getText().toString();
            depature=editTextDeparture.getText().toString();
            String[] depature_date=dateTxt.getText().toString().split("/");
            String[] arrival_date=dateTxt2.getText().toString().split("/");
            Intent  intent=new Intent(FlightSearch.this,SeeFlights.class);
            intent.putExtra("arrival",arrival);
            intent.putExtra("depature",depature);
            intent.putExtra("depature_date",depature_date);
            intent.putExtra("arrival_date",arrival_date);
            startActivity(intent);

        }else{
            String arrival="";
            String depature="";
            arrival=editTextArrival.getText().toString();
            depature=editTextDeparture.getText().toString();
            String[] depature_date=dateTxt.getText().toString().split("/");
            Intent  intent=new Intent(FlightSearch.this,SeeFlights.class);
            intent.putExtra("arrival",arrival);
            intent.putExtra("depature",depature);
            intent.putExtra("depature_date",depature_date);
            startActivity(intent);

        }


    }
}