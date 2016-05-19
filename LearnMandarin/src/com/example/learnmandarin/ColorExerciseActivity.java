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
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ColorExerciseActivity extends ActionBarActivity {
	
	private int count = 0;
	private ImageView im = null;
	private Button Nextbtn = null;
	private ImageButton OptionbtnA = null;
	private ImageButton OptionbtnC = null;
	private ImageButton OptionbtnD = null;
	private ImageButton OptionbtnB = null;
	private int maxcount = 11;
	
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_exercise);
		Nextbtn = (Button) findViewById(R.id.NextExercisebtn);
		im = (ImageView) findViewById(R.id.MandarinWordImage);
		OptionbtnA = (ImageButton) findViewById(R.id.OptionbtnA);
		OptionbtnB = (ImageButton) findViewById(R.id.OptionbtnB);
		OptionbtnC = (ImageButton) findViewById(R.id.OptionbtnC);
		OptionbtnD = (ImageButton) findViewById(R.id.OptionbtnD);
		
		
		Playbtn = (ImageButton) findViewById(R.id.Playcolor);
		Playbtn.setVisibility(View.INVISIBLE);
		
		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(true);
				OptionbtnA.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setColorResult("a",count);
						printImage(true);
					}
				});
				OptionbtnB.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setColorResult("b",count);
						printImage(true);

					}
				});
				OptionbtnC.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setColorResult("c",count);
						printImage(true);

					}
				});
				OptionbtnD.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setColorResult("d",count);
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
					afd = getAssets().openFd("colorexercise/" + count + ".m4a");
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
			Toast.makeText(getApplicationContext(), "Exam over with marks "+ResultHandeler.findColorResult(), Toast.LENGTH_LONG).show();
			
			//store result
			SharedPreferences mPref = getSharedPreferences("Marks", Context.MODE_PRIVATE);
			 mPref.edit().putInt("colormarks", ResultHandeler.findColorResult()).commit();
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
			istr = assetManager.open("colorexercise/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
