package com.example.floris;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
public class acces_floris_json extends MainActivity {
    TextView txt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout rootLayout = new LinearLayout(getApplicationContext());  
        txt = new TextView(getApplicationContext());  
        rootLayout.addView(txt);  
        setContentView(rootLayout);  
        // Définir le texte et appeler la fonction de connexion.  
        txt.setText("Connexion..."); 
        // Appeler la méthode pour récupérer les données JSON
        txt.setText(getServerData(getAll)); 
    }
    // Mettre l'adresse du script PHP
    public static final String getAll = "http://kt.lc/floris/json.php?livraison=all";
    private String getServerData(String returnString) {
        InputStream is = null;
        String result = "";
        // Envoie de la commande http
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(getAll);
            
            // httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            
        }catch(Exception e){
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        // Convertion de la requête en string
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result=sb.toString();
        }catch(Exception e){
            Log.e("log_tag", "Error converting result " + e.toString());
        }
        // Parse les données JSON
        try{
            JSONArray jArray = new JSONArray(result);
            for(int i=0;i<jArray.length();i++){
                JSONObject json_data = jArray.getJSONObject(i);
                // Affichage ID_ville et Nom_ville dans le LogCat
                Log.i("log_tag","ID_ville: "+json_data.getInt("ID_ville")+
                        ", Nom_ville: "+json_data.getString("Nom_ville")
                );
                // Résultats de la requête
                returnString += "\n\t" + jArray.getJSONObject(i); 
            }
        }catch(JSONException e){
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return returnString; 
    }
}