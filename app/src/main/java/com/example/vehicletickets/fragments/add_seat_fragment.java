package com.example.vehicletickets.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vehicletickets.R;


public class add_seat_fragment extends Fragment {

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;
    ImageButton button7;
    ImageButton button8;
    ImageButton button9;
    ImageButton button10;
    ImageButton button11;
    ImageButton button12;
    ImageButton button13;
    ImageButton button14;
    ImageButton button15;
    ImageButton button16;
    ImageButton button17;
    ImageButton button18;
    ImageButton button19;
    ImageButton button20;
    ImageButton button21;
    ImageButton button22;
    ImageButton button23;
    ImageButton button24;
    ImageButton button25;
    ImageButton button26;
    ImageButton button27;
    ImageButton button28;
    ImageButton button29;
    ImageButton button30;
    ImageButton button31;

    String arrival_ = "";
    String arrivalfull_ = "";
    String departure_ = "";
    String departurefull_ = "";
    String date_location_ = "";
    String flight_number_ = "";
    int money_ = 0;
    String time_ = "";


    public add_seat_fragment() {
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
        return inflater.inflate(R.layout.fragment_add_seat_fragment, container, false);
    }

    int i = 0;
    TextView seat_number;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button1 = view.findViewById(R.id.b1);
        button2 = view.findViewById(R.id.b2);
        button3 = view.findViewById(R.id.b3);
        button4 = view.findViewById(R.id.b4);
        button5 = view.findViewById(R.id.b5);
        button6 = view.findViewById(R.id.b6);
        button7 = view.findViewById(R.id.b7);
        button8 = view.findViewById(R.id.b8);
        button9 = view.findViewById(R.id.b9);
        button10 = view.findViewById(R.id.b10);
        button11 = view.findViewById(R.id.b11);
        button12 = view.findViewById(R.id.b12);
        button13 = view.findViewById(R.id.b13);
        button14 = view.findViewById(R.id.b14);
        button15 = view.findViewById(R.id.b15);
        button16 = view.findViewById(R.id.b16);
        button17 = view.findViewById(R.id.b17);
        button18 = view.findViewById(R.id.b18);
        button19 = view.findViewById(R.id.b19);
        button20 = view.findViewById(R.id.b20);
        button21 = view.findViewById(R.id.b21);
        button22 = view.findViewById(R.id.b22);
        button23 = view.findViewById(R.id.b23);
        button24 = view.findViewById(R.id.b24);
        button25 = view.findViewById(R.id.b25);
        button26 = view.findViewById(R.id.b26);
        button27 = view.findViewById(R.id.b27);
        button28 = view.findViewById(R.id.b28);
        button29 = view.findViewById(R.id.b29);
        button30 = view.findViewById(R.id.b30);
        button31 = view.findViewById(R.id.b31);

        buttons_yelllow();
        ImageButton button = view.findViewById(R.id.go_forward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                add_select_flight_fragmentDirections.ActionAddSelectFlightFragmentToAddSeatFragment action=add_select_flight_fragmentDirections.actionAddSelectFlightFragmentToAddSeatFragment();


                add_seat_fragmentDirections.ActionAddSeatFragmentToAddCheckoutFragment action=add_seat_fragmentDirections.actionAddSeatFragmentToAddCheckoutFragment();


                action.setTime(time_);
                action.setMoney(money_);
                action.setFlightNo(flight_number_);
                action.setFlightDate(date_location_);
                action.setDepartureLocationFull(departurefull_);
                action.setDepartureLocation(departure_);
                action.setArrivalLocationFull(arrivalfull_);
                action.setArrivalLocation(arrival_);
                action.setSeatNumber(seat_number.getText().toString());

//                NavDirections action = add_seat_fragmentDirections.actionAddSeatFragmentToAddCheckoutFragment();
                Navigation.findNavController(view).navigate(action);

            }
        });


        TextView shortname_id_departure = view.findViewById(R.id.shortname_id_departure);
        TextView longname_id_departure = view.findViewById(R.id.longname_id_departure);
        TextView shortname_id_arrival = view.findViewById(R.id.shortname_id_arrival);
        TextView longname_id_arrival = view.findViewById(R.id.longname_id_arrival);
        TextView flight_number = view.findViewById(R.id.flight_number);
        seat_number = view.findViewById(R.id.seat_number);

        if (getArguments() != null) {


            arrival_ = add_seat_fragmentArgs.fromBundle(getArguments()).getArrivalLocation();
            arrivalfull_ = add_seat_fragmentArgs.fromBundle(getArguments()).getArrivalLocationFull();
            departure_ = add_seat_fragmentArgs.fromBundle(getArguments()).getDepartureLocation();
            departurefull_ = add_seat_fragmentArgs.fromBundle(getArguments()).getDepartureLocationFull();
            date_location_ = add_seat_fragmentArgs.fromBundle(getArguments()).getDateLocation();
            flight_number_ = add_seat_fragmentArgs.fromBundle(getArguments()).getFlightNumbers();
            money_ = add_seat_fragmentArgs.fromBundle(getArguments()).getMoney();
            time_ = add_seat_fragmentArgs.fromBundle(getArguments()).getTime();

        }
        shortname_id_departure.setText(departure_);
        longname_id_departure.setText(departurefull_);
        shortname_id_arrival.setText(arrival_);
        longname_id_arrival.setText(arrivalfull_);
        flight_number.setText(flight_number_);

    }


    public void buttons_yelllow() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setImageResource(R.drawable.tiklanmiskoltuk);

                seat_number.setText("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button2.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("4");

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button5.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button7.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button8.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button9.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("9");
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button10.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("10");
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button11.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("11");
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button12.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("12");
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button13.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("13");
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button14.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("14");
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button15.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("15");
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button16.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("16");
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button17.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("17");
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button18.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("18");
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button19.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("19");
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button20.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("20");
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button21.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("21");
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button22.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("22");
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button23.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("23");
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button24.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("24");
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button25.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("25");
            }
        });
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button26.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("26");
            }
        });
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button27.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("27");
            }
        });
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button28.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("28");
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button29.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("29");
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button30.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("30");
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button31.setImageResource(R.drawable.tiklanmiskoltuk);
                seat_number.setText("31");
            }
        });

    }


}