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

public class GrammarExerciseActivity extends Activity {

	ImageView QuestionImage;
	Button OptionA, OptionB;
	int count = 0;
	int maxcount = 6;
	String[] QuestionText;
	int resultCount =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grammar_exercise);
		QuestionText = getResources().getStringArray(
				R.array.GrammarQuestionsandAnswers1);
		QuestionImage = (ImageView) findViewById(R.id.GrammarQuestionImage);
		OptionA = (Button) findViewById(R.id.GrammarOptionA);
		OptionB = (Button) findViewById(R.id.GrammarOptionB);
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grammar_exercise, menu);
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
			count++;
		} else {
			Intent intentGrammarExercise = new Intent(getApplicationContext(),
					GrammarExerciseActivity2.class);
			startActivity(intentGrammarExercise);
			finish();
		}

		// else
		// {
		// Toast.makeText(getApplicationContext(),
		// "Exam over with marks "+ResultHandeler.findBasiccommResult(),
		// Toast.LENGTH_LONG).show();
		// //store result
		// SharedPreferences mPref = getSharedPreferences("Marks",
		// Context.MODE_PRIVATE);
		// mPref.edit().putInt("basiccommmarks",
		// ResultHandeler.findBasiccommResult()).commit();
		// finish();
		// }
		// set question
		Bitmap image = getBitmapFromAsset(count + ".png");
		QuestionImage.setImageBitmap(image);
		int arraycount = 2 * (count-1);
		OptionA.setText(QuestionText[arraycount]);
		OptionB.setText(QuestionText[arraycount + 1]);
		
	}

	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("grammarexercise/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
