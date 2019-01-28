package cat.copernic.kyt3c.fitnessreference;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> datos;
    private LayoutInflater infla;
    private ItemClickListener listener;

    // datos al constructorr
    MyRecyclerViewAdapter(Context context, List<String> data) {
        this.infla = LayoutInflater.from(context);
        this.datos = data;
    }

    // rellena la fila cuando hace falta
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = infla.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // mete los datos en la fila
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String actividad = datos.get(position);
        holder.myTextView.setText(actividad);
    }

    // nuemero de todas las filas
    @Override
    public int getItemCount() {
        return datos.size();
    }


    //guarda y quita las filas uqe no ves en pantalla
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.activi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) listener.onItemClick(view, getAdapterPosition());
        }
    }

    // da los datos de cada una de las filas
    String getItem(int id) {
        return datos.get(id);
    }

    // permite que pueda mer cuando clickas
    void setClickListener(ItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}