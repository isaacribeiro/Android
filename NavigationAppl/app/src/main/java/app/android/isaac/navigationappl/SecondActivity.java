package app.android.isaac.navigationappl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String CATEGORY = "Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("SecondScreen");
        setContentView(textView);
        Intent l_intent =  getIntent();
        if (l_intent != null){
            Bundle params = l_intent.getExtras();
            if (params != null) {
                String msg = params.getString("msg_key");
                Log.i(CATEGORY, "Mensagem: " + msg);
            }
        }

    }
}
