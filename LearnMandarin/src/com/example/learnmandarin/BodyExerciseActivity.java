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

public class BodyExerciseActivity extends ActionBarActivity {
	private int count = 0;
	private ImageView im = null;
	private Button Nextbtn = null;
	private ImageButton OptionbtnA = null;
	private ImageButton OptionbtnC = null;
	private ImageButton OptionbtnD = null;
	private ImageButton OptionbtnB = null;
	private int maxcount = 9;
	
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_body_exercise);
		
		Nextbtn = (Button) findViewById(R.id.bodyNextExercisebtn);
		im = (ImageView) findViewById(R.id.bodyMandarinWordImage);
		OptionbtnA = (ImageButton) findViewById(R.id.bodyOptionbtnA);
		OptionbtnB = (ImageButton) findViewById(R.id.bodyOptionbtnB);
		OptionbtnC = (ImageButton) findViewById(R.id.bodyOptionbtnC);
		OptionbtnD = (ImageButton) findViewById(R.id.bodyOptionbtnD);
		Playbtn = (ImageButton) findViewById(R.id.Playbody);
		Playbtn.setVisibility(View.INVISIBLE);
		
		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(true);
				OptionbtnA.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setBodyResult("a",count);
						printImage(true);
					}
				});
				OptionbtnB.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setBodyResult("b",count);
						printImage(true);

					}
				});
				OptionbtnC.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setBodyResult("c",count);
						printImage(true);

					}
				});
				OptionbtnD.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						ResultHandeler.setBodyResult("d",count);
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
					afd = getAssets().openFd("bodyexercise/" + count + ".m4a");
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.body_exercise, menu);
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
	
	private void printImage(boolean next) {
		if (count < maxcount) {
			if (next)
				count++;
		} else
		{
			Toast.makeText(getApplicationContext(), "Exam over with marks "+ResultHandeler.findBodyResult(), Toast.LENGTH_LONG).show();
			//store result
			SharedPreferences mPref = getSharedPreferences("Marks", Context.MODE_PRIVATE);
			 mPref.edit().putInt("bodymarks", ResultHandeler.findBodyResult()).commit();
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
			istr = assetManager.open("bodyexercise/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
