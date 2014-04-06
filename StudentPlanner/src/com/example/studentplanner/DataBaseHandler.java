package com.example.studentplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class DataBaseHandler extends SQLiteOpenHelper {
	private static final String DATABASE_NAME ="plannerDB";
	private static final int DATABASE_VERSION = 2;
	
	
	
	private static final String DATABASE_CREATE_DUE_DATE = "create table Due_Date "
			+ "(id integer primary key autoincrement, Month integer not null, year integer not null, day integer not null, hour integer not null, minute integer not null) ";
	
	private static final String DATABASE_CREATE_REMINDER_DATE = "create table Reminder_Date "
			+ "(id integer primary key autoincrement, Month integer not null, year integer not null, day integer not null, hour integer not null, minute integer not null) ";
	private static final String DATABASE_CREATE_STUDENT_ACTIVITIES =  "create table Student_Activities "
			+ "(id integer primary key autoincrement, name text not null, type text not null,"
			+ " Due_Date_Id integer, Reminder_Date_Id Integer, Reminder_Interval integer, "
			+ "foreign key (Due_Date_Id) references Due_Date(Id), "
			+ "foreign key (Reminder_Date_Id) references Reminder_Date(Id)"
			+ ")";
	

	public DataBaseHandler (Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
 	
	@Override
	public void onCreate(SQLiteDatabase database) {
		//run during creation of database.
		database.execSQL("PRAGMA foreign_keys = ON");
		database.execSQL(DATABASE_CREATE_DUE_DATE);
		database.execSQL(DATABASE_CREATE_REMINDER_DATE);
		database.execSQL(DATABASE_CREATE_STUDENT_ACTIVITIES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		//run during upgrade to new database
		 Log.w(DataBaseHandler.class.getName(),
                 "Upgrading database from version " + oldVersion + " to "
                         + newVersion + ", which will destroy all old data");
		 database.execSQL("PRAGMA foreign_keys = ON");
		 database.execSQL("drop table if exists Due_date");
		 database.execSQL("drop table if exists Reminder_date");
		 database.execSQL("drop table if exists Student_Activites");
		 
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
		
		String query = "insert into Due_Date values (" + dp.getMonth() +", " + dp.getYear() + ", " + dp.getDayOfMonth() + ", " + tp.getCurrentHour() + ", " + tp.getCurrentMinute() + ")";
		Log.d("DatabaseHandler", query);
		database.execSQL(query);
	}

}
