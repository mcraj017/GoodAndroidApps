package com.example.learnmalay;


import java.util.ArrayList;



import android.annotation.SuppressLint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScoreActivity extends Activity {

	private ArrayList<LoginTable> list;
	private LoginDataBaseAdapter loginDataBaseAdapter;
	private TextView tv,tv2;
	private LinearLayout ll;
	private int total;
	private LinearLayout rl;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		
		// SOME CODE
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	    loginDataBaseAdapter=loginDataBaseAdapter.open();
	    
	    
	     rl = (LinearLayout) findViewById(R.id.showscorelayout);
	     list = loginDataBaseAdapter.getAllElements();
	    for(LoginTable lt : list)
	    {
	    	tv = new TextView(this);
	    	tv.setText(lt.USERNAME);
	    	 
	    	total =lt.GRAMMARSCORE+lt.VERBSCORE+lt.DICTIONARYSCORE;
	    	
	    	tv2 = new TextView(this);
	    	tv2.setText("\t\t\t\t\t\t\t\t\t"+total+"/27");
	    	
	    	ll =new LinearLayout(this);
	    	ll.addView(tv);
	    	ll.addView(tv2);
	    	
	    	rl.addView(ll);
	    	System.out.println(lt.USERNAME+" : "+" , "+lt.GRAMMARSCORE+" , "+lt.VERBSCORE+" , "+lt.DICTIONARYSCORE);
	    }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
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
}
