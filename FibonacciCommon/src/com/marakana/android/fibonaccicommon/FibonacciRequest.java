
package com.marakana.android.fibonaccicommon;

import android.os.Parcel;
import android.os.Parcelable;

public class FibonacciRequest implements Parcelable {

    public static final int RECURSIVE_JAVA_TYPE = 1;

    public static final int ITERATIVE_JAVA_TYPE = 2;

    public static final int RECURSIVE_NATIVE_TYPE = 3;

    public static final int ITERATIVE_NATIVE_TYPE = 4;

    private final long n;

    private final int type;

    public FibonacciRequest(long n, int type) {
        this.n = n;
        if (type < RECURSIVE_JAVA_TYPE || type > ITERATIVE_NATIVE_TYPE) {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
        this.type = type;
    }

    private FibonacciRequest(Parcel parcel) {
        this(parcel.readLong(), parcel.readInt());
    }

    public long getN() {
        return n;
    }

    public int getType() {
        return type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(this.n);
        parcel.writeInt(this.type);
    }

    public static final Parcelable.Creator<FibonacciRequest> CREATOR = new Parcelable.Creator<FibonacciRequest>() {
        public FibonacciRequest createFromParcel(Parcel in) {
            return new FibonacciRequest(in);
        }

        public FibonacciRequest[] newArray(int size) {
            return new FibonacciRequest[size];
        }
    };
}
