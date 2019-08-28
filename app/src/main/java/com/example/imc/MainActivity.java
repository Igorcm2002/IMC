package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final float[] imc = new float[1];
        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView img = findViewById(R.id.imageView);
                img.setImageResource(R.drawable.perfil);
                TextView editPeso = (TextView) findViewById(R.id.editPeso);
                TextView editAltura = (TextView) findViewById(R.id.editAltura);
                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                TextView tvDescricao = (TextView) findViewById(R.id.tvDescricao);
                int peso = Integer.parseInt(editPeso.getText().toString());
                float altura = Float.parseFloat(editAltura.getText().toString());
                imc[0] = peso / (altura * altura );
                if(imc[0]<18.5) {
                    tvResultado.setText(imc[0] + "");
                    tvDescricao.setText("Está Abaixo do Peso");
                    img.setImageResource(R.drawable.abaixopeso);
                }else{
                    if(imc[0]<25) {
                        tvResultado.setText(imc[0] + "");
                        tvDescricao.setText("Está Com o Peso Ideal ");
                        img.setImageResource(R.drawable.normal);
                    }else{
                        if(imc[0]<30) {
                            tvResultado.setText(imc[0] + "");
                            tvDescricao.setText("Está Acima do peso");
                            img.setImageResource(R.drawable.sobrepeso);
                    }else{
                            if(imc[0]<30) {
                                tvResultado.setText(imc[0] + "");
                                tvDescricao.setText("Está Com Obesidade 1");
                                img.setImageResource(R.drawable.obesidade1);

                            }else{
                                if(imc[0]<39) {
                                    tvResultado.setText(imc[0] + "");
                                    tvDescricao.setText("Está Com Obesidade 2");
                                    img.setImageResource(R.drawable.obesidade2);

                                }else{
                                    if(imc[0]>=40) {
                                        tvResultado.setText(imc[0] + "");
                                        tvDescricao.setText("Está Com Obesidade 3");
                                        img.setImageResource(R.drawable.obesidade3);
                            }
                        }
                    }
                }
            };
            };
        };
    } );
    }
}