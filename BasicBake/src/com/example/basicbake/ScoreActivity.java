package com.example.basicbake;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class ScoreActivity extends Activity {
	TextView scoreview ;
	WebView scoreweb;
	Button done;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		
		scoreview = (TextView) findViewById(R.id.scoreview);
		scoreweb = (WebView) findViewById(R.id.scoreweb);
		done = (Button) findViewById(R.id.done);
		Bundle extras = getIntent().getExtras();
		int value = 0;
		if (extras != null) {
		    value = extras.getInt("score");
		}
		scoreview.setText(value +"/10");
		int score = value;
		System.out.println("after : "+score);
		if(score>7&&score<=10)
		{
			scoreweb.loadUrl("file:///android_asset/excellent.html");
		}
		else if(score>5&&score<=7)
		{
			scoreweb.loadUrl("file:///android_asset/good.html");
		}
		else if(score>3&&score<=5)
		{
			scoreweb.loadUrl("file:///android_asset/retest.html");
		}
		else if(score>=0&&score<=3)
		{
			scoreweb.loadUrl("file:///android_asset/learnmore.html");
		}
		done.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						finish();
					}
				}
				);
	}
}
