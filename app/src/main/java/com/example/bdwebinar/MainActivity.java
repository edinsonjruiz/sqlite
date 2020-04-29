package com.example.bdwebinar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText nom, conf, fec, lin;
    Button guardar, listado, eliminar;
 //   Button actualizar, consultar;
    Webinar web;
    WebinarController c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        fec = findViewById(R.id.edtfecha);
        nom = findViewById(R.id.edtnombre);
        conf = findViewById(R.id.edtconferencista);
        lin = findViewById(R.id.edtlink);
        guardar = findViewById(R.id.btnguardar);
        listado = findViewById(R.id.btnlistado);
        eliminar = findViewById(R.id.btneliminar);

      //  actualizar = findViewById(R.id.btnactualizar);
      //  consultar = findViewById(R.id.btnconsultar);

        c = new WebinarController(getApplicationContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web = new Webinar(nom.getText().toString(),conf.getText().toString(),fec.getText().toString(),
                        lin.getText().toString());
                Toast.makeText(getApplicationContext(), web.nombre, Toast.LENGTH_SHORT).show();
                if(!c.buscarWebinar(web.nombre)) {
                    Log.d("Buscar", "No encontrado");
                    long id = c.agregarWebinar(web);
                    Toast.makeText(getApplicationContext(), "Webinar registrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("Buscar", "encontrado");
                    Toast.makeText(getApplicationContext(),"El webinar ya esta registrado",Toast.LENGTH_SHORT).show();
                }

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web = new Webinar(nom.getText().toString(), conf.getText().toString(), fec.getText().toString(),
                        lin.getText().toString());
        Toast.makeText(getApplicationContext(), web.nombre, Toast.LENGTH_SHORT).show();
        if (c.buscarWebinar(web.nombre)) {
            Log.d("Buscar", "Encontrado");
            c.eliminar(web.nombre);
            Toast.makeText(getApplicationContext(), "Webinar Eliminado", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("Buscar", "No encontrado");
            Toast.makeText(getApplicationContext(), "El webinar no fue encontrado", Toast.LENGTH_SHORT).show();
        }

            }
        });

        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(i);
            }
        });

        /*
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c.buscarEstudiante(est.codigo)){
                    Log.e("Buscar", "Entro");
                    c.actualizarEstudiante(est);
                    Toast.makeText(getApplicationContext(), "Estudiante actualizado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Estudiante no existe", Toast.LENGTH_SHORT).show();
                }
            }
        });

        */


    }


}
