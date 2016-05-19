package com.example.basicbake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipesActivity extends Activity {
	Button btnBasic,btnBack,btntop,btnmeasurement;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipes);
		
		 btnBasic = (Button) findViewById(R.id.btnbasic);
         btnBack = (Button) findViewById(R.id.btnrecipesback);
         btntop = (Button) findViewById(R.id.btntoprecipes);
         btnmeasurement = (Button) findViewById(R.id.btnmeasurement);
         
	        btnBasic.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					Intent intentb=new Intent(getApplicationContext(),BasicActivity.class);
					startActivity(intentb);
					}
				});
	        
	        btntop.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					Intent intentt=new Intent(getApplicationContext(),TopRecipesActivity.class);
					startActivity(intentt);
					}
				});
	        btnmeasurement.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					
					Intent intentbc=new Intent(getApplicationContext(),ButterCakeActivity.class);
					Bundle bundle = new Bundle();
					//Add your data to bundle
					bundle.putString("name","EQUIVALENT");
					intentbc.putExtras(bundle);
					startActivity(intentbc);
					}
				});
	        
	        
	        btnBack.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					finish();
					}
				});
	}

}
