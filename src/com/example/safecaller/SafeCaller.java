package com.example.safecaller;

import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SafeCaller extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_safe_caller);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.safe_caller, menu);
		return true;
	}
	
	public void startAlert(View view) {
	    EditText text = (EditText) findViewById(R.id.editTime);
	    int i = Integer.parseInt(text.getText().toString());
	    Intent intent = new Intent(this, alarmindicator.class);
	    PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
	    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
	    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
	        + (i * 1000), pendingIntent);
	    Toast.makeText(this, "Alarm set in " + i + " seconds",
	        Toast.LENGTH_LONG).show();
	  }
	
}

