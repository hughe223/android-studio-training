package com.example.a21hw;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class DisplayWidget extends AppWidgetProvider {
    public static final String mSharedPrefFile = "com.example.a21hw";
    public static final String SAVED_MESSAGE = "save";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        String message = context.getApplicationContext().getSharedPreferences(mSharedPrefFile, 0).getString(SAVED_MESSAGE, "");
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.display_widget);
        views.setTextViewText(R.id.widget_text, message);

        Intent intentBoot = new Intent(context, MainActivity.class);
        PendingIntent pendingBoot = PendingIntent.getActivity(context, appWidgetId, intentBoot, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.AppWidget, pendingBoot);

        Intent intentUpdate = new Intent(context, DisplayWidget.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] idArray = new int[]{appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
        PendingIntent pendingUpdate = PendingIntent.getBroadcast(context, appWidgetId, intentUpdate, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.button_refresh,pendingUpdate);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

}