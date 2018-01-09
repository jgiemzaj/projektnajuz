package com.example.justyna.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_pokaz_liste)
    Button pokazListe;
    @BindView(R.id.button_zm_miejsce)
    Button zmienMiejsce;

    @BindView(R.id.wpisztekst)
    EditText wpiszTekst;

    @BindView(R.id.miasto)
    TextView City;

    @BindView(R.id.textView2)
    TextView information;

    @BindView(R.id.textView)
    TextView temp;

    @BindView(R.id.imageView)
    ImageView obrazek;

    @OnClick (R.id.button_pokaz_liste)
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle bundle = new Bundle();
        String enteredText = wpiszTekst.getText().toString();
        bundle.putString("Key", enteredText);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @OnClick (R.id.button_zm_miejsce)
    public void onClick2(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        String g = wpiszTekst.getText().toString();
        City.setText(g);
        Bundle bundle = new Bundle();
        bundle.putString("item", g);
        intent.putExtras(bundle);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Glide.with(MainActivity.this).load("https://emojipedia-us.s3.amazonaws.com/thumbs/160/google/6/rainbow_1f308.png").into(obrazek);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            City.setText(bundle.getString("miasto"));
            information.setText(bundle.getString("info"));
            Integer t = bundle.getInt("temp");
            if (t<10) {
                Glide.with(MainActivity.this).load("https://cdn2.iconfinder.com/data/icons/weather-icon-set/256/rain_snow.png").into(obrazek);
            }
            temp.setText(bundle.getInt("temp") + " stopni Celsujsza");
        }
    }
}
