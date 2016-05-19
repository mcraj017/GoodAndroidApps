package com.example.learnmalay;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GrammarActivity extends Activity {
	Button Module1button,Module2button,Module3button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grammar);
		
		Module1button=(Button)findViewById(R.id.Modulebutton1);
		 Module2button=(Button)findViewById(R.id.Modulebutton2);
		 Module3button=(Button)findViewById(R.id.Modulebutton3);
		 
		 // Set OnClick Listener on Grammar button 
		    Module1button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for Activity  and Start The Activity
				Intent intentLearn=new Intent(getApplicationContext(),Module1Activity.class);
				startActivity(intentLearn);
				finish();
				}
			});
		 // Set OnClick Listener on Verb button 
		    Module2button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
	
				Intent intentExercise=new Intent(getApplicationContext(),Module2Activity.class);
				startActivity(intentExercise);
				finish();
				}
			});

		    Module3button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent intentScore=new Intent(getApplicationContext(),Module3Activity.class);
				startActivity(intentScore);
				finish();
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grammar, menu);
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
