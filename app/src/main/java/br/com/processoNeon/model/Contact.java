package br.com.processoNeon.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Moises on 06/08/2016.
 */
public class Contact implements Parcelable{

    private String clientID;
    private String name;
    private int imageResourceId;
    private String mobile;
    private String dateSend;
    private String value;

    //-----------------------------------------------------------------------------------------
    public Contact (Parcel parcel){
        this.clientID = parcel.readString();
        this.name = parcel.readString();
        this.imageResourceId = parcel.readInt();
        this.mobile = parcel.readString();
        this.dateSend = parcel.readString();
        this.value = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.clientID);
        parcel.writeString(this.name);
        parcel.writeInt(this.imageResourceId);
        parcel.writeString(this.mobile);
        parcel.writeString(this.dateSend);
        parcel.writeString(this.value);
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>(){

        @Override
        public Contact createFromParcel(Parcel parcel) {
            return new Contact(parcel);
        }

        @Override
        public Contact[] newArray(int i) {
            return new Contact[i];
        }
    };
    //--------------------------------------------------------------------------------------



    public Contact(int imageResourceId, String name, String mobile, String clientID) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.mobile = mobile;
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}



