package com.example.floris;

import java.util.ArrayList;
import java.util.List;

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

public class accueil extends Activity {
	
    private String login;
	private String name;
	
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
        
        /* ------- */
        // MENUBAR
        /*final Button ButtonMenu = (Button) findViewById(R.id.ButtonMenu);
        // clic sur le bouton menu
        ButtonMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.v("click", "ButtonMenu");
			}
		});*/
        
        /*final Button ButtonMenu = (Button) findViewById(R.id.ButtonMenu);
        ButtonMenu.setOnClickListener(new OnClickListener() {
      			
        	@Override
	        public void onClick(View v) {
		      	Intent intent = new Intent(accueil.this, MainActivity.class);
		      	startActivity(intent);
	      	}
	    });*/
        
        /*
        final Button ButtonLogout = (Button) findViewById(R.id.ButtonLogout);
        // clic sur le bouton menu
        ButtonLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View R) {
				Log.v("click", "ButtonLogout");
			}
		});*/
        /* ------- */
        
        // Bonjour au nom du livreur
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        name = json.getName(login);
        textView2.setText(name);
        
        // On affiche la liste
     	
        List<listAccueil> maBibliotheque = new ArrayList<listAccueil>();
        /*
        lvListe = (ListView)findViewById(R.id.listelivraison);
        String[] listeStrings = {"France","Allemagne","Russie"};
        lvListe.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listeStrings));*/
    }
}