package grownapps.casamientofloryagus.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import grownapps.casamientofloryagus.R;

/**
 * Created by Juan Btesh on 11/07/2016.
 */
public class RecyclerViewInvitadosAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> listaDeInvitados;

    public RecyclerViewInvitadosAdapter(Context context,List listaDeInvitados) {
        this.context = context;
        this.listaDeInvitados = listaDeInvitados;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_invitados_recyclerview_detalle, parent, false);
        InvitadosViewHolder invitadosViewHolder = new InvitadosViewHolder(itemView);
        return invitadosViewHolder;    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String actualInvitado = listaDeInvitados.get(position);
        InvitadosViewHolder invitadosViewHolder = (InvitadosViewHolder) holder;
        invitadosViewHolder.bindFeeds(actualInvitado, context);
    }

    @Override
    public int getItemCount() {
        return listaDeInvitados.size();
    }

    private static class InvitadosViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public InvitadosViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview_recyclerview_invitados);
        }
        public void bindFeeds(final String actualString, Context context){
            textView.setText(actualString);
        }
    }
}
