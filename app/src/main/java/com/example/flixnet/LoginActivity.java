package com.example.flixnet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity
{
    private Button btnLog, btnReg; //Creación de los botonos

    public final int COD_REGISTRO=666; //Establecer código de resgistro

    private FirebaseAuth fbauth;

    private FirebaseDatabase fbdatabase;

    private EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Obtenemos una instancia de FB
        fbauth=FirebaseAuth.getInstance();

        // obtener una referencia a cada componente
        btnLog = findViewById(R.id.btnLogin);
        btnReg = findViewById(R.id.btnRegister);
        email=findViewById(R.id.userName);
        pass=findViewById(R.id.passWord);

        // definimos escuchador para el botón LOGIN

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Guardamos en variable el email y password que el usuario introduce.
                String ema = email.getText().toString();
                String pas = pass.getText().toString();

                //Logueamos
                fbauth.signInWithEmailAndPassword(ema,pas)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if(task.isSuccessful()){
                                    //Login completado,
                                    //Obtener info del usuario
                                    FirebaseUser usuario = fbauth.getCurrentUser();

                                    //Obtener uid del usuario logeado
                                    String uid=fbauth.getCurrentUser().getUid();


                                    //Obtener una instacncia de FBData
                                   // fbdatabase = FirebaseDatabase.getInstance();
                                    Log.i("joer",uid);
                                    //Obtener una referencia al usuario logueado
                                    /*fbdatabase.getReference("usuarios/" + uid)
                                            .addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                    Log.i("JOER", "HEllo...." );
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                                    Log.i("JOER", "Goodbye...." );
                                                }
                                            });*/






                                }else{
                                    //Error en el Login
                                    Toast toast2 =
                                            Toast.makeText(getApplicationContext(),
                                                    "No login: ", Toast.LENGTH_SHORT);
                                    Log.i("JOER",task.getException().getMessage()) ;

                                    toast2.show();


                                }
                            }
                        });

                //SNACKBAR
                //Snackbar snack;

                //snack=Snackbar.make(v,"Realizando login",Snackbar.LENGTH_INDEFINITE); //Creación del snackbar
                                  //vista          mensaje            duración

                //snack.setAction(getResources().getText(R.string.label_ok), new View.OnClickListener()
                //{
                 //   @Override
                   // public void onClick(View view) { }
                //}) ;

                //Posibles estilos
                //snack.setTextColor(getResources().getColor(R.color.micolor)) ;
                //snack.setBackgroundTint(getResources().getColor(R.color.colorAccent)) ;

                //Mostramos el snackbar
                //snack.show();
            }
        });

        // definimos escuchador para el botón REGISTRO

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
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
