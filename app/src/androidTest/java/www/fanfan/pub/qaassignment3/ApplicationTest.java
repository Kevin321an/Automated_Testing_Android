package www.fanfan.pub.qaassignment3;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ApplicationTest() {
        super(MainActivity.class);
    }

    private MainActivity mClickActvity;
    private android.support.design.widget.FloatingActionButton mButton;
    private TextView mTextView;
    private ImageButton bespin, dagoban, tatooine, endor, hoth;


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mClickActvity = getActivity();
        bespin = (ImageButton) mClickActvity.findViewById(R.id.bespin);
        dagoban = (ImageButton) mClickActvity.findViewById(R.id.dagoban);
        tatooine = (ImageButton) mClickActvity.findViewById(R.id.tatooine);
        endor = (ImageButton) mClickActvity.findViewById(R.id.endor);
        hoth = (ImageButton) mClickActvity.findViewById(R.id.hoth);

        mTextView = (TextView) mClickActvity.findViewById(R.id.item_touch_helper_previous_elevation);
    }





    @MediumTest
    public void testClick(){

        for (int i= 0; i<999999999;i++){
            int index = new Random().nextInt(5);
            Log.d("radom number", Integer.toString(index));

            switch (index){
                case 0 : TouchUtils.clickView(this, bespin);
                    break;
                case 1 : TouchUtils.clickView(this, dagoban);
                    break;
                case 2 : TouchUtils.clickView(this, tatooine);
                    break;
                case 3 : TouchUtils.clickView(this, endor);
                    break;
                case 4 : TouchUtils.clickView(this, hoth);

            }

        }

    }


}