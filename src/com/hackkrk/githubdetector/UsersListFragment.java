package com.hackkrk.githubdetector;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class UsersListFragment extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.users_list_fragment, container);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		String[] items = new String[] {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
		setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.user_list_item,
                items));
	}
}
