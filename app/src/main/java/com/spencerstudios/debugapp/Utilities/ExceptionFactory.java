package com.spencerstudios.debugapp.Utilities;

import android.content.Context;
import android.widget.Toast;

public class ExceptionFactory {

    public static void indexOutOfBounds(Context context) {
        try {
            int[] i = {1, 2, 3};
            int a = i[10];
        } catch (Exception e) {
            msg(context, e.toString());
        }
    }

    public static void nullPointer(Context context) {
        try {
            String string = null;
            System.out.println(string.length());
        } catch (Exception e) {
            msg(context, e.toString());
        }
    }

    public static void arithmetic(Context context) {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            msg(context, e.toString());
        }
    }

    private static void msg(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
