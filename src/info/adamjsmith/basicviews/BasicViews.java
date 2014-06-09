package info.adamjsmith.basicviews;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TimePicker;


public class BasicViews extends Activity {
	
	String[] presidents = {
			"Dwight D. Eisenhower",
			"John F. Kennedy"
	};
	
	TimePicker timePicker;
	
	int hour, minute;
	static final int TIME_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        
        showDialog(TIME_DIALOG_ID);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, presidents);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.txtCountries);
        textView.setThreshold(3);
        textView.setAdapter(adapter);
        
        final ProgressBar progressBar;
		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		progressBar.setVisibility(View.INVISIBLE);
        
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DisplayToast("You have clicked the Open button");
			}
		});
        
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		progressBar.setVisibility(View.VISIBLE);
        		try {
        			Thread.sleep(500);
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
        		progressBar.setVisibility(View.INVISIBLE);
        	}
        });
        
        CheckBox chkAutosave = (CheckBox) findViewById(R.id.chkAutosave);
        chkAutosave.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (((CheckBox)v).isChecked())
					DisplayToast("CheckBox is checked");
				else
					DisplayToast("CheckBox is unchecked");
			}
		});
    }
    
    protected Dialog onCreateDialog(int id) {
    	switch(id) {
    	case TIME_DIALOG_ID:
    		return new TimePickerDialog(this, mTimeSetListener, hour, minute, false);
    	}
    	return null;
    }
    
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
    	public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
    		hour = hourOfDay;
    		minute = minuteOfHour;
    		
    		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
    		Date date = new Date(0,0,0, hour, minute);
    		String strDate = timeFormat.format(date);
    		
    		Toast.makeText(getBaseContext(), "You have slected " + strDate, Toast.LENGTH_SHORT).show();
    	}
    };
    
    public void onClickTime(View view) {
    	Toast.makeText(getBaseContext(), "Time selected: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute(), Toast.LENGTH_SHORT).show();
    }
    
    private void DisplayToast(String msg) {
    	Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
