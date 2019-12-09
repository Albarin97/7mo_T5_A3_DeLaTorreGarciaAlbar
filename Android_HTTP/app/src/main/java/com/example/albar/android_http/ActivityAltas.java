package com.example.albar.android_http;

import android.content.Context;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAltas extends Activity{
    EditText cajaNumControl, cajaNombre, cajaPrimerAp, cajaSegundoAp, cajaEdad, cajaSemestre, cajaCarrera;

    @override
    protected void onCreate(@Nullable bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        cajaNumControl = findViewById(R.id.caja_num_control);
        //
        //
    }

    public void registrarAlumno(View v){
        String nc = cajaNumControl.getText().toString();
        //
        //
        byte e = Byte.parseByte(cajaEdad.getText().toString());

        //Verificar conexion WIFI
        ConectivityManager cm = (ConectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo():

        if(ni != null && ni.isConnected()){
            //Proceso para enviar peticion HTTP con cadena JSON q contendra los datos del alumno
        }else{
            Toast.makeText(this, "Error en WIFI", Toast.LENGTH_LONG).show();
            Log.i("MSG =>", "Error de WIFI");
        }
    }

}
