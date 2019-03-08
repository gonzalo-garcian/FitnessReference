package cat.copernic.kyt3c.fitnessreference;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterEntrenamientos extends RecyclerView.Adapter<AdapterEntrenamientos.ViewHolderEntrenamientos> {

    ArrayList<Entrenamiento> listEntrenamientos;


    public AdapterEntrenamientos(ArrayList<Entrenamiento> listEntrenamientos) {

        this.listEntrenamientos = listEntrenamientos;
    }
    @NonNull
    @Override
    public AdapterEntrenamientos.ViewHolderEntrenamientos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.entrenamiento_list,null,false);
        return new ViewHolderEntrenamientos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEntrenamientos.ViewHolderEntrenamientos viewHolderEntrenamientos, int position) {
        viewHolderEntrenamientos.asignarDatos(listEntrenamientos.get(position));

    }

    @Override
    public int getItemCount() {
        return listEntrenamientos.size();
    }

    public class ViewHolderEntrenamientos extends RecyclerView.ViewHolder {
        TextView nombreEntrenamiento,descripcionEntrenamiento;

        public ViewHolderEntrenamientos(@NonNull View itemView) {
            super(itemView);
            nombreEntrenamiento=itemView.findViewById(R.id.nombreEntrenamiento);
            descripcionEntrenamiento=itemView.findViewById(R.id.descripcionEntrenamiento);

        }

        public void asignarDatos(Entrenamiento entrenamiento) {
            entrenamiento = new Entrenamiento(entrenamiento.getNombre(),entrenamiento.getDescripcion());
        }
    }
}
