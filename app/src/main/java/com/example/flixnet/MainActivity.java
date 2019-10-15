package com.example.flixnet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{
    private Button btnLog, btnReg; //Creación de los botonos

    public final int COD_REGISTRO=666; //Establecer código de resgistro

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtener una referencia a cada componente
        btnLog = findViewById(R.id.btnLogin);
        btnReg = findViewById(R.id.btnRegister);

        // definimos escuchador para el botón LOGIN

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SNACKBAR
                Snackbar snack;

                snack=Snackbar.make(v,"Realizando login",Snackbar.LENGTH_INDEFINITE); //Creación del snackbar
                                  //vista          mensaje            duración

                snack.setAction(getResources().getText(R.string.label_ok), new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) { }
                }) ;

                //Posibles estilos
                //snack.setTextColor(getResources().getColor(R.color.micolor)) ;
                //snack.setBackgroundTint(getResources().getColor(R.color.colorAccent)) ;

                //Mostramos el snackbar
                snack.show();
            }
        });

        // definimos escuchador para el botón REGISTRO

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                //Empezar la intencion
                //startActivity(intent);
                startActivityForResult(intent,COD_REGISTRO);
            }
        });


    } //fin on Create



    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data)
    {
        if (requestCode==COD_REGISTRO)
        {
            if (resultCode == RESULT_OK)
                Snackbar.make(btnLog, "El registro ha finalizado con éxito.", Snackbar.LENGTH_LONG).show();
            else
                Snackbar.make(btnLog, "El registro se ha cancelado.", Snackbar.LENGTH_LONG).show();
        }

        //
        super.onActivityResult(requestCode, resultCode, data) ;

    } // fin-onActivityResult
}
