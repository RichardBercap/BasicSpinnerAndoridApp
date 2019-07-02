package com.example.bercap.basuic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.content.Context;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   // Button boton;

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   boton = (Button) findViewById(R.id.button);
       // boton.setOnclickListener(this);
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, "Hello Richard", duration);
        toast.show();


        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);

        tv1 = (TextView) findViewById(R.id.textResultado);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String[] options ={"Sumar","Restar","Multiplicar","Dividir"};
    // context is in where activity shows
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(context, R.layout.spinner_item_richard, options);
        spinner1.setAdapter(adapter); // push in spinner the options created
    }

    //method of bottom
    public void Calcular(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1);
        int valor2_int = Integer.parseInt(valor2);

        String selection = spinner1.getSelectedItem().toString();

        if (selection.equals("Sumar")){
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        }else if (selection.equals("Restar")){
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }else if (selection.equals("Multiplicar")){
            int multi = valor1_int * valor2_int;
            String resultado = String.valueOf(multi);
            tv1.setText(resultado);
        }else if (selection.equals("Dividir")){

            if(valor2_int !=0){
                int div = valor1_int / valor2_int;
                String resultado = String.valueOf(div);
                tv1.setText(resultado);
            }else{
                int duration = Toast.LENGTH_SHORT;
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Cant Resolve", duration);
                toast.show();
            }

        }
    }

}
