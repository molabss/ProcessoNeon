package br.com.processoNeon.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.processoNeon.R;
import br.com.processoNeon.adapter.ContactHistoryAdapter;
import br.com.processoNeon.helper.AsyncResponse;
import br.com.processoNeon.helper.NeonRESTParamsWrapper;
import br.com.processoNeon.model.ContactHistory;
import br.com.processoNeon.networkcomm.RetrieveHistoryTask;
import br.com.processoNeon.system.ApplicationInit;

public class ShowHistoryActivity extends AppCompatActivity implements AsyncResponse {

    private RecyclerView mRvListHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(this.getResources().getString(R.string.sendHistory));
        ab.setDisplayHomeAsUpEnabled(true);

        NeonRESTParamsWrapper wrapper = new NeonRESTParamsWrapper(
                "http://processoseletivoneon.azurewebsites.net/GetTransfers"
                ,ApplicationInit.sToken);

        RetrieveHistoryTask.GetHistory task = new RetrieveHistoryTask(ShowHistoryActivity.this).new GetHistory();
        task.delegate = this;
        task.execute(wrapper);
    }

    @Override
    public void processFinish(Object o) {
        List<ContactHistory> listHist = (List<ContactHistory>)o;
        mRvListHistory = (RecyclerView)findViewById(R.id.rvListHistory);
        mRvListHistory.setLayoutManager(new LinearLayoutManager(this));
        ContactHistoryAdapter chAdapter = new ContactHistoryAdapter(this,listHist);
        mRvListHistory.setAdapter(chAdapter);
        mRvListHistory.setItemAnimator(new DefaultItemAnimator());
    }
}
