package br.com.processoNeon.model;

import android.os.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Moisés on 07/08/2016.
 */

public class ContactHistory extends Contact{

    private String Id;
    private String ClienteId;
    private String Valor;
    private String Token;
    private String Data;

    public ContactHistory(Parcel parcel) {
        super(parcel);
        this.Id = parcel.readString();
        this.ClienteId = parcel.readString();
        this.Valor = parcel.readString();
        this.Token = parcel.readString();
        this.Data = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(Id);
        parcel.writeString(ClienteId);
        parcel.writeString(Valor);
        parcel.writeString(Token);
        parcel.writeString(Data);
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    public static final Creator<ContactHistory> CREATOR = new Creator<ContactHistory>(){

        @Override
        public ContactHistory createFromParcel(Parcel parcel) {
            return new ContactHistory(parcel);
        }

        @Override
        public ContactHistory[] newArray(int i) {
            return new ContactHistory[i];
        }
    };


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getData() {
        Locale local = new Locale("pt","BR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy 'às' HH:mm",local);
        Date d = null;
        try {
            d = sdf.parse(Data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = output.format(d);
        return formattedTime;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getClienteId() {
        return ClienteId;
    }

    public void setClienteId(String clienteId) {
        ClienteId = clienteId;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }
}
