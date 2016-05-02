package com.cooshow.objectanamition;

import com.cooshow.objectanamition.Topbar.TopbarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Topbar bar=(Topbar) findViewById(R.id.topbar);
		bar.setOnTopbarClickListener(new TopbarClickListener() {
			
			@Override
			public void rightClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "right click", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "left click", Toast.LENGTH_SHORT).show();
			}
		});
//		bar.setLeftVisible(false);
	}
	
	
}
