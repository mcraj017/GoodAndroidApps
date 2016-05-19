package com.example.learnmandarin;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ScoreActivity extends Activity {
	
	TextView ColorScore,BasiccommScore,BodyScore,FamilyScore, NumeracyScore,ShapeScore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		ColorScore = (TextView) findViewById(R.id.colorscore);
		BasiccommScore = (TextView) findViewById(R.id.basiccommscore);
		BodyScore = (TextView) findViewById(R.id.bodyscore);
		FamilyScore = (TextView) findViewById(R.id.myfamilyscore);
		NumeracyScore = (TextView) findViewById(R.id.numeracyscore);
		ShapeScore = (TextView) findViewById(R.id.shapescore);
		try{
		SharedPreferences mPref= getSharedPreferences("Marks", Context.MODE_PRIVATE);
		int colorscore = mPref.getInt("colormarks", 0);
		ColorScore.setText(""+colorscore+" / 11");
		int basiccommscore = mPref.getInt("basiccommmarks", 0);
		BasiccommScore.setText(""+basiccommscore+" / 11");
		int bodyscore = mPref.getInt("bodymarks", 0);
		BodyScore.setText(""+bodyscore+" / 9");
		int familyscore = mPref.getInt("familymarks", 0);
		FamilyScore.setText(""+familyscore+" / 8");
		int numeracyscore = mPref.getInt("numeracymarks", 0);
		NumeracyScore.setText(""+numeracyscore+" / 9");
		int shapescore = mPref.getInt("shapemarks", 0);
		ShapeScore.setText(""+shapescore+" / 11");
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
