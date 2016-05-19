package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class GeneralTipsActivity extends Activity implements OnClickListener{
	Button btntip1,btntip2,btntip3,btntip4,btntip5,btntip6,btntip7,btnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_general_tips);
		btntip1 = (Button) findViewById(R.id.btngeneraltip1);
		btntip2 = (Button) findViewById(R.id.btngeneraltip2);
		btntip3 = (Button) findViewById(R.id.btngeneraltip3);
		btntip4 = (Button) findViewById(R.id.btngeneraltip4);
		btntip5 = (Button) findViewById(R.id.btngeneraltip5);
		btntip6 = (Button) findViewById(R.id.btngeneraltip6);
		btntip7 = (Button) findViewById(R.id.btngeneraltip7);
		btnBack = (Button) findViewById(R.id.btngeneralback);
		btntip1.setOnClickListener(this);
		btntip2.setOnClickListener(this);
		btntip3.setOnClickListener(this);
		btntip4.setOnClickListener(this);
		btntip5.setOnClickListener(this);
		btntip6.setOnClickListener(this);
		btntip7.setOnClickListener(this);
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				finish();
				}
			});
	}
	@Override
	public void onClick(View arg0) {
		Button v = (Button) arg0;
		Intent intentT=new Intent(getApplicationContext(),TipActivity.class);
		Bundle bundle = new Bundle();
		
		bundle.putString("tip",v.getText().toString());
		intentT.putExtras(bundle);
		startActivity(intentT);
		
	}


}
