package br.com.processoNeon.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.processoNeon.R;
import br.com.processoNeon.adapter.ContactsAdapter;
import br.com.processoNeon.model.Contact;

public class SendMoneyActivity extends AppCompatActivity {

    private RecyclerView mRvListContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(this.getResources().getString(R.string.titleSendMoney));
        ab.setDisplayHomeAsUpEnabled(true);

        mRvListContacts = (RecyclerView)findViewById(R.id.rvListContacts);
        mRvListContacts.setLayoutManager(new LinearLayoutManager(this));
        final List<Contact> contactList = new ArrayList<Contact>();

        contactList.add(new Contact(R.mipmap.amy,"Amy", "(11) 98877.6655","548"));
        contactList.add(new Contact(R.mipmap.antonia,"Antonia", "(11) 93344.8907","987"));
        contactList.add(new Contact(R.mipmap.axa,"Axa", "(11) 93456.8906","345"));
        contactList.add(new Contact(R.mipmap.fany,"Fany", "(11) 92345.8765","654"));
        contactList.add(new Contact(R.mipmap.francisco,"Francisco", "(11) 93456.0987","234"));
        contactList.add(new Contact(R.mipmap.frederico,"Frederico", "(11) 964767.9237","800"));
        contactList.add(new Contact(R.mipmap.jack,"Jack", "(11) 91243.8654","765"));
        contactList.add(new Contact(R.mipmap.jesus,"Jesus", "(11) 98877.6655","143"));
        contactList.add(new Contact(R.mipmap.joao,"João", "(11) 98877.6655","276"));

        contactList.add(new Contact(R.mipmap.mary,"Mary", "(11) 98877.6655","908"));
        contactList.add(new Contact(R.mipmap.mike,"Mike", "(11) 98877.6655","117"));
        contactList.add(new Contact(R.mipmap.nicole,"Nicole", "(11) 98877.6655","599"));
        contactList.add(new Contact(R.mipmap.obama,"Obama", "(11) 98877.6655","455"));
        contactList.add(new Contact(R.mipmap.samy,"Samy", "(11) 98877.6655","555"));

        ContactsAdapter cAdapter = new ContactsAdapter(this,contactList);

//        mRvListContacts.addOnItemTouchListener(
//                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override public void onItemClick(View view, int position) {
//                        startActivity(new Intent(SendMoneyActivity.this,ValuePopupActivity.class).putExtra("contact",contactList.get(position)));
//                    }
//                })
//        );
        mRvListContacts.setAdapter(cAdapter);
        mRvListContacts.setItemAnimator(new DefaultItemAnimator());
    }
}
