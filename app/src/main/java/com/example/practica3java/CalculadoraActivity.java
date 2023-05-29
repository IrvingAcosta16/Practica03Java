package com.example.practica3java;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraActivity extends AppCompatActivity {

    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;
    private Button btnLimpiar;
    private Button btnAbandonar;

    private EditText txtNum1;
    private EditText txtNum2;
    private TextView lblResultado;
    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        iniciarComponentes();

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSumar();
            }
        });
        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRestar();
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMultiplicar();
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDividir();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });
        btnAbandonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAbandonar();
            }
        });
    }

    private void iniciarComponentes() {
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnDividir = findViewById(R.id.btnDividir);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnAbandonar = findViewById(R.id.btnAbandonar);

        lblResultado = findViewById(R.id.lblResultado);
        calculadora = new Calculadora(0, 0);
    }

    private void btnSumar() {
        String num1 = txtNum1.getText().toString();
        String num2 = txtNum2.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones");
        } else {
            double resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
            lblResultado.setText(String.valueOf(resultado));
        }
    }

    private void btnRestar() {
        String num1 = txtNum1.getText().toString();
        String num2 = txtNum2.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones");
        } else {
            double resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
            lblResultado.setText(String.valueOf(resultado));
        }
    }

    private void btnDividir() {
        String num1 = txtNum1.getText().toString();
        String num2 = txtNum2.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones");
        } else {
            double num1Value = Double.parseDouble(num1);
            double num2Value = Double.parseDouble(num2);
            if (num2Value != 0) {
                double resultado = num1Value / num2Value;
                lblResultado.setText(String.valueOf(resultado));
            } else {
                mostrarAlerta("Error", "No se puede dividir entre cero");
            }
        }
    }


    private void btnMultiplicar() {
        String num1 = txtNum1.getText().toString();
        String num2 = txtNum2.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            mostrarAlerta("Error", "Primero debes ingresar los números para hacer las operaciones");
        } else {
            double resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
            lblResultado.setText(String.valueOf(resultado));
        }
    }

    private void btnLimpiar() {
        txtNum1.setText("");
        txtNum2.setText("");
        lblResultado.setText("");
    }

    private void btnAbandonar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("¿Deseas regresar?");
        confirmar.setPositiveButton("Confirmar", (dialog, which) -> finish());
        confirmar.setNegativeButton("Cancelar", null);
        confirmar.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
