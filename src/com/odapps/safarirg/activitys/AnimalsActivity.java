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
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class AnimalsActivity extends Activity {

	private List<StandardListItem> animalsList;
	private StandardListAdapter animalsAdapter;
	private int animalClass;
	private String path;

	private ListView lvAnimals;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animals);

		// No Screen OFF
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// No Animations to Activity
		getWindow().setWindowAnimations(0);

		initialize();
		fillList();
	}

	private void initialize() {
		// List and Adapter
		animalsList = new ArrayList<StandardListItem>();
		animalsAdapter = new StandardListAdapter(this, R.layout.activity_animals, animalsList);

		// ListVIew
		lvAnimals = (ListView) findViewById(R.id.lvAnimals);
		lvAnimals.setClickable(true);
		lvAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				StandardListItem animal = animalsList.get(position);
				Intent profileIntent = new Intent(AnimalsActivity.this, ProfileActivity.class);
				
				int animalId = animal.getItemId();
				if (animalId == C.GORILLA) {
					profileIntent.putExtra("animalClass", animalId);
					startActivity(profileIntent);
				}
			}
		});
		lvAnimals.setAdapter(animalsAdapter);
		animalClass = getIntent().getIntExtra("animalClass", C.MAMMAL);
	}

	private void fillList() {
		path = "android.resource://" + getPackageName() + "/raw/";
		switch (animalClass) {
		case C.ALL:
			addBirds();
			addReptiles();
			addMammals();
			break;
		case C.AMPHIBIAN:
			break;
		case C.BIRD:
			addBirds();
			break;
		case C.INSECT:
			break;
		case C.MAMMAL:
			addMammals();
			break;
		case C.REPTILE:
			addReptiles();
			break;
		}
		animalsAdapter.notifyDataSetChanged();
	}

	private void addBirds() {
		animalsList.add(new StandardListItem(C.PARROT, "Parrot", "Bird", path + "classes_birds"));
		animalsList.add(new StandardListItem(0, "Ostrich", "Bird", path + "classes_birds"));
		animalsList.add(new StandardListItem(0, "Eagle", "Bird", path + "classes_birds"));
	}

	private void addReptiles() {
		animalsList.add(new StandardListItem(0, "Turtle", "Reptile", path + "classes_reptiles"));
		animalsList.add(new StandardListItem(C.SNAKE, "Snake", "Reptile", path + "classes_reptiles"));
		animalsList.add(new StandardListItem(0, "Lizard", "Reptile", path + "classes_reptiles"));
	}

	private void addMammals() {
		animalsList.add(new StandardListItem(C.LION, "Lion", "Mammal", path + "classes_mammals"));
		animalsList.add(new StandardListItem(C.GORILLA, "Gorilla", "Mammal", path + "classes_mammals"));
		animalsList.add(new StandardListItem(0, "Elephent", "Mammal", path + "classes_mammals"));
	}
}
