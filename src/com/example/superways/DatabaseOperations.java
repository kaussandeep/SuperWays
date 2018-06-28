package com.example.superways;

import com.example.superways.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	public static final int database_version = 9;
	public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.USER_NAME+" TEXT,"+TableInfo.PARTY_NAME+" TEXT,"+TableInfo.DATEE+" TEXT,"+TableInfo.PACKAGES+" TEXT,"+TableInfo.WEIGHT+" TEXT,"+TableInfo.FREIGHT+" TEXT,"+TableInfo.CONSIGNEE+" TEXT,"+TableInfo.CONSIGNER+" TEXT,"+TableInfo.TRUCKNUMBER+" TEXT,"+TableInfo.LORRYHIRE+" TEXT,"+TableInfo.PROFIT+" TEXT);";
	
	

	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		Log.d("Database Operations", "Database created");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database Operations", "Table Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void putinformation(DatabaseOperations dop, String name, String party, String date, String pkgs, String weight, String freight, String consignee, String consigner, String trucknumber, String lorryhire, String nprofit  )
	{
		SQLiteDatabase SQ =  dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfo.USER_NAME, name);
		cv.put(TableInfo.PARTY_NAME, party);
		cv.put(TableInfo.DATEE, date);
		cv.put(TableInfo.PACKAGES, pkgs);
		cv.put(TableInfo.WEIGHT, weight);
		cv.put(TableInfo.FREIGHT, freight);
		cv.put(TableInfo.CONSIGNEE, consignee);
		cv.put(TableInfo.CONSIGNER, consigner);
		cv.put(TableInfo.TRUCKNUMBER, trucknumber);
		cv.put(TableInfo.LORRYHIRE, lorryhire);
		cv.put(TableInfo.PROFIT, nprofit);
		
		long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
		
		Log.d("Database Operations", "One Row inserted");
		
	}
	
	
}
