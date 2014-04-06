package com.example.studentplanner;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

public class NewEndeavorActivity extends ActionBarActivity {
	//define constants for intent extra key.
	private final static String ENDEAVOR = "com.example.studentplanner.NEWENDEAVOR";
	private final static String TYPEINDEX = "com.example.studentplanner.TYPE";
	private final static String DUEDATE = "com.example.studentplanner.DUEDATE";
	private final static String REMINDERDATE = "com.example.studentplanner.REMINDERDATE";
	private final static String REMINDERINTERVAL = "com.example.studentplanner.REMINDERINTERVAL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_endeavor);
		 if (savedInstanceState == null) {
          getSupportFragmentManager().beginTransaction()
                  .add(R.id.container, new PlaceholderFragment())
                  .commit();
      }
	}

	private Object supportgetFragmentManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_endeavor, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_new_endeavor,
					container, false);
			return rootView;
		}
	}
	
	/*public void showCalender() {
		showPopupCalendar(NewEndeavorActivity.this);
	}
	
	
	public void showPopupCalendar(Activity context) {
		LayoutInflater layoutInflater  = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = layoutInflater.inflate(R.layout.fragment_new_endeavor, null, false);
		final PopupWindow popup = new PopupWindow(layout,400,400);
		popup.setContentView(layout);
		popup.setHeight(500);
		popup.setOutsideTouchable(false);
		//popup.setBackgroundDrawable(new BitmapDrawable());

        CalendarView cv = (CalendarView) layout.findViewById(R.id.calendarView);
        cv.setBackgroundColor(Color.BLUE);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month,
                int dayOfMonth) {
            // TODO Auto-generated method stub
            popup.dismiss();
            Log.d("date selected", "date selected " + year + " " + month + " " + dayOfMonth);

            }
        
        });
        popup.showAtLocation(layout, Gravity.TOP,5,170);

        

		
	} */
	
	public void submitOnClick(View v) {
		
		Calendar dueDate = Calendar.getInstance(); //create Calendar to put date and time from input into
		Calendar reminderDate = Calendar.getInstance();
	
		
		EditText endeavorNameField = (EditText) findViewById(R.id.nameEntry);
		Spinner typeField = (Spinner) findViewById(R.id.typeDropDown);
		DatePicker dueDateField = (DatePicker) findViewById(R.id.dueDateEntry);
		DatePicker reminderDateField = (DatePicker) findViewById(R.id.reminderDateEntry);
		Spinner reminderInterval = (Spinner) findViewById(R.id.intervalDropDown);
		TimePicker dueTimeField = (TimePicker) findViewById(R.id.dueDateTime);
		TimePicker reminderTimeField = (TimePicker) findViewById(R.id.reminderTime);
		
		Intent resultIntent = new Intent(); //intent which will return these values to the main activity.
		
		
		String name = endeavorNameField.toString();
		int typeIndex = typeField.getSelectedItemPosition();
		Log.d("NewEndeavorActivity", ""+ typeIndex);  //all logs are debug strings
		dueDate.set(dueDateField.getYear(), dueDateField.getMonth(), dueDateField.getDayOfMonth(), 
				dueTimeField.getCurrentHour(), dueTimeField.getCurrentMinute()); //convert date from picker into Java calendar for easier calculations
		
		Log.d("NewEndeavorActivity", "Calendar: " + dueDate.toString());
		
		reminderDate.set(reminderDateField.getYear(), reminderDateField.getMonth(), reminderDateField.getDayOfMonth(), 
				reminderTimeField.getCurrentHour(), reminderTimeField.getCurrentMinute());
		
		int reminderIntervalIndex = reminderInterval.getSelectedItemPosition();
				
	//send values back
		
		resultIntent.putExtra(ENDEAVOR, name);
		resultIntent.putExtra(TYPEINDEX, typeIndex);
		resultIntent.putExtra(DUEDATE, dueDate);
		resultIntent.putExtra(REMINDERDATE, reminderDate);
		resultIntent.putExtra(REMINDERINTERVAL, reminderIntervalIndex);
		
		
		setResult(Activity.RESULT_OK, resultIntent); //required to send data back to main activity
		
		this.finish();
		
	
		
	}

}
