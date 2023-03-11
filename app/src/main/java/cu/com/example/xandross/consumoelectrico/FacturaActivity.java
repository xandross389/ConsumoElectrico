package cu.com.example.xandross.consumoelectrico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class FacturaActivity extends AppCompatActivity {
    int con;
    public static final String FLOAT_FORMAT = "%1.2f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        con = getIntent().getExtras().getInt("consumo", 0);

        rellenarFatura(con);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_factura, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void rellenarFatura(int pConsumo) {
        double importeTotal;

                // lleno los consumosi
        if (pConsumo <= 100) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText(String.valueOf(pConsumo));
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText(String.format(FLOAT_FORMAT, pConsumo * 0.09));

            importeTotal = pConsumo * 0.09;
        } else if ((pConsumo >= 101) && (pConsumo <= 150)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText(String.valueOf(pConsumo - 100));
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText(String.format(FLOAT_FORMAT, (pConsumo - 100) * 0.3));

            importeTotal = (pConsumo - 100) * 0.3 + 9;
        } else if ((pConsumo >= 151) && (pConsumo <= 200)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText(String.valueOf(pConsumo - 150));
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText(String.format(FLOAT_FORMAT, (pConsumo - 150) * 0.4));

            importeTotal = (pConsumo - 150) * 0.4 + 24;
        } else if ((pConsumo >= 201) && (pConsumo <= 250)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText(String.valueOf(pConsumo - 200));
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText(String.format(FLOAT_FORMAT, (pConsumo - 200) * 0.6));

            importeTotal = (pConsumo - 200) * 0.6 + 44;
        } else if ((pConsumo >= 251) && (pConsumo <= 300)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText("50");
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText("30.00");

            TextView valorConsumoRango5 = (TextView)findViewById(R.id.valorConsumoRango5);
            valorConsumoRango5.setText(String.valueOf(pConsumo - 250));
            TextView valorImporteRango5 = (TextView)findViewById(R.id.valorImporteRango5);
            valorImporteRango5.setText(String.format(FLOAT_FORMAT, (pConsumo - 250) * 0.8));

            importeTotal = (pConsumo - 250) * 0.8 + 74;
        } else if ((pConsumo >= 301) && (pConsumo <= 350)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText("50");
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText("30.00");

            TextView valorConsumoRango5 = (TextView)findViewById(R.id.valorConsumoRango5);
            valorConsumoRango5.setText("50");
            TextView valorImporteRango5 = (TextView)findViewById(R.id.valorImporteRango5);
            valorImporteRango5.setText("40.00");

            TextView valorConsumoRango6 = (TextView)findViewById(R.id.valorConsumoRango6);
            valorConsumoRango6.setText(String.valueOf(pConsumo - 300));
            TextView valorImporteRango6 = (TextView)findViewById(R.id.valorImporteRango6);
            valorImporteRango6.setText(String.format(FLOAT_FORMAT, (pConsumo - 300) * 1.5));

            importeTotal = (pConsumo - 300) * 1.5 + 114;
        } else if ((pConsumo >= 351) && (pConsumo <= 500)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText("50");
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText("30.00");

            TextView valorConsumoRango5 = (TextView)findViewById(R.id.valorConsumoRango5);
            valorConsumoRango5.setText("50");
            TextView valorImporteRango5 = (TextView)findViewById(R.id.valorImporteRango5);
            valorImporteRango5.setText("40.00");

            TextView valorConsumoRango6 = (TextView)findViewById(R.id.valorConsumoRango6);
            valorConsumoRango6.setText("50");
            TextView valorImporteRango6 = (TextView)findViewById(R.id.valorImporteRango6);
            valorImporteRango6.setText("75.00");

            TextView valorConsumoRango7 = (TextView)findViewById(R.id.valorConsumoRango7);
            valorConsumoRango7.setText(String.valueOf(pConsumo - 350));
            TextView valorImporteRango7 = (TextView)findViewById(R.id.valorImporteRango7);
            valorImporteRango7.setText(String.format(FLOAT_FORMAT, (pConsumo - 350) * 1.8));

            importeTotal = (pConsumo - 350) * 1.8 + 189;
        } else if ((pConsumo >= 501) && (pConsumo <= 1000)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText("50");
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText("30.00");

            TextView valorConsumoRango5 = (TextView)findViewById(R.id.valorConsumoRango5);
            valorConsumoRango5.setText("50");
            TextView valorImporteRango5 = (TextView)findViewById(R.id.valorImporteRango5);
            valorImporteRango5.setText("40.00");

            TextView valorConsumoRango6 = (TextView)findViewById(R.id.valorConsumoRango6);
            valorConsumoRango6.setText("50");
            TextView valorImporteRango6 = (TextView)findViewById(R.id.valorImporteRango6);
            valorImporteRango6.setText("75.00");

            TextView valorConsumoRango7 = (TextView)findViewById(R.id.valorConsumoRango7);
            valorConsumoRango7.setText("150");
            TextView valorImporteRango7 = (TextView)findViewById(R.id.valorImporteRango7);
            valorImporteRango7.setText("270.00");

            TextView valorConsumoRango8 = (TextView)findViewById(R.id.valorConsumoRango8);
            valorConsumoRango8.setText(String.valueOf(pConsumo - 500));
            TextView valorImporteRango8 = (TextView)findViewById(R.id.valorImporteRango8);
            valorImporteRango8.setText(String.format(FLOAT_FORMAT, (pConsumo - 500) * 2.0));

            importeTotal = (pConsumo - 500) * 2.0 + 459;
        } else if ((pConsumo >= 1001) && (pConsumo <= 5000)) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText("50");
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText("30.00");

            TextView valorConsumoRango5 = (TextView)findViewById(R.id.valorConsumoRango5);
            valorConsumoRango5.setText("50");
            TextView valorImporteRango5 = (TextView)findViewById(R.id.valorImporteRango5);
            valorImporteRango5.setText("40.00");

            TextView valorConsumoRango6 = (TextView)findViewById(R.id.valorConsumoRango6);
            valorConsumoRango6.setText("50");
            TextView valorImporteRango6 = (TextView)findViewById(R.id.valorImporteRango6);
            valorImporteRango6.setText("75.00");

            TextView valorConsumoRango7 = (TextView)findViewById(R.id.valorConsumoRango7);
            valorConsumoRango7.setText("150");
            TextView valorImporteRango7 = (TextView)findViewById(R.id.valorImporteRango7);
            valorImporteRango7.setText("270.00");

            TextView valorConsumoRango8 = (TextView)findViewById(R.id.valorConsumoRango8);
            valorConsumoRango8.setText("500");
            TextView valorImporteRango8 = (TextView)findViewById(R.id.valorImporteRango8);
            valorImporteRango8.setText("1000.00");

            TextView valorConsumoRango9 = (TextView)findViewById(R.id.valorConsumoRango9);
            valorConsumoRango9.setText(String.valueOf(pConsumo - 1000));
            TextView valorImporteRango9 = (TextView)findViewById(R.id.valorImporteRango9);
            valorImporteRango9.setText(String.format(FLOAT_FORMAT, (pConsumo - 1000) * 3.0));

            importeTotal = (pConsumo - 1000) * 3.0 + 1459;
        } else if (pConsumo > 5001) {
            TextView valorConsumoRango1 = (TextView)findViewById(R.id.valorConsumoRango1);
            valorConsumoRango1.setText("100");
            TextView valorImporteRango1 = (TextView)findViewById(R.id.valorImporteRango1);
            valorImporteRango1.setText("9.00");

            TextView valorConsumoRango2 = (TextView)findViewById(R.id.valorConsumoRango2);
            valorConsumoRango2.setText("50");
            TextView valorImporteRango2 = (TextView)findViewById(R.id.valorImporteRango2);
            valorImporteRango2.setText("15.00");

            TextView valorConsumoRango3 = (TextView)findViewById(R.id.valorConsumoRango3);
            valorConsumoRango3.setText("50");
            TextView valorImporteRango3 = (TextView)findViewById(R.id.valorImporteRango3);
            valorImporteRango3.setText("20.00");

            TextView valorConsumoRango4 = (TextView)findViewById(R.id.valorConsumoRango4);
            valorConsumoRango4.setText("50");
            TextView valorImporteRango4 = (TextView)findViewById(R.id.valorImporteRango4);
            valorImporteRango4.setText("30.00");

            TextView valorConsumoRango5 = (TextView)findViewById(R.id.valorConsumoRango5);
            valorConsumoRango5.setText("50");
            TextView valorImporteRango5 = (TextView)findViewById(R.id.valorImporteRango5);
            valorImporteRango5.setText("40.00");

            TextView valorConsumoRango6 = (TextView)findViewById(R.id.valorConsumoRango6);
            valorConsumoRango6.setText("50");
            TextView valorImporteRango6 = (TextView)findViewById(R.id.valorImporteRango6);
            valorImporteRango6.setText("75.00");

            TextView valorConsumoRango7 = (TextView)findViewById(R.id.valorConsumoRango7);
            valorConsumoRango7.setText("150");
            TextView valorImporteRango7 = (TextView)findViewById(R.id.valorImporteRango7);
            valorImporteRango7.setText("270.00");

            TextView valorConsumoRango8 = (TextView)findViewById(R.id.valorConsumoRango8);
            valorConsumoRango8.setText("500");
            TextView valorImporteRango8 = (TextView)findViewById(R.id.valorImporteRango8);
            valorImporteRango8.setText("1000.00");

            TextView valorConsumoRango9 = (TextView)findViewById(R.id.valorConsumoRango9);
            valorConsumoRango9.setText("4000");
            TextView valorImporteRango9 = (TextView)findViewById(R.id.valorImporteRango9);
            valorImporteRango9.setText("12000.00");

            TextView valorConsumoRango10 = (TextView)findViewById(R.id.valorConsumoRango10);
            valorConsumoRango10.setText(String.valueOf(pConsumo - 5000));
            TextView valorImporteRango10 = (TextView)findViewById(R.id.valorImporteRango10);
            valorImporteRango10.setText(String.format(FLOAT_FORMAT, (pConsumo - 5000) * 5.0));

            importeTotal = (pConsumo - 5000) * 5.0 + 13459;
        } else importeTotal = 0.00;

        TextView valorConsumoTotal = (TextView)findViewById(R.id.valorConsumoTotal);
        valorConsumoTotal.setText(String.valueOf(pConsumo));
        TextView valorImporteTotal = (TextView)findViewById(R.id.valorImporteTotal);
        valorImporteTotal.setText(String.format(FLOAT_FORMAT, importeTotal));
    }


}
