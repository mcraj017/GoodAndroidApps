package com.example.learnmalay;


import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
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

public class DictionaryActivity extends Activity {
	private int count = 0;
	private ImageView im = null;
	private Button Nextbtn = null;
	private int maxcount = 3;
	
	private Button Backbtn = null;
	
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary);
		
		Nextbtn = (Button) findViewById(R.id.Nextbutton5);
		
		im = (ImageView) findViewById(R.id.Dictionaryimage);
		
		Backbtn = (Button) findViewById(R.id.Backbutton5);
		
		Playbtn = (ImageButton) findViewById(R.id.dictionaryplay);
		
		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mp.stop();
				printImage(true);
				
			}
		});
		Backbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mp.stop();
				printImage(false);
			}
		});
		Playbtn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				mp.stop();
				 mp.reset();
				try {

					AssetFileDescriptor afd;
					afd = getAssets().openFd("Module7/" + count + ".mp3");
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
			else if (!next)
				if (count == 0 || count == 1)
					count = 1;
				else
					count--;
		} else
			{
			Intent intentExercise=new Intent(getApplicationContext(),ExerciseActivity.class);
			startActivity(intentExercise);
			finish();
			}
		Bitmap image = getBitmapFromAsset(count + ".png");
		im.setImageBitmap(image);

	}
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("Module7/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
