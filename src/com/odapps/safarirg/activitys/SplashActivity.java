package com.odapps.safarirg.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.WindowManager;

import com.odapps.safarirg.R;
import com.odapps.safarirg.classes.C;

public class SplashActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		// No Screen OFF
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// No Animations to Activity
		getWindow().setWindowAnimations(0);
		
		Splash timer = new Splash(C.TIMER_OF_SPLASH, 1000);
	    timer.start();
	}
	
	
	
	//Timer Class inside my Activity
    public class Splash extends CountDownTimer{

        public Splash(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
        	
        }
    }


}

