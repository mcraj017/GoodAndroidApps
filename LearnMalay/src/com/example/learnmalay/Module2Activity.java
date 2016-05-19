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
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Module2Activity extends Activity {
	private int count = 0;
	private ImageView im = null;
	private Button Nextbtn = null;
private int maxcount = 4;
	
	private Button Backbtn = null;
	
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_module2);
			
			Nextbtn = (Button) findViewById(R.id.Nextbutton2);
			im = (ImageView) findViewById(R.id.Module2Image);
			
			Backbtn = (Button) findViewById(R.id.Backbutton2);
			Playbtn = (ImageButton) findViewById(R.id.module2play);
			
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
						afd = getAssets().openFd("Module2/" + count + ".mp3");
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
			Intent intentExercise=new Intent(getApplicationContext(),GrammarActivity.class);
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
			istr = assetManager.open("Module2/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
	
	
}
