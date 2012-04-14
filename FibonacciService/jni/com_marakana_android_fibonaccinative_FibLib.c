#include "com_marakana_android_fibonaccinative_FibLib.h" /* <1> */

jlong fib(jlong n) { /* <2> */
    return n <= 0 ? 0 : n == 1 ? 1 : fib(n - 1) + fib(n - 2);
}

JNIEXPORT jlong JNICALL Java_com_marakana_android_fibonaccinative_FibLib_fibNR
  (JNIEnv *env, jclass clazz, jlong n) { /* <3> */
    return fib(n);
}

JNIEXPORT jlong JNICALL Java_com_marakana_android_fibonaccinative_FibLib_fibNI
  (JNIEnv *env, jclass clazz, jlong n) { /* <4> */
    jlong previous = -1;
    jlong result = 1;
    jlong i;
    for (i = 0; i <= n; i++) {
        jlong sum = result + previous;
        previous = result;
        result = sum;
    }
    return result;
}
