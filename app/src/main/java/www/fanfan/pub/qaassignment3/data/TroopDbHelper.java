package www.fanfan.pub.qaassignment3.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import www.fanfan.pub.qaassignment3.data.TroopContract.TroopList;
/**
 * Created by FM on 12/7/2015.
 */
public class TroopDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "troopList.db";
    public TroopDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table
        final String SQL_CREATE_TroopList_TABLE = "CREATE TABLE " + TroopList.TABLE_NAME + " (" +
                TroopList._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TroopList.COLUMN_PLANT+ " REAL NOT NULL " +
                " );";
        sqLiteDatabase.execSQL(SQL_CREATE_TroopList_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TroopList.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insert(String planets){
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        //values.put(TroopList._ID, id);
        values.put(TroopContract.TroopList.COLUMN_PLANT, planets);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                TroopContract.TroopList.TABLE_NAME,
                null,
                values);
        db.close();
    }
    public  int  count( String planets){
        SQLiteDatabase db = this.getReadableDatabase();
        final  String[] COLUMNS = {TroopList._ID, TroopContract.TroopList.COLUMN_PLANT};
        // query
        Cursor cursor =
                db.query(TroopContract.TroopList.TABLE_NAME, // a. table
                        COLUMNS, // b. column names
                        TroopContract.TroopList.COLUMN_PLANT + " = ?", // c. selections
                        new String[]{String.valueOf(planets)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        return  cursor.getCount();
    }
    public int getCountAll(){
        String countQuery = "SELECT * FROM " + TroopContract.TroopList.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();
        return cursor.getCount();
    }

}
