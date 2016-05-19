package com.example.wassuputp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SearchActivity extends Activity {
	private String query;
	private PropertiesManager pm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		Bundle bundle = getIntent().getExtras();
		query= bundle.getString("query");
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		addContentView(getResult(query),lp);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
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
	
	
	public ScrollView getResult(String query)
	{
		pm = new PropertiesManager();
		TableLayout tl = new TableLayout(this);
		ScrollView sv = new ScrollView(this);
		HashSet<String> results = new HashSet<String>();
		results = pm.searchProperties(query, this);
		for(String result : results)
		{
			TableRow tr = new TableRow(this);
			tr.addView(printImage(result));
			tl.addView(tr);
		}
		sv.addView(tl);
		return sv;
		
	}
	
	
	
	private TableLayout printImage(String imgstr) {

		TableLayout lv = new TableLayout(this);
		String lowerimgstr = imgstr.toLowerCase();
		List<String> files = null;
		Bitmap image;
		//System.out.println(imgstr);
		
		if(imgstr.equalsIgnoreCase("Programme of Study"))
			lowerimgstr="pos";
		else if(imgstr.equalsIgnoreCase("Year of Study"))
			lowerimgstr="yos";
		
		

		try {
			files = getImage(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int i = 1;
		for (String file : files) {
			if (file.equalsIgnoreCase(lowerimgstr+".png")) {
				image = getBitmapFromAsset(file);
				ImageView im = new ImageView(this);
				TableRow tr1 = new TableRow(this);
				TableRow tr2 = new TableRow(this);
				TextView tv = new TextView(this);
				tv.setText(Html.fromHtml(pm.getDescription(lowerimgstr,
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
		
		return lv;
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
		
		
		
		private List<String> getImage(Context conetx) throws IOException {
			AssetManager assetManager = conetx.getAssets();
			String[] files = assetManager.list("posters");
			List<String> it = Arrays.asList(files);
			return it;

		}
}
