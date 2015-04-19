package com.proyectos.roxana.bombergisv01.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyectos.roxana.bombergisv01.R;

public class GPS extends Fragment {

    /* Aqui va todo lo que tenga que contener tu mapa de google :v */

    public GPS newInstace(@Nullable Bundle bundle){
        return new GPS();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.gps_fragment, container, false);
        return (view == null)? null : view;

    }
}
