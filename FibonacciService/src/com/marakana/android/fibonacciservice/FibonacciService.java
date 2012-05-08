package com.marakana.android.fibonacciservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FibonacciService extends Service { // <1>

	private static final String TAG = "FibonacciService";

	private IFibonacciServiceImpl service; // <2>

	@Override
	public void onCreate() {
		super.onCreate();
		this.service = new IFibonacciServiceImpl(); // <3>
		Log.d(TAG, "onCreate()'ed"); // <5>
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind()'ed"); // <5>
		return this.service; // <4>
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG, "onUnbind()'ed"); // <5>
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy()'ed");
		this.service = null;
		super.onDestroy();
	}
}
