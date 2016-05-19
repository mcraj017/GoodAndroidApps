package com.example.learnmalay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GrammarExerciseEndActivity extends Activity {
	
	private Button Nextbtn = null;
	private TextView scoreText = null;
	
	LoginDataBaseAdapter loginDataBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grammar_exercise_end);
		Nextbtn = (Button) findViewById(R.id.GotoVerb);
		
		scoreText = (TextView) findViewById(R.id.GrammarScoreText);
		int score =ResultHandeler.findGrammarResult();
		scoreText.setText("Skor Anda: "+score+"/13");
		// create a instance of SQLite Database
	     loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	     loginDataBaseAdapter=loginDataBaseAdapter.open();
	     System.out.println(ResultHandeler.UserName);
	     
	     loginDataBaseAdapter.update(ResultHandeler.UserName, score, 1);
		
		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent intentExercise=new Intent(getApplicationContext(),VerbExerciseActivity.class);
				startActivity(intentExercise);
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grammar_exercise_end, menu);
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
