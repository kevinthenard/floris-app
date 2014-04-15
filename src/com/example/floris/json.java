package com.example.floris;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class json extends acces_floris_json {

	int ID = 1;
	String toto = "toto";
	String[] items;
	String[] itemsByID;
	String message;
	
	
	public int getID() {
		return ID;
	}
	public String[] getAllLivraisons() {
		items = new String[] { "Vegetables","Fruits","Flower Buds","Legumes","Bulbs","Tubers" };
		return items;
		
	}
	public String[] getLivraisonsByID(int iD) {
		itemsByID = new String[] { "Vegetables2","Fruits2","Flower Buds2","Legumes2" };
		return itemsByID;
	}
	public void setMessageLivraisonsByID(int iD, String Message) {
		message = Message;
	}
	public static boolean connectLivreur(String nom, String mdp) {
		//http://kt.lc/floris/json.php?livreur=1&nom=livreur1@floris.fr&passmd5=ab4f63f9ac65152575886860dde480a
		Log.v("String", "nom " + nom + " mdp " + mdp);
		
		if (nom.equals("toto") && mdp.equals("titi")) {
			
			
			//Context context = getApplicationContext();
			// "nom " + nom + " mdp " +mdp;
			/*CharSequence text = "Hello toast!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();*/
			
			Log.v("String2", "nom " + nom + " mdp " + mdp);
			
			return true;
		}else{
			return false;
		}
	}
	
}
