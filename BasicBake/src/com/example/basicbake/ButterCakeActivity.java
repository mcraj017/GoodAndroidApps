package com.example.basicbake;


import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

public class ButterCakeActivity extends Activity {
	
	TextView mTextView;
	WebView webView;
	String Name;
	ImageButton play, pause, stop;
	
	boolean stopoption = false;
	final MediaPlayer mp = new MediaPlayer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_butter_cake);
		
		play = (ImageButton) findViewById(R.id.playbtn);
		pause = (ImageButton) findViewById(R.id.pausebtn);
		stop = (ImageButton) findViewById(R.id.stopbtn);
		Bundle bundle = getIntent().getExtras();
		Name= bundle.getString("name");
		mTextView = (TextView) findViewById(R.id.recipestitle);
		mTextView.setText(Name);
		webView = (WebView) findViewById(R.id.recipesDetails);
		Name = Name.toLowerCase();
		Name=Name.replace(" ", "");
		webView.loadUrl("file:///android_asset/"+Name+".html");
		playaudio();
		play.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if(stopoption)
				{
					playaudio();
					stopoption = false;
				}
				else
				mp.start();
				}
			});
		pause.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				mp.pause();
				}
			});
		stop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mp.stop();
				stopoption = true;
				}
			});

	}
	
	public void playaudio() {
		mp.stop();
		 mp.reset();
		try {

			AssetFileDescriptor afd;
			afd = getAssets().openFd("audio/" + Name + ".wav");
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
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mp.stop();
		 mp.reset();
	}
}