package www.fanfan.pub.qaassignment3;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import www.fanfan.pub.qaassignment3.data.TroopDbHelper;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int I_BESPIN = 0, I_DAGOBAN = 1, I_ITAOOINE = 2, I_ENDOR = 3, I_HOTH = 4;
    TroopDbHelper mDbHelper;
    private int i = 0;
    private String[] planets = {"BESPIN", "BAGOBAN", "TAOOINE", "ENDOR", "HOTH"};
    private ImageButton bespin, dagoban, tatooine, endor, hoth;
    private TextView t_bespin, t_dagoban, t_tatooine, t_endor, t_hoth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bespin = (ImageButton) findViewById(R.id.bespin);
        dagoban = (ImageButton) findViewById(R.id.dagoban);
        tatooine = (ImageButton) findViewById(R.id.tatooine);
        endor = (ImageButton) findViewById(R.id.endor);
        hoth = (ImageButton) findViewById(R.id.hoth);

        t_bespin = (TextView) findViewById((R.id.text1));
        t_dagoban = (TextView) findViewById((R.id.text2));
        t_tatooine = (TextView) findViewById((R.id.text3));
        t_endor = (TextView) findViewById((R.id.text4));
        t_hoth = (TextView) findViewById((R.id.text5));

        mDbHelper = new TroopDbHelper(this);

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int index = new Random().nextInt(planets.length);
                mDbHelper.insert(planets[index]);
                Snackbar.make(view, "number:" + i++, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("dbCount", Integer.toString(mDbHelper.getCountAll()));
            }
        });*/

    }

    void shootMessage(View view, String planets) {
        //final String s1= "let's kill all";
        Snackbar.make(view, "The number of " + mDbHelper.getCountAll() + " STORMTROOPER has been sent to "
                + planets, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    String countTroop(String planets) {
        return Integer.toString(mDbHelper.count(planets));
    }

    @Override
    public void onClick(View view) {
        if (view == bespin) {
            mDbHelper.insert(planets[I_BESPIN]);
            shootMessage(view, planets[I_BESPIN]);
            t_bespin.setText(countTroop(planets[I_BESPIN]));

        } else if (view == dagoban) {
            mDbHelper.insert(planets[I_DAGOBAN]);
            shootMessage(view, planets[I_DAGOBAN]);
            t_dagoban.setText(countTroop(planets[I_DAGOBAN]));
        } else if (view == tatooine) {
            mDbHelper.insert(planets[I_ITAOOINE]);
            shootMessage(view, planets[I_ITAOOINE]);
            t_tatooine.setText(countTroop(planets[I_ITAOOINE]));
        } else if (view == endor) {
            mDbHelper.insert(planets[I_ENDOR]);
            shootMessage(view, planets[I_ENDOR]);
            t_endor.setText(countTroop(planets[I_ENDOR]));
        } else if (view == hoth) {
            mDbHelper.insert(planets[I_HOTH]);
            shootMessage(view, planets[I_HOTH]);
            t_hoth.setText(countTroop(planets[I_HOTH]));
        }
    }


}
