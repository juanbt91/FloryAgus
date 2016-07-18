package grownapps.casamientofloryagus.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import grownapps.casamientofloryagus.Fragment.FragmentFotos;
import grownapps.casamientofloryagus.Fragment.FragmentInicio;
import grownapps.casamientofloryagus.Fragment.FragmentInvitados;

/**
 * Created by Juan Btesh on 08/07/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> listaDeFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listaDeFragments = new ArrayList<Fragment>();
        FragmentInicio fragmentInicio = new FragmentInicio();
        listaDeFragments.add(new FragmentInicio());
        listaDeFragments.add(new FragmentFotos());
        listaDeFragments.add(new FragmentInvitados());


    }

    @Override
    public Fragment getItem(int position) {
        return listaDeFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaDeFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Inicio";
        }
        else if (position == 1){
            return "Fotos";
        }
        else {
            return "Invitados";
        }
        //return this.listaDeFragments.get(position).getTag();
        //esto esta mal pero hay que pedirle el nombre
    }
}
