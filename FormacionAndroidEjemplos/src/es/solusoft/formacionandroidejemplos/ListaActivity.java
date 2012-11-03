package es.solusoft.formacionandroidejemplos;

import java.util.ArrayList;

import es.solusoft.internal.ElementoLista;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Codigo de ejemplo de implementacion y comportamiento de una ListActivity
 * @author findemor
 *
 */
public class ListaActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);

		// Obtenemos la lista de elementos
		ArrayList<ElementoLista> myElements = getElementosLista();
		// Entregamos la lista al adaptador
		setListAdapter(new CustomAdapter(this, R.layout.lista_item, myElements));
	}


	/**
	 * Adaptador personalizado para mostrar elementos en la lista
	 * @author findemor
	 *
	 */
	private class CustomAdapter extends ArrayAdapter<ElementoLista> {
		private ArrayList<ElementoLista> items;

		public CustomAdapter(Context context, int textViewResourceId,
				ArrayList<ElementoLista> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.lista_item, null);
			}
			ElementoLista e = items.get(position);
			if (e != null) {
				TextView ttitulo = (TextView) v.findViewById(R.id.titulo);
				if (ttitulo != null) {
					ttitulo.setText(e.getName());
				}
			}
			return v;
		}
	}

	/**
	 * Genera una lista con algunos elementos
	 * 
	 * @return
	 */
	private ArrayList<ElementoLista> getElementosLista() {
		ArrayList<ElementoLista> l = new ArrayList<ElementoLista>();

		l.add(new ElementoLista("Elemento1"));
		l.add(new ElementoLista("Elemento2"));
		l.add(new ElementoLista("Elemento3"));

		return l;
	}
}
