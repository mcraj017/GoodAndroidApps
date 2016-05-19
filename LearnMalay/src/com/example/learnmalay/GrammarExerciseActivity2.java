package com.example.learnmalay;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GrammarExerciseActivity2 extends Activity {
	
	ImageView QuestionImage;
	Button OptionA, OptionB,OptionC;
	int count =0;
	int maxcount = 4;
	String[] QuestionText;
	int resultCount =6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grammar_exercise_activity2);
		
		QuestionText = getResources().getStringArray(
				R.array.GrammarQuestionsandAnswers2);
		QuestionImage=(ImageView) findViewById(R.id.GrammarQuestionImage2);
		OptionA = (Button) findViewById(R.id.GrammarOptionA2);
		OptionB = (Button) findViewById(R.id.GrammarOptionB2);
		OptionC = (Button) findViewById(R.id.GrammarOptionC2);
		printQuestion();
		
		OptionA.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ResultHandeler.setGrammarResult("a", resultCount);
				resultCount++;
				printQuestion();
			}
		});
		OptionB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ResultHandeler.setGrammarResult("b", resultCount);
				resultCount++;
				printQuestion();
				

			}
		});
		OptionC.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ResultHandeler.setGrammarResult("c", resultCount);
				resultCount++;
				printQuestion();
				

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grammar_exercise_activity2, menu);
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
	private void printQuestion() {
		if (count < maxcount) {
			count++;} 
		else{
			Intent intentGrammarExercise = new Intent(getApplicationContext(),
					GrammarExerciseActivity3.class);
			startActivity(intentGrammarExercise);
			finish();
		}

		//	else
//		{
//			Toast.makeText(getApplicationContext(), "Exam over with marks "+ResultHandeler.findBasiccommResult(), Toast.LENGTH_LONG).show();
//			//store result
//			SharedPreferences mPref = getSharedPreferences("Marks", Context.MODE_PRIVATE);
//			 mPref.edit().putInt("basiccommmarks", ResultHandeler.findBasiccommResult()).commit();
//			finish();
//		}
		//set question

		Bitmap image = getBitmapFromAsset(count + ".png");
		QuestionImage.setImageBitmap(image);
		int arraycount = 3*(count-1);
		OptionA.setText(QuestionText[arraycount]);
		OptionB.setText(QuestionText[arraycount+1]);
		OptionC.setText(QuestionText[arraycount+2]);
		

	}
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("grammarexercise2/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
