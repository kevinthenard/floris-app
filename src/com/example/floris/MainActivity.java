package com.example.floris;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends Activity {
	
	private TextView TextMessageErreur = null; // initialisation message d'erreur à vide
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		TextMessageErreur = new TextView(this); // On créé l'objet du message d'erreur
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// On déclare les éléments que l'on va utiliser
        
		final Button BoutonConnect = (Button) findViewById(R.id.button_connect);
        final TextView editText1 = (TextView) findViewById(R.id.editText1);
        final TextView editText2 = (TextView) findViewById(R.id.editText2);
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
		
        
        
        // lors d'un clic sur le bouton du formulaire
        BoutonConnect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View R) {
				// TODO Auto-generated method tub

				
				// ICI ce qu'il se passe quand on clique sur le bouton
				
				if (editText1.length() < 1) {
					textView1.setText("Veuillez remplir le champ de login (email)");
				}else if (editText2.length() < 1) {
					textView1.setText("Veuillez remplir le mot de passe");
				}else{
					// on change de vue
					 boolean resultpassword = json.connectLivreur(editText1.getText().toString(), editText2.getText().toString());

					 if (resultpassword == true) {
						 final String LOGIN = textView1.getText().toString();
							Intent vueAccueil = new Intent(MainActivity.this, accueil.class);
							vueAccueil.putExtra("login", LOGIN ); // pour passer le texte à la prochaine vue
							//startActivity(vueAccueil); // change de vue
							textView1.setText("Good.");
					 }else{
						 textView1.setText("Le login et mot de passe sont faux.");
					 }
					// A RECUPERER DE LA BDD
					
					
				}
	        	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}