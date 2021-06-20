package com.example.vehicletickets.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vehicletickets.R;
import com.example.vehicletickets.adapter.date_adapter;
import com.example.vehicletickets.adapter.flight_info_adapter;
import com.example.vehicletickets.adapter.profileRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Random;

public class add_select_flight_fragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference documentReference;
    CollectionReference collectionReference;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    com.example.vehicletickets.adapter.date_adapter date_adapter;
    RecyclerView recyclerView;

    com.example.vehicletickets.adapter.flight_info_adapter fligh_adapter;
    RecyclerView recyclerView2;

    ArrayList<String> date_textarr= new ArrayList<>();
    ArrayList<String> number_date_textarr=new ArrayList<>();

    ArrayList<String> departure_locationarr = new ArrayList<>();
    ArrayList<String> departure_location_fullarr = new ArrayList<>();
    ArrayList<String> date_locationarr = new ArrayList<>();

    ArrayList<String> arrival_locationarr = new ArrayList<>();
    ArrayList<String> arrival_location_fullarr = new ArrayList<>();
    ArrayList<String> flight_numbersarr = new ArrayList<>();
    ArrayList<String> time_array = new ArrayList<>();

    private ArrayList<Integer> money_array= new ArrayList<>();


    private static final String[] paths = {"Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
            "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
            "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
            "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "Mersin", "İstanbul", "İzmir",
            "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya",
            "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya",
            "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak",
            "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};



    public add_select_flight_fragment() {
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
        View view = inflater.inflate(R.layout.fragment_add_select_flight_fragment, container, false);
//        new_res.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), FlightSearch.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }
    String departure;
    String arrival;
    String date;
    String new_date;
    String classType;
    int traveller;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() !=null){
            departure=add_select_flight_fragmentArgs.fromBundle(getArguments()).getDepartureLocation();


            arrival=add_select_flight_fragmentArgs.fromBundle(getArguments()).getArrivalLocation();
            date=add_select_flight_fragmentArgs.fromBundle(getArguments()).getDate();

            String[] parts = date.split("/");
            new_date="20";
            new_date+=parts[2];
            new_date+="-";
            new_date+=parts[0];
            new_date+="-";
            new_date+=parts[1];

            classType=add_select_flight_fragmentArgs.fromBundle(getArguments()).getClassType();
            traveller=add_select_flight_fragmentArgs.fromBundle(getArguments()).getNumTraveller();
        }



        fligh_adapter = new flight_info_adapter(departure_locationarr, departure_location_fullarr, date_locationarr, arrival_locationarr, arrival_location_fullarr, flight_numbersarr,money_array,time_array,getContext());

        date_adapter = new date_adapter(date_textarr,number_date_textarr,getContext());

        recyclerView = view.findViewById(R.id.date_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(date_adapter);

        recyclerView2 = view.findViewById(R.id.all_flight_info_recycler_view);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(fligh_adapter);



//        collectionReference=db.collection("flights");
//
//        String[] new_paths=new String[paths.length];
//        int j=0;
//        for(String str:paths){
//            String new_str="";
//            for(int i=0;i<3;i++){
//                str=str.toUpperCase();
//                new_str+=str.charAt(i);
//            }
//            new_paths[j]=new_str;
//            j++;
//            System.out.println(new_str);
//        }
//
//        String s = "2021-06-20";
//        String e = "2021-07-20";
//        LocalDate start = LocalDate.parse(s);
//        LocalDate end = LocalDate.parse(e);
//        List<LocalDate> totalDates = new ArrayList<>();
//        while (!start.isAfter(end)) {
//            totalDates.add(start);
//            start = start.plusDays(1);
//            System.out.println(start);
//
//        }
//
//        String[] list_day_name={"MDY","TUS","WED","THR","FRI","STR","SUN"};
//
//        for (int k=0;k<paths.length;k++){
//            String path=paths[k];
//            String arrival_paths=paths[k];
//            String arrival_path_short=new_paths[k];
//            Random rand = new Random();
//
//            String departure_path=paths[paths.length-k-1];
//            String departure_path_short=new_paths[paths.length-k-1];
//            int in=k%30;
//            String date=totalDates.get(in).toString();
//            String day_name=list_day_name[k%7];
//            String fligt_number="";
//            fligt_number+=departure_path.charAt(0);
//            fligt_number+=arrival_paths.charAt(0);
//            fligt_number+=date.charAt(0);
//            String time="";
//            String hour=String.valueOf(rand.nextInt(12));
//            String minutes=String.valueOf(rand.nextInt(60));
//            time+=hour;
//            time+=":";
//            time+=minutes;
//
//
//            Map<String,Object> hm=new HashMap<>();
//
//            hm.put("arrival_path",arrival_paths);
//            hm.put("arrival_path_short",arrival_path_short);
//            hm.put("departure_path",departure_path);
//            hm.put("departure_path_short",departure_path_short);
//            hm.put("date",date);
//            hm.put("day_name",day_name);
//            hm.put("fligt_number",fligt_number);
//            hm.put("time",time);
//            hm.put("money",getRandomNumber(50,150));
//
//            collectionReference.add(hm);
//
//        }

        deneme();

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public void deneme(){

        collectionReference=db.collection("flights");

        collectionReference
                .whereEqualTo("arrival_path",arrival)
                .whereEqualTo("departure_path",departure)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    for (QueryDocumentSnapshot document : task.getResult()) {



                        date_textarr.add(document.getString("day_name"));
                        String temp=document.getString("date");
                        String[] parts=temp.split("-");
                        temp=parts[2];
                        number_date_textarr.add(temp);

                        departure_locationarr.add(document.getString("departure_path_short"));
                        departure_location_fullarr.add(document.getString("departure_path"));
                        date_locationarr.add(document.getString("date"));

                        arrival_locationarr.add(document.getString("arrival_path_short"));
                        arrival_location_fullarr.add(document.getString("arrival_path"));
                        flight_numbersarr.add(document.getString("fligt_number"));
                        time_array.add(document.getString("time"));

                        System.out.println(Integer.valueOf(document.get("money").toString()));
                        money_array.add(Integer.valueOf(document.get("money").toString()));


                    }
                    date_adapter.notifyDataSetChanged();
                    fligh_adapter.notifyDataSetChanged();
                } else {
                }
            }
        });




    }


}