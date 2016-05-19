package com.example.womensafetyapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PhoneNumberActivity extends Activity {

	ListView number; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_number);
		
		number = (ListView) findViewById(R.id.number);
		SharedPreferences mPref = getSharedPreferences("contacts", Context.MODE_PRIVATE);
		int count = mPref.getInt("count", 1);
		if(count<=1){
			Toast.makeText(getApplicationContext(), "No phone numbers added", Toast.LENGTH_LONG).show();
			finish();
		}

		final ArrayList<String> numbers = new ArrayList<String>();
			 
			for (int i =1;i < count;i++)
			{
				numbers.add(mPref.getString("contact"+i, "00"));
			}
		 
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  
				      android.R.layout.simple_list_item_1, 
				      numbers);
			number.setAdapter(adapter);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
