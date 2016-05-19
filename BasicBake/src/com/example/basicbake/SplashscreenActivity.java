package com.example.basicbake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashscreenActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splashscreen);
		Thread logoTimer = new Thread() {
            public void run(){
                try{
                    int logoTimer = 0;
                    while(logoTimer < 4000){
                        sleep(100);
                        logoTimer = logoTimer +100;
                    };
                    Intent i = new Intent(SplashscreenActivity.this, MainActivity.class);
                    startActivity(i);
                }
                 
                catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                 
                finally{
                    finish();
                }
	}
		};
		logoTimer.start();
	}
}
