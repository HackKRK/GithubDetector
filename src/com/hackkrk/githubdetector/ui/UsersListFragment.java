package com.hackkrk.githubdetector.ui;

import java.util.List;

import com.hackkrk.githubdetector.R;
import com.hackkrk.githubdetector.api.GitUser;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UsersListFragment extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.users_list_fragment, container);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	public void setUsersList(List<GitUser> users) {
		setListAdapter(new UsersListAdapter(getActivity(), users));
	}
}
