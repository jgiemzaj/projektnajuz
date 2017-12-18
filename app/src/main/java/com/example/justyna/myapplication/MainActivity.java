package com.example.justyna.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    TextView City ;


    @OnClick (R.id.button_pokaz_liste)
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
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


    }
}
