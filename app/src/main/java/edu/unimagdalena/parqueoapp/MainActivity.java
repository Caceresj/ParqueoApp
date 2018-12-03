package edu.unimagdalena.parqueoapp;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private Context contextglobal= this;

    private ViewPager mViewPager;
    private ArrayList<Locales> taba1,taba2,taba3;
    private int numiteraccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        HttpClient httpClient = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if(status.isSuccess()){
                    Gson gson = new GsonBuilder().create();
                    try {
                        JSONObject jsonObject = new JSONObject(status.getResult());
                        JSONArray jsonArray = jsonObject.getJSONArray("locales");
                        ArrayList<Locales> locales = new ArrayList<Locales>();
                        numiteraccion = jsonArray.length();
                        for (int i=0; i< jsonArray.length();i++){
                            String locales1 = jsonArray.getString(i);
                            Locales locales2 = gson.fromJson(locales1,Locales.class);
                            locales.add(locales2);
                        }
                        taba1= GetLocalesArray(locales);
                        taba2= GetLocalesArray(locales);
                        taba3= GetLocalesArray(locales);

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                   //Toast.makeText(MainActivity.this,status.getResult(),Toast.LENGTH_SHORT).show();
                    System.out.println(status.getResult());
                }
            }
        });
        httpClient.excecute("https://inventoryapphola.000webhostapp.com/informacion.json");
        //httpClient.excecute("https://inventoryapphola.000webhostapp.com/json.txt");

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager =  findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout =  findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



    }

    public ArrayList<Locales> GetLocalesArray(ArrayList<Locales> joda){
        return joda;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Tab1Map tab1= new Tab1Map();
                    Bundle bundle = new Bundle();
                    for(int i=1;i<numiteraccion+1;i++){
                        for(Locales locales: taba1){
                            if(locales.getId()==i) {
                                bundle.putInt("id"+i,locales.getId());
                                bundle.putDouble("lon" + i, locales.getLongitud());
                                bundle.putDouble("lat" + i, locales.getLatitud());
                                bundle.putString("nombre"+i,locales.getNombre());
                                bundle.putInt("costo"+i,locales.getCosto());
                            }
                        }
                    }
                    bundle.putInt("termina",numiteraccion);
                    Log.i("JOderMa",bundle.toString());
                    tab1.setArguments(bundle);
                    return tab1;


                case 1:
                    Tab2List tab2 = new Tab2List();
                    Bundle bundle2 = new Bundle();
                    for(int i=1;i<numiteraccion+1;i++){
                        for(Locales locales: taba2){
                            Log.i("aja","("+locales.getId()+","+i+")");
                            if(locales.getId()==i) {
                                bundle2.putInt("id"+i,locales.getId());
                                bundle2.putString("nombre"+i,locales.getNombre());
                                bundle2.putDouble("lon" + i, locales.getLongitud());
                                bundle2.putDouble("lat" + i, locales.getLatitud());
                                bundle2.putString("prop" + i, locales.getPropetario());
                                bundle2.putInt("cos"+i,locales.getCosto());
                                bundle2.putString("hor"+i,locales.getHorario());
                                bundle2.putInt("cupo"+i,locales.getCupo());
                                bundle2.putString("image"+i,locales.getImagenurl());
                            }
                        }
                    }
                    bundle2.putInt("termina",numiteraccion);
                    Log.i("JOderMa",bundle2.toString());
                    tab2.setArguments(bundle2);
                    return tab2;


                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "Maps";
                case 1:
                    return "List";

            }
            return null;
        }
    }
}
