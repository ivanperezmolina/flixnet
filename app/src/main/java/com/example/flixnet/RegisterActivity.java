package com.example.flixnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister, btnCancel;

    public final int COD_CANCEL = 777;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // obtener una referencia a cada componente
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);






        btnCancel.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view)
        {
            // cancelamos el proceso y regresamos a la actividad anterior
            setResult(RESULT_CANCELED);
            finish();

            return;
        }
    });

      btnRegister.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              setResult(RESULT_OK);
              finish();

              return;
          }
      });


}
}
