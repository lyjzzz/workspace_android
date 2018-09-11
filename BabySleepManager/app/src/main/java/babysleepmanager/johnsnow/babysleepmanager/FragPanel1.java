package babysleepmanager.johnsnow.babysleepmanager;

import android.app.Fragment;
import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragPanel1 extends Fragment {

    View view;
    EditText editText_date;
    Button button_now;
    Button button_milk;
    Button button_milkreset;
    Button button_small;
    Button button_big;


    private int milk_cnt = 0;
    private boolean small_chk = false;
    private boolean big_chk = false;

    long now;
    Date date;
    SimpleDateFormat sdf;
    String formatDate;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_panel1, container, false);

        setNowDateTime();

        button_now  = (Button) view.findViewById(R.id.button_now);
        button_now.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view){
                setNowDateTime();
            }
        });

        button_milk  = (Button) view.findViewById(R.id.button_milk);
        button_milk.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view){
                milk_cnt += 10;
                button_milk.setText("분유추가("+String.valueOf(milk_cnt)+" ml)");
            }
        });

        button_milkreset  = (Button) view.findViewById(R.id.button_milkreset);
        button_milkreset.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view){
                milk_cnt = 0;
                button_milk.setText("분유추가(0 ml)");
            }
        });

        button_small  = (Button) view.findViewById(R.id.button_small);
        button_small.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view){
                if(small_chk==false){
                    small_chk = true;
                    button_small.setText("소변(O)");
                }
                else{
                    small_chk = false;
                    button_small.setText("소변");
                }
            }
        });

        button_big  = (Button) view.findViewById(R.id.button_big);
        button_big.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view){
                if(big_chk==false){
                    big_chk = true;
                    button_big.setText("응가(O)");
                }
                else{
                    big_chk = false;
                    button_big.setText("응가");
                }
            }
        });

        return view;
    }

    void setNowDateTime(){
        long now = System.currentTimeMillis();
        date = new Date(now);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatDate = sdf.format(date);
        editText_date = (EditText) view.findViewById(R.id.editText_date);
        editText_date.setText(formatDate);
    }

}
