package com.r0adkll.slidr.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    @InjectView(R.id.recycler)
    Button mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mRecycler.setOnClickListener(this);
    }


	@Override
	public void onClick(View v) {
		 Intent viewer = new Intent(MainActivity.this, ViewerActivity.class);
	        startActivity(viewer);
	}

}
