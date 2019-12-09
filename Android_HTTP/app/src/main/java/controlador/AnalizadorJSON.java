package controlador;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class AnalizadorJSON {

    InputStream is = null;
    OutputStream os = null;
    JSONObject jsonObject = null;

    //Metodo para ejecutar la instruccion DML (ABCC)
    public JSONObject peticionHTTP(String url, String metodo, Map datos){
        HttpURLConnection conexion = null;
        URL nUrl = null;

        try{
            String cadenaJSON="{\"nc\":\""+URLEncoder.encode(datos.get("nc"), "UTF-8")+"\", \"n\":\" ";

            Log.d("MSJ =>", cadenaJSON);

            nUrl = new URL(url);

            conexion = (httpURLConnection) nUrl.openConnection();

            conexion.setDoOutput(true);
            conexion.setRequestMethod(metodo);

            conexion.setFixedLengthStreamingMode(cadenaJSON.getByte().length);

            conexion.setRequestProperty("Content-Type", "appLication/x-www-forms-urlencoder");

            os. = new BufferedOutputStream(conexion.getOutputStream());

            os.write(cadenaJSON.getBytes());
            os.flush();
            os.close();

        }catch (UsupportedEncodingException e){
            Log.e("MSJ=>", "Error de codificacion");
        }

        try{
            is = new BufferedInputStream(conexion.getInputStream());

            BufferedReader br = new Bufferedreader(new InputStreamReader(is));
            StringBuilder cadena = new StringBuilder();

            String fila = "";

            while((fila = br.readLine()) != null){
                cadena.append(fila + "\n");
            }
            is.close();

            String cadenaJSONrecibida = cadena.toString();
        }

        try{
            jsonObject = new JSONObject(cadenaJSONrecibida);
        }
        return null;
    }
}
