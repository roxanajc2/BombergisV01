package com.proyectos.roxana.bombergisv02.view.fragment;

import java.lang.Class;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.proyectos.roxana.bombergisv02.MainActivity;

import com.proyectos.roxana.bombergisv02.R;

public class BottomMenu extends Fragment {

    public  static int BUTTONS = 6;


    public static int BUTTON_NAME_1 = 0;
    public static int BUTTON_NAME_2 = 1;
    public static int BUTTON_NAME_3 = 2;
    public static int BUTTON_NAME_4 = 3;
    public static int BUTTON_NAME_5 = 4;
    public static int BUTTON_NAME_6 = 5;

    private Button [] lsButtons;

    /*Este metodo es solo por si es que necesitas pasarle data al menu, por si aca, te lo dejo xd si no lo vas a usar
    * lo borras, siempre lo pongo en mis fragments, por si aca ñ.ñ */

    public static BottomMenu newInstance(@Nullable Bundle bundle){

        /*Aqui harias algo como Bundle args = new Bundle(), args.putInt("un_valor", value),
        * this.setArguments(args)*/
        return new BottomMenu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view  = inflater.inflate(R.layout.bottom_menu_fragment, container, false);

        if(view != null){

            lsButtons = new Button[BUTTONS];

            lsButtons[BUTTON_NAME_1] = (Button) view.findViewById(R.id.button_name_1);
            lsButtons[BUTTON_NAME_2] = (Button) view.findViewById(R.id.button_name_2);
            lsButtons[BUTTON_NAME_3] = (Button) view.findViewById(R.id.button_name_3);
            lsButtons[BUTTON_NAME_4] = (Button) view.findViewById(R.id.button_name_4);
            lsButtons[BUTTON_NAME_5] = (Button) view.findViewById(R.id.button_name_5);
            lsButtons[BUTTON_NAME_6] = (Button) view.findViewById(R.id.button_name_6);

            this.addEvents();

            return view;

        }else return null;
    }

    private void addEvents(){


        final MainActivity activity = (MainActivity) this.getActivity();

        for(int i = 0; i < 6; ++i){
            final int current_position = i;

            lsButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.showFragment(current_position, false);
                }
            });
        }
    }

}
