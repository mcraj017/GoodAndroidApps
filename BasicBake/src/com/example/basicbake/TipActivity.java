package com.example.basicbake;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class TipActivity extends Activity {

	Button btnBack;
	TextView mTextView;
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip);
		 btnBack = (Button) findViewById(R.id.btnTipback);
		 Bundle bundle = getIntent().getExtras();
			String Tip= bundle.getString("tip");
			
			mTextView = (TextView) findViewById(R.id.Texttiptitle);
			mTextView.setText(Tip);
			
			webView = (WebView) findViewById(R.id.webTip);
			Tip = Tip.toLowerCase();
			Tip=Tip.replace(" ", "");
			Tip=Tip.replace("#", "");
			webView.loadUrl("file:///android_asset/"+Tip+".html");
	
	btnBack.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {

			finish();
			}
		});

}
}