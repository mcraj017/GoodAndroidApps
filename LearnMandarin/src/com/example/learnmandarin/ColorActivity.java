package com.example.learnmandarin;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
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

public class ColorActivity extends Activity {
	private int count = 0;
	private int maxcount = 11;
	private ImageView im = null;
	private Button Nextbtn = null;
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();
	private Button Backbtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color);
		im = (ImageView) findViewById(R.id.ColorImage);
		Nextbtn = (Button) findViewById(R.id.Nextbtn);
		Playbtn = (ImageButton) findViewById(R.id.Playbtn);
		Backbtn = (Button) findViewById(R.id.Backbtn);

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

		Playbtn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				mp.stop();
				 mp.reset();
				try {

					AssetFileDescriptor afd;
					afd = getAssets().openFd("color/" + count + ".m4a");
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
		getMenuInflater().inflate(R.menu.color, menu);
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

	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("color/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}

	private void printImage(boolean next) {
		if (count < maxcount) {
			if (next)
				count++;
			else if (!next)
				if (count == 0 || count == 1)
					count = maxcount;
				else
					count--;
		} else
			count = 1;
		Bitmap image = getBitmapFromAsset(count + ".png");
		im.setImageBitmap(image);

	}
}
