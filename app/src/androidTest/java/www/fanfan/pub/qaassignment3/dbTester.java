package www.fanfan.pub.qaassignment3;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

import www.fanfan.pub.qaassignment3.data.TroopContract;
import www.fanfan.pub.qaassignment3.data.TroopDbHelper;

/**
 * Created by FM on 12/8/2015.
 */
public class dbTester extends AndroidTestCase {
    public static final String LOG_TAG = dbTester.class.getSimpleName();
    void deleteTheDatabase() {
        mContext.deleteDatabase(TroopDbHelper.DATABASE_NAME);
    }

    public void setUp() {
        deleteTheDatabase();
    }


    public void testCreateDb() throws Throwable {

        final HashSet<String> tableNameHashSet = new HashSet<String>();
        tableNameHashSet.add(TroopContract.TroopList.TABLE_NAME);


        mContext.deleteDatabase(TroopDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new TroopDbHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());


        db.close();
    }

}

