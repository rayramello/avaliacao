package com.centec.appcalcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int peso;

    float altura;

    String mensagem = "";

    float imc;

    EditText etPeso, etAltura;

    TextView tvResultado;

    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        btCalcular = (Button) findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peso = Integer.parseInt(etPeso.getText().toString());
                altura = Float.parseFloat(etAltura.getText().toString());

                imc = peso / (altura*altura);

                if (imc < 18.5){
                    mensagem = "Abaixo do peso normal";
                } else if ((imc >= 18.5 ) && (imc < 24.9)) {
                    mensagem = "Peso normal";
                } else if ((imc >= 25) && (imc <29.9)) {
                    mensagem = "Excesso de peso";
                } else if ((imc >= 30) && (imc <34.9)) {
                    mensagem = "Obesidade classe 1";
                } else if ((imc >= 35) && (imc <39.9)) {
                    mensagem = "Obesidade classe 2";
                } else if (imc >= 40) {
                    mensagem = "Obesidade classe 3";
                }
                tvResultado.setText("IMC: " + String.valueOf(imc)+ "\nMensagem: "+ mensagem);

            }
        });
    }
}