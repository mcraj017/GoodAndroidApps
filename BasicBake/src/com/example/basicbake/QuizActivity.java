package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class QuizActivity extends Activity {
	Button btnpart1,btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		 btnpart1 = (Button) findViewById(R.id.btnpart1);
         btnBack = (Button) findViewById(R.id.btnquizback);
         
         btnpart1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					Intent intentp=new Intent(getApplicationContext(),Quizpart1Activity.class);
					startActivity(intentp);
					finish();
					}
				});
	
	btnBack.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {

			finish();
			}
		});
}
}
