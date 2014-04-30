package com.example.floris;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("NewApi")
public class json extends acces_floris_json {

	int ID = 1;
	String[] items;
	String[] itemsByID;
	String message;
	static String result = "false";
	
	public static String getAdresse(String id) {
		try {
        	
        	// http://kt.lc/floris/json.php?getnamebyid=1&email=livreur1@floris.fr
        	String myurl = "http://kt.lc/floris/json.php?getadressebyid=1&id="+id;

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* ajouté */
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); /* ajouté */
            connection.connect();
            
            InputStream inputStream = connection.getInputStream();
            result = InputStreamOperations.InputStreamToString(inputStream);
            
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
	}
	public static String getCodePostal(String id) {
		try {
        	// http://kt.lc/floris/json.php?getcpbyid=1&email=livreur1@floris.fr
        	String myurl = "http://kt.lc/floris/json.php?getcpbyid=1&id="+id;

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* ajouté */
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); /* ajouté */
            connection.connect();
            
            InputStream inputStream = connection.getInputStream();
            result = InputStreamOperations.InputStreamToString(inputStream);
            
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
	}
	public static String getVille(String id) {
		try {
        	// http://kt.lc/floris/json.php?getvillebyid=1&email=livreur1@floris.fr
        	String myurl = "http://kt.lc/floris/json.php?getvillebyid=1&id="+id;
            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* ajouté */
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); /* ajouté */
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            result = InputStreamOperations.InputStreamToString(inputStream);
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
	}
	public static String getPays(String id) {
		try {
        	// http://kt.lc/floris/json.php?getpaysbyid=1&email=livreur1@floris.fr
        	String myurl = "http://kt.lc/floris/json.php?getpaysbyid=1&id="+id;

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* ajouté */
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); /* ajouté */
            connection.connect();
            
            InputStream inputStream = connection.getInputStream();
            result = InputStreamOperations.InputStreamToString(inputStream);
            
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
	}
	public static String getDateLivraisonPrevue(String id) {
		try {
        	// http://kt.lc/floris/json.php?getpaysbyid=1&email=livreur1@floris.fr
        	String myurl = "http://kt.lc/floris/json.php?getdatelivraisonbyid=1&id="+id;

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* ajouté */
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); /* ajouté */
            connection.connect();
            
            InputStream inputStream = connection.getInputStream();
            result = InputStreamOperations.InputStreamToString(inputStream);
            
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
	}
    
    
	public static String getName(String email) {
		try {
        	
        	// http://kt.lc/floris/json.php?getnamebyid=1&email=livreur1@floris.fr
        	String myurl = "http://kt.lc/floris/json.php?getnamebyid=1&email="+email;

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* ajouté */
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy); /* ajouté */
            connection.connect();
            
            InputStream inputStream = connection.getInputStream();
            // Result contient le boolean : true = session, false = combo log/mdp faux.
            result = InputStreamOperations.InputStreamToString(inputStream);
            
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
        }
	}
	public static String md5(String s) {
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();

	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i=0; i<messageDigest.length; i++)
	            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
	        return hexString.toString();

	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	
	public int getID() {
		return ID;
	}
	public void setMessageLivraisonsByID(int iD, String Message) {
		message = Message;
	}
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	public static boolean connectLivreur(String nom, String mdp) {

			ArrayList<String> personnes = new ArrayList<String>();
	        try {
	        	
	        	// http://kt.lc/floris/json.php?livreur=1&nom=livreur1@floris.fr&passmd5=ab4f63f9ac65152575886860dde480a1
	        	String password = md5(mdp);
	        	String myurl = "http://kt.lc/floris/json.php?livreur=1&nom="+nom+"&passmd5="+password;
	        	
	        	// String myurl= "http://www.exemple.com/getPersonnes";

	            URL url = new URL(myurl);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            /* ajouté */
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        	StrictMode.setThreadPolicy(policy); /* ajouté */
	            connection.connect();
	            
	            InputStream inputStream = connection.getInputStream();
	            // Result contient le boolean : true = session, false = combo log/mdp faux.
	            result = InputStreamOperations.InputStreamToString(inputStream);
	            
	            // on teste result s'il est true ou false
	            int test = result.indexOf("true");
	            
	    		if (test>=0) {
	    			Log.v("return", "true");
	    			return true;
	    		} else {
	    			Log.v("return", "false");
	    			return false;
	    		}
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
}