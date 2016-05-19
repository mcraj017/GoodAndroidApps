package com.example.learnmandarin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class LearnActivity extends Activity {
	private ImageButton Colorbtn, Numeracybtn, Shapebtn, Familybtn, Bodybtn,Basiccommbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn);
		Colorbtn = (ImageButton) findViewById(R.id.Colorbtn);
		Numeracybtn = (ImageButton) findViewById(R.id.Numeracybtn);
		Shapebtn = (ImageButton) findViewById(R.id.Shapebtn);
		Familybtn = (ImageButton) findViewById(R.id.MyFamilybtn);
		Bodybtn = (ImageButton) findViewById(R.id.MyBodybtn);
		Basiccommbtn = (ImageButton) findViewById(R.id.Basicbtn);

		Colorbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						ColorActivity.class);
				startActivity(intentLearn);
			}
		});

		Numeracybtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						NumeracyActivity.class);
				startActivity(intentLearn);
			}
		});
		Shapebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						ShapeActivity.class);
				startActivity(intentLearn);
			}
		});
		Familybtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						FamilyActivity.class);
				startActivity(intentLearn);
			}
		});

		Bodybtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						BodyActivity.class);
				startActivity(intentLearn);
			}
		});
		Basiccommbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						BasicCommActivity.class);
				startActivity(intentLearn);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.learn, menu);
		return true;
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
