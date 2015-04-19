package com.proyectos.roxana.bombergisv01;import com.google.android.gms.maps.*;import com.google.android.gms.location.LocationClient;import com.google.android.gms.maps.model.LatLng;import com.google.android.gms.maps.model.Marker;import com.google.android.gms.maps.model.MarkerOptions;import android.app.Activity;import android.support.v4.app.Fragment;import android.support.v4.app.FragmentActivity;import android.os.Bundle;import android.support.v4.app.FragmentManager;import android.support.v4.app.FragmentTransaction;import android.support.v4.widget.DrawerLayout;import android.support.v7.app.ActionBarDrawerToggle;import android.util.Log;import android.view.View;import android.widget.Toast;import android.widget.CheckBox;public class MainActivity extends FragmentActivity {    GoogleMap googleMap;    public static final int FRAGMENTS = 6;    public static final int MENU1_FRAGMENT = 0;    public static final int MENU2_FRAGMENT = 1;    public static final int MENU3_FRAGMENT = 2;    public static final int MENU4_FRAGMENT = 3;    public static final int MENU5_FRAGMENT = 4;    public static final int MENU6_FRAGMENT = 5;        private DrawerLayout drawerLayout;    private ActionBarDrawerToggle drawerToggle;    private Fragment fragments[];    // Checkbox de los tipos de mapas    private CheckBox CheckM1,CheckM2,CheckM3;    GoogleMap MapType;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        //googleMap=((MapFragment)getFragmentManager().findFragmentById(R.id.gps_fragment)).getMap();        CargarMapa();        // setUpMapIfNeeded();        //System.out.println("entro al mapaaa");        //createMapView();        this.initFragments();        this.showFragment(MENU1_FRAGMENT, false);        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open,R.string.drawer_close){            @Override            public void onDrawerClosed(View drawerView) {                super.onDrawerClosed(drawerView);                if(getActionBar() != null)                    getActionBar().setTitle("CLOSE :D");            }            @Override            public void onDrawerOpened(View drawerView) {                super.onDrawerOpened(drawerView);                if(getActionBar() != null)                    getActionBar().setTitle("OPEN :D");            }        };        drawerLayout.setDrawerListener(drawerToggle);        //addListenerOnCheckMapa1();    }    public void initFragments(){        FragmentManager manager = getSupportFragmentManager();        fragments = new Fragment[FRAGMENTS];        fragments[MENU1_FRAGMENT] = manager.findFragmentById(R.id.menu1_fragment);        fragments[MENU2_FRAGMENT] = manager.findFragmentById(R.id.menu2_fragment);        fragments[MENU3_FRAGMENT] = manager.findFragmentById(R.id.menu3_fragment);        fragments[MENU4_FRAGMENT] = manager.findFragmentById(R.id.menu4_fragment);        fragments[MENU5_FRAGMENT] = manager.findFragmentById(R.id.menu5_fragment);        fragments[MENU6_FRAGMENT] = manager.findFragmentById(R.id.menu6_fragment);        FragmentTransaction transaction = manager.beginTransaction();        for(int i = 0; i < fragments.length; i++) transaction.hide(fragments[i]);        transaction.commit();    }    public void showFragment(int fragmentIndex, boolean addToBackStack) {        FragmentManager fm = getSupportFragmentManager();        FragmentTransaction transaction = fm.beginTransaction();        for (int i = 0; i < fragments.length; i++) {            if (i == fragmentIndex){                transaction.show(fragments[i]);            }else {                transaction.hide(fragments[i]);            }        }        if (addToBackStack) {            transaction.addToBackStack(null);        }        transaction.commit();    }    private void CargarMapa() {// Configuramos el objeto GoogleMaps con valores iniciales.        if (googleMap == null) {            //Instanciamos el objeto mMap a partir del MapFragment definido bajo el Id "map"            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.gps_fragment)).getMap();            // Chequeamos si se ha obtenido correctamente una referencia al objeto GoogleMap            if (googleMap != null) {                // El objeto GoogleMap ha sido referenciado correctamente                //ahora podemos manipular sus propiedades                //Seteamos el tipo de mapa                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);                googleMap.animateCamera( CameraUpdateFactory.zoomTo( 15.0f ) );                //Activamos la capa o layer MyLocation                googleMap.setMyLocationEnabled(true);            }        }    }//MP1 es el tipo de mapa 1. El Normal    public void addListenerOnCheckMapa1(){        CheckM1=(CheckBox)findViewById(R.id.MP1);        CheckM1.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                if(((CheckBox)v).isChecked()){                   // Toast.makeText(this, CargarMapa(MP1), Toast.LENGTH_LONG).show();                }            }        });    }}