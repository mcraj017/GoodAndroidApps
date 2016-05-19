package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class BasicActivity extends Activity implements OnClickListener {
	Button btnButterCake,btnBack,btnspongecake,btnchocolatecake,btncupcake;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic);
		btnButterCake = (Button) findViewById(R.id.btnbuttercake);
		btnBack = (Button) findViewById(R.id.btnbasicback);
		btnspongecake = (Button) findViewById(R.id.btnspongecake);
		btnchocolatecake = (Button) findViewById(R.id.btnchocolate);
		btncupcake = (Button) findViewById(R.id.btncupcake);
		
		btnButterCake.setOnClickListener(this);
		btnspongecake.setOnClickListener(this);
		btnchocolatecake.setOnClickListener(this);
		btncupcake.setOnClickListener(this);
		
		
        btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				finish();
				}
			});
	}
	
	

	@Override
	public void onClick(View arg0) {
		
		Button b = (Button)arg0;
	    String name = b.getText().toString();
		
		Intent intentbc=new Intent(getApplicationContext(),ButterCakeActivity.class);
		Bundle bundle = new Bundle();
		//Add your data to bundle
		bundle.putString("name",name);
		intentbc.putExtras(bundle);
		startActivity(intentbc);
	}
	
}
