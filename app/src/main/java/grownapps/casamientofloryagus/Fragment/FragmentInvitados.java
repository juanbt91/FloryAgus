package grownapps.casamientofloryagus.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import grownapps.casamientofloryagus.Adapter.RecyclerViewFotosAdapter;
import grownapps.casamientofloryagus.Adapter.RecyclerViewInvitadosAdapter;
import grownapps.casamientofloryagus.R;

/**
 * Created by Juan Btesh on 08/07/2016.
 */
public class FragmentInvitados extends android.support.v4.app.Fragment{

    RecyclerView recyclerViewInvitados;
    private List<String> listaDeInvitados;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listaDeInvitados = new ArrayList<>();
        llenarInvitados();

        View vista = inflater.inflate(R.layout.fragment_invitados,container,false);

        recyclerViewInvitados = (RecyclerView) vista.findViewById(R.id.recyclerView_invitados);
        RecyclerViewInvitadosAdapter recyclerViewInvitadosAdapter = new RecyclerViewInvitadosAdapter(getActivity(),listaDeInvitados);
        recyclerViewInvitados.setAdapter(recyclerViewInvitadosAdapter);

        recyclerViewInvitados.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));

        return vista;
    }

    public void llenarInvitados (){
        listaDeInvitados.add("Juan Btesh");
        listaDeInvitados.add("Taja Rampih");
        listaDeInvitados.add("Sofía Btesh");
        listaDeInvitados.add("Agustín Sajoux");
        listaDeInvitados.add("Paula Pujol");
        listaDeInvitados.add("David Btesh");
        listaDeInvitados.add("Nicole Btesh");
        listaDeInvitados.add("Renata Btesh");
        listaDeInvitados.add("Élida Sáenz");
        listaDeInvitados.add("Raúl Btesh");
        listaDeInvitados.add("Dorine Btesh");
        listaDeInvitados.add("Marcela Pujol");
        listaDeInvitados.add("Javier Jacomet");
        listaDeInvitados.add("María José Pujol");
        listaDeInvitados.add("Diego Pereyra Iraola");
        listaDeInvitados.add("Abril Pereyra Iraola");
        listaDeInvitados.add("Olivia Pereyra Iraola");
        listaDeInvitados.add("María Sara Pereyra Iraola");
        listaDeInvitados.add("Diego Pereyra Iraola");
        //poner algo como "la lista solo muestra los invitados que se bajaron la app"
    }
}
