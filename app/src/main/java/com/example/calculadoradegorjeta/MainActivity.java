package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private SeekBar seekGorjeta;
    private TextView textGorjeta;
    private TextView textTotal;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editValor           = findViewById(R.id.editValor);
        textPorcentagem     = findViewById(R.id.textPorcentagem);
        seekGorjeta         = findViewById(R.id.seekBarGorjeta);
        textGorjeta         = findViewById(R.id.campoGorjeta);
        textTotal           = findViewById(R.id.campoTotal);

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcula();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






}
    public void calcula(){

        String valorRecuperado = editValor.getText().toString();

        if ( valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_LONG).show();

        }else {
            //CONVERTENDO STRING PSRA DOUBLE
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //CALCULAR A GORJETA TOTAL
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            //EXIBIR A GORJETA TOTAL
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + Math.round(total));

        }
    }

}