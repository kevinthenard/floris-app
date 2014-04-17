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

public class accueil extends Activity {
	Intent vueAccueil = getIntent();
	
	private String login;
	private TextView message_accueil_nom;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accueil);
		
		//message_accueil_nom = (TextView) findViewById(R.id.message_accueil_nom);
		
		login = vueAccueil.getStringExtra("login");
		message_accueil_nom.setText(login);
	}
}