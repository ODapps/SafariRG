package com.odapps.safarirg.activitys;

import java.util.ArrayList;
import java.util.List;

import com.odapps.safarirg.R;
import com.odapps.safarirg.classes.C;
import com.odapps.safarirg.classes.StandardListAdapter;
import com.odapps.safarirg.classes.StandardListItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class ClassesActivity extends Activity {

	private List<StandardListItem> classesList;
	private StandardListAdapter animalsAdapter;

	private ViewFlipper vfClasses;
	private ListView lvClasses;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classes);

		initialize();
		fillList();
	}

	private void initialize() {
		// List and Adapter
		classesList = new ArrayList<StandardListItem>();
		animalsAdapter = new StandardListAdapter(this, R.layout.activity_classes, classesList);

		// ViewFlipper
		vfClasses = (ViewFlipper) findViewById(R.id.vfClasses);
		vfClasses.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		vfClasses.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		vfClasses.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent animalsListIntent = new Intent(ClassesActivity.this, AnimalsActivity.class);
				switch (vfClasses.getCurrentView().getId()) {
				case R.id.ivBirds:
					animalsListIntent.putExtra("animalClass", C.BIRD);
					break;
				case R.id.ivMammals:
					animalsListIntent.putExtra("animalClass", C.MAMMAL);
					break;
				case R.id.ivReptiles:
					animalsListIntent.putExtra("animalClass", C.REPTILE);
					break;
				}
				startActivity(animalsListIntent);
			}
		});
		vfClasses.setFlipInterval(4000);
		vfClasses.startFlipping();

		// ListView
		lvClasses = (ListView) findViewById(R.id.lvClasses);
		lvClasses.setClickable(true);
		lvClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent animalsListIntent = new Intent(ClassesActivity.this, AnimalsActivity.class);
				animalsListIntent.putExtra("animalClass", ((StandardListItem) parent.getItemAtPosition(position)).getItemId());
				startActivity(animalsListIntent);
			}

		});
		lvClasses.setAdapter(animalsAdapter);
	}

	private void fillList() {
		String path = "android.resource://" + getPackageName() + "/raw/";
		classesList.add(new StandardListItem(C.ALL, "All", null, null));
		classesList.add(new StandardListItem(C.AMPHIBIAN, "Amphibians", null, path + "classes_mammals"));
		classesList.add(new StandardListItem(C.BIRD, "Birds", null, path + "classes_birds"));
		classesList.add(new StandardListItem(C.INSECT, "Insects", null,  path + "classes_mammals"));
		classesList.add(new StandardListItem(C.MAMMAL, "Mammals", null, path + "classes_mammals"));
		classesList.add(new StandardListItem(C.REPTILE, "Reptiles", null, path + "classes_reptiles"));

		animalsAdapter.notifyDataSetChanged();
	}
}
