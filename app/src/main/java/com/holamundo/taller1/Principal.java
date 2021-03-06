package com.holamundo.taller1;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends Activity {
    //Declaro las variables
    private Spinner material, dije, tipo, moneda;
    private String mat[],dij[],tip[], mon[];
    private EditText cantidad;
    private TextView resp;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturar objetos del layout principal
        material = findViewById(R.id.cmbMaterial);
        dije = findViewById(R.id.cmbDije);
        tipo = findViewById(R.id.cmbTipo);
        cantidad = findViewById(R.id.txtCantidad);
        moneda = findViewById(R.id.cmbMoneda);
        resp = findViewById(R.id.txtResultado);
        //Recursos de la aplicación
        recursos =this.getResources();
        //Capturar los arrays
        mat = recursos.getStringArray(R.array.op_material);
        ArrayAdapter<String> adapterMat = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, mat);
        material.setAdapter(adapterMat);

        dij = recursos.getStringArray(R.array.op_dije);
        ArrayAdapter<String> adapterDij = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, dij);
        dije.setAdapter(adapterDij);

        tip = recursos.getStringArray(R.array.op_tipo);
        ArrayAdapter<String> adapterTip = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, tip);
        tipo.setAdapter(adapterTip);

        mon = recursos.getStringArray(R.array.op_moneda);
        ArrayAdapter<String> adapterMon = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, mon);
        moneda.setAdapter(adapterMon);
    }

    public void cotizar(View v){
        int op_mat=material.getSelectedItemPosition();
        int op_dij=dije.getSelectedItemPosition();
        int op_tip=tipo.getSelectedItemPosition();
        int cant = Integer.parseInt(cantidad.getText().toString());
        int op_mon=moneda.getSelectedItemPosition();
        int total = 0;
        if (op_mat==1){
            if (op_dij==1){
                if (op_tip==1 || op_tip==2){
                    total = Metodos.calcular(cant,100, op_mon);
                }
                if (op_tip==3){
                    total = Metodos.calcular(cant, 80, op_mon);
                }
                if (op_tip==4){
                    total = Metodos.calcular(cant, 70, op_mon);
                }
            }
            if (op_dij==2){
                if (op_tip==1 || op_tip==2){
                    total = Metodos.calcular(cant,120, op_mon);
                }
                if (op_tip==3){
                    total = Metodos.calcular(cant, 100, op_mon);
                }
                if (op_tip==4){
                    total = Metodos.calcular(cant, 90, op_mon);
                }
            }
        }
        if (op_mat==2){
            if (op_dij==1){
                if (op_tip==1 || op_tip==2){
                    total = Metodos.calcular(cant,90, op_mon);
                }
                if (op_tip==3){
                    total = Metodos.calcular(cant, 70, op_mon);
                }
                if (op_tip==4){
                    total = Metodos.calcular(cant, 50, op_mon);
                }
            }
            if (op_dij==2){
                if (op_tip==1 || op_tip==2){
                    total = Metodos.calcular(cant,110, op_mon);
                }
                if (op_tip==3){
                    total = Metodos.calcular(cant, 90, op_mon);
                }
                if (op_tip==4){
                    total = Metodos.calcular(cant, 80, op_mon);
                }
            }
        }
        resp.setText("El valor total de su consulta es de: " + total + moneda.getSelectedItem());
    }


}
