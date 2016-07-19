package steven.com.edxapp.aplicaccionedx;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ActividadPrincipal extends AppCompatActivity {

    private int año;
    private int mes;
    private int dia;
    private EditText campoFecha;
    private Button botonFecha;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad_principal);



        //boton actividad
        Button btn = (Button) findViewById(R.id.cronometro); btn.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { Intent intent = new Intent(v.getContext(), crono.class); startActivityForResult(intent, 0); } });
        //obtener una instancia de los controles Gui dentro del layout

        campoFecha = (EditText) findViewById(R.id.campoFecha);
        botonFecha = (Button) findViewById(R.id.botonFecha);
        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mostrarFecha();
        oyenteSelectorFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                año = year;
                mes = monthOfYear;
                dia = dayOfMonth;
                mostrarFecha();
            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteSelectorFecha,año,mes,dia);

        }
        return null;
    }

    public void mostrarCalendario(View control){
        showDialog(TIPO_DIALOGO);
    }

    public void mostrarFecha(){
        campoFecha.setText(dia+"/"+mes+"/"+año);
    }
}
