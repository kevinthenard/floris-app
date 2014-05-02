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

public class livraison extends Activity {
	
    private String id;
    private String adresse;
    private String codepostal;
    private String ville;
    private String pays;
    private String datelivraisonprevue;
	//Resources res = getResources();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // On récupère les variables des vues précédentes
        Intent accueilIntent = getIntent();
        id = accueilIntent.getStringExtra("id");

        // On affiche le contenu de la vue
        setContentView(R.layout.livraison);
        
        /* ------- */
        // MENUBAR
        // To Menu
        final ImageButton ButtonMenu = (ImageButton) findViewById(R.id.ButtonMenu);
        ButtonMenu.setOnClickListener(new OnClickListener() {
        	@Override
	        public void onClick(View v) {
		      	Intent intent = new Intent(livraison.this, accueil.class);
		      	startActivity(intent);
	      	}
	    });
        
        final ImageButton ButtonLogout = (ImageButton) findViewById(R.id.ButtonLogout);
        // Delog
        ButtonLogout.setOnClickListener(new View.OnClickListener() {
        	@Override
	        public void onClick(View v) {
		      	Intent intent = new Intent(livraison.this, MainActivity.class);
		      	startActivity(intent);
	      	}
		});
        /* ------- */
        
        // Modification des infos
        
        final TextView numero_livraison = (TextView) findViewById(R.id.numerolivraison);
        final TextView adresse_view = (TextView) findViewById(R.id.adresse);
        final TextView codepostal_view = (TextView) findViewById(R.id.codepostal);
        final TextView ville_view = (TextView) findViewById(R.id.ville);
        final TextView pays_view = (TextView) findViewById(R.id.pays);
        final TextView datelivraisonprevue_view = (TextView) findViewById(R.id.datelivraisonprevue);
        
        adresse = json.getAdresse(id);
        codepostal = json.getCodePostal(id);
        ville = json.getVille(id);
        pays = json.getPays(id);
        datelivraisonprevue = json.getDateLivraisonPrevue(id);
        
        numero_livraison.setText(id);
        adresse_view.setText(adresse);
        codepostal_view.setText(codepostal);
        ville_view.setText(ville);
        pays_view.setText(pays);
        
        datelivraisonprevue_view.setText(datelivraisonprevue);
    }
}