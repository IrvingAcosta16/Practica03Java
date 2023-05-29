package com.example.practica3java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnAbandonar;
    private EditText txtUsuario;
    private EditText txtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        btnAbandonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Abandonar(); }
        });
    }

    private void iniciarComponentes() {
        btnLogin = findViewById(R.id.btnLogin);
        btnAbandonar = findViewById(R.id.btnAbandonar);
        txtContraseña = findViewById(R.id.txtContraseña);
        txtUsuario = findViewById(R.id.txtUsuario);
    }


    private void Login() {
        String strUsuario = getResources().getString(R.string.usuario);
        String strContra = getResources().getString(R.string.contraseña);

        if (txtUsuario.getText().toString().equals(strUsuario) && txtContraseña.getText().toString().equals(strContra)) {
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtra("Usuario", strUsuario);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuario o contraseña invalida", Toast.LENGTH_LONG).show();
        }
    }

    private void Abandonar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("¿Deseas regresar?");
        confirmar.setPositiveButton("Confirmar", (dialog, which) -> finish());
        confirmar.setNegativeButton("Cancelar", null);
        confirmar.show();
    }
}






