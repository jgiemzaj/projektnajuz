package com.example.justyna.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Zabrze", 18, "Śląskie: zachmurzenie"));
        places.add(new Place("Gliwice", 17, "Śląskie: silne zachmurzenie"));
        places.add(new Place("Katowice", 14, "Śląskie: okresowe przejaśnienia"));
        places.add(new Place("Warszawa", 9, "Mazowieckie: Przelotne opady"));
        places.add(new Place("Praga", 5, "Czechy: Mgła"));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        OnClickPlace listener = (view, position) -> {

            String miasto = places.get(position).getPlaceName();
            String info = places.get(position).getInformation();
            Integer temp = places.get(position).getTemperature();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("miasto", miasto);
            bundle.putString("info", info);
            bundle.putInt("temp", temp);
            intent.putExtras(bundle);
            startActivity(intent);
        };

        PlaceAdapter placeAdapter = new PlaceAdapter(places, listener);
        recyclerView.setAdapter(placeAdapter);
    }
}
