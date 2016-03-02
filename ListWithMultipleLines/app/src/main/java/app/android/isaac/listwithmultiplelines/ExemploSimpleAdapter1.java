package app.android.isaac.listwithmultiplelines;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ExemploSimpleAdapter1 extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        //Each item needs be a Hashmap
        for (int i = 0; i < 10; i++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("nome", "Nome" + i);
            item.put("fone", "Fone" + i);
            list.add(item);
        }

        //Uses the SimpleAdapter
        //Array that defines the HashMap keys
        String[] from = new String[] {"nome", "fone"};

        //text1 and text2 are Android's standards for the native layout "Two_line_list_item"
        int[] to = new int[] { android.R.id.text1, android.R.id.text2};
        int nativeLayout = android.R.layout.two_line_list_item;
        setListAdapter(new SimpleAdapter(this, list, nativeLayout, from, to));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView, view, position, id);

        //Takes the item on the selected position
        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();

        //Makes a Toast
        Toast.makeText(this, "Selected Contact: " + item, Toast.LENGTH_SHORT).show();
    }

}