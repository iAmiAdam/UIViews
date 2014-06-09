package info.adamjsmith.basicviews;

import android.app.Activity;
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

public class BasicViews extends Activity {
	
	String[] presidents = {
			"Dwight D. Eisenhower",
			"John F. Kennedy"
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
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
    
    private void DisplayToast(String msg) {
    	Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
