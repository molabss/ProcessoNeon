package br.com.processoNeon.view;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.processoNeon.R;

public class MainActivity extends AppCompatActivity {

    private Button sendMoney;
    private Button showHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/HelveticaNeue.ttf");
        TextView nome = (TextView)findViewById(R.id.userName);
        nome.setTypeface(custom_font);
        TextView email = (TextView)findViewById(R.id.email);
        email.setTypeface(custom_font);

        sendMoney = (Button)findViewById(R.id.sendMoney);
        showHistory = (Button)findViewById(R.id.showHistory);

        sendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SendMoneyActivity.class));
            }
        });

        showHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ShowHistoryActivity.class));
            }
        });
    }
}
