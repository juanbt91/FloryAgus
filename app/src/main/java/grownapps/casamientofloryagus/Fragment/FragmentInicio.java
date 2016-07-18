package grownapps.casamientofloryagus.Fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import grownapps.casamientofloryagus.R;

/**
 * Created by Juan Btesh on 08/07/2016.
 */
public class FragmentInicio extends android.support.v4.app.Fragment {
    private static final String TAG = "CountdownTimer";

    private TextView textViewDias;
    private TextView textViewHoras;
    private TextView textViewMinutos;
    private TextView textViewSegundos;

    Time conferenceTime = new Time(Time.getCurrentTimezone());

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);

        conferenceTime.set(R.string.fecha_segundo,R.string.fecha_minuto,R.string.fecha_hora,R.string.fecha_dia,R.string.fecha_mes,R.string.fecha_ano);
        conferenceTime.normalize(true);
        long confMillis = conferenceTime.toMillis(true);

        Time nowTime = new Time(Time.getCurrentTimezone());
        nowTime.setToNow();
        nowTime.normalize(true);
        long nowMillis = nowTime.toMillis(true);

        Long milliDiff = confMillis - nowMillis;

        textViewSegundos = (TextView) vista.findViewById(R.id.fragment_inicio_textview_segundos);
        textViewSegundos.setText(milliDiff.toString());

        
        return vista;

    }
}
