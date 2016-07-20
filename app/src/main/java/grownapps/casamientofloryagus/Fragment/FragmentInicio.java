package grownapps.casamientofloryagus.Fragment;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import grownapps.casamientofloryagus.R;

/**
 * Created by Juan Btesh on 08/07/2016.
 */
public class FragmentInicio extends android.support.v4.app.Fragment {
    private static final String FORMAT = "%02d:%02d:%02d:%02d";

    private TextView textViewDias;
    private TextView textViewHoras;
    private TextView textViewMinutos;
    private TextView textViewSegundos;
    private TextView textViewFaltan;
    private TextView textViewTextoDias;
    private TextView textViewTextoHoras;
    private TextView textViewTextoMinutos;
    private TextView textViewTextoSegundos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);

        Resources res = getResources();
        int segundo = res.getInteger(R.integer.fecha_segundo);
        int minuto = res.getInteger(R.integer.fecha_minuto);
        int hora = res.getInteger(R.integer.fecha_hora);
        int dia = res.getInteger(R.integer.fecha_dia);
        int mes = res.getInteger(R.integer.fecha_mes);
        int ano = res.getInteger(R.integer.fecha_ano);

        Time conferenceTime = new Time(Time.getCurrentTimezone());
        conferenceTime.set(segundo,minuto,hora,dia,mes,ano);
        conferenceTime.normalize(true);
        long confMillis = conferenceTime.toMillis(true);

        Time nowTime = new Time(Time.getCurrentTimezone());
        nowTime.setToNow();
        nowTime.normalize(true);
        long nowMillis = nowTime.toMillis(true);

        Long milliDiff = confMillis - nowMillis;
        Typeface digital_clock_font = Typeface.createFromAsset(this.getContext().getApplicationContext().getAssets(), "fonts/digital-7.ttf");

        textViewSegundos = (TextView) vista.findViewById(R.id.fragment_inicio_textview_segundos);
        textViewMinutos = (TextView) vista.findViewById(R.id.fragment_inicio_textview_minutos);
        textViewHoras = (TextView) vista.findViewById(R.id.fragment_inicio_textview_horas);
        textViewDias = (TextView) vista.findViewById(R.id.fragment_inicio_textview_dias);
        textViewFaltan = (TextView) vista.findViewById(R.id.fragment_inicio_textview_faltan);
        textViewTextoDias = (TextView) vista.findViewById(R.id.fragment_inicio_textview_textodias);
        textViewTextoHoras = (TextView) vista.findViewById(R.id.fragment_inicio_textview_textohoras);
        textViewTextoMinutos = (TextView) vista.findViewById(R.id.fragment_inicio_textview_textominutos);
        textViewTextoSegundos = (TextView) vista.findViewById(R.id.fragment_inicio_textview_textosegundos);

        textViewSegundos.setTypeface(digital_clock_font);
        textViewMinutos.setTypeface(digital_clock_font);
        textViewHoras.setTypeface(digital_clock_font);
        textViewDias.setTypeface(digital_clock_font);
        textViewFaltan.setTypeface(digital_clock_font);
        textViewTextoDias.setTypeface(digital_clock_font);
        textViewTextoHoras.setTypeface(digital_clock_font);
        textViewTextoMinutos.setTypeface(digital_clock_font);
        textViewTextoSegundos.setTypeface(digital_clock_font);

        CountDownTimer countDown = new CountDownTimer(milliDiff,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                textViewSegundos.setText(""+TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)%(60));
                textViewMinutos.setText(""+TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)%(60));
                textViewHoras.setText(""+TimeUnit.MILLISECONDS.toHours(millisUntilFinished)%(24));
                textViewDias.setText(""+TimeUnit.MILLISECONDS.toDays(millisUntilFinished));
            }

            @Override
            public void onFinish() {
            }
        };
        countDown.start();
        
        return vista;

    }
}
