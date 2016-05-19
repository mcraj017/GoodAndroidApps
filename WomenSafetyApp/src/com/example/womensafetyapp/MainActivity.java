package com.example.womensafetyapp;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	ImageButton presshere = null;
	Button gotooptions, addcontacts;

	TextView gpslocation;
	double latitude, longitude;
	GPSTracker gps;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gpslocation = (TextView) findViewById(R.id.gpslocation);
		presshere = (ImageButton) findViewById(R.id.presshere);
		gotooptions = (Button) findViewById(R.id.gotooptions);
		addcontacts = (Button) findViewById(R.id.addcontacts);
		gps = new GPSTracker(MainActivity.this);
		if (gps.canGetLocation() == true) {
			latitude = gps.getLatitude();
			longitude = gps.getLongitude();
		}

		gpslocation
				.setText("your location is \n" + longitude + "  " + latitude);

		presshere.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				SharedPreferences mPref = getSharedPreferences("contacts",
						Context.MODE_PRIVATE);
				int count = mPref.getInt("count", 1);

				if (count <= 1) {
					Toast.makeText(getApplicationContext(), "No number exist",
							Toast.LENGTH_LONG).show();
				} else {
					for (int i = 1; i < count; i++) {
						String number = mPref.getString("contact" + i, "00");
						sendSMS(number,
								"Please help!!! and call as soon as possible and My Location is "
										+ latitude + "  " + longitude);
						Toast.makeText(getApplicationContext(),
								"Location Sent", Toast.LENGTH_LONG).show();
					}
				}
			}
		});

		gotooptions.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentR = new Intent(getApplicationContext(),
						OptionsActivity.class);
				startActivity(intentR);
			}
		});
		addcontacts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentR = new Intent(getApplicationContext(),
						SecondMainActivity.class);
				startActivity(intentR);
			}
		});
	}

	private void sendSMS(String phoneNumber, String message) {
		// PendingIntent pi = PendingIntent.getActivity(this, 0,
		// new Intent(this, MainActivity.class), 0);
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, null, null);
	}
}
