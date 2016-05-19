package com.example.basicbake;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class ReadNutritionActivity extends Activity {

	WebView nutritionweb;
	Button btnnext;
	int Count =1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_nutrition);
		
		nutritionweb = (WebView) findViewById(R.id.nutritionweb);
		btnnext = (Button) findViewById(R.id.btnnutritionnext);
		print(Count);
		
		btnnext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Count++;
				if(Count>2)
				finish();
				print(Count);
			}
		});
		
	}
	
	private void print(int count)
	{
		nutritionweb.loadUrl("file:///android_asset/nutrition"+count+".html");
	}
}
