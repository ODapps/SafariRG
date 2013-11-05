package com.odapps.safarirg.activitys;

import com.odapps.safarirg.R;
import com.odapps.safarirg.classes.C;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class ProfileActivity extends Activity {

	private ImageView ivProfileImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);

		initialize();
		fillProfile();
	}

	private void initialize() {
		ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
	}

	private void fillProfile() {
		Intent intent = getIntent();
		Uri uri;
		switch (intent.getIntExtra("animalClass", C.BIRD)) {
		case C.BIRD:
			uri = Uri.parse("android.resource://" + getPackageName() + "/raw/classes_birds");
			ivProfileImage.setImageURI(uri);
			break;
		case C.GORILLA:
			uri = Uri.parse("android.resource://" + getPackageName() + "/raw/profile_gorilla");
			ivProfileImage.setImageURI(uri);
			break;
		default:
			uri = Uri.parse("android.resource://" + getPackageName() + "/raw/classes_birds");
			ivProfileImage.setImageURI(uri);
			break;
		}
		ivProfileImage.setImageURI(uri);
	}

}
