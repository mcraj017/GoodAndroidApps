package com.example.basicbake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WatchActivity extends Activity implements OnClickListener {

	final int MSG_START_TIMER = 0;
	final int MSG_STOP_TIMER = 1;
	final int MSG_UPDATE_TIMER = 2;
	private int MAX_MIN = 1;

	StopWatch timer = new StopWatch();
	final int REFRESH_RATE = 100;

	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case MSG_START_TIMER:
				timer.start(); // start timer
				mHandler.sendEmptyMessage(MSG_UPDATE_TIMER);
				break;

			case MSG_UPDATE_TIMER:
				tvTextView.setText("" + timer.getElapsedTimeSecs());
				tvTextView2.setText("" + timer.getElapsedTimeMin());
				if (timer.getElapsedTimeMin() == MAX_MIN) {
					timer.stop();
					Intent i = new Intent(WatchActivity.this,
							EndTimerActivity.class);
					startActivity(i);
					finish();
				}
				mHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIMER, REFRESH_RATE); // text
																					// view
																					// is
																					// updated
																					// every
																					// second,

				break; // though the timer is still running
			case MSG_STOP_TIMER:
				mHandler.removeMessages(MSG_UPDATE_TIMER); // no more updates.
				timer.stop();// stop timer
				tvTextView.setText("" + timer.getElapsedTimeSec());
				tvTextView2.setText("" + timer.getElapsedTimeMins());
				break;

			default:
				break;
			}
		}
	};

	TextView tvTextView, tvTextView2;
	EditText tvmaxmin;
	Button btnStart, btnStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_watch);

		tvTextView = (TextView) findViewById(R.id.time);
		tvTextView2 = (TextView) findViewById(R.id.time2);
		tvmaxmin = (EditText) findViewById(R.id.MaxMin);

		btnStart = (Button) findViewById(R.id.btnstartwatch);
		btnStop = (Button) findViewById(R.id.btnstopwatch);
		btnStart.setOnClickListener(this);
		btnStop.setOnClickListener(this);
	}

	public void onClick(View v) {
		if (btnStart == v) {

			try {
				MAX_MIN = Integer.parseInt(tvmaxmin.getText().toString());
				if (MAX_MIN < 1 || MAX_MIN > 60) {
					Toast.makeText(getBaseContext(),
							"Please enter valid value", Toast.LENGTH_SHORT)
							.show();
					return;
				}

			} catch (Exception e) {
				Toast.makeText(getBaseContext(), "Please enter valid value",
						Toast.LENGTH_SHORT).show();
			}
			mHandler.sendEmptyMessage(MSG_START_TIMER);
		} else if (btnStop == v) {
			mHandler.sendEmptyMessage(MSG_STOP_TIMER);
		}
	}
}
