package com.example.floris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.floris.MainActivity;
import com.example.floris.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class accueil extends Activity {
	
    private String login;
	private String name;
	
	/* Variables Liste */
	
	ListView id;
	ListView code_client;
	ListView date_livraison_estime;
	ListView list;

	Button Btngetdata;
	ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
	
	//URL to get JSON Array
	private static String url = "http://kt.lc/floris/json.php?livraison=all";
	
	//JSON Node Names 
	private static final String TAG_LIV = "livraison";
	private static final String TAG_ID = "id";
	private static final String TAG_CC = "code_client";
	private static final String TAG_DLE = "date_livraison_estime";
	JSONArray android = null;
	
	/* Fin Variables Liste*/
	
	ListView lvListe;
	//Resources res = getResources();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // On récupère les variables des vues précédentes
        Intent MainActivityIntent = getIntent();
        login = MainActivityIntent.getStringExtra("login");
        
        // On affiche le contenu de la vue
        setContentView(R.layout.accueil);
        
        oslist = new ArrayList<HashMap<String, String>>();

        Btngetdata = (Button)findViewById(R.id.getdata);
        Btngetdata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
		         new JSONParse().execute();
			}
		});
        /* ------- */
        // MENUBAR
        // To Menu        
        ImageButton ButtonLogout = (ImageButton) findViewById(R.id.ButtonLogout);
        // Delog
        ButtonLogout.setOnClickListener(new View.OnClickListener() {
        	@Override
	        public void onClick(View v) {
		      	Intent intent = new Intent(accueil.this, MainActivity.class);
		      	startActivity(intent);
	      	}
		});
        /* ------- */
        // Bonjour au nom du livreur
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        name = json.getName(login);
        textView2.setText(name);
	}
	private class JSONParse extends AsyncTask<String, String, JSONObject> {
   	 private ProgressDialog pDialog;
   	@Override
       protected void onPreExecute() {
           super.onPreExecute();
           // A MODIFIER
           id = (ListView)findViewById(R.id.id);
			code_client = (ListView)findViewById(R.id.cc);
			date_livraison_estime = (ListView)findViewById(R.id.dle);
			 
           pDialog = new ProgressDialog(accueil.this);
           pDialog.setMessage("Chargement ...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(true);
           pDialog.show();
   	}
   	
   	@Override
       protected JSONObject doInBackground(String... args) {
   		JSONParser jParser = new JSONParser();
   		// Getting JSON from URL
   		JSONObject json = jParser.getJSONFromUrl(url);
   		return json;
   	}
   	 @Override
        protected void onPostExecute(JSONObject json) {
   		 pDialog.dismiss();
   		 try {
   				// Getting JSON Array from URL
   				android = json.getJSONArray(TAG_LIV);
   				for(int i = 0; i < android.length(); i++){
   				JSONObject c = android.getJSONObject(i);
   				
   				// Storing  JSON item in a Variable
   				String id = c.getString(TAG_ID);
   				String cc = c.getString(TAG_CC);
   				String dle = c.getString(TAG_DLE);

   				// Adding value HashMap key => value
   				
   				HashMap<String, String> map = new HashMap<String, String>();

   				map.put(TAG_ID, id);
   				map.put(TAG_CC, cc);
   				map.put(TAG_DLE, dle);
   				
   				oslist.add(map);
   				list=(ListView)findViewById(R.id.list);
   				
   				ListAdapter adapter = new SimpleAdapter(accueil.this, oslist,
   						R.layout.list_v,
   						new String[] { TAG_ID, TAG_CC, TAG_DLE }, new int[] {
   								R.id.id,R.id.cc, R.id.dle});

   				list.setAdapter(adapter);
   				list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

   		            @Override
   		            public void onItemClick(AdapterView<?> parent, View view,
   		                int position, long id) {
			                //Toast.makeText(accueil.this, "You Clicked at "+oslist.get(+position).get("id"), Toast.LENGTH_SHORT).show();
			                // Changement de vue
							Intent vueLivraison = new Intent(accueil.this, livraison.class);
							vueLivraison.putExtra("id", oslist.get(+position).get("id") ); // pour passer le texte à la prochaine vue
							Log.i("unID", oslist.get(+position).get("id"));
							startActivity(vueLivraison); // change de vue
   		            	}
   		        	});
   			}
   		} catch (JSONException e) {
   			e.printStackTrace();
   		}
   	 }
   }
}