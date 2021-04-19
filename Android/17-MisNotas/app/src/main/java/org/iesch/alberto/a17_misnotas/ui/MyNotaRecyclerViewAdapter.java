package org.iesch.alberto.a17_misnotas.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.iesch.alberto.a17_misnotas.R;
import org.iesch.alberto.a17_misnotas.models.Nota;

import java.util.List;


public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<Nota> mValues;

    public MyNotaRecyclerViewAdapter(List<Nota> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvContenido.setText(holder.mItem.getContenido());

        if ( holder.mItem.isFavorita()){
            holder.imFavorito.setImageResource(R.drawable.ic_baseline_star_24);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTitulo;
        public final TextView tvContenido;
        public final ImageView imFavorito;
        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitulo = view.findViewById(R.id.tv_titulo);
            tvContenido = view.findViewById(R.id.tv_contenido);
            imFavorito = view.findViewById(R.id.imageViewFavorito);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}