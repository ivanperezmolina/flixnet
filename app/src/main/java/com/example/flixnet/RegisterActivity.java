package com.example.flixnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    //Declaramos las variables con la herramienta BindView

    @BindView(R.id.userName)
    public EditText userName;

    @BindView(R.id.name)
    public EditText name;

    @BindView(R.id.apellidos)
    public EditText apellidos;

    @BindView(R.id.passWord)
    public EditText passWord;

    @BindView(R.id.confiPassWord)
    public EditText confiPassWord;

    @BindView(R.id.spinner)
    public Spinner pais;

    @BindView(R.id.btnOkRegister)
    public Button btnOkRegister;

    @BindView(R.id.btnCancel)
    public Button btnCancel;

    //FB
    private FirebaseAuth fbauth ;
    private FirebaseDatabase fbdatabase ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Bindeamos la actividad con ButterKnife
        ButterKnife.bind(this) ;

        //Obtenemos la instancia de FirebaseAuth
        fbauth = FirebaseAuth.getInstance() ;

        //Obtenemos la instancia de FirebaseDatabase
        fbdatabase =  FirebaseDatabase.getInstance() ;

        //#################################################################
        // instanciar la vista
        //email     = findViewById(R.id.regEmail) ;
        //btnReg    = findViewById(R.id.regRegister) ;
        //btnCancel = findViewById(R.id.regCancel) ;

        // añadimos elementos al spinner de manera programática
        // creamos un array con la información que queremos mostrar en
        // el spinner. Podemos utilizar un array o una lista.
        /*String[] paises = new String[] {
                "España", "Italia", "Reino Unido", "Alemania", "Francia"
        } ;*/
        //#################################################################

        List<String> lista = new ArrayList<String>()
        {{
            add("España") ;
            add("Italia") ;
            add("Reino Unido") ;
            add("Alemania") ;
            add("Francia") ;
        }}   ;


        // creamos un adatador para el spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lista) ;

        // asociamos el adaptador al spinner
        pais.setAdapter(adaptador) ;


        //#################################################################################
        /*pais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int i, long l)
            {
                Snackbar.make(view, "Seleccionado: " + i, Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });*/
        //#################################################################################

        //Escuchador botón cancelar
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cancelamos el proceso y regresamos a la actividad anterior
                setResult(RESULT_CANCELED) ;
                finish() ;

                return ;
            }
        });//Fin escuchador btn Cancel

        btnOkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el valor de los campos del formulario

            }
        });//Fin escuchador btnOkRegister

    }//FIN ON-CREATE
}
