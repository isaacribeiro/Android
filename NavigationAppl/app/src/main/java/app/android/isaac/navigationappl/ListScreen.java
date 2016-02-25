package app.android.isaac.navigationappl;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListScreen extends ListActivity {

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        /* Array de Strings para visualizar na lista */
        String[] list_elements = new String[] {"Element 1", "Element 2", "Element 3"};

        /* Utiliza o adaptador ArrayAdapter para exibir o array de Strings na tela */
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_elements);
        setListAdapter(arrayAdapter);

    }

    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView, view, position, id);

        //Pega o item naquela posição
        Object object = this.getListAdapter().getItem(position);
        String item = object.toString();

        //Exibe um alerta
        Toast.makeText(this, "Value selected: " + item, Toast.LENGTH_SHORT).show();

    }
}
