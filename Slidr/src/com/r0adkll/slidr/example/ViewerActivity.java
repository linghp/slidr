package com.r0adkll.slidr.example;

import android.app.Activity;
import android.os.Bundle;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.example.model.AndroidOS;

/**
 * Created by r0adkll on 1/11/15.
 */
public class ViewerActivity extends Activity {

    public static final String EXTRA_OS = "extra_os_version";



    private AndroidOS mOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        int primary = getResources().getColor(R.color.primaryDark);
        int secondary = getResources().getColor(R.color.accent);
        Slidr.attach(this, primary, secondary);

    }


}
