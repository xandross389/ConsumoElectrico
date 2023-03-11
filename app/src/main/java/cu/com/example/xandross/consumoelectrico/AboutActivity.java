package cu.com.example.xandross.consumoelectrico;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        ImageView imgDonate = (ImageView)findViewById(R.id.imgDonate);
        imgDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogTransferirSaldo(context);
            }
        });

        ImageView imgPhone = (ImageView)findViewById(R.id.imgPhone);
        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickPhoneCall("5354389534");
            }
        });

        ImageView imgMail = (ImageView)findViewById(R.id.imgMail);
        imgMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] addressesArray = {"xandross389@yahoo.es"};
                sendEmail(addressesArray, "Sobre aplicacion movil Consumo Electrico");
            }
        });

        ImageView imgDeveloper = (ImageView)findViewById(R.id.imgDeveloper);
        imgDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContactPerson("Alejandro","+5354389534","MOVIL",
                        "xandross389@yahoo.es","Desarrollador Android","Desarrollador de la aplicacion Consumo Electrico");
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.consultar_saldo) {
            consultarSaldo(context);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void consultarSaldo(Context context) {

        try{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:*222"+Uri.encode("#")));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }catch(Exception e){
            Toast.makeText(context,
                        "Error consultando el saldo",
                        Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void transferirSaldo(int _cantTransf, int _pinNumber) {
        // startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:*222#")));
        // # -> %23 o Uri.encode("#")
        // transferencia de saldo -> *234*1*numeroBeneficiario*pinNumber*cantSaldo#
        // TRANSFERIR SALDO

        if (_cantTransf != 0 && _pinNumber != 0) {
            try{
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(
                        Uri.parse("tel:*234*1*54389534*"+String.valueOf(_pinNumber)+"*"+
                                String.valueOf(_cantTransf)+Uri.encode("#")));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }catch(Exception e){
                Toast.makeText(getBaseContext(),
                        "Error intentando transferir el saldo ("+e.getMessage()+")",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        } else if ((_cantTransf == 0 && _pinNumber == 0) || (_pinNumber == 0))  {
            try{
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(
                        Uri.parse("tel:*234*1*54389534"+Uri.encode("#")));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }catch(Exception e) {
                Toast.makeText(getBaseContext(),
                        "Error intentando transferir el saldo (" + e.getMessage() + ")",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
                }
            } else if (_cantTransf == 0) {
            try {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(
                        Uri.parse("tel:*234*1*54389534*" + String.valueOf(_pinNumber) +
                                Uri.encode("#")));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            } catch (Exception e) {
                Toast.makeText(getBaseContext(),
                        "Error intentando transferir el saldo (" + e.getMessage() + ")",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace(); }

            } else {
                try{
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(
                            Uri.parse("tel:*234*1*54389534"+Uri.encode("#")));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }catch(Exception e){
                    Toast.makeText(getBaseContext(),
                            "Error intentando transferir el saldo ("+e.getMessage()+")",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
    }

    public void showDialogTransferirSaldo(final Context context) {
        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View dialogTransferirSaldo = layoutInflater.inflate(
                R.layout.activity_dialog_transferir_saldo, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set prompts.xml to be the layout file of the alertdialog
        // builder
        alertDialogBuilder.setView(dialogTransferirSaldo);

        final EditText edtCantTransf = (EditText) dialogTransferirSaldo
                .findViewById(R.id.edtCantTransf);
        final EditText edtPinNumber = (EditText) dialogTransferirSaldo
                .findViewById(R.id.edtPinNumber);

        // setup a dialog window
        alertDialogBuilder
                .setTitle("Contribuir")
                .setCancelable(false)
                .setPositiveButton("Donar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       // if (edtCantTransf.getText().toString().length() > 0) {
                            int cantSaldo = 0;
                            int pin = 0;

                        //cantSaldo = Integer.valueOf();
                       // pin = Integer.valueOf(edtPinNumber.getText().toString().isEmpty());

                        if (! edtCantTransf.getText().toString().isEmpty()) {
                            cantSaldo = Integer.valueOf(edtCantTransf.getText().toString());
                        }

                        if (! edtPinNumber.getText().toString().isEmpty()) {
                            pin = Integer.valueOf(edtPinNumber.getText().toString());
                        }

                        transferirSaldo(cantSaldo, pin);
                        //} else {
                       //     Toast.makeText(getBaseContext(),
                       //             "Debe especificar la cantidad a transferir",
                       //             Toast.LENGTH_SHORT).show();
                       //     //edtCantTransf.requestFocus();
                       // }

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

    void pickPhoneCall(String pPhoneNumber) {
        try{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(
                    Uri.parse("tel:"+pPhoneNumber));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }catch(Exception e){
            Toast.makeText(getBaseContext(),
                    "Error intentando realizar llamada ("+e.getMessage()+")",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    void sendEmail(String[] addresses, String subject) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }catch(Exception e){
                Toast.makeText(getBaseContext(),
                        "Error intentando realizar llamada ("+e.getMessage()+")",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

    }

    void addContactPerson(String personName, String phone, String phoneType,
                          String email, String jobTitle, String comment) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, personName);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, phoneType);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle);
        intent.putExtra(ContactsContract.Intents.Insert.NOTES, comment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
