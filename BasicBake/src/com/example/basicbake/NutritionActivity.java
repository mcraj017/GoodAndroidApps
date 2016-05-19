package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NutritionActivity extends Activity {

	Button btntouchtoread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nutrition);
		
		btntouchtoread = (Button) findViewById(R.id.btntouchtoread);
		
		btntouchtoread.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intentExercise1=new Intent(getApplicationContext(),ReadNutritionActivity.class);
					startActivity(intentExercise1);
					finish();
			}
		});
		
	}
}
