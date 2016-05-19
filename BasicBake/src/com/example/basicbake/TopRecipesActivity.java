package com.example.basicbake;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TopRecipesActivity extends Activity implements OnClickListener {
	Button btnpavlova,btncongobars,btnredvelvet,btnbrownies,btncreampuff,btnback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top_recipes);
		
		btnpavlova = (Button) findViewById(R.id.btnpavlova);
		btncongobars = (Button) findViewById(R.id.btncongobars);
		btnredvelvet = (Button) findViewById(R.id.btnredvelvet);
		btnbrownies = (Button) findViewById(R.id.btnbrownies);
		btncreampuff = (Button) findViewById(R.id.btncreamepuff);
		
		btnpavlova.setOnClickListener(this);
		btncongobars.setOnClickListener(this);
		btnredvelvet.setOnClickListener(this);
		btnbrownies.setOnClickListener(this);
		btncreampuff.setOnClickListener(this);
		
		
		btnback = (Button) findViewById(R.id.btntoprecipesback);
        btnback.setOnClickListener(new View.OnClickListener() {
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
