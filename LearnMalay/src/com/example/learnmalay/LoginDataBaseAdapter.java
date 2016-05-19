package com.example.learnmalay;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter 
{
		static final String DATABASE_NAME = "login.db";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		// TODO: Create public field for each column in your table.
		// SQL Statement to create a new database.
		static final String DATABASE_CREATE = "create table "+"LOGIN"+
		                             "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text," +
		                             		"PASSWORD text,GRAMMARSCORE integer," +
		                             		"VERBSCORE integer,DICTIONARYSCORE integer); ";
		// Variable to hold the database instance
		public  SQLiteDatabase db;
		// Context of the application using the database.
		private final Context context;
		// Database open/upgrade helper
		private DataBaseHelper dbHelper;
		public  LoginDataBaseAdapter(Context _context) 
		{
			context = _context;
			dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  LoginDataBaseAdapter open() throws SQLException 
		{
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			db.close();
		}

		public  SQLiteDatabase getDatabaseInstance()
		{
			return db;
		}

		public void insertEntry(String userName,String password)
		{
	       ContentValues newValues = new ContentValues();
			// Assign values for each row.
			newValues.put("USERNAME", userName);
			newValues.put("PASSWORD",password);
			
			// Insert the row into your table
			db.insert("LOGIN", null, newValues);
			///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
		}
		public int deleteEntry(String UserName)
		{
			//String id=String.valueOf(ID);
		    String where="USERNAME=?";
		    int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
	       // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
	        return numberOFEntriesDeleted;
		}	
		public String getSinlgeEntry(String userName)
		{
			Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
	        if(cursor.getCount()<1) // UserName Not Exist
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
			String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
			cursor.close();
			return password;				
		}
		public void  updateEntry(String userName,String password)
		{
			// Define the updated row content.
			ContentValues updatedValues = new ContentValues();
			// Assign values for each row.
			updatedValues.put("USERNAME", userName);
			updatedValues.put("PASSWORD",password);
			
	        String where="USERNAME = ?";
		    db.update("LOGIN",updatedValues, where, new String[]{userName});			   
		}		
		
		public void update(String UserName, int score,int partno) {
	        if (db == null) {
	            return;
	        }
	        String part = null;
	        switch(partno){
	        case 1:
	        	part = "GRAMMARSCORE";
	        	break;
	        case 2:
	        	part = "VERBSCORE";
	        	break;
	        case 3:
	        	part ="DICTIONARYSCORE";
	        	break;
	        };

	        ContentValues row = new ContentValues();
	        row.put(part, score);
	        db.update("LOGIN", row, "USERNAME = ?", new String[] {UserName} );
	        db.close();
	    }
		
		public ArrayList<LoginTable> getAllElements() {

		    ArrayList<LoginTable> list = new ArrayList<LoginTable>();

		    // Select All Query
		    String selectQuery = "SELECT  * FROM LOGIN";

		    try {

		        Cursor cursor = db.rawQuery(selectQuery, null);
		        try {

		            // looping through all rows and adding to list
		            if (cursor.moveToFirst()) {
		                do {
		                   LoginTable obj = new LoginTable();
		                   
		                    //only one column
		                    obj.setUSERNAME(cursor.getString(1));
		                    obj.setGRAMMARSCORE(cursor.getInt(3));
		                    obj.setVERBSCORE(cursor.getInt(4));
		                    obj.setDICTIONARYSCORE(cursor.getInt(5));

		                    //you could add additional columns here..

		                    list.add(obj);
		                } while (cursor.moveToNext());
		            }

		        } finally {
		            try { cursor.close(); } catch (Exception ignore) {}
		        }

		    } finally {
		         try { db.close(); } catch (Exception ignore) {}
		    }

		    return list;
		}
	
}

