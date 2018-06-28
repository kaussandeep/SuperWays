package com.example.superways;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.superways.TableData.TableInfo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	Context ctx = this ;
	
	
	
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
			

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}
	
	//code for NEXT button

	public void next(View view){
		EditText CNNumber=(EditText) findViewById(R.id.editText1);
	
		int x = Integer.parseInt(CNNumber.getText().toString());
		int y = x+1 ;
		CNNumber.setText(Integer.toString(y));
		EditText destination=(EditText) findViewById(R.id.party);
		EditText datee=(EditText) findViewById(R.id.date);
		EditText pkgs=(EditText) findViewById(R.id.pkgs);
		EditText weight=(EditText) findViewById(R.id.Weight);
		EditText freight=(EditText) findViewById(R.id.Freight);
		EditText consignee=(EditText) findViewById(R.id.Consignee);
		EditText consigner=(EditText) findViewById(R.id.Consigner);
		EditText trucknumber=(EditText) findViewById(R.id.TruckNumber);
		EditText lorryhire=(EditText) findViewById(R.id.LorryHire);
		
		EditText profitbox=(EditText) findViewById(R.id.profit);
		
		DatabaseOperations db = new DatabaseOperations(ctx);
		SQLiteDatabase SQ = db.getReadableDatabase();
		
			Cursor c=SQ.rawQuery("SELECT * from reg_ingo5 WHERE USER_NAME='"+CNNumber.getText()+"'", null);
			if(c.moveToFirst()){
				destination.setText(c.getString(1));
				datee.setText(c.getString(2));
				pkgs.setText(c.getString(3));
				weight.setText(c.getString(4));
				freight.setText(c.getString(5));
				consignee.setText(c.getString(6));
				consigner.setText(c.getString(7));
				lorryhire.setText(c.getString(8));
				trucknumber.setText(c.getString(9));	
				profitbox.setText(c.getString(10));
			}
		}
	
	// Code for PREVIOUS Button
	public void previous(View view){
		EditText CNNumber=(EditText) findViewById(R.id.editText1);
		
		int x = Integer.parseInt(CNNumber.getText().toString());
		int y = x-1 ;
		CNNumber.setText(Integer.toString(y));
		
		EditText destination=(EditText) findViewById(R.id.party);
		EditText datee=(EditText) findViewById(R.id.date);
		EditText pkgs=(EditText) findViewById(R.id.pkgs);
		EditText weight=(EditText) findViewById(R.id.Weight);
		EditText freight=(EditText) findViewById(R.id.Freight);
		EditText consignee=(EditText) findViewById(R.id.Consignee);
		EditText consigner=(EditText) findViewById(R.id.Consigner);
		EditText trucknumber=(EditText) findViewById(R.id.TruckNumber);
		EditText lorryhire=(EditText) findViewById(R.id.LorryHire);
		EditText profitPre=(EditText) findViewById(R.id.profit);
		DatabaseOperations db = new DatabaseOperations(ctx);
		SQLiteDatabase SQ = db.getReadableDatabase();
		
			Cursor c=SQ.rawQuery("SELECT * from reg_ingo5 WHERE USER_NAME='"+CNNumber.getText()+"'", null);
			if(c.moveToFirst()){
				destination.setText(c.getString(1));
				datee.setText(c.getString(2));
				pkgs.setText(c.getString(3));
				weight.setText(c.getString(4));
				freight.setText(c.getString(5));
				consignee.setText(c.getString(6));
				consigner.setText(c.getString(7));
				lorryhire.setText(c.getString(8));
				trucknumber.setText(c.getString(9));	
				profitPre.setText(c.getString(10));
		
		
			}
		
		
	}
		//code for reset button
	public void resetbutton(View v)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Date date = new Date();
		int currentMonth = Log.d("Month",dateFormat.format(date));
		System.out.println(currentMonth);
		
		
		
	}
	
	
	// Code for Retrieve Button
	

	public void query(View view)
	{
		Button btnView=(Button) findViewById(R.id.query);
		EditText CNNumber=(EditText) findViewById(R.id.editText1);
		EditText destination=(EditText) findViewById(R.id.party);
		EditText datee=(EditText) findViewById(R.id.date);
		EditText pkgs=(EditText) findViewById(R.id.pkgs);
		EditText weight=(EditText) findViewById(R.id.Weight);
		EditText freight=(EditText) findViewById(R.id.Freight);
		EditText consignee=(EditText) findViewById(R.id.Consignee);
		EditText consigner=(EditText) findViewById(R.id.Consigner);
		EditText trucknumber=(EditText) findViewById(R.id.TruckNumber);
		EditText lorryhire=(EditText) findViewById(R.id.LorryHire);
		EditText profitss=(EditText) findViewById(R.id.profit);
		DatabaseOperations db = new DatabaseOperations(ctx);
		SQLiteDatabase SQ = db.getReadableDatabase();
		if(view==btnView){
		
			Cursor c=SQ.rawQuery("SELECT * from reg_ingo5 WHERE USER_NAME='"+CNNumber.getText()+"'", null);
			if(c.moveToFirst()){
				destination.setText(c.getString(1));
				datee.setText(c.getString(2));
				pkgs.setText(c.getString(3));
				weight.setText(c.getString(4));
				freight.setText(c.getString(5));
				consignee.setText(c.getString(6));
				consigner.setText(c.getString(7));
				lorryhire.setText(c.getString(8));
				trucknumber.setText(c.getString(9));
				profitss.setText(c.getString(10));
				
			}
		}
		
	}
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}
	
	
	/* action listener for the SAVE Button */
	public void submit(View view)
	{
	Button button1 = (Button) findViewById(R.id.button1);
	
	
			
			TextView firsttextbox = (TextView) findViewById(R.id.editText1);
			TextView secondtextbox = (TextView) findViewById(R.id.party);
			String first = firsttextbox.getText().toString();
			String second = secondtextbox.getText().toString();
			
			TextView datee=(TextView) findViewById(R.id.date);
			String date = datee.getText().toString();
			
			TextView weights=(TextView) findViewById(R.id.Weight);
			String weight = weights.getText().toString();
			
			TextView freights=(TextView) findViewById(R.id.Freight);
			String freight = freights.getText().toString();
			
			TextView consignees=(TextView) findViewById(R.id.Consignee);
			String consignee = consignees.getText().toString();
			
			TextView consigners=(TextView) findViewById(R.id.Consigner);
			String consigner = consigners.getText().toString();
			
			TextView pkgss=(TextView) findViewById(R.id.pkgs);
			String pkgs = pkgss.getText().toString();
			
			TextView trucknumbers=(TextView) findViewById(R.id.TruckNumber);
			String trucknumber = trucknumbers.getText().toString();
			
			TextView lorryhires=(TextView) findViewById(R.id.LorryHire);
			String lorryhire = lorryhires.getText().toString();
			
			int l = Integer.parseInt(lorryhires.getText().toString());
			int f = Integer.parseInt(freights.getText().toString());
			int totalprofit = f-l;
			String nprofit = Integer.toString(totalprofit);
			TextView profitbox=(TextView) findViewById(R.id.profit);
			profitbox.setText(nprofit);
			String newprofit = profitbox.getText().toString();
			
			
			DatabaseOperations db = new DatabaseOperations(ctx);
			
			db.putinformation(db, first, second, date, pkgs, weight, freight, consignee, consigner, lorryhire, trucknumber, newprofit);
			
		Toast.makeText(getBaseContext(), "Row Inserted", Toast.LENGTH_LONG).show();
		//finish();
		}
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
