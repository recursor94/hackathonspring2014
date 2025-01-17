package com.example.studentplanner;

import java.util.Calendar;

public class StudentEndeavor {
private int type;
private Calendar dueDate;
private String endeavorName;
private Calendar reminderStartDate;
private long reminderInterval; //time interval to remind student
public StudentEndeavor (int t, Calendar dD, String an, Calendar rsd, long ri) {
	this.type = t;
	this.dueDate = dD;
	this.endeavorName = an;
	this.reminderStartDate = rsd;
	this.reminderInterval = ri;
}

public long getDueDate() {
	
	/*returns time in mili seconds so it can be compared
	to other dates, and registered with the android alarm service
	to be repeated over time. */
	return dueDate.getTimeInMillis();
}


public String getEndeavorName() {
	return endeavorName;
}

public long getReminderStartDate() {
	return reminderStartDate.getTimeInMillis();
}

public long getReminderInterVal() {
	return reminderInterval;
}

public String getName() {
	return endeavorName;
}
public int getType() {
	return type;
}


}
