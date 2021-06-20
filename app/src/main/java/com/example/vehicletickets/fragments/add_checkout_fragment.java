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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vehicletickets.R;

public class add_checkout_fragment extends Fragment {

    String arrival_ = "";
    String arrivalfull_ = "";
    String departure_ = "";
    String departurefull_ = "";
    String date_location_ = "";
    String flight_number_ = "";
    String seat_ = "";
    int money_ = 0;
    String time_ = "";

    public add_checkout_fragment() {
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
        return inflater.inflate(R.layout.fragment_add_checkout_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton button=view.findViewById(R.id.go_forward);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_checkout_fragmentDirections.ActionAddCheckoutFragmentToAddPaymentİnfo action=add_checkout_fragmentDirections.actionAddCheckoutFragmentToAddPaymentİnfo();

                arrival_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getArrivalLocation();
                arrivalfull_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getArrivalLocationFull();
                departure_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getDepartureLocation();
                departurefull_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getDepartureLocationFull();
                date_location_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getFlightDate();
                flight_number_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getFlightNo();
                money_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getMoney();
                time_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getTime();
                seat_=add_checkout_fragmentArgs.fromBundle(getArguments()).getSeatNumber();

                action.setDeparture(departure_);
                action.setDepartureFull(departurefull_);
                action.setTime(time_);
                action.setMoney(money_);
                action.setFlightNumber(flight_number_);
                action.setFlightDate(date_location_);
                action.setArrival(arrival_);
                action.setArrivalFull(arrivalfull_);
                action.setSeatNumber(seat_);

//                NavDirections action= add_checkout_fragmentDirections.actionAddCheckoutFragmentToAddPaymentİnfo();
                Navigation.findNavController(view).navigate(action);




            }
        });

        TextView shortname_id_departure=view.findViewById(R.id.shortname_id_departure);
        TextView longname_id_departure=view.findViewById(R.id.longname_id_departure);
        TextView shortname_id_arrival=view.findViewById(R.id.shortname_id_arrival);
        TextView longname_id_arrival=view.findViewById(R.id.longname_id_arrival);
        TextView day_text=view.findViewById(R.id.day_text);
        TextView flight_number_info=view.findViewById(R.id.flight_number_info);
        TextView time=view.findViewById(R.id.time);
        TextView seat_info=view.findViewById(R.id.seat_info);
        TextView class_info=view.findViewById(R.id.class_info);
        TextView payment=view.findViewById(R.id.payment);

        if (getArguments() != null) {

            arrival_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getArrivalLocation();
            arrivalfull_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getArrivalLocationFull();
            departure_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getDepartureLocation();
            departurefull_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getDepartureLocationFull();
            date_location_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getFlightDate();
            flight_number_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getFlightNo();
            money_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getMoney();
            time_ = add_checkout_fragmentArgs.fromBundle(getArguments()).getTime();
            seat_=add_checkout_fragmentArgs.fromBundle(getArguments()).getSeatNumber();

        }
        shortname_id_departure.setText(departure_);
        longname_id_departure.setText(departurefull_);
        shortname_id_arrival.setText(arrival_);
        longname_id_arrival.setText(arrivalfull_);
        day_text.setText(date_location_);
        flight_number_info.setText(flight_number_);
        time.setText(time_);
        seat_info.setText(seat_);
        class_info.setText("Economy");
        String a="$";
        a+=String.valueOf(money_);
        payment.setText(a);




    }
}