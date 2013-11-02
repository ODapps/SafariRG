package com.odapps.safarirg.classes;

import java.util.List;

import com.odapps.safarirg.R;
import com.odapps.safarirg.activitys.ClassesActivity;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StandardListAdapter extends ArrayAdapter<StandardListItem>{

	LinearLayout llLine;
	ImageView ivPic;
	TextView tvName, tvDes;

	public StandardListAdapter(Context context, int resource, List<StandardListItem> objects) {
		super(context, resource, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View block;
		if (getContext().getClass() == ClassesActivity.class) {
			if (position == 0) {
				block = inflater.inflate(R.layout.all_list_line, parent, false);
				return block;
			}
			block = inflater.inflate(R.layout.pic_name_list_line, parent, false);
			tvDes = null;
		}
		else {
			block = inflater.inflate(R.layout.pic_name_des_list_line, parent, false);
			tvDes = (TextView) block.findViewById(R.id.tvDes);
		}
		llLine = (LinearLayout) block.findViewById(R.id.llLine);
		if (position % 2 == 0)
			llLine.getBackground().setAlpha(0);
		else
			llLine.getBackground().setAlpha(70);
		ivPic = (ImageView) block.findViewById(R.id.ivPic);
		tvName = (TextView) block.findViewById(R.id.tvName);
		StandardListItem item = (StandardListItem) getItem(position);
		Uri uri = Uri.parse(item.getImagePath());
		ivPic.setImageURI(uri);
		tvName.setText(item.getItemName());
		if (tvDes != null)
			tvDes.setText(item.getItemDes());
		return block;
	}
}
