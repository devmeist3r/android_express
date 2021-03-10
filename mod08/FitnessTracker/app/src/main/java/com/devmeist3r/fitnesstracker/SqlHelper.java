package com.devmeist3r.fitnesstracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

  private static  final String DB_NAME = "fitness_tracker.db";
  private static  final int DB_VERSION = 1;

  private static SqlHelper INSTANCE;

  static SqlHelper getInstance(Context context) {
    if (INSTANCE == null)
      INSTANCE = new SqlHelper(context);

    return INSTANCE;
  }

  public SqlHelper(@Nullable Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
