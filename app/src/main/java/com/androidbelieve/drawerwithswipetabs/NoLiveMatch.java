package com.androidbelieve.drawerwithswipetabs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by M.yousaf on 9/20/2016.
 */
public class NoLiveMatch {

    public void showAlertDialog(Context context, String title, String message,
                                Boolean status)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        alertDialog.setTitle(title);

        alertDialog.setMessage(message);

        if(status != null)

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });

        alertDialog.show();
    }
}
