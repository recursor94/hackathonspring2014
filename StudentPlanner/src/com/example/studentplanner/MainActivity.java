package com.example.studentplanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public class MainActivity extends Activity{
	
	private ArrayList<StudentEndeavor> studentEndeavors;
	private AlarmManager alarmManager; //used to register task in background and launch twilio intent after time passes.
	
	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if (savedInstanceState == null) {
          //  getSupportFragmentManager().beginTransaction()
            //        .add(R.id.container, new PlaceholderFragment())
              //      .commit();
        //}
        
        
        try {
        	  ViewConfiguration config = ViewConfiguration.get(this);
        	  Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

        	  if (menuKeyField != null) {
        	    menuKeyField.setAccessible(true);
        	    menuKeyField.setBoolean(config, false);
        	  }
        	}
        	catch (Exception e) {
        	  // presumably, not relevant
        	}
        
        alarmManager  = (AlarmManager) getSystemService(ALARM_SERVICE);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
    	 MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.main_activity_actions, menu);
        
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       switch(item.getItemId()) {
       case R.id.action_new:
    	   makeNewActivityForm();
    	   break;
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void makeNewActivityForm() {
    	Intent intent = new Intent(this, NewEndeavorActivity.class);
    	startActivityForResult(intent, Activity.RESULT_OK);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    /*	Log.d("MainActivity", "Started response to activity.");
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	//create student endeavor to hold new data.
    	
    	//lots of code required to get proper values from the intents extra key value pair
    	int typeIndex = data.getIntExtra(NewEndeavorActivity.TYPEINDEX, 0);
    	int reminderInterval = data.getIntExtra(NewEndeavorActivity.REMINDERINTERVAL, 0);
    	Calendar dueDate = data.get
    	
    	
    	
    	String name = data.getStringExtra(NewEndeavorActivity.ENDEAVOR);
    	
    	StudentEndeavor studentEndeavor = new StudentEndeavor();
    	
    	
    	alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calend, intervalMillis, operation); */
    	
    	
    	
    }
    
  

}
