package com.helloworld_danielsalas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView tv_count;
    private String datoGuardado = "datoGuardado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_count = findViewById(R.id.tv_count);

    }

    /*
    Método que graba el estado de la aplicación cuando esta sufra un cambio de estado
    o sea destruida y vuelta formar en un giro de pantalla
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(datoGuardado, Integer.toString(contador));
    }

    /*
    Este método recupera los datos guardados en el método onSaveInstanceState()
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = Integer.parseInt(savedInstanceState.getString(datoGuardado));
        tv_count.setText(Integer.toString(contador));
    }

    public void pulsarToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void pulsarCount(View view) {
        contador++;
        tv_count.setText(Integer.toString(contador));

    }

    public void ponerACero(View view) {
        contador = 0;
        tv_count.setText(Integer.toString(contador));
    }
}