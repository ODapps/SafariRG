package com.odapps.safarirg.activitys;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.odapps.safarirg.R;
import com.odapps.safarirg.classes.C;
import com.odapps.safarirg.modules.Module_GetHTTP;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends Activity implements OnClickListener  {

	private TextView 	mTextView;
	private Animation	mAnimation;
	private Context 	mContext;
	private ViewFlipper mViewFlipper;
	private Button 		mBtnMap, mBtnAnimals;

	private final int DURATION_OF_NEWS = 500000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// No Screen OFF
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// No Animations to Activity
		getWindow().setWindowAnimations(0);

		// My Activity Context		
		mContext = getApplicationContext();		

		// My Parse.com  initialize - NOT WORKING (OFIR)
		Parse.initialize(this, "M3PK2zNpCpDZUiLt7BkNyE4ng5HCGgfY0cnVdgCR", "e8FCKzzP1r8Qncg691HhwZ8VtP1C8O7o5TSmZiPn"); 
		ParseAnalytics.trackAppOpened(getIntent());

		mTextView = (TextView) findViewById(R.id.tvNews);

		mViewFlipper = (ViewFlipper) findViewById(R.id.vfMenuAnimalsImages);

		mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
			
		mViewFlipper.setFlipInterval(C.TIMER_OF_FLIPVIEW);
		mViewFlipper.startFlipping();

	

		mBtnMap = (Button) findViewById(R.id.bMenuMap);
		mBtnMap.setOnClickListener(this);

		mBtnAnimals = (Button) findViewById(R.id.bMenuAnimals);
		mBtnAnimals.setOnClickListener(this);
		
		
	}

	private void animateTextView(String result) {

		int textWidth = getTextViewWidth(mTextView);

		mAnimation = new TranslateAnimation(
				-textWidth, textWidth,
				0, 0);
		mAnimation.setDuration(DURATION_OF_NEWS);    // Set custom duration.
		mAnimation.setRepeatCount(Animation.INFINITE);    // Infinite animation.
		//mAnimation.scaleCurrentDuration(textWidth);
		mTextView.startAnimation(mAnimation);
		
		Toast.makeText(getApplicationContext(), "123", 1).show();

	}

	private int getTextViewWidth(TextView textView) {
		textView.measure(0, 0);    // Need to set measure to (0, 0).
		return textView.getMeasuredWidth();
	}

	@Override
	public void onClick(View v) {
		int event = v.getId();

		if(event == mBtnMap.getId()) {
			Intent intent = new Intent(getApplicationContext(), MapActivity.class);
			startActivity(intent);
		}

		if(event == mBtnAnimals.getId()) {
			Intent intent = new Intent(this, ClassesActivity.class);
			startActivity(intent);

		}
	}

}
