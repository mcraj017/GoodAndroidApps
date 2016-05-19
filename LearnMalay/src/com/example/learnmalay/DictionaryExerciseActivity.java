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

public class DictionaryExerciseActivity extends Activity {
	ImageView QuestionImage;
	Button OptionA, OptionB,OptionC,OptionD, OptionE,OptionF;
	int count =0;
	int smallCount=0;
	int maxcount = 5;
	String[] QuestionText;
	String Answer="JAWAPAN: ";
	TextView AnswerView;
	int maxsmallcount=0;
	
	int resultcount =0; 
	static String options;
	int tempcount =0;
	
	int [] anslenght ={5,5,6,5,4};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary_exercise);
		
		QuestionText = getResources().getStringArray(
				R.array.DictionaryQuestionsandAnswers);
		QuestionImage=(ImageView) findViewById(R.id.DictionaryQuestionImage);
		OptionA = (Button) findViewById(R.id.DictionaryOptionA);
		OptionB = (Button) findViewById(R.id.DictionaryOptionB);
		OptionC = (Button) findViewById(R.id.DictionaryOptionC);
		OptionD = (Button) findViewById(R.id.DictionaryOptionD);
		OptionE = (Button) findViewById(R.id.DictionaryOptionE);
		OptionF = (Button) findViewById(R.id.DictionaryOptionF);
		AnswerView = (TextView) findViewById(R.id.DictionaryAnswerText);
		OptionA.setVisibility(View.INVISIBLE);
		OptionB.setVisibility(View.INVISIBLE);
		OptionC.setVisibility(View.INVISIBLE);
		OptionD.setVisibility(View.INVISIBLE);
		OptionE.setVisibility(View.INVISIBLE);
		OptionF.setVisibility(View.INVISIBLE);
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
		OptionD.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				collectResult("d");
				tempcount++;
				Button b = (Button)v;
				b.setVisibility(View.INVISIBLE);
				showAnswer(b.getText().toString());
				
			}
		});
		OptionE.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				collectResult("e");
				tempcount++;
				Button b = (Button)v;
				b.setVisibility(View.INVISIBLE);
				showAnswer(b.getText().toString());
				
			}
		});
		OptionF.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				collectResult("f");
				tempcount++;
				Button b = (Button)v;
				b.setVisibility(View.INVISIBLE);
				showAnswer(b.getText().toString());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dictionary_exercise, menu);
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
			findOption();
			Intent intentExercise1=new Intent(getApplicationContext(),DictionaryExerciseEndActivity.class);
			startActivity(intentExercise1);
			finish();}


		//set question

		smallCount =0;
		tempcount=0;
		options="";
		Bitmap image = getBitmapFromAsset(count + ".png");
		QuestionImage.setImageBitmap(image);
		int arraycount = countItems();
		showButton(arraycount);
		Answer="JAWAPAN: ";
		AnswerView.setText("JAWAPAN: ");
}
		
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("dictionaryexercise/" + strName);
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
			maxsmallcount = anslenght[count-1];
			if(smallCount>(maxsmallcount-2)){
				findOption();
				printQuestion();
				return;
			}
			System.out.println(smallCount+">"+(maxsmallcount-2) +" | "+count);
			smallCount++;
			
	}
	private void showButton(int arraycount)
	{
		Button[] Options = {OptionA, OptionB,OptionC,OptionD, OptionE,OptionF};
		System.out.println(arraycount);
		for(int i =0;i<anslenght[count-1];i++)
			{
			Options[i].setVisibility(View.VISIBLE);
			Options[i].setText(QuestionText[arraycount+i]);
		}
	}
	
	private int countItems()
	{
		int ItemCount =0;
		for(int i=0;i<(count-1);i++)
		{
			ItemCount += anslenght[i];
		}
		return ItemCount;
	}
	
	private void collectResult(String option)
	{
		options += option;
	}
	
	private void findOption()
	{
		
		System.out.println(options);
		int temp = resultcount+count-1;
		String[] tempanswer = new String[]{
				"cbade","cdabe",
				"adcbe",
				"dbfaec","defabc",
				"cbade","cdabe",
				"dbca"
				};
		if(count==1&&(options.equalsIgnoreCase(tempanswer[0])||options.equalsIgnoreCase(tempanswer[1])))
		{
			ResultHandeler.DictionaryResult[resultcount] = "a";
		}
		else if(count==2&&(options.equalsIgnoreCase(tempanswer[2])))
		{
			ResultHandeler.DictionaryResult[resultcount+1] = "a";
		}
		else if(count==3&&(options.equalsIgnoreCase(tempanswer[3])||options.equalsIgnoreCase(tempanswer[4])))
		{
			ResultHandeler.DictionaryResult[resultcount+2] = "a";
		}
		else if(count==4&&(options.equalsIgnoreCase(tempanswer[5])||options.equalsIgnoreCase(tempanswer[6])))
		{
			ResultHandeler.DictionaryResult[resultcount+3] = "a";
		}
		else if(count==5&&(options.equalsIgnoreCase(tempanswer[7])))
		{
			ResultHandeler.DictionaryResult[resultcount+4] = "a";
		}
		else
			ResultHandeler.DictionaryResult[temp] = "b";
	}
	
}
