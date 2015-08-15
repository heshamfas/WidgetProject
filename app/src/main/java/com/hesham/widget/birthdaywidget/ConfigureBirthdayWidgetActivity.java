package com.hesham.widget.birthdaywidget;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ConfigureBirthdayWidgetActivity extends AppCompatActivity {

    private String TAG = ConfigureBirthdayWidgetActivity.class.getSimpleName();
    private int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_widget);
        setupButton();

        //get the widget instance id from the intent extra
        Intent intent= getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
                    }
            }
    private void setupButton(){
        Button button =(Button) findViewById(R.id.btn_bdw_update_bday_widget);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveConfiguration(v);
            }
        });
    }

    //Read Name and Date
    //call updaeAppWidgetLocal to save the values for this instance
    // in that Method also send the view to the home page
    //return the result of the configuration activity to the SDK
    // finish the Activity
    private void saveConfiguration(View v){
        String name = this.getName();
        String date = this.getdate();
        if(Utils.validateDate(date)== false){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_birthday_widget, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
