package grownapps.casamientofloryagus.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import grownapps.casamientofloryagus.R;

/**
 * Created by Juan Btesh on 08/07/2016.
 */
public class RecyclerViewFotosAdapter extends RecyclerView.Adapter {

    private Context context;
    private List <Integer> listaDeFotos;

    public RecyclerViewFotosAdapter(Context context,List listaDeFotos) {
        this.context = context;
        this.listaDeFotos = listaDeFotos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_fotos_recyclerview_detalle, parent, false);
        FotosViewHolder fotosViewHolder = new FotosViewHolder(itemView);
        return fotosViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Integer actualImage = listaDeFotos.get(position);
        FotosViewHolder fotosViewHolder = (FotosViewHolder) holder;
        fotosViewHolder.bindFeeds(actualImage, context);
    }

    @Override
    public int getItemCount() {
        return listaDeFotos.size();
    }
    private static class FotosViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public FotosViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView_recyclerview_fotos);
        }
        public void bindFeeds(final Integer actualImage, Context context){
            imageView.setImageResource(actualImage);
            //Picasso.with(context).load(actualImage).into(imageView);
        }
    }



}
