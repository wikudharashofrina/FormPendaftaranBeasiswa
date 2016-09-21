package id.sch.smktelkom_mlg.learn.formpendaftaranbeasiswa;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgStatus;
    CheckBox cbA, cbB, cbC;
    TextView tvHasil;
    EditText etNama;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgStatus = (RadioGroup) findViewById(R.id.RadioGroupStatus);
        etNama = (EditText) findViewById(R.id.editTextNama);
        cbA = (CheckBox) findViewById(R.id.checkBox);
        cbB = (CheckBox) findViewById(R.id.checkBox2);
        cbC = (CheckBox) findViewById(R.id.checkBox3);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doClick();
            }
        });
    }


        private void doClick() {
             String nama = etNama.getText().toString();
            String hobi = "";
            int startlen = hobi.length();
            if (cbA.isChecked()) hobi += cbA.getText() + ",";
            if (cbB.isChecked()) hobi += cbB.getText() + ",";
            if (cbC.isChecked()) hobi += cbC.getText() + ",";
            if (hobi.length() == startlen) hobi += "Kosong";

            String hasil = null;
            if (rgStatus.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgStatus.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvHasil.setText("Nama Anda : " + "Anda belum memilih jenis kelamin");
            }else {
                tvHasil.setText("Nama Anda : " + nama + "\n Jenis Kelamin Anda : " + hasil + "\n Hobi Anda : " + hobi);
            }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner_toolbar, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        return true;

    }
}

