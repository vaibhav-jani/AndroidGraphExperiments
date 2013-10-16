package x.y;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends ListActivity {

	ArrayList<String> tests;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tests = getAllActivities();
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
	}
	@Override
	protected void onListItemClick(ListView list, View view, int position,
			long id) {
		super.onListItemClick(list, view, position, id);

		try {
			Class<?> c = Class.forName(tests.get(position));
			Intent intent = new Intent(this, c);
			startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private ArrayList<String> getAllActivities() {

		ArrayList<String> alla = new ArrayList<String>();

		PackageManager manager = getPackageManager();
		
		List<PackageInfo> pInfos = manager.getInstalledPackages(PackageManager.GET_ACTIVITIES);
		for (PackageInfo pInfo : pInfos) {
			ActivityInfo[] aInfos = pInfo.activities;
			if (aInfos != null) {
				for (ActivityInfo activityInfo : aInfos) {
					String name = activityInfo.name;
					if(name.startsWith("x.y")) alla.add(name);
				}
			}
		}
		
		return alla;
	}
}
