package com.example.learnmandarin;




import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity {

	ImageButton btnExercise,btnScore,btnLearn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 btnExercise=(ImageButton)findViewById(R.id.Exercisebtn);
		 btnLearn=(ImageButton)findViewById(R.id.Learnbtn);
		 btnScore=(ImageButton)findViewById(R.id.Scorebtn);
			
		    // Set OnClick Listener on Learn button 
		    btnLearn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for SignUpActivity  and Start The Activity
				Intent intentLearn=new Intent(getApplicationContext(),LearnActivity.class);
				startActivity(intentLearn);
				}
			});
		 // Set OnClick Listener on Exercise button 
		    btnExercise.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for SignUpActivity  and Start The Activity
				Intent intentExercise=new Intent(getApplicationContext(),ExerciseActivity.class);
				startActivity(intentExercise);
				}
			});
		 // Set OnClick Listener on Score button 
		    btnScore.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for SignUpActivity  and Start The Activity
				Intent intentScore=new Intent(getApplicationContext(),ScoreActivity.class);
				startActivity(intentScore);
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
