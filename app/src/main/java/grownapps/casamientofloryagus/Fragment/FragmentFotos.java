package grownapps.casamientofloryagus.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import grownapps.casamientofloryagus.Adapter.RecyclerViewFotosAdapter;
import grownapps.casamientofloryagus.R;

/**
 * Created by Juan Btesh on 08/07/2016.
 */
public class FragmentFotos extends android.support.v4.app.Fragment {

    RecyclerView recyclerViewFotos;
    private List<Integer> listaDeFotos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listaDeFotos = new ArrayList<>();
        llenarFotos();

        View vista = inflater.inflate(R.layout.fragment_fotos,container,false);
        recyclerViewFotos = (RecyclerView) vista.findViewById(R.id.recyclerView_fotos);
        RecyclerViewFotosAdapter recyclerViewFotosAdapter = new RecyclerViewFotosAdapter(getActivity(),listaDeFotos);
        recyclerViewFotos.setAdapter(recyclerViewFotosAdapter);

        recyclerViewFotos.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));
        //recyclerViewFotos.setLayoutManager(new GridLayoutManager(container.getContext(), listaDeFotos.size()));
        //recyclerViewFotos.setHasFixedSize(true);

        return vista;
    }


    public void llenarFotos (){
        listaDeFotos.add(R.drawable.floragus1);
        listaDeFotos.add(R.drawable.floragus2);
        listaDeFotos.add(R.drawable.floragus3);
        listaDeFotos.add(R.drawable.floragus4);
        listaDeFotos.add(R.drawable.floragus5);
        listaDeFotos.add(R.drawable.floragus6);
        listaDeFotos.add(R.drawable.floragus7);
        listaDeFotos.add(R.drawable.floragus8);
        listaDeFotos.add(R.drawable.floragus9);
        listaDeFotos.add(R.drawable.floragus10);
        listaDeFotos.add(R.drawable.floragus11);
        listaDeFotos.add(R.drawable.floragus12);
        listaDeFotos.add(R.drawable.floragus13);
        listaDeFotos.add(R.drawable.floragus14);
        listaDeFotos.add(R.drawable.floragus15);
        listaDeFotos.add(R.drawable.floragus16);
        listaDeFotos.add(R.drawable.floragus17);
        listaDeFotos.add(R.drawable.floragus18);
        listaDeFotos.add(R.drawable.floragus19);
        listaDeFotos.add(R.drawable.floragus20);
        listaDeFotos.add(R.drawable.floragus21);
        listaDeFotos.add(R.drawable.floragus22);
        listaDeFotos.add(R.drawable.floragus23);
        listaDeFotos.add(R.drawable.floragus24);
        listaDeFotos.add(R.drawable.floragus25);
        listaDeFotos.add(R.drawable.floragus26);
        listaDeFotos.add(R.drawable.floragus27);
        listaDeFotos.add(R.drawable.floragus28);
        listaDeFotos.add(R.drawable.floragus29);
    }

}
