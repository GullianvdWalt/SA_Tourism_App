package com.gvdw.satourismapp;

/*
 Pearson Pretoria BSC IT Level 3
 2020 ITJA321 - Take Home Assessment Question 6
 Gullian Van Der Walt - H5G8YT7X3
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

  // Database Properties
  private static final String DATABASE_NAME = "satourist";
  private static final String TABLE_NAME = "touristattractions";

  // Database Columns
  public static final String COL_1 = "Id";
  private static final String COL_2 = "province";
  private static final String COL_3 = "place";

  public DatabaseHelper(@Nullable Context context) {
    super(context, DATABASE_NAME,null,1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, province TEXT," +
      "place TEXT)");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
    onCreate(db);
  }

  // Insert Data into the DB
  public boolean addPlaces(){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    contentValues.put(COL_2, "Gauteng");
    contentValues.put(COL_3, "Union Buildings");

    contentValues.put(COL_2, "Western Cape");
    contentValues.put(COL_3, "Table Mountain");

    contentValues.put(COL_2, "KwaZulu Natal");
    contentValues.put(COL_3, "uShaka Marine World");

    contentValues.put(COL_2, "Eastern Cape");
    contentValues.put(COL_3, "Addo Elephant National Park");

    contentValues.put(COL_2, "Northern Cape");
    contentValues.put(COL_3, "Augrabies Falls National Park");

    contentValues.put(COL_2, "Mpumalanga");
    contentValues.put(COL_3, "Kruger National Park");

    contentValues.put(COL_2, "Limpopo");
    contentValues.put(COL_3, "Mapungubwe National Park");

    contentValues.put(COL_2, "North West");
    contentValues.put(COL_3, "Sun City Resort");

    contentValues.put(COL_2, "Free State");
    contentValues.put(COL_3, " Free State National Botanical Garden");

    // Bind
    long result = db.insert(TABLE_NAME, null, contentValues);
    if(result == -1) {
      return false;
    }
    return true;
  }

  // Get Tourist Attractions
  public PlaceDetails getPlaceDetails(String province){
    SQLiteDatabase db = getReadableDatabase();

    //SQL Query
    String sql = "SELECT * FROM touristattractions WHERE touristattractions.province = " + "'"+province+"'";
    Cursor cursor = db.rawQuery(sql, null);

    PlaceDetails placeDetails = new PlaceDetails();


    if(cursor != null){
      cursor.moveToFirst();
      // Set Place Details
     placeDetails.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
     placeDetails.setProvince(cursor.getString(cursor.getColumnIndex(COL_2)));
     placeDetails.setPlace(cursor.getString(cursor.getColumnIndex(COL_3)));

    }


    cursor.close();
    db.close();

    return placeDetails;
  }




}
