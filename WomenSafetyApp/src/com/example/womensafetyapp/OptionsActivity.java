package com.example.womensafetyapp;





import java.io.IOException;



import android.support.v7.app.ActionBarActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OptionsActivity extends ActionBarActivity {

	Button btnfakepolicesieren,btntorch,btnbetterystatus,btnsafetytips;
	public static Camera camera = null;
	static boolean clickOn = false;
	int level;
	
	private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
	    @Override
	    public void onReceive(Context arg0, Intent intent) {
	      // TODO Auto-generated method stub
	      level = intent.getIntExtra("level", 0);
	    }
	  };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		btnfakepolicesieren = (Button) findViewById(R.id.btnfakepolicesieren);
		btntorch = (Button) findViewById(R.id.btntorch);
		btnbetterystatus = (Button) findViewById(R.id.btnbatterystatus);
		btnsafetytips = (Button) findViewById(R.id.btnsafetytips);
		final MediaPlayer mp = new MediaPlayer();
		this.registerReceiver(this.mBatInfoReceiver, 
			    new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		
		btnfakepolicesieren.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(mp.isPlaying() == true)
					{
						mp.stop();
					}
					else{
					mp.stop();
					 mp.reset();
					try {

						AssetFileDescriptor afd;
						afd = getAssets().openFd("audio/Police_Siren.mp3");
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
				}
					
				});
		btntorch .setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					try{ 
						   if(clickOn == true) {
						   clickOn = false;
						   camera = Camera.open();
						   Parameters parameters = camera.getParameters();
						   parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
						   camera.setParameters(parameters);
						   camera.startPreview();
						   } else {
						   clickOn = true;
						   camera.stopPreview();
						   camera.release();
						   camera = null;
						   }    
						   }catch(Exception e) {}

					}
				});
		btnbetterystatus.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Bettery status is "+level + "%",Toast.LENGTH_LONG).show(); 

					}
				});
		btnsafetytips.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					Intent intentW=new Intent(getApplicationContext(),SafetyTips.class);
					startActivity(intentW);
					}
				});
	}

	
	}
