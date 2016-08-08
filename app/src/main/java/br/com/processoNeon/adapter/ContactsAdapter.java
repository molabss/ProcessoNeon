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
import br.com.processoNeon.model.Contact;

/**
 * Created by Moisés on 06/08/2016.
 */
public class ContactsAdapter extends RecyclerView.Adapter{

    private Context mContext;
    List<Contact> contactList;

    public ContactsAdapter(Context mContext, List<Contact> contactList){
        this.mContext = mContext;
        this.contactList = contactList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_contact, null);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ContactViewHolder holder = (ContactViewHolder) viewHolder;
        holder.ivProfile.setImageResource(contactList.get(i).getImageResourceId());
        holder.tvName.setText(contactList.get(i).getName());
        holder.tvMobile.setText(contactList.get(i).getMobile());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProfile;
        private TextView tvMobile;
        private TextView tvName;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvMobile = (TextView) itemView.findViewById(R.id.tvMobile);
        }
    }
}
