package com.qian;

public class NativeCaller {
    static {
        System.loadLibrary("hello");

    };

    public static native int getStringFromNative();


}
