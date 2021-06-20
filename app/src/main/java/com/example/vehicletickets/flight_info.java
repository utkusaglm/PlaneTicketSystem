package com.example.vehicletickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class flight_info extends AppCompatActivity {
    TextView departure_location;
    TextView departure_location_full;
    TextView arrival_location;
    TextView arrival_location_full;
    TextView ticket_price;
    TextView flight_date_info;
    TextView flight_number_info;
    TextView boardingtime_info;
    TextView seat_info;
    String departure="";
    String departure_short="";
    String date="";
    String arrival="";
    String arrival_short="";
    String flight_number="";
    String time="";
    String seat="";
    String price="$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_info);

        departure_location=findViewById(R.id.departure_location);
        departure_location_full=findViewById(R.id.departure_location_full);
        arrival_location=findViewById(R.id.arrival_location);
        arrival_location_full=findViewById(R.id.arrival_location_full);
        ticket_price=findViewById(R.id.ticket_price);
        flight_date_info=findViewById(R.id.flight_date_info);
        flight_number_info=findViewById(R.id.flight_number_info);
        boardingtime_info=findViewById(R.id.boardingtime_info);
        seat_info=findViewById(R.id.seat_info);

        Intent intent=getIntent();

        if(intent!=null){
            departure=intent.getStringExtra("departure");
            departure_short=intent.getStringExtra("departure_short");
            date=intent.getStringExtra("date");
            arrival=intent.getStringExtra("arrival");
            arrival_short=intent.getStringExtra("arrival_short");
            flight_number=intent.getStringExtra("flight_number");
            time=intent.getStringExtra("time");
            seat=intent.getStringExtra("seat");
            price+=intent.getStringExtra("price");
        }
        departure_location.setText(departure_short);
        departure_location_full.setText(departure);
        arrival_location.setText(arrival_short);
        arrival_location_full.setText(arrival);
        ticket_price.setText(price);
        flight_date_info.setText(date);
        flight_number_info.setText(flight_number);
        boardingtime_info.setText(time);
        seat_info.setText(seat);





    }
}