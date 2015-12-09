package www.fanfan.pub.qaassignment3;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ApplicationTest() {
        super(MainActivity.class);
    }

    private MainActivity mClickActvity;
    private android.support.design.widget.FloatingActionButton mButton;
    private TextView mTextView;


    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mClickActvity = getActivity();
        //mButton = (android.support.design.widget.FloatingActionButton) mClickActvity.findViewById(R.id.fab);
        mTextView = (TextView) mClickActvity.findViewById(R.id.item_touch_helper_previous_elevation);
    }

    /*@MediumTest
    public void testInitialValue(){
        int initialNumber = Integer.parseInt( mTextView.getText().toString());
        assertEquals(0, initialNumber);
    }*/

    @MediumTest
    public void testClick(){
     /*   int priorNumber = Integer.parseInt( mTextView.getText().toString());*/
        for (int i= 0; i<100;i++){
            TouchUtils.clickView(this, mButton);
          /*  priorNumber++;
            int newNumber = Integer.parseInt( mTextView.getText().toString());
            assertEquals(priorNumber, newNumber);*/
        }

    }


}