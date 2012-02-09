package com.hackkrk.githubdetector.ui;

import java.util.List;

import com.hackkrk.githubdetector.R;
import com.hackkrk.githubdetector.api.GitUser;

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

public class UsersListAdapter extends ArrayAdapter<GitUser> {
	
	private final Context context;
	private final List<GitUser> users;

	public UsersListAdapter(Context context, List<GitUser> values) {
		super(context, R.layout.user_list_item, values);
		this.context = context;
		this.users = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.user_list_item, parent,
					false);

			UserListViewHolder holder = new UserListViewHolder();
			holder.label = (TextView) convertView.findViewById(R.id.label);
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			convertView.setTag(holder);
		}

		UserListViewHolder holder = (UserListViewHolder) convertView.getTag();

		GitUser user = this.users.get(position);
		holder.label.setText(user.getLogin());
		holder.icon.setImageResource(R.drawable.ic_launcher);

		return convertView;
	}
}
