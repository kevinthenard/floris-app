package com.example.floris;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class listAccueil {
	
	private String numerolivraison;
    private String ville;
 
    public void Livre(String numerolivraison, String ville) {
        this.numerolivraison = numerolivraison;
        this.ville = ville;
    }
 
    public String getnumerolivraison() {
        return numerolivraison;
    }
 
    public String getVille() {
        return ville;
    }
    /*private void RemplirLaBibliotheque() {
        maBibliotheque.clear();
        maBibliotheque.add(new listAccueil("Starcraft 2 : Les diables du ciel", "William-C Dietz"));
        maBibliotheque.add(new listAccueil("L'art du développement Android", "Mark Murphy"));
        maBibliotheque.add(new listAccueil("Le seuil des ténèbres", "Karen Chance"));
    }*/
	
}
