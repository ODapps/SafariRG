package com.odapps.safarirg.activitys;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

import com.odapps.safarirg.R;
import com.odapps.safarirg.classes.TouchImageView;
import com.odapps.safarirg.classes.ZoomablePinView;

public class MapActivity extends Activity implements OnClickListener, OnTouchListener {

	private Button mBtn_Center, mFirstHelp;

	//ImageView mapView;
	private TouchImageView mapView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		// No Screen OFF
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// No Animations to Activity
		getWindow().setWindowAnimations(0);
		
		mapView = (TouchImageView) findViewById(R.id.tivMap);
		mapView.setImageResource(R.drawable.map);
		mapView.setMaxZoom(10f);
		mapView.setDefulatZoom(2.3f);

		mBtn_Center = (Button) findViewById(R.id.bLocation);
		mBtn_Center.setOnClickListener(this);

		mFirstHelp = (Button) findViewById(R.id.bStudyRoom);
		mFirstHelp.setOnClickListener(this);
	}

	public void printPinPosition(View view) {
		ZoomablePinView pin = mapView.getPin();
		if (pin != null) {
			PointF pinPos = pin.getPositionInPixels();
			Toast.makeText(this, "pin position: " + pinPos.x + ", " + pinPos.y, Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(this, "no pin", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onClick(View v) {
		int event = v.getId();

		if(event == mBtn_Center.getId()) {
			//mapView.scrollTo(0, 0);
			printPinPosition(mapView);
			ZoomablePinView z = new ZoomablePinView(this);
		}

		if(event == mFirstHelp.getId()) {
			mapView.addPin();
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
