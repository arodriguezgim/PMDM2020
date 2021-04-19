package com.creatersolutions.monitordeterremotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

// Parte B: 3 Implementamos el extends y generemos el constructor
public class TerremotoAdapter extends ArrayAdapter<Terremoto> {

    // Parte B: 4a: Creamos una variable global para la lista de Terremotos, otra para el contexto, y otra para el is del Layout (el numero de celda que es)
    private ArrayList<Terremoto> eqList;
    private Context context;
    private int layoutId;


    public TerremotoAdapter(@NonNull Context context, int resource, @NonNull List<Terremoto> terremotos) {
        super(context, resource, terremotos);

        // Parte B: 4b: Ponemos estos valores en el Constructor
        this.context = context;
        this.layoutId = resource;
        eqList = new ArrayList<>(terremotos);
    }


    // Parte B: 5 - Implementamos el getView: Este método hará el trabajo de RECOGER TODOS LOS TERREMOTOS para insertarlos en los TextViews del Layout-
    //IMPORTANTE: Este método se ejecutará tantas veces como elementos tengamos para mostrar-
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Parte C: 2: Me creu una referencia a la clase ViewHolder que hemos creado
        ViewHolder holder;
        // Parte C: 3: Si este convertView es nulo es que ese elemento de la lista no ha sido creado aun, y entonces lo inflamos y lo asignamos
        if( convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layoutId, null);

            // Parte C: 4 Creamos un new Holder yle asignamos los campos que contiene
            holder = new ViewHolder();
            holder.magnitudeTextView = (TextView) convertView.findViewById(R.id.eq_list_item_magnitud);
            holder.lugarTextView = (TextView) convertView.findViewById(R.id.eq_lis_item_lugar);

            // Parte C: 5 Una vez que se ha creado le asignamos una referencia como Tag y le asignamos el holder que acabamos de crear (contiene un id unico)
            convertView.setTag(holder);

        } else {
            // Parte C: 6 Si ya ha sido creado el elemento anteriormente le asigna el tag
            holder = (ViewHolder) convertView.getTag();
        }

        // Parte B: 6: Usaremos el metodo LayoutInflater. getSystemService nos permite crear Views a partir de un archivo xml
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Parte B: 7: Creo un View para, a partir del xml eq_list_item extraer todos los hijos (2 TextViews y un ImageView) y poder editarlos
        //OBSERVACION: Nos pide la id del layout qque usaremos para inflar ese View
        //View rootView = inflater.inflate(R.layout.eq_list_item, null);

        // Parte B: 8 - Como ya tenemos eq_list_view en un view podemos obtener los hijos
        //TextView magnitudTextView = (TextView) rootView.findViewById(R.id.eq_list_item_magnitud);
        //TextView lugarTextView = (TextView) rootView.findViewById(R.id.eq_lis_item_lugar);

        // Parte B: 9 Creamos un objeto Terremoto y se lo asignamos al objeto en la posicion del elemento que se está buscando
        Terremoto terremoto = eqList.get(position);

        // Parte B: 10 Asignamos los campos magnitud y lugar del objeto i a los campos del View
        //magnitudTextView.setText(terremoto.getMagnitud());
        //lugarTextView.setText(terremoto.getLugar());

        // Parte C: 7 Ahora devolvemos el holder....
        holder.magnitudeTextView.setText(terremoto.getMagnitud());
        holder.lugarTextView.setText(terremoto.getLugar());

        // Parte B: 11 Devolvemos el rootView que hemos creado
        //return rootView;

        // Parte C: 8 Devolvemos el convertView
        return  convertView;
        //return super.getView(position, convertView, parent);
    }

    // Parte C: 1 - Creamos una clase que se llame ViewHolder condos campos (los texview que creamos antes)
    private class ViewHolder {
        public TextView magnitudeTextView;
        public TextView lugarTextView;
    }
}
