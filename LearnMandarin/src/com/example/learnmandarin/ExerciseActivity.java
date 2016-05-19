package com.example.learnmandarin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ExerciseActivity extends Activity {
	private Button ColorExercisebtn, NumeracyExercisebtn, ShapeExercisebtn, FamilyExercisebtn, BodyExercisebtn,BasiccommExercisebtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise);
		
		ColorExercisebtn = (Button) findViewById(R.id.colorexercisebtn);
		NumeracyExercisebtn = (Button) findViewById(R.id.numeracyexercisebtn);
		ShapeExercisebtn = (Button) findViewById(R.id.shapeexercisebtn);
		FamilyExercisebtn = (Button) findViewById(R.id.myfamilyexercisebtn);
		BodyExercisebtn = (Button) findViewById(R.id.bodyexercisebtn);
		BasiccommExercisebtn = (Button) findViewById(R.id.basiccommexercisebtn);
		
		

		ColorExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						ColorExerciseActivity.class);
				startActivity(intentLearn);
			}
		});

		NumeracyExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						NumeracyExerciseActivity.class);
				startActivity(intentLearn);
			}
		});
		ShapeExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						ShapeExerciseActivity.class);
				startActivity(intentLearn);
			}
		});
		FamilyExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						FamilyExerciseActivity.class);
				startActivity(intentLearn);
			}
		});

		BodyExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						BodyExerciseActivity.class);
				startActivity(intentLearn);
			}
		});
		BasiccommExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentLearn = new Intent(getApplicationContext(),
						BasicCommExerciseActivity.class);
				startActivity(intentLearn);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exercise, menu);
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
