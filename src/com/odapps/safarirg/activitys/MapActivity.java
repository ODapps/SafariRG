package com.odapps.safarirg.activitys;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

import com.odapps.safarirg.R;
import com.odapps.safarirg.classes.TouchImageView;
import com.odapps.safarirg.classes.ZoomablePinView;

public class MapActivity extends Activity implements OnClickListener, OnTouchListener {

	float mx;
	float my;
	
	int mScreenWidth;
	int mScreenHeight;
	int mMapWidth;
	int mMapHeight;
	
	    
	Button mBtn_Center;
	Button mFirstHelp;
	
	//ImageView mapView;
	
	private TouchImageView mapView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
	       

		mapView = (TouchImageView) findViewById(R.id.touchImageViewMap);
		mapView.setImageResource(R.drawable.map);
		mapView.setMaxZoom(10f);
		mapView.setDefulatZoom(2.4f);
		
		mBtn_Center = (Button) findViewById(R.id.Button_Map);
		mBtn_Center.setOnClickListener(this);
				
		mFirstHelp = (Button) findViewById(R.id.Button06);
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
