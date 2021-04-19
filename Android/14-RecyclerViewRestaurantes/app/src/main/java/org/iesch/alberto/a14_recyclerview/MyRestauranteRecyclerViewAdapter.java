package org.iesch.alberto.a14_recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private Context ctx;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items) {
        mValues = items;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Rescatamos los datos del elemento position
        holder.mItem = mValues.get(position);

        holder.textViewNombreRestaurante.setText(holder.mItem.getNombre());
        holder.textViewDireccionRestaurante.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracion.setRating(holder.mItem.getValoracion());
        //Para la imagen vamos a usar unalibreria externa de imagenes

        Glide
                .with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .into(holder.imageViewPhotoRestaurante);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhotoRestaurante;
        public final RatingBar ratingBarValoracion;

        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombreRestaurante = view.findViewById(R.id.textViewNombre);
            textViewDireccionRestaurante = view.findViewById(R.id.textViewDireccion);
            imageViewPhotoRestaurante = view.findViewById(R.id.fotoRestaurante);
            ratingBarValoracion = view.findViewById(R.id.ratingBarValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '";
        }
    }
}