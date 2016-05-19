package com.example.basicbake;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class VideoActivity extends Activity {
	Button btnBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vedio);
		VideoView videoview = (VideoView) findViewById(R.id.videoView1);

		Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);

		videoview.setVideoURI(uri);
		videoview.start();
		
		btnBack = (Button) findViewById(R.id.btnvideoback);
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				finish();
				}
			});
	}


}
