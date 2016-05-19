package com.example.wassuputp;


import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;



public class MainActivity extends Activity implements OnItemSelectedListener {
	
	TableLayout tl = null;
	Spinner spinner;
	PropertiesManager pm;
	SearchView search;
	int health =0;
	int social =0;
	int sports =0;
	int entertainment =0;
	int pos =0;
	int yos =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		//search 
		search=(SearchView) findViewById(R.id.searchView1);
		search.setQueryHint("Search Events");
		
		 search.setOnQueryTextListener(new OnQueryTextListener() {
				
				@Override
				public boolean onQueryTextSubmit(String query) {
					// TODO Auto-generated method stub
					Bundle bundle = new Bundle();
					Intent intentSearch=new Intent(getApplicationContext(),SearchActivity.class);
					//Add your data to bundle
					bundle.putString("query",query);
					intentSearch.putExtras(bundle);
					
					startActivity(intentSearch);
					
					return false;
				}
				
				@Override
				public boolean onQueryTextChange(String newText) {
					// TODO Auto-generated method stub
						
				Toast.makeText(getBaseContext(), newText,
						Toast.LENGTH_SHORT).show();
					return false;
				}
			});
        
        
		
		
		 SharedPreferences Histories = getSharedPreferences("Store", Context.MODE_PRIVATE);
			//store history			
				String Max = Histories.getString("Max", null);
				HashSet<String> options = new HashSet<String>();
				options.add("Health");
				options.add("Social");
				options.add("Sports");
				options.add("Entertainment");
				options.add("Programme of Study");
				options.add("Year of Study");
		tl = new TableLayout(this);
		ArrayList<String> Category_Array = new ArrayList<String>();
		pm = new PropertiesManager();
		spinner = new Spinner(this);
		spinner.setBackgroundColor(getResources().getColor(R.color.blue));
		System.out.println(Max);
		if(Max!=null){
		Category_Array.add(Max);
		options.remove(Max);
		Iterator<String> values = options.iterator();
		String value;
		while(values.hasNext())
		{
			value = values.next();
			Category_Array.add(value);
		}
		}
		else{
		Category_Array.add("Health");
		Category_Array.add("Social");
		Category_Array.add("Sports");
		Category_Array.add("Entertainment");
		Category_Array.add("Programme of Study");
		Category_Array.add("Year of Study");
		}

		
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				Category_Array);
		
		spinner.setAdapter(spinnerArrayAdapter);
		
		
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
	 lp.addRule(RelativeLayout.BELOW, spinner.getId());
		
		
		TextView blank1 = new TextView(this);
		TextView blank2 = new TextView(this);
		TextView blank3 = new TextView(this);
		TextView blank4 = new TextView(this);
		TextView tv = new TextView(this);
		TableRow tr1 = new TableRow(this);
		TableRow tr2 = new TableRow(this);
		TableRow tr3 = new TableRow(this);
		TableRow tr4 = new TableRow(this);
		TableRow tr5 = new TableRow(this);
		TableRow tr6 = new TableRow(this);
		
		
		blank1.setText(" ");
		blank2.setText(" ");
		blank3.setText(" ");
		blank4.setText(" ");
		tv.setText("Please Select");
		tr1.addView(blank1);
		tr2.addView(blank2);
		tr3.addView(blank3);
		tr4.addView(blank4);
		tr5.addView(tv);
		tr6.addView(spinner);
		tl.addView(tr1, 0);
		tl.addView(tr2, 1);
		tl.addView(tr3, 2);
		tl.addView(tr4, 3);
		tl.addView(tr5, 4);
		tl.addView(tr6, 5);
		addContentView(tl, lp);
		
		
		spinner.setOnItemSelectedListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		String option = parent.getItemAtPosition(position).toString();
		
		//count selections
		
		if(option.equalsIgnoreCase("Health"))
		{
			health++;
		}
		else if (option.equalsIgnoreCase("Social"))
		{
			social++;
		}
		else if (option.equalsIgnoreCase("Sports"))
		{
			sports++;
		}
		else if (option.equalsIgnoreCase("Entertainment"))
		{
			entertainment++;
		}
		else if (option.equalsIgnoreCase("Programme of Study"))
		{
			pos++;
		}
		else if (option.equalsIgnoreCase("Year of Study"))
		{
			yos++;
		}

		
		 
		System.out.println(tl.getChildCount());
		
		
		if (tl.getChildCount() > 6) {
			tl.removeViews(6, tl.getChildCount() - 6);

		}
	
		TextView tv7 = new TextView(this);
		tv7.setText(option);
		TableRow tr7 = new TableRow(this);
		tr7.addView(tv7);
		ScrollView lv1 = printImage(option);
		TableRow tr8 = new TableRow(this);
		tr8.addView(lv1);
		tl.addView(tr7, 6);
		tl.addView(tr8, 7);
		Set<String> History = new HashSet<String>();
		SharedPreferences Histories = getSharedPreferences("Store", Context.MODE_PRIVATE);
		//store history			
			History= Histories.getStringSet("history", new HashSet<String>());

			Set<String> postHistory=HistoryManager.createHistory(History, option);
			Histories.edit().putStringSet("history", postHistory).commit();

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("posters/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}

	private ScrollView printImage(String imgstr) {

		TableLayout lv = new TableLayout(this);
		ScrollView sv = new ScrollView(this);
		String lowerimgstr = imgstr.toLowerCase();
		List<String> files = null;
		Bitmap image;
		//System.out.println(imgstr);
		
		if(imgstr.equalsIgnoreCase("Programme of Study"))
			lowerimgstr="programmeofstudy";
		else if(imgstr.equalsIgnoreCase("Year of Study"))
			lowerimgstr="yearofstudy";
		
		

		try {
			files = getImage(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int i = 1;
		for (String file : files) {
			if (file.equalsIgnoreCase(lowerimgstr + i + ".png")) {
				image = getBitmapFromAsset(file);
				ImageView im = new ImageView(this);
				TableRow tr1 = new TableRow(this);
				TableRow tr2 = new TableRow(this);
				TextView tv = new TextView(this);
				tv.setText(Html.fromHtml(pm.getDescription(lowerimgstr + i,
						this)));
				im.setImageBitmap(image);
				tr1.addView(tv);
				tr2.addView(im);
				lv.addView(tr1);
				lv.addView(tr2);

				i++;
			}
		}
		if (lv.getChildCount() == 0) {
			image = getBitmapFromAsset("no_event.png");
			ImageView im = new ImageView(this);
			TableRow tr = new TableRow(this);
			im.setImageBitmap(image);
			tr.addView(im);

			lv.addView(tr);
			i = 1;
		
	}
		
		Set<String> History = new HashSet<String>();
		SharedPreferences Histories;
		try{
			Histories= getSharedPreferences("Store", Context.MODE_PRIVATE);
			History= Histories.getStringSet("history", new HashSet<String>());
			History = HistoryManager.RecreateHistory(History, imgstr);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		try{
		if(!History.isEmpty())
		{
			TableRow tr8 = new TableRow(this);
			TextView tv2 = new TextView(this);
			tv2.setText(Html.fromHtml("<b>Suggestions</b>"));
			tr8.addView(tv2);
			lv.addView(tr8);
			for(String history : History)
			{
				TableRow tr9 = new TableRow(this);
				TableRow tr10 = new TableRow(this);
				TextView tv4 = new TextView(this);
				tv4.setText(Html.fromHtml("<b>"+history+"</b>"));
				tr9.addView(tv4);
				
				tr10.addView(addSuggestion(history, files));
				
				lv.addView(tr9);
				lv.addView(tr10);
			}
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		sv.addView(lv);
		return sv;
	}

	private List<String> getImage(Context conetx) throws IOException {
		AssetManager assetManager = conetx.getAssets();
		String[] files = assetManager.list("posters");
		List<String> it = Arrays.asList(files);
		return it;

	}

	public TableLayout addSuggestion(String imgstr,List<String> files) {
		TableLayout lv = new TableLayout(this);
		String lowerimgstr = imgstr.toLowerCase();
		
		Bitmap image;
		
		ImageView im = new ImageView(this);
		if(imgstr.equalsIgnoreCase("Programme of Study"))
			lowerimgstr="programmeofstudy";
		else if(imgstr.equalsIgnoreCase("Year of Study"))
			lowerimgstr="yearofstudy";
		
		
		int i =1;
		for (String file : files) {
			if(file.equalsIgnoreCase("no_event.png"))
				continue;
			else if(file.equalsIgnoreCase(lowerimgstr + i + ".png"))
			{
				
				image = getBitmapFromAsset(file);
				im = new ImageView(this);
				TableRow tr1 = new TableRow(this);
				TableRow tr2 = new TableRow(this);
				TextView tv = new TextView(this);
				tv.setText(Html.fromHtml(pm.getDescription(file.replace(".png", ""),
					this)));
				im.setImageBitmap(image);
				tr1.addView(tv);
			    tr2.addView(im);
				lv.addView(tr1);
				lv.addView(tr2);
			i++;
			}
		}
		return lv;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		String Max =maxValue(health,social, sports, entertainment,	pos, yos);
		SharedPreferences Histories = getSharedPreferences("Store", Context.MODE_PRIVATE);
		//store history

			Histories.edit().putString("Max", Max).commit();

			System.out.println(Max);
		
	}
	
	private String maxValue(int health, int social, int sports, int entertainment,	int pos,	int yos)
	{
		int max = health;
		String Max="Health";
		if(social>max)
		{
			max=social;
			Max="Social";
		}
		if(sports>max)
		{
			max=sports;
			Max="Sports";
		}
		if(entertainment>max)
		{
			max=entertainment;
			Max="Entertainment";
		}
		if(pos>max)
		{
			max=pos;
			Max="Programme of Study";
		}
		if(yos>max)
		{
			max=yos;
			Max="Year of Study";
		}
		return Max;
	}
}
