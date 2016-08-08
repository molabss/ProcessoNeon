package br.com.processoNeon.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.processoNeon.R;
import br.com.processoNeon.helper.NeonRESTParamsWrapper;
import br.com.processoNeon.model.Contact;
import br.com.processoNeon.networkcomm.SendMoneyTask;
import br.com.processoNeon.system.ApplicationInit;

public class ValuePopupActivity extends AppCompatActivity {

    private TextView userName;
    private TextView mobile;
    private EditText valToSend;
    private ImageView picContact;
    private Button btnSendMoney;
    private Contact mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_popup);

        userName = (TextView)findViewById(R.id.name);
        mobile = (TextView)findViewById(R.id.mobile);
        valToSend = (EditText)findViewById(R.id.valToSend);
        btnSendMoney = (Button)findViewById(R.id.btnSendMoney);
        picContact = (ImageView) findViewById(R.id.picContact);
        mContact = (Contact) getIntent().getParcelableExtra("contact");
        userName.setText(mContact.getName());
        mobile.setText(mContact.getMobile());
        picContact.setImageResource(mContact.getImageResourceId());
        //valToSend.addTextChangedListener(new MoneyMask(valToSend));

        btnSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NeonRESTParamsWrapper wrapper = new NeonRESTParamsWrapper(
                        "http://processoseletivoneon.azurewebsites.net/SendMoney"
                        ,ApplicationInit.sToken
                        ,mContact.getClientID()
                        ,valToSend.getText().toString()
                );
                SendMoneyTask.Send task = new SendMoneyTask(ValuePopupActivity.this).new Send();
                task.execute(wrapper);
            }
        });
    }
}
