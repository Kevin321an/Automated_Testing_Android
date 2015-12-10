package www.fanfan.pub.qaassignment3.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by FM on 12/7/2015.
 */
public class TroopContract {
    public static final String CONTENT_AUTHORITY = "www.fanfan.pub.qaassignment3";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH= "troop";
    public static final class TroopList implements BaseColumns {
        //table location
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        // Table name
        public static final String TABLE_NAME = "troopList";

        // Storm troop id
        public static final String CREATED_AT = "created_at";

        // The plant they been sent to
        public static final String COLUMN_PLANT = "planets";
    }
}
