package com.example.danilo.login.Activities.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.danilo.login.Activities.Clases.Conf;
import com.example.danilo.login.R;
import com.github.snowdream.android.widget.SmartImageView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class GaleriaActivity extends AppCompatActivity {

    private ListView listaGaleria;
   // ArrayList idevento=new ArrayList();
    ArrayList imagen=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        listaGaleria= findViewById(R.id.listaGaleria);
        descargarImagen();

    }

    private void descargarImagen() {
      //  idevento.clear();
        imagen.clear();

        final ProgressDialog progressDialog= new ProgressDialog(GaleriaActivity.this);
        progressDialog.setMessage("Cargando datos");
        progressDialog.show();

        AsyncHttpClient client= new AsyncHttpClient();
        client.get(Conf.servidor+"/webservices/listarfotos.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    progressDialog.dismiss();

                    try {
                        JSONArray jsonArray= new JSONArray(new String(responseBody));
                        for (int i=0; i<jsonArray.length();i++){


                          //  idevento.add(jsonArray.getJSONObject(i).getString("idevento"));
                            imagen.add(jsonArray.getJSONObject(i).getString("foto"));

                        }
                        listaGaleria.setAdapter(new GaleriaActivity.ImagenAdapter(getApplicationContext()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });



    }

    private class ImagenAdapter extends BaseAdapter {
        Context ctx;
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;
        TextView tvnombre, tvfechainicio, tvfechafin;

        public ImagenAdapter(Context applicationContext) {
            this.ctx=applicationContext;
            layoutInflater=(LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagen.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewGroup viewGroup=(ViewGroup)layoutInflater.inflate(R.layout.activity_galeria_item,null);
            smartImageView=(SmartImageView)viewGroup.findViewById(R.id.imagen1);
          //  idevento=(TextView)viewGroup.findViewById(R.id.idevento);


            String urlfinal= Conf.servidor+"/proyecto/posters/"+imagen.get(position).toString();
            Rect rect=new Rect(smartImageView.getLeft(),smartImageView.getTop(),smartImageView.getRight(),smartImageView.getBottom());
            smartImageView.setImageUrl(urlfinal,rect);

           // idevento.setText(idevento.get(position).toString());


            return viewGroup;
        }
    }

}
