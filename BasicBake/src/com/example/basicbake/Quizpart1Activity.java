package com.example.basicbake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class Quizpart1Activity extends Activity implements OnClickListener{
	private WebView question, explanation;
	private Button btnoptiona, btnoptionb, btnoptionc, btnoptiond, btnnext;
	private int part = 1;
	private int maxcount = 10;
	private int Count = 1;
	private String Answers[]=null;
	int score =0;

	boolean gonext=false;
	private String[][] options = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizpart1);

		btnoptiona = (Button) findViewById(R.id.btnoptionA);
		btnoptionb = (Button) findViewById(R.id.btnoptionB);
		btnoptionc = (Button) findViewById(R.id.btnoptionC);
		btnoptiond = (Button) findViewById(R.id.btnoptionD);
		btnnext = (Button) findViewById(R.id.btnpart1next);
		question = (WebView) findViewById(R.id.question);
		explanation = (WebView) findViewById(R.id.explanation);


			options = new String[][] {
					{ "A: all-purpose flour", "B: cake flour",
							"C: pastry flour" },
					{ "A: 450 degrees Fahrenheit (232 degrees Celsius)",
							"B: 500 degrees Fahrenheit (260 degrees Celsius)",
							"C: 550 degrees Fahrenheit (288 degrees Celsius)" },
					{ "A: apple sauce", "B: banana puree", "C: pumpkin puree" },
					{ "A: yeast", "B: baking soda and corn starch",
							"C: baking soda, an acid and corn starch" },
					{ "A: To control the amount of salt in the recipe",
							"B. Unsalted butter is usually fresher",
							"C. Unsalted butter has fewer calories",
							"D: A and B" },
					{
							"A: For each cup of all-purpose flour, add 1 1/2 teaspoons of baking powder and 1/2 teaspoon of salt. Mix to combine",
							"B. For each cup of all-purpose flour, add 2 teaspoons of yeast. Mix to combine.",
							"C. There's no viable substitution" },
					{
							"A: Same as half-and-half cream",
							"B. A Russian dessert using whipped cream and gelatin",
							"C. An acid used as a leavening agent" },
					{
							"A: It helps tenderize the dough or batter",
							"B. When creamed with butter or shortening, it contributes to the volume of a cake",
							"C. It aids in browning during baking",
							"D. All of the above" },
					{ "A: 1 teaspoon", "B. 1 1/2 tablespoons",
							"C. 1 1/2 teaspoons" },
					{ "A: Grand Marnier Souffle", "B. Cheesecake",
							"C. Crepes suzette" } };
			Answers = new String[] {"b","b","a","c","d","a","c","d","c","b"};



		printQuestion(Count);
		btnoptiona.setOnClickListener(this);
		btnoptionc.setOnClickListener(this);
		btnoptionb.setOnClickListener(this);
		btnoptiond.setOnClickListener(this);
		btnnext.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(!gonext)
					return;
				Count++;
				if(Count>maxcount)
				{
					Intent intentExercise1=new Intent(getApplicationContext(),ScoreActivity.class);
					
					System.out.println("before : "+score);
					intentExercise1.putExtra("score", score);
					startActivity(intentExercise1);
					finish();
					return;
				}
				printQuestion(Count);
			}
		});
		
	}
	@Override
	public void onClick(View arg0) {
		Button b = (Button) arg0;
		Button a = btnoptiona;
		if((Answers[Count-1]).equalsIgnoreCase("b"))
		{
			a = btnoptionb;
		}
		else if((Answers[Count-1]).equalsIgnoreCase("c"))
		{
			a = btnoptiond;
		}
		else if((Answers[Count-1]).equalsIgnoreCase("d"))
		{
			a = btnoptiond;
		}

		if(a.getText().toString().equalsIgnoreCase(b.getText().toString()))
		{
			score++;
		}
		System.out.println(a.getText().toString()+"->"+b.getText().toString());
		printAnswer(Count);
		btnnext.setVisibility(View.VISIBLE);
		
	}

	private void printQuestion(int count) {
		

		gonext=false;
		btnoptiond.setVisibility(View.INVISIBLE);
		btnoptiond.setVisibility(View.INVISIBLE);
		btnoptiona.setBackgroundColor(getResources().getColor(R.color.yellow));
		btnoptionb.setBackgroundColor(getResources().getColor(R.color.yellow));
		btnoptionc.setBackgroundColor(getResources().getColor(R.color.yellow));
		btnoptiond.setBackgroundColor(getResources().getColor(R.color.yellow));
		explanation.loadUrl("about:blank");
		question.loadUrl("file:///android_asset/p" + part + "q" + count
				+ ".html");
		btnoptiona.setText(options[count-1][0]);
		btnoptionb.setText(options[count-1][1]);
		btnoptionc.setText(options[count-1][2]);
		if (options[count-1].length > 3) {
			btnoptiond.setVisibility(View.VISIBLE);
			btnoptiond.setText(options[count-1][3]);
		}
	}
	private void printAnswer(int count)
	{
		
		btnoptiona.setBackgroundColor(getResources().getColor(R.color.red));
		btnoptionb.setBackgroundColor(getResources().getColor(R.color.red));
		btnoptionc.setBackgroundColor(getResources().getColor(R.color.red));
		btnoptiond.setBackgroundColor(getResources().getColor(R.color.red));
		
		if(Answers[count-1].equals("a"))
		{
			
			btnoptiona.setBackgroundColor(getResources().getColor(R.color.green));
		}
		else if(Answers[count-1].equals("b"))
		{
			
			btnoptionb.setBackgroundColor(getResources().getColor(R.color.green));
		}
		else if(Answers[count-1].equals("c"))
		{
			
			btnoptionc.setBackgroundColor(getResources().getColor(R.color.green));
		}
		else if(Answers[count-1].equals("d"))
		{
			
			btnoptiond.setBackgroundColor(getResources().getColor(R.color.green));
		}
		
		explanation.loadUrl("file:///android_asset/p" + part + "e" + count
				+ ".html");
		gonext=true;
	}


	
}
