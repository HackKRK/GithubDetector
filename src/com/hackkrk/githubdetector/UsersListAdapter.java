package com.hackkrk.githubdetector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class UserListViewHolder {
	ImageView icon;
	TextView label;
}

public class UsersListAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public UsersListAdapter(Context context, String[] values) {
		super(context, R.layout.user_list_item, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
		LayoutInflater inflater = LayoutInflater.from(context);
		/*
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		*/
		convertView = inflater.inflate(R.layout.user_list_item, parent, false);
		}

		return convertView;
	}
}

