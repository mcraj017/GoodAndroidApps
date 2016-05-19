package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class IllustrationTipsActivity extends Activity implements OnClickListener {
	Button btncake,btnmacaroons,btnbrownies,btnbakingpan,btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_illustration_tips);
		btncake = (Button) findViewById(R.id.btncaketips);
		btnmacaroons = (Button) findViewById(R.id.btnmacaroons);
		btnbrownies = (Button) findViewById(R.id.btnbrowniestips);
		btnbakingpan = (Button) findViewById(R.id.btnbakingtips);
		btnBack = (Button) findViewById(R.id.btnillusback);
		btncake.setOnClickListener(this);
		btnmacaroons.setOnClickListener(this);
		btnbakingpan.setOnClickListener(this);
		btnbrownies.setOnClickListener(this);
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				finish();
				}
			});
	}
	@Override
	public void onClick(View v) {
		Button b = (Button) v;
		Intent intentT=new Intent(getApplicationContext(),TipActivity.class);
		Bundle bundle = new Bundle();
		
		bundle.putString("tip",b.getText().toString());
		intentT.putExtras(bundle);
		startActivity(intentT);
		
	}

}
