package com.example.learnmalay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ExerciseActivity extends Activity {
	Button GrammarExercisebtn,VerbExercisebtn, DictionaryExercisebtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		if (getIntent().getBooleanExtra("EXIT", false)) {
		    finish();
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise);
		GrammarExercisebtn = (Button) findViewById(R.id.GrammarExerciseButton);
		VerbExercisebtn = (Button) findViewById(R.id.VerbExerciseButton);
		DictionaryExercisebtn = (Button) findViewById(R.id.DictionaryExerciseButton);
		GrammarExercisebtn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
				
					Intent intentGrammarExercise=new Intent(getApplicationContext(),GrammarExerciseActivity.class);
					startActivity(intentGrammarExercise);
					finish();
					}
				});
		VerbExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
			
				Intent intentVerbExercise=new Intent(getApplicationContext(),VerbExerciseActivity.class);
				startActivity(intentVerbExercise);
				finish();
				}
			});
		DictionaryExercisebtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
			
				Intent intentDictionaryExercise=new Intent(getApplicationContext(),DictionaryExerciseActivity.class);
				startActivity(intentDictionaryExercise);
				finish();
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
