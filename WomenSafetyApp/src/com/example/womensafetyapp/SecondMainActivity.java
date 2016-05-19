package com.example.womensafetyapp;

import android.support.v7.app.ActionBarActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SecondMainActivity extends ActionBarActivity{

	Button add, shownumbers, clearcontacts;
	EditText phonenumber;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_main);

		add = (Button) findViewById(R.id.addphonenumber);
		
		shownumbers = (Button) findViewById(R.id.gotonumbers);
		
		clearcontacts = (Button) findViewById(R.id.clearnumbers);

		phonenumber = (EditText) findViewById(R.id.phonenumber);

		
		shownumbers.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentR = new Intent(getApplicationContext(),
						PhoneNumberActivity.class);
				startActivity(intentR);
			}
		});
		clearcontacts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				getSharedPreferences("contacts",
						0).edit().clear().commit();
				Toast.makeText(getApplicationContext(),
						"All contacts has been removed", Toast.LENGTH_LONG).show();
			}
		});
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SharedPreferences mPref = getSharedPreferences("contacts",
						Context.MODE_PRIVATE);
				int count = mPref.getInt("count", 1);

				String number = (String) phonenumber.getText().toString();
				if (number == null) {
					Toast.makeText(getApplicationContext(),
							"Enter phone number", Toast.LENGTH_LONG).show();
				} else {
					mPref.edit().putString("contact" + count, number).commit();
					count++;
					mPref.edit().putInt("count", count).commit();
					Toast.makeText(getApplicationContext(),
							"phone number added", Toast.LENGTH_LONG).show();
					finish();
				}
			}
		});
	}

}
