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
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FamilyActivity extends Activity {
	private int count = 0;
	private int maxcount = 8;
	private ImageView im = null;
	private Button Nextbtn = null;
	private Button Backbtn = null;
	
	private ImageButton Playbtn = null;
	final MediaPlayer mp = new MediaPlayer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_family);
		
		Nextbtn = (Button) findViewById(R.id.Nextbtn3);
		im = (ImageView) findViewById(R.id.FamilyImage);
		Backbtn = (Button) findViewById(R.id.Backbtn3);
		
		Playbtn = (ImageButton) findViewById(R.id.PlayFamilybtn);
		
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
					afd = getAssets().openFd("family/" + count + ".m4a");
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
					count = maxcount;
				else
					count--;
		} else
			count = 1;
		Bitmap image = getBitmapFromAsset(count + ".png");
		im.setImageBitmap(image);

	}
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("family/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}
}
