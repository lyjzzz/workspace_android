package babysleepmanager.johnsnow.babysleepmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    android.app.FragmentManager fm;
    android.app.FragmentTransaction ftrans;
    FragPanel1 fp1;
    FragPanel2 fp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm = getFragmentManager();
        ftrans = fm.beginTransaction();
        fp1 = new FragPanel1();
        ftrans.replace(R.id.main_frame, fp1);
        ftrans.commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_panel1:
                    fm = getFragmentManager();
                    ftrans = fm.beginTransaction();
                    fp1 = new FragPanel1();
                    ftrans.replace(R.id.main_frame, fp1);
                    ftrans.commit();
                    return true;
                case R.id.navigation_panel2:
                    fm = getFragmentManager();
                    ftrans = fm.beginTransaction();
                    fp2 = new FragPanel2();
                    ftrans.replace(R.id.main_frame, fp2);
                    ftrans.commit();
                    return true;
                case R.id.navigation_panel3:
                    return true;
            }
            return false;

        }
    };


}
