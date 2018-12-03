package edu.unimagdalena.parqueoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tab2List extends Fragment {
    int numeroiter;
    int id;
    int costo;
    int cupo;
    String nombre;
    String propetario;
    String horario;
    double longitud;
    double latitud;
    String image;
    String [] jodee = new String[15];
    ArrayTab2 arrayTab2;
    private ArrayList<ArrayTab2> arrayTab1s = new ArrayList<ArrayTab2>();
    ListView listView;
    String[] elementos = {"jose", "pedro", "maria", "miguel", "luis", "daniel", "elena", "Laura", "Sofia"};
    public void onCreate(Bundle savedInstanceStateState){
        super.onCreate(savedInstanceStateState);
        if(getArguments() != null){
            numeroiter = getArguments().getInt("termina");
            for(int i=0;i<numeroiter;i++){
                id =getArguments().getInt("id"+(i+1));
                nombre = getArguments().getString("nombre"+(i+1));
                longitud = getArguments().getDouble("lon"+(i+1));
                latitud = getArguments().getDouble("lat"+(i+1));
                propetario = getArguments().getString("prop"+(i+1));
                costo =getArguments().getInt("cos"+(i+1));
                horario = getArguments().getString("hor"+(i+1));
                cupo =getArguments().getInt("cupo"+(i+1));
                image = getArguments().getString("image"+(i+1));
                arrayTab2 = new ArrayTab2(id,nombre,propetario,horario,image,longitud,latitud,costo,cupo);
                arrayTab1s.add(arrayTab2);
                jodee[i] = nombre +"\n"+ costo + "";
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2list, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        listView = getView().findViewById(R.id.lvListado);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_expandable_list_item_1, jodee);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name,prop,hora,img;
                double longi,lati;
                int cost,cup;
                for(ArrayTab2 arrayTab2 : arrayTab1s){
                    if(arrayTab2.getId()-1 == position) {
                        name = arrayTab2.getNombre();
                        prop = arrayTab2.getPropetario();
                        hora = arrayTab2.getHorario();
                        longi = arrayTab2.getLongitud();
                        lati = arrayTab2.getLatitud();
                        cost = arrayTab2.getCosto();
                        cup = arrayTab2.getCupo();
                        img = arrayTab2.getImage();

                        Intent intent = new Intent(getActivity(), Main2Activity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("prop", prop);
                        intent.putExtra("hora",hora);
                        intent.putExtra("longi",longi);
                        intent.putExtra("latit",lati);
                        intent.putExtra("cost",cost);
                        intent.putExtra("cup",cup);
                        intent.putExtra("img",img);
                        startActivity(intent);
                    }
                }
                // Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
















/*
package edu.unimagdalena.parqueoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Tab2List extends Fragment {
    int numeroiter;
    int id;
    int costo;
    int cupo;
    String nombre;
    String propetario;
    String horario;
    double longitud;
    double latitud;
    String image;
    String [] jodee = new String[5];
    ArrayTab2 arrayTab2;

    private ArrayTab2[] arrayTab1s = new ArrayTab2[5];
    private ListView listView;
    public void onCreate(Bundle savedInstanceStateState){
        super.onCreate(savedInstanceStateState);
        if(getArguments() != null){
            numeroiter = getArguments().getInt("termina");
            for(int i=0;i<numeroiter;i++){
                id =getArguments().getInt("id"+(i+1));
                nombre = getArguments().getString("nombre"+(i+1));
                longitud = getArguments().getDouble("lon"+(i+1));
                latitud = getArguments().getDouble("lat"+(i+1));
                propetario = getArguments().getString("prop"+(i+1));
                costo =getArguments().getInt("cos"+(i+1));
                horario = getArguments().getString("hor"+(i+1));
                cupo =getArguments().getInt("cupo"+(i+1));
                image = getArguments().getString("image"+(i+1));
                arrayTab1s [i]= new ArrayTab2(id,nombre,propetario,image,horario);
                jodee[i] = nombre +"\n"+ costo + "";
            }Log.i("Corone",arrayTab1s.toString());//Log.i("Cone",getActivity().getBaseContext()+"");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        listView = getView().findViewById(R.id.lvListado);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_expandable_list_item_1, jodee);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}*/