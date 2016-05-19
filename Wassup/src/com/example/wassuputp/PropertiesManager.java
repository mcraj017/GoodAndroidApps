package com.example.wassuputp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class PropertiesManager{
	public String getDescription(String Key,Context context)
	{
		Resources resources = context.getResources();
		AssetManager assetManager = resources.getAssets();
		Properties properties = new Properties();
    		try {
    		    InputStream inputStream = assetManager.open("events_description.properties");
    		    properties.load(inputStream);
    		} catch (IOException e) {
    		    return"Failed to open events property file";
    		} 	

try{
    	String value = properties.getProperty(Key);
    	if (value==null)
    		value = properties.getProperty(Key.toUpperCase());
    	String summary = "<html><p>"+ value+"</p></html>";
    	//System.out.println(Key+"=>"+value);
    	
    	if(value == null)
    		return "No Description";
    	else
    		return summary;
    		
}
catch(NullPointerException npe)
{
	return "No Description";
}
	}
	
	
	public HashSet<String> searchProperties(String query,Context context)
	{
		HashSet<String> results = new HashSet<String>();
		Resources resources = context.getResources();
		AssetManager assetManager = resources.getAssets();
		Properties properties = new Properties();
    		try {
    		    InputStream inputStream = assetManager.open("events_description.properties");
    		    properties.load(inputStream);
    		} catch (IOException e) {
    		    e.printStackTrace();
    		} 	
    		
    		for(String key : properties.stringPropertyNames()) {
    			  String value = properties.getProperty(key);
    			  if(value.toLowerCase().contains(query.toLowerCase()))
    				  results.add(key);
    			  if(key.toLowerCase().contains(query.toLowerCase()))
    				  results.add(key);
    			}
    		
    		
		return results;
	}

}
