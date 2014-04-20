package com.example.floris;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;

public class accueil extends Activity {
	
    private String login;
	private String name;
	
	//Resources res = getResources();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On récupère les variables des vues précédentes
        Intent MainActivityIntent = getIntent();
        login = MainActivityIntent.getStringExtra("login");
        
        // On affiche le contenu de la vue
        setContentView(R.layout.accueil);
        
        // Bonjour au nom du livreur
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        name = json.getName(login);
        textView2.setText(name);     
    }
}