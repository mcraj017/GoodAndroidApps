package com.example.learnmalay;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class TutorialActivity extends Activity {

	Button btnGrammar,btnVerb,btnDictionary;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		btnGrammar=(Button)findViewById(R.id.Garamarbtn);
		 btnVerb=(Button)findViewById(R.id.Verbbtn);
		 btnDictionary=(Button)findViewById(R.id.Dictionarybtn);
		 
		
		    btnGrammar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
			
				Intent intentLearn=new Intent(getApplicationContext(),GrammarActivity.class);
				startActivity(intentLearn);
				finish();
				}
			});
		
		    btnVerb.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
			
				Intent intentExercise=new Intent(getApplicationContext(),VerbActivity.class);
				startActivity(intentExercise);
				finish();
				}
			});
		
		    btnDictionary.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent intentScore=new Intent(getApplicationContext(),DictionaryActivity.class);
				startActivity(intentScore);
				finish();
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutorial, menu);
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
