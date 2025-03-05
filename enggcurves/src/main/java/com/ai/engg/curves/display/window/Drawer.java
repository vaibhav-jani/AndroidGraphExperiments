package com.ai.engg.curves.display.window;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;

import com.ai.engg.curves.drawings.Drawing;

import java.util.ArrayList;

public class Drawer extends AsyncTask<Void, Void, SurfaceRenderer> {

    private Activity activity;

    private ArrayList<Drawing> drawings = new ArrayList<Drawing>();
    private SurfaceAttributes surfaceAttributes;

    private ProgressDialog progressDialog;

    public Drawer(ArrayList<Drawing> drawings, SurfaceAttributes surfaceAttributes, Activity activity) {

        this.drawings = drawings;
        this.activity = activity;
        this.surfaceAttributes = surfaceAttributes;

		/*this.surfaceAttributes = new SurfaceAttributes();
		this.surfaceAttributes.setBackgroundColor("#00000000");
		this.surfaceAttributes.setGridColor("#44FFFFFF");
		this.surfaceAttributes.setAxisColor("#00FFFFFF");*/

    }

    public Drawer(Drawing drawing, SurfaceAttributes surfaceAttributes, Activity activity) {

        if (drawing != null) this.drawings.add(drawing);
        this.activity = activity;
        this.surfaceAttributes = surfaceAttributes;

		/*this.surfaceAttributes = new SurfaceAttributes();
		this.surfaceAttributes.setBackgroundColor("#00000000");
		this.surfaceAttributes.setGridColor("#AAFFFFFF");
		this.surfaceAttributes.setAxisColor("#00FFFFFF");*/
    }

    public void draw() {
        this.execute();
    }

    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Rendering Please Wait  ...");
        progressDialog.setCancelable(true);
        progressDialog.setOnCancelListener(new OnCancelListener() {

            public void onCancel(DialogInterface dialog) {

                Drawer.this.cancel(true);
                activity.finish();
            }

        });
        progressDialog.show();

    }

    ;

    @Override
    protected SurfaceRenderer doInBackground(Void... params) {

        return new SurfaceRenderer(activity, drawings, surfaceAttributes);
    }

    @Override
    protected void onPostExecute(SurfaceRenderer result) {
        super.onPostExecute(result);
        activity.setContentView(result);
        if (progressDialog != null) progressDialog.dismiss();
    }
} 
