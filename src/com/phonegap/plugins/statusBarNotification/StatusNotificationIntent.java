package com.phonegap.plugins.statusBarNotification;

import oschneider.NotificationPhoneGap.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class StatusNotificationIntent
{
	public static Notification buildNotification(Context context,
			CharSequence tag, CharSequence contentTitle,
			CharSequence contentText, String url)
	{
		int icon = R.drawable.icon;
		// URL intent
		Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
		notificationIntent.setData(Uri.parse(url));

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(icon).setContentTitle(contentTitle)
				.setContentText(contentText)
				.setPriority(NotificationCompat.PRIORITY_HIGH)
				.setTicker(contentText)
				.setAutoCancel(true);
		PendingIntent resultPendingIntent = PendingIntent.getActivity(context,
				0, notificationIntent, 0);
		mBuilder.setContentIntent(resultPendingIntent);
		return mBuilder.build();
	}
}
