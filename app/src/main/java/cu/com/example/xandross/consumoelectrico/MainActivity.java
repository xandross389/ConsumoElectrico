package cu.com.example.xandross.consumoelectrico;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;


public class MainActivity extends AppCompatActivity {
    public final static String FLOAT_FORMAT = "%1.2f";
    private EditText edtLecturaActual;
    private EditText edtLecturaAnterior;
    private Button btnFechaLecturaActual;
    private Button btnFechaLecturaAnterior;
    private TextView txtConsumoClaculadoValue;
    private TextView txtImporteCalculadoValue;
    private TextView txtDiasLeidosValue;
    private TextView txtPromConsDiarioValue;
    private TextView txtPrediccionImporteMensualValue;
    private TextView txtConsumoClaculado;
    private TextView txtImporteCalculado;
    private TextView txtDiasLeidos;
    private TextView txtPromConsDiario;
    private TextView txtPrediccionImporteMensual;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        initViewObjects();
        // resetDatosEstadisticos();

        edtLecturaAnterior.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (edtLecturaAnterior.getText().toString().length() < 10 ) {
                    calcularEstadisticasDeConsumo();
                } else
                {
                    Toast.makeText(getApplicationContext(), "El número es demasiado grande",Toast.LENGTH_LONG).show();
                    edtLecturaAnterior.setText("");
                }
                return false;
            }
        });

        edtLecturaActual.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (edtLecturaActual.getText().toString().length() < 10 ) {
                    calcularEstadisticasDeConsumo();
                } else
                {
                    Toast.makeText(getApplicationContext(), "El número es demasiado grande",Toast.LENGTH_LONG).show();
                    edtLecturaActual.setText("");
                }
                return false;
            }
        });

        cleanImputEditTexts();

        final Button btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanImputEditTexts();
            }
        });

        final Button btnVerFactura = (Button) findViewById(R.id.btnVerFactura);

        btnVerFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtLecturaActual.getText().toString().length() > 0 &&
                        edtLecturaAnterior.getText().toString().length() > 0)
                    if (Integer.valueOf(edtLecturaActual.getText().toString())
                            <= Integer.valueOf(edtLecturaAnterior.getText().toString())) {

                        Toast.makeText(getBaseContext(),
                                "La lectura actual debe ser mayor que la lectura anterior",
                                Toast.LENGTH_SHORT).show();
                    } else {

                        Intent i = new Intent(getBaseContext(), FacturaActivity.class);

                        int consum = Integer.parseInt(edtLecturaActual.getText().toString()) -
                                Integer.parseInt(edtLecturaAnterior.getText().toString());

                        Bundle b = new Bundle();
                        b.putInt("consumo", consum);

                        i.putExtras(b);
                        startActivity(i);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    }
                else {
                    Toast.makeText(getBaseContext(),
                            "Debe especificar la lectura anterior y la actual",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnFechaLecturaActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDatePicker(context, v);
            }
        });

        btnFechaLecturaAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDatePicker(context, v);
            }
        });

        txtPrediccionImporteMensualValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Importe aproximado a pagar a fin de mes si mantiene el ritmo de consumo actual",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtPromConsDiarioValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Promedio de consumo diario calculado a partir de las lecturas y los días entre ambas lecturas",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtDiasLeidosValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Días transcurridos entre las lecturas anterior y actual",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtConsumoClaculadoValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Consumo calculado a partir de las lecturas anterior y actual",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtImporteCalculadoValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Importe a pagar según la lectura realizada",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtPrediccionImporteMensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Importe aproximado a pagar a fin de mes si mantiene el ritmo de consumo actual",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtPromConsDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Promedio de consumo diario calculado a partir de las lecturas y los días entre ambas lecturas",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtDiasLeidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Días transcurridos entre las lecturas anterior y actual",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtConsumoClaculado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Consumo calculado a partir de las lecturas anterior y actual",
                        Toast.LENGTH_LONG).show();
            }
        });

        txtImporteCalculado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        "Importe a pagar según la lectura realizada",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void calcularEstadisticasDeConsumo() {

        // si estan registradas las lecturas
        if (edtLecturaActual.getText().toString().length() > 0 &&
                edtLecturaAnterior.getText().toString().length() > 0) {
            // si la alectura actual es mayor que la anterior
            // si la fecha anterior y actual han sido especificadas
            if (Integer.valueOf(edtLecturaActual.getText().toString())
                    >= Integer.valueOf(edtLecturaAnterior.getText().toString())) {
                if ((btnFechaLecturaAnterior.getText().toString().length() > 0) &&
                        (btnFechaLecturaActual.getText().toString().length() > 0)) {

                    int consumoActual = Integer.parseInt(edtLecturaActual.
                    getText().toString()) - Integer.
                    parseInt(edtLecturaAnterior.getText().toString());

                    txtConsumoClaculadoValue.setText(String.
                            valueOf(consumoActual) + " Kw/h");

                    Integer cantDiasLeidos = 0;

                    try {
                        String strFechaActual = Utils.formatDate(btnFechaLecturaActual.getText().
                                toString(), "ddd/mm/yyy", "yyyy-mm-dd");
                        String strFechaAnterior = Utils.formatDate(btnFechaLecturaAnterior.getText().
                                toString(), "ddd/mm/yyy", "yyyy-mm-dd");
                        cantDiasLeidos = Utils.DaysBetweenDates(Date.valueOf(strFechaActual),
                                Date.valueOf(strFechaAnterior));

                        txtDiasLeidosValue.setText(String.
                                valueOf(cantDiasLeidos) + " dias");

                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }

                    txtImporteCalculadoValue.setText(String.format(FLOAT_FORMAT,
                            Utils.calcularImporteTotal(consumoActual)) + " pesos");

                    if (cantDiasLeidos == 0) {
                        txtPromConsDiarioValue.setText("No disponible");
                        txtPrediccionImporteMensualValue.setText("No disponible");
                    } else if (cantDiasLeidos < 0) {
                        Toast.makeText(getApplicationContext(),
                                "La fecha de la lectura anterior no puede ser mayor que la actual",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        txtPromConsDiarioValue.setText(String.format(FLOAT_FORMAT,
                                Utils.calcularPromedioConsumoDiario(consumoActual,
                                        cantDiasLeidos)) + " Kw/h");

                        txtPrediccionImporteMensualValue.setText(String.format(FLOAT_FORMAT,
                                Utils.predecirImporteFinalMes(consumoActual, cantDiasLeidos)) + " pesos");
                    }
                } else resetDatosEstadisticos();
            }  else resetDatosEstadisticos();
        } else resetDatosEstadisticos();
    }

    private void initViewObjects() {
        txtConsumoClaculadoValue = (TextView)findViewById(R.id.txtConsumoClaculadoValue);
        txtImporteCalculadoValue = (TextView)findViewById(R.id.txtImporteCalculadoValue);
        txtDiasLeidosValue = (TextView)findViewById(R.id.txtDiasLeidosValue);
        txtPromConsDiarioValue = (TextView)findViewById(R.id.txtPromConsDiarioValue);
        txtPrediccionImporteMensualValue =(TextView)findViewById(R.id.txtPrediccionImporteMensualValue);

        txtConsumoClaculado = (TextView)findViewById(R.id.txtConsumoClaculado);
        txtImporteCalculado = (TextView)findViewById(R.id.txtImporteCalculado);
        txtDiasLeidos = (TextView)findViewById(R.id.txtDiasLeidos);
        txtPromConsDiario = (TextView)findViewById(R.id.txtPromConsDiario);
        txtPrediccionImporteMensual =(TextView)findViewById(R.id.txtPrediccionImporteMensual);

        edtLecturaActual = (EditText)findViewById(R.id.edtLecturaActual);
        edtLecturaAnterior = (EditText)findViewById(R.id.edtLecturaAnterior);
        btnFechaLecturaActual = (Button)findViewById(R.id.btnFechaLecturaActual);
        btnFechaLecturaAnterior = (Button)findViewById(R.id.btnFechaLecturaAnterior);
    }

    private void cleanImputEditTexts() {
        edtLecturaActual.setText("");
        edtLecturaAnterior.setText("");
        btnFechaLecturaAnterior.setText("");
        btnFechaLecturaActual.setText("");
        edtLecturaAnterior.requestFocus();
        resetDatosEstadisticos();
    }

    private void resetDatosEstadisticos() {
        txtConsumoClaculadoValue.setText("0 Kw/h");
        txtImporteCalculadoValue.setText("0 pesos");
        txtDiasLeidosValue.setText("No disponible");
        txtPromConsDiarioValue.setText("No disponible");
        txtPrediccionImporteMensualValue.setText("No disponible");
    }

    public void showDialogDatePicker(final Context context, final View view) {
        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        final View dialogDatePicker = layoutInflater.inflate(
                R.layout.activity_dialog_date_picker, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set prompts.xml to be the layout file of the alertdialog
        // builder
        alertDialogBuilder.setView(dialogDatePicker);

        // setup a dialog window
        alertDialogBuilder
                .setTitle("Fecha de la lectura")
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        final DatePicker datePicker = (DatePicker) dialogDatePicker.findViewById(R.id.datePicker);
                        String dia = Integer.toString(datePicker.getDayOfMonth());
                        String mes = Integer.toString(datePicker.getMonth() + 1);
                        String anno = Integer.toString(datePicker.getYear());

                        //   Toast.makeText(context, "Mes: "+ mes, Toast.LENGTH_SHORT).show();

                        if (view.getId() == R.id.btnFechaLecturaAnterior) {
                            btnFechaLecturaAnterior.setText(dia + "/" + mes + "/" + anno);
                        } else if (view.getId() == R.id.btnFechaLecturaActual) {
                            btnFechaLecturaActual.setText(dia + "/" + mes + "/" + anno);
                        }

                      //  if (true) {
                            // calculo los datos estadisticos
                            calcularEstadisticasDeConsumo();
                      //  } else {
                      //      resetDatosEstadisticos();
                      //      Toast.makeText(context, "La fecha de lectura anterior no puede ser mayor que la actual",
                      //              Toast.LENGTH_SHORT).show();
                      //  }
                    }
                })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alertD = alertDialogBuilder.create();
        alertD.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent i = new Intent(getBaseContext(), AboutActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);

            return true;
        } else if (id == R.id.help) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
