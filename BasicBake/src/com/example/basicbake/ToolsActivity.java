package com.example.basicbake;


import java.io.IOException;
import java.io.InputStream;



import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ToolsActivity extends Activity {
	private int maxcount =10;
	private int count =0;
	private ImageView im = null;
	private Button Nextbtn = null;
	private Button Backbtn = null;
	private Button Basictoolsbtn = null;
	private TextView tvbasictools=null;
	private String[] tools = {"PASTRY","COOLING","CUPCAKE PAN","MEASURING","MIXER","PIPING BAG"
								,"ROLLER","SPATULA","CAKE PAN","FLOWER"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools);
		
		Nextbtn = (Button) findViewById(R.id.btntoolsnext);
		Basictoolsbtn = (Button) findViewById(R.id.btnbasictools);
		Backbtn = (Button) findViewById(R.id.btntoolsback);
		im=(ImageView) findViewById(R.id.imgtools1);
		
		tvbasictools = (TextView) findViewById(R.id.texttools);
		

		Nextbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(true);
			}
		});
		
		Backbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				printImage(false);
			}
		});
		Basictoolsbtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Nextbtn.setVisibility(View.VISIBLE);
				Backbtn.setVisibility(View.VISIBLE);
				Basictoolsbtn.setVisibility(View.INVISIBLE);
				printImage(true);
			}
		});

	}
	private Bitmap getBitmapFromAsset(String strName) {
		AssetManager assetManager = getAssets();
		InputStream istr = null;

		try {
			istr = assetManager.open("tools/" + strName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		return bitmap;
	}

	private void printImage(boolean next) {
		if (count < maxcount) {
			if (next)
				count++;
			else if (!next)
				if (count == 0 || count == 1)
					count = maxcount;
				else
					count--;
		} else
			if(next)
			count = 1;
			else
				count--;
		
		String tool = tools[count-1];
		
		tvbasictools.setText(tool);
		tool = tool.replace(" ", "");
		tool = tool.toLowerCase();
		System.out.println(tool);
		Bitmap image = getBitmapFromAsset(tool + ".png");
		im.setImageBitmap(image);

	}
	
}
