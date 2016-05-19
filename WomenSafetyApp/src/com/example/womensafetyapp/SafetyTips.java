package com.example.womensafetyapp;



import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.os.Bundle;


public class SafetyTips extends ActionBarActivity {
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_safety_tips);
		webView = (WebView) findViewById(R.id.webView1);
		webView.loadUrl("file:///android_asset/safetytips.html");
	}
}
