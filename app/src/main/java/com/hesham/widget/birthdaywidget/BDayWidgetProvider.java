package com.hesham.widget.birthdaywidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

/**
 * Created by root on 8/12/15.
 */
public class BDayWidgetProvider extends AppWidgetProvider {
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
    }
}
