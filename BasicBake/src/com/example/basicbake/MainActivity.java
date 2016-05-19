package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends Activity {
	
	Button btnRecipes,btntimer,btntools,btnquiz,btntips,btnvideo,btnnutrition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRecipes = (Button) findViewById(R.id.btnrecipes);
        btntimer = (Button) findViewById(R.id.btntimer);
        btntools = (Button) findViewById(R.id.btntools);
        btnquiz = (Button) findViewById(R.id.btnquiz);
        btntips = (Button) findViewById(R.id.btntips);
        btnvideo = (Button) findViewById(R.id.btnvedio);
        btnnutrition = (Button) findViewById(R.id.btnnutrition);
        btnRecipes.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentR=new Intent(getApplicationContext(),RecipesActivity.class);
				startActivity(intentR);
				}
			});
        btntimer.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentW=new Intent(getApplicationContext(),WatchActivity.class);
				startActivity(intentW);
				}
			});
        btntools.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentT=new Intent(getApplicationContext(),ToolsActivity.class);
				startActivity(intentT);
				}
			});
        btnquiz.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentQ=new Intent(getApplicationContext(),QuizActivity.class);
				startActivity(intentQ);
				}
			});
        btntips.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentT=new Intent(getApplicationContext(),TipsActivity.class);
				startActivity(intentT);
				}
			});
        btnvideo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentT=new Intent(getApplicationContext(),VideoActivity.class);
				startActivity(intentT);
				}
			});
        btnnutrition.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentN=new Intent(getApplicationContext(),NutritionActivity.class);
				startActivity(intentN);
				}
			});
    }


  
}
