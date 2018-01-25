package ru.redsys.rosenergoatomconference.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by a on 23/01/18.
 */

public class Helpers {

    public static String getTextFromRawFile(Context ctx, int resourceId) {

        InputStream inputStream = ctx.getResources().openRawResource(resourceId);

        byte[] b = new byte[0];
        try {
            b = new byte[inputStream.available()];
            inputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }
}
