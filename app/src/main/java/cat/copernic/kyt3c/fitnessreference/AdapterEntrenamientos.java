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
    private LayoutInflater inflater;

    public AdapterEntrenamientos(ArrayList<Entrenamiento> listEntrenamientos) {

        this.listEntrenamientos = listEntrenamientos;
    }
    @NonNull
    @Override
    public AdapterEntrenamientos.ViewHolderEntrenamientos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= inflater
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEntrenamientos.ViewHolderEntrenamientos viewHolderEntrenamientos, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderEntrenamientos extends RecyclerView.ViewHolder {
        TextView nombreEntrenamiento,descripcionEntrenamiento;

        public ViewHolderEntrenamientos(@NonNull View itemView) {
            super(itemView);
            nombreEntrenamiento=itemView.findViewById(R.id.nombreEntrenamiento);
            descripcionEntrenamiento=itemView.findViewById(R.id.descripcionEntrenamiento);

        }
    }
}
