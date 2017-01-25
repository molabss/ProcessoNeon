package br.com.processoNeon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_contact,parent,false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
        ContactViewHolder holder = (ContactViewHolder) viewHolder;
        holder.ivProfile.setImageResource(contactList.get(i).getImageResourceId());
        holder.tvName.setText(contactList.get(i).getName());
        holder.tvMobile.setText(contactList.get(i).getMobile());
        holder.toolbar.inflateMenu(R.menu.card_toolbar);
        holder.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(mContext,menuItem.getTitle() +"",Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProfile;
        private TextView tvMobile;
        private TextView tvName;
        private Toolbar toolbar;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivProfile = (ImageView) itemView.findViewById(R.id.ivProfile);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvMobile = (TextView) itemView.findViewById(R.id.tvMobile);
            toolbar = (Toolbar) itemView.findViewById(R.id.toolbar);
        }
    }
}
