package com.example.firebaserecycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebaserecycler.R;
import com.example.firebaserecycler.models.NotaModel;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {

    private List<NotaModel> lista;

    public NotaAdapter(List<NotaModel> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView contenido;
        TextView fecha;

        public ViewHolder(View v){
            super(v);
            titulo = v.findViewById(R.id.teViTitulo);
            contenido = v.findViewById(R.id.teViContenido);
            fecha = v.findViewById(R.id.teViFecha);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NotaModel nota = lista.get(position);
        holder.titulo.setText(nota.getTitulo());
        holder.contenido.setText(nota.getContenido());
        holder.fecha.setText(new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault()).format(nota.getFecha()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
