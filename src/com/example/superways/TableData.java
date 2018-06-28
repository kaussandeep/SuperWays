package com.example.superways;

import android.provider.BaseColumns;

public class TableData {
	
	public TableData()
	{
		
	}
	public static abstract class TableInfo implements BaseColumns
	{
		
		public static final String USER_NAME = "user_name";
		public static final String DATEE = "date";
		public static final String PACKAGES = "pkgs";
		
		public static final String PARTY_NAME = "party_name";
		public static final String WEIGHT = "weight";
		public static final String FREIGHT = "freight";
		public static final String CONSIGNEE = "consignee";
		public static final String CONSIGNER = "consigner";
		public static final String TRUCKNUMBER = "trucknumber";
		public static final String LORRYHIRE = "lorryhire";
		public static final String PROFIT = "profit";
		
		public static final String DATABASE_NAME = "superways4";
		public static final String TABLE_NAME = "reg_ingo5";
		
		
	}	

}
