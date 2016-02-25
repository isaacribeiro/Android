package app.android.isaac.navigationappl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button l_button = new Button(this);
        l_button.setText("Go to Second Screen");
        l_button.setOnClickListener(this);
        setContentView(l_button);
    }

    public void onClick(View view){
        //Intent l_intent = new Intent(this, SecondActivity.class);
        Intent l_intent = new Intent(this, ListScreen.class);
        Bundle params = new Bundle();
        params.putString("msg_key", "Message sent");
        l_intent.putExtras(params);
        startActivity(l_intent);
    }
}
