package com.example.basicbake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TipsActivity extends Activity {
	Button btngeneral,btndecoration,btnillustration,btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tips);
		btngeneral = (Button) findViewById(R.id.btntipsgeneral);
        btndecoration = (Button) findViewById(R.id.btntipsdecoration);
        btnillustration = (Button) findViewById(R.id.btntipsillustration);
        btnBack = (Button) findViewById(R.id.btnTipsback);
        
        btngeneral.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentG=new Intent(getApplicationContext(),GeneralTipsActivity.class);
				startActivity(intentG);
				}
			});
        btndecoration.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentD=new Intent(getApplicationContext(),DecorationTipsActivity.class);
				startActivity(intentD);
				}
			});
        btnillustration.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentI=new Intent(getApplicationContext(),IllustrationTipsActivity.class);
				startActivity(intentI);
				}
			});
        btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				finish();
				}
			});
	}
}
