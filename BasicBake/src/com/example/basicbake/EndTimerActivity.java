package com.example.basicbake;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndTimerActivity extends Activity {
	Button btnback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_timer);

		btnback = (Button) findViewById(R.id.btnendtimerback);
		btnback.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
}
