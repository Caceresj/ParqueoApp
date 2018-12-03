package edu.unimagdalena.parqueoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    String nombre,propetario,horario,imagen;

    int costo,cupo,id;
    TextView textViewname,textViewprop,textViewhorario,textViewcupo,textViewcosto;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nombre = getIntent().getStringExtra("name");
        propetario = getIntent().getStringExtra("prop");
        horario = getIntent().getStringExtra("hora");
        costo = getIntent().getIntExtra("cost",-1);
        cupo = getIntent().getIntExtra("cup",-1);
        imagen = getIntent().getStringExtra("img");
        id = getResources().getIdentifier(imagen,"drawable",getPackageName());
        textViewprop =findViewById(R.id.tViewpropetario);
        textViewname = findViewById(R.id.tViewname);
        textViewhorario = findViewById(R.id.tViewhorario);
        textViewcupo = findViewById(R.id.tViewcupo);
        textViewcosto = findViewById(R.id.tViewcosto);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(id);
        textViewname.setText(nombre);
        textViewprop.setText(propetario);
        textViewhorario.setText(horario);
        textViewcupo.setText(String.valueOf(cupo));
        textViewcosto.setText(String.valueOf(costo));
    }
}
/*
                        intent.putExtra("longi",longi);
                        intent.putExtra("latit",lati);

 */