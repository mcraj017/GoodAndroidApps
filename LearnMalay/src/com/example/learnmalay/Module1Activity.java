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

public class Module1Activity extends Activity {

	private int count = 0;
	private ImageView im = null;
	private Button Nextbtn = null;

	private int maxcount = 4;

	private Button Backbtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_module1);

		Nextbtn = (Button) findViewById(R.id.Nextbutton1);
		im = (ImageView) findViewById(R.id.Module1Image);
		Backbtn = (Button) findViewById(R.id.Backbutton1);

		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(true);
			}
		});
		Backbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(false);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.module1, menu);
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
			istr = assetManager.open("Module1/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
