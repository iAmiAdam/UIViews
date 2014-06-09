package info.adamjsmith.basicviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BasicViews extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DisplayToast("You have clicked the Open button");
			}
		});
        
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		DisplayToast("You have clicked the Save button");
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
