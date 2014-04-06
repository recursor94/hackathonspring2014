package com.example.studentplanner;

import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class DataBaseHandler extends SQLiteOpenHelper {
	private static final String DATABASE_NAME ="plannerDB";
	private static final int DATABASE_VERSION = 7;
	
	
	
	private static final String DATABASE_CREATE_DUE_DATE = "create table DueDate "
			+ "(id integer primary key autoincrement, Month integer not null, year integer not null, day integer not null, hour integer not null, minute integer not null) ";
	
	private static final String DATABASE_CREATE_REMINDER_DATE = "create table ReminderDate "
			+ "(id integer primary key autoincrement, Month integer not null, year integer not null, day integer not null, hour integer not null, minute integer not null) ";
	
	private static final String DATABASE_CREATE_STUDENT_ACTIVITIES =  "create table Student_Activities "
			+ "(id integer primary key autoincrement, name text not null, type text not null, "
			+ " DueDate integer, ReminderDate Integer, ReminderInterval integer)";
	

	public DataBaseHandler (Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
 	
	@Override
	public void onCreate(SQLiteDatabase database) {
		//run during creation of database.
		database.execSQL("PRAGMA foreign_keys = ON");
		//database.execSQL(DATABASE_CREATE_DUE_DATE);
		//database.execSQL(DATABASE_CREATE_REMINDER_DATE);
		database.execSQL(DATABASE_CREATE_STUDENT_ACTIVITIES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		//run during upgrade to new database
		 Log.w(DataBaseHandler.class.getName(),
                 "Upgrading database from version " + oldVersion + " to "
                         + newVersion + ", which will destroy all old data");
		 database.execSQL("PRAGMA foreign_keys = ON");
		 database.execSQL("drop table if exists DueDate");
		 database.execSQL("drop table if exists ReminderDate");
		 database.execSQL("drop table if exists Student_Activities");
		 
		 onCreate(database);
		 
		

	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
			super.onOpen(db);
			if (!db.isReadOnly()) {
	// Enable foreign key constraints
	db.execSQL("PRAGMA foreign_keys=ON;"); //required to enable foreign keys!
	}
		}
	
	public void addDueDate(DatePicker dp, TimePicker tp) {
		
		SQLiteDatabase database = this.getWritableDatabase();
		
		String query = "insert into DueDate (month, year, day, hour, minute) "
				+ "values (" + dp.getMonth() +", " + dp.getYear() + ", " + dp.getDayOfMonth() + ", " + tp.getCurrentHour() + ", " + tp.getCurrentMinute() + ")";
		Log.d("DatabaseHandler", query);
		database.execSQL(query);
	}
	
	public void addReminderDate(DatePicker dp, TimePicker tp) {
		SQLiteDatabase database= this.getWritableDatabase();
		
		String query = "insert into ReminderDate (month, year, day, hour, minute) values ("
				+ "" + dp.getMonth() +", " + dp.getYear() + ", " + dp.getDayOfMonth() + ", " + tp.getCurrentHour() + ", " + tp.getCurrentMinute() + ")";
		Log.d("DatabaseHandler", query);
		database.execSQL(query);

		
	}
	
	public void addStudentActivity(String name, int typeIndex, int reminderIndex, Calendar dueDate, Calendar reminderDate ) {
		SQLiteDatabase database = this.getWritableDatabase();
		String type = "";
		long reminderInterval = 0l; //in milliseconds since this is how dates can be best compared, and how alarm service works.
		
		switch(typeIndex) {
		case 0:
			type = "Class";
			break;
		case 1:
			type = "Extracurricular";
			break;
		case 2:
			type = "Other";
			break;
		}
		
		switch(reminderIndex) {
		case 0:
			reminderInterval =  604800000; //This many milliseconds are in a week.
			break;
		
		case 1:
			reminderInterval = 86400000; //in a day
			break;
		case 2:
			reminderInterval = 43200000; //in 12 hours
			break;
		case 3:
			reminderInterval = 3600000; //in an hour
			break;
		case 4:
			reminderInterval = 1800000; //in 30 minutes
			break;
		case 5:
			reminderInterval=600000; //in 10 minutes
			break;
		case 6:
			reminderInterval=300000;//in 5 minutes
			break;
		
			}
		
		String query = "insert into Student_Activities(name, type, DueDate, ReminderDate, ReminderInterval) values ('" + name + "', '" + type + 
				"' , " + dueDate.getTimeInMillis() + " , " + reminderDate.getTimeInMillis() + " , " + reminderInterval + ")";
		
		
		Log.d("QUUUUERRRRRYYYY", query);
		
		/*(ArrayList<String[]> strs = getDbTableDetails();
		
		
		for(String[] as : strs) {
			for(String s :as ) {
				Log.d("SCHEMA", s);
			}
		} */
		
		database.execSQL(query);
		
		
		
		
		
	}
	
	
	/**
     * Get all table Details from teh sqlite_master table in Db.
     * 
     * @return An ArrayList of table details.
     */
  /*  public ArrayList<String[]> getDbTableDetails() {
        
    	SQLiteDatabase database = this.getWritableDatabase();
    	Cursor c = database.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table'", null);
        ArrayList<String[]> result = new ArrayList<String[]>();
        int i = 0;
        result.add(c.getColumnNames());
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String[] temp = new String[c.getColumnCount()];
            for (i = 0; i < temp.length; i++) {
                temp[i] = c.getString(i);
            }
            result.add(temp);
        }

        return result;
    }*/
	
	
	public void queryAllActivities() {
		SQLiteDatabase database = this.getReadableDatabase();
		Cursor cursor = database.query("Student_Activities", new String [] {"id", "name", "type", "DueDate", "ReminderDate", "ReminderInterval"}, null, null, null, null, null, null);
		while(cursor.moveToNext()) {
			Log.d("Query", cursor.getString(cursor.getColumnIndex("name")));
			Log.d("Query", cursor.getString(cursor.getColumnIndex("type")));
			Log.d("Query", cursor.getLong(cursor.getColumnIndex("DueDate")) + "");
			Log.d("Query", cursor.getLong(cursor.getColumnIndex("ReminderDate")) + "");
			Log.d("Query", cursor.getLong(cursor.getColumnIndex("ReminderInterval")) + "");


			
		}
		
		
	}

}
