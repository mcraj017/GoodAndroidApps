package com.example.learnmalay;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentActivity extends  Activity {
	String userName= "Welcome";
	Button btnTutorial,btnExercise,btnLogout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student);
		Bundle bundle = getIntent().getExtras();
		userName= bundle.getString("userName");
		ResultHandeler.UserName = userName;
		
		btnTutorial=(Button)findViewById(R.id.Tutorialbtn);
		 btnExercise=(Button)findViewById(R.id.Exercisebtn);
		 btnLogout=(Button)findViewById(R.id.Logoutbutton);
		// Set OnClick Listener on Grammar button 
		 btnTutorial.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for Activity  and Start The Activity
				Intent intentLearn=new Intent(getApplicationContext(),TutorialActivity.class);
				startActivity(intentLearn);
				}
			});
		 // Set OnClick Listener on Exercise button 
		    btnExercise.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/// Create Intent for Activity  and Start The Activity
				Intent intentExercise=new Intent(getApplicationContext(),ExerciseActivity.class);
				startActivity(intentExercise);
				}
			});
		    btnLogout.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					/// Create Intent for Activity  and Start The Activity
					Intent intentMain=new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intentMain);
					finish();
					}
				});
		
	}
	@Override
	protected void onStart() {
		super.onStart();
		TextView tv = (TextView) findViewById(R.id.Usernametv);
		tv.setText("SELAMAT DATANG  "+ userName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student, menu);
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
