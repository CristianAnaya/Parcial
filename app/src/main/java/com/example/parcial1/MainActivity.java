package com.example.parcial1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    EditText edtPension, edtSalario, edtEmpleado, edtValorExtra, edtHorasExtras, edtSalud, edtSalarioTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPension = findViewById(R.id.edtPension);
        edtSalario = findViewById(R.id.edtSalario);
        edtEmpleado = findViewById(R.id.edtEmpleado);
        edtValorExtra = findViewById(R.id.edtValorExtra);
        edtHorasExtras = findViewById(R.id.edtHorasExtras);
        edtSalud = findViewById(R.id.edtSalud);
        edtSalarioTotal = findViewById(R.id.edtSalarioTotal);

        btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int salario = Integer.valueOf(edtSalario.getText().toString());
                int valorExtras =  Integer.valueOf(edtValorExtra.getText().toString());
                int horasExtras = Integer.valueOf(edtHorasExtras.getText().toString());

                int salarioBase = salario + (horasExtras * valorExtras);
                int pension = (int) (salarioBase * 0.04);
                int salud = (int) (salarioBase * 0.04);

                salarioBase = salarioBase - (pension + salud);

                edtSalud.setText(String.valueOf(salud));
                edtPension.setText(String.valueOf(pension));
                edtSalarioTotal.setText(String.valueOf(salarioBase));


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {

            case R.id.btnSalarioMinimo:
                    edtSalario.setText(String.valueOf(877803));
                break;
            case R.id.btnLimpiar:
                edtSalario.setText("");
                edtEmpleado.setText("");
                edtHorasExtras.setText("");
                edtPension.setText("");
                edtSalarioTotal.setText("");
                edtSalud.setText("");
                edtValorExtra.setText("");
                break;

        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}