package sg.edu.rp.c346.id22000210.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking the variables to the UI element
        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        //Initiate that the buttons has a context menu
        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, getString(R.string.website));
        menu.add(0, 1, 1, getString(R.string.contact_the_bank));
        menu.add(0, 2, 2, getString(R.string.favourite));

        if(v == btnDBS) {
            wordClicked = getString(R.string.dbs);
        }
        else if (v == btnOCBC) {
            wordClicked = getString(R.string.ocbc);
        }
        else if (v == btnUOB) {
            wordClicked = getString(R.string.uob);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String web = "";
        String contact = "";

        if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
            if (item.getItemId() == 0) {
                //Go to Website
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.web_dbs)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                //Contact the Bank
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.contact_dbs)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 2) {
                // Toggle favorite
                Button selectedButton = (Button) item.getActionView();
                selectedButton.setTextColor(Color.BLACK);
                selectedButton.setBackgroundColor(Color.RED);
            }
        }

            if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
                if (item.getItemId() == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.web_ocbc)));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 1) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.contact_ocbc)));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 2) {
                    // Toggle favorite
                    Button selectedButton = (Button) item.getActionView();
                    selectedButton.setTextColor(Color.BLACK);
                    selectedButton.setBackgroundColor(Color.RED);
                }
            }

            if (wordClicked.equalsIgnoreCase(getString(R.string.uob))) {
                if (item.getItemId() == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.web_uob)));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 1) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.contact_uob)));
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == 2) {
                    // Toggle favorite
                    Button selectedButton = (Button) item.getActionView();
                    selectedButton.setTextColor(Color.BLACK);
                    selectedButton.setBackgroundColor(Color.RED);
                }
            }
            return false;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText(getString(R.string.dbs));
            btnOCBC.setText(getString(R.string.ocbc));
            btnUOB.setText(getString(R.string.uob));
            return true;

        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText(getString(R.string.chi_dbs));
            btnOCBC.setText(getString(R.string.chi_ocbc));
            btnUOB.setText(getString(R.string.chi_uob));
            return true;

        } else {
            btnDBS.setText(getString(R.string.translation_error));
            btnOCBC.setText(getString(R.string.translation_error));
            btnUOB.setText(getString(R.string.translation_error));
        }

        return super.onOptionsItemSelected(item);
    }


}