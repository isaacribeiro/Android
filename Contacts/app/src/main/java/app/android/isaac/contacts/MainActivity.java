package app.android.isaac.contacts;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the ListView Component to other Layout, case needed
        //setContentView(R.layout.activity_main);

        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        //Retrieves the Contact Cursor
//        Cursor cursor = getContentResolver().query(uri, null, null, null, null); DEPRECATED
//        startManagingCursor(cursor);                                             DEPRECATED

        LoaderManager loader = getLoaderManager().initLoader(this.getTaskId(), uri, );
        startManagingCursor(cursor);

        //Lists Contact's name
        String[] columns = new String[] { ContactsContract.Contacts.DISPLAY_NAME };
        int[] fields = new int[] { R.id.nome };

        //Connects the Adapter to XML
        adapter = new SimpleCursorAdapter(this, R.layout.activity_main, cursor, columns, fields);

        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView, view, position, id);

        //Gets the cursor from the clicked position
        Cursor cursor = (Cursor) adapter.getItem(position);

        //Gets Contact's Name and Telefone
        String nameColumn = ContactsContract.Contacts.DISPLAY_NAME;
        String name = cursor.getString(cursor.getColumnIndexOrThrow(nameColumn));
        Toast.makeText(this, "Selected Contact: " + name, Toast.LENGTH_SHORT).show();
    }
    
}