package com.marakana.android.fibonaccinative;

public class FibLib {

	public static long fibJR(long n) { // <1>
		return n <= 0 ? 0 : n == 1 ? 1 : fibJR(n - 1) + fibJR(n - 2);
	}

	public static long fibJI(long n) { // <2>
		long previous = -1;
		long result = 1;
		for (long i = 0; i <= n; i++) {
			long sum = result + previous;
			previous = result;
			result = sum;
		}
		return result;
	}

	public native static long fibNR(long n); // <3>

	public native static long fibNI(long n); // <4>

	static {
		System.loadLibrary("com_marakana_android_fibonaccinative_FibLib"); // <5>
	}
}
