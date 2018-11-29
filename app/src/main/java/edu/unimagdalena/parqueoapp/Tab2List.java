package edu.unimagdalena.parqueoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    String [] jodee = new String[5];
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
                arrayTab2 = new ArrayTab2(nombre);
                arrayTab1s.add(arrayTab2);
                jodee[i] = nombre +"\n"+ costo + "";
            }//Log.i("Corone",String.valueOf(id));
        }
    }
    /* bundle2.putInt("id"+i,locales.getId());
                                bundle2.putString("nombre2"+i,locales.getNombre());
                                bundle2.putDouble("lon2" + i, locales.getLongitud());
                                bundle2.putDouble("lat2" + i, locales.getLatitud());
                                bundle2.putString("prop" + i, locales.getPropetario());
                                bundle2.putInt("cos"+i,locales.getCosto());
                                bundle2.putString("hor"+i,locales.getHorario());
                                bundle2.putInt("cupo"+i,locales.getCupo());
                                bundle2.putString("image"+i,locales.getImagenurl());*/

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
}