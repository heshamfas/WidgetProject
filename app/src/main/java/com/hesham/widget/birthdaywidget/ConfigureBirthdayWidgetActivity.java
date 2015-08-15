package com.hesham.widget.birthdaywidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

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
        String date = this.getDate();
        if(Utils.validateDate(date)== false){
            setDate("wrong date: " + date);
            return;
        }
        if(this.mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID){
            Toast.makeText(this, "Invalid Widget ID" ,Toast.LENGTH_LONG).show();
            return;
        }
        updateAppWidgetLocal(name,date);
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();
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

    public String getName() {
        EditText nameET = (EditText) findViewById(R.id.et_bdw_text_name);
        return nameET.getText().toString();
    }
    private String getDate(){
        EditText dateText = (EditText)findViewById(R.id.et_bdw_text_date);
        return dateText.getText().toString();
    }

    private void setDate(String date){
        EditText dateText = (EditText)findViewById(R.id.et_bdw_text_date);
        dateText.setText(date);
        dateText.requestFocus();
    }
    private void updateAppWidgetLocal( String name, String dob){
        //Create an object to hold the data: widgetid, name and dob
        BDayWidgetModel bdayWidgetModel = new BDayWidgetModel( mAppWidgetId,name,dob);
        // create the view and send it to the home screen
        updateAppWidget(this, AppWidgetManager.getInstance(this), bdayWidgetModel);
        // use the data model object to save the id, name and dob in prefs
        bdayWidgetModel.savePreferences(this);
    }

    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, BDayWidgetModel widgetModel){
        //Construct a RemoteViews Object from the widget layout file
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.bday_widget);

        //use the control ids in the layout to set values on them.
        //notice that these methods are limited and available on the
        //TextView directly to se these values.

        remoteViews.setTextViewText(R.id.et_bdw_text_name, widgetModel.getName()+ ":" + "widgetModel.iid");


    }
}
