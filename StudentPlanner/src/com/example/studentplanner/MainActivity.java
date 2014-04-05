package com.example.studentplanner;

import java.lang.reflect.Field;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

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

}
