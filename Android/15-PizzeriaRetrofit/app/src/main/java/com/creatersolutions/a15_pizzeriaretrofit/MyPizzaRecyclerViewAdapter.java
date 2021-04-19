package com.creatersolutions.a15_pizzeriaretrofit;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.creatersolutions.a15_pizzeriaretrofit.models.Pizza;

import java.util.List;


public class MyPizzaRecyclerViewAdapter extends RecyclerView.Adapter<MyPizzaRecyclerViewAdapter.ViewHolder> {

    private final List<Pizza> mValues;

    public MyPizzaRecyclerViewAdapter(List<Pizza> pizzas) {
        mValues = pizzas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pizza, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvNombrePizza.setText(holder.mItem.getName());
        holder.tvDescripcionPizza.setText(holder.mItem.getDescription());

        //AQUI USAREMOS GLIDE PARA CARGAR LA IMAGEN.
        Glide.with(holder.itemView)
                .load(holder.mItem.getImage())
                .into(holder.tvImagenPizza);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvNombrePizza;
        public final TextView tvDescripcionPizza;
        public final ImageView tvImagenPizza;
        public Pizza mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvNombrePizza = view.findViewById(R.id.tvNombrePizza);
            tvDescripcionPizza = view.findViewById(R.id.tvDescription);
            tvImagenPizza = view.findViewById(R.id.ivPizzaImage);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNombrePizza.getText() + "'";
        }
    }
}