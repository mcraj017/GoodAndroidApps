package com.example.learnmandarin;

import java.io.IOException;
import java.io.InputStream;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class FamilyExerciseActivity extends ActionBarActivity {
	
	private int count = 0;
	private ImageView im = null;
	private Button Nextbtn = null;
	private ImageButton OptionbtnA = null;
	private ImageButton OptionbtnC = null;
	private ImageButton OptionbtnD = null;
	private ImageButton OptionbtnB = null;
	private int maxcount = 8;
	
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_family_exercise);
		Nextbtn = (Button) findViewById(R.id.familyNextExercisebtn);
		im = (ImageView) findViewById(R.id.familyMandarinWordImage);
		OptionbtnA = (ImageButton) findViewById(R.id.familyOptionbtnA);
		OptionbtnB = (ImageButton) findViewById(R.id.familyOptionbtnB);
		OptionbtnC = (ImageButton) findViewById(R.id.familyOptionbtnC);
		OptionbtnD = (ImageButton) findViewById(R.id.familyOptionbtnD);
		
		Playbtn = (ImageButton) findViewById(R.id.Playfamily);
		Playbtn.setVisibility(View.INVISIBLE);
		
		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(true);
				OptionbtnA.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setFamilyResult("a",count);
						printImage(true);
					}
				});
				OptionbtnB.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setFamilyResult("b",count);
						printImage(true);

					}
				});
				OptionbtnC.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setFamilyResult("c",count);
						printImage(true);

					}
				});
				OptionbtnD.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setFamilyResult("d",count);
						printImage(true);

					}
				});
			}
		});

		Playbtn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				mp.stop();
				 mp.reset();
				try {

					AssetFileDescriptor afd;
					afd = getAssets().openFd("familyexercise/" + count + ".m4a");
					mp.setDataSource(afd.getFileDescriptor(),
							afd.getStartOffset(), afd.getLength());
					mp.prepare();
					mp.start();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}

	
	private void printImage(boolean next) {
		if (count < maxcount) {
			if (next)
				count++;
		} else
		{
			Toast.makeText(getApplicationContext(), "Exam over with marks "+ResultHandeler.findFamilyResult(), Toast.LENGTH_LONG).show();
			//store result
			SharedPreferences mPref = getSharedPreferences("Marks", Context.MODE_PRIVATE);
			 mPref.edit().putInt("familymarks", ResultHandeler.findFamilyResult()).commit();
			finish();
		}
		if(count!=0)
		{
			Nextbtn.setVisibility(View.INVISIBLE);
			Playbtn.setVisibility(View.VISIBLE);
		}
		//set question
		Bitmap image = getBitmapFromAsset(count + ".png");
		im.setImageBitmap(image);
		
		//set option
		image=getBitmapFromAsset(count + "a.png");
		OptionbtnA.setImageBitmap(image);
		image=getBitmapFromAsset(count + "b.png");
		OptionbtnB.setImageBitmap(image);
		image=getBitmapFromAsset(count + "c.png");
		OptionbtnC.setImageBitmap(image);
		image=getBitmapFromAsset(count + "d.png");
		OptionbtnD.setImageBitmap(image);

	}
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("familyexercise/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
