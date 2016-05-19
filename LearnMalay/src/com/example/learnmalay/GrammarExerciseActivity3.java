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
import android.widget.TextView;

public class GrammarExerciseActivity3 extends Activity {
	
	ImageView QuestionImage;
	Button OptionA, OptionB,OptionC;
	int count =0;
	int smallCount=0;
	int maxcount = 3;
	String[] QuestionText;
	String Answer="JAWAPAN: ";
	TextView AnswerView;
	int resultcount=10;
	static String[] options = new String[3]; 
	int tempcount =0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grammar_exercise_activity3);
		
		QuestionText = getResources().getStringArray(
				R.array.GrammarQuestionsandAnswers3);
		QuestionImage=(ImageView) findViewById(R.id.GrammarQuestionImage3);
		OptionA = (Button) findViewById(R.id.GrammarOptionA3);
		OptionB = (Button) findViewById(R.id.GrammarOptionB3);
		OptionC = (Button) findViewById(R.id.GrammarOptionC3);
		AnswerView = (TextView) findViewById(R.id.GrammarAnswerText);
		printQuestion();
		
		OptionA.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				collectResult("a");
				tempcount++;
				Button b = (Button)v;
				b.setVisibility(View.INVISIBLE);
				showAnswer(b.getText().toString());
				
			}
		});
		OptionB.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				collectResult("b");
				tempcount++;
				Button b = (Button)v;
				b.setVisibility(View.INVISIBLE);
				showAnswer(b.getText().toString());
				
			}
		});
		OptionC.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				collectResult("c");
				tempcount++;
				Button b = (Button)v;
				b.setVisibility(View.INVISIBLE);
				showAnswer(b.getText().toString());
				
				
			}
		});
		
	}

	
	private void printQuestion() {
		if (count < maxcount) {
			count++;} 
		else{
			findOption();
			Intent intentExercise1=new Intent(getApplicationContext(),GrammarExerciseEndActivity.class);
			startActivity(intentExercise1);
			finish();
			}


		smallCount =0;
		tempcount=0;
		Bitmap image = getBitmapFromAsset(count + ".png");
		QuestionImage.setImageBitmap(image);
		int arraycount = 3*(count-1);
		showButton();
		Answer="JAWAPAN: ";
		OptionA.setText(QuestionText[arraycount]);
		OptionB.setText(QuestionText[arraycount+1]);
		OptionC.setText(QuestionText[arraycount+2]);
		AnswerView.setText("JAWAPAN: ");
}
		
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("grammarexercise3/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
	
	private void showAnswer(String option)
	{
			Answer += option;
			AnswerView.setText(Answer +"  ");	
			if(smallCount>1){
				findOption();
				printQuestion();
				return;
			}
			smallCount++;
			
	}
	private void showButton()
	{
		OptionA.setVisibility(View.VISIBLE);
		OptionB.setVisibility(View.VISIBLE);
		OptionC.setVisibility(View.VISIBLE);
	}
	
	private void collectResult(String option)
	{
		options[tempcount]=option;
	}
	
	private void findOption()
	{
		int temp = resultcount+count-1;
		String[][] tempanswer = new String[][]{{"c","b","a"},{"a","c","b"},{"a","c","b"}};
		if(count==1&&options == tempanswer[0])
		{
			ResultHandeler.GrammarResult[resultcount] = "a";
		}
		else if(count==2&&options == tempanswer[1])
		{
			ResultHandeler.GrammarResult[resultcount+1] = "a";
		}
		else if(count==3&&options == tempanswer[2])
		{
			ResultHandeler.GrammarResult[resultcount+2] = "a";
		}
		else
			ResultHandeler.GrammarResult[temp] = "b";
	}
}
