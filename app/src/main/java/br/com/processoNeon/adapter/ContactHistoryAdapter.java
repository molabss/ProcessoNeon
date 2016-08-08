package br.com.processoNeon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.processoNeon.R;
import br.com.processoNeon.model.ContactHistory;

/**
 * Created by Moisés on 07/08/2016.
 */
public class ContactHistoryAdapter extends RecyclerView.Adapter{

    private Context mContext;
    List<ContactHistory> listHist;

    public ContactHistoryAdapter(Context mContext, List<ContactHistory> listHist){
        this.mContext = mContext;
        this.listHist = listHist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_contact_history, null);
        ContactHistViewHolder viewHolder = new ContactHistViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ContactHistViewHolder holder = (ContactHistViewHolder) viewHolder;
        holder.ivProfile.setImageResource(listHist.get(i).getImageResourceId());
        holder.tvName.setText(listHist.get(i).getName());
        holder.tvMobile.setText(listHist.get(i).getMobile());
        holder.tvDate.setText(listHist.get(i).getData());
    }

    @Override
    public int getItemCount() {
        return listHist.size();
    }

    public static class ContactHistViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProfile;
        private TextView tvMobile;
        private TextView tvName;
        private TextView tvDate;

        public ContactHistViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvMobile = (TextView) itemView.findViewById(R.id.tvMobile);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}
