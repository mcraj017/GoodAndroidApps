package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class DecorationTipsActivity extends Activity implements OnClickListener{
	Button btnmeringues,btncookiesballoon,btncandiedlemon,btnstrawberries,btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decoration_tips);
		btnmeringues = (Button) findViewById(R.id.btndecomeringues);
		btncookiesballoon = (Button) findViewById(R.id.btndecocookiesballoon);
		btncandiedlemon = (Button) findViewById(R.id.btndecocandiedlemon);
		btnstrawberries = (Button) findViewById(R.id.btndecostrawberries);
		btnBack = (Button) findViewById(R.id.btndecoback);
		btnmeringues.setOnClickListener(this);
		btncookiesballoon.setOnClickListener(this);
		btncandiedlemon.setOnClickListener(this);
		btnstrawberries.setOnClickListener(this);
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
