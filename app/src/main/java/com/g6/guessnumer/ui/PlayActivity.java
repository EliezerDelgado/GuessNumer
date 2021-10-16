package com.g6.guessnumer.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.g6.guessnumer.R;
import com.g6.guessnumer.data.model.Data;
import com.g6.guessnumer.databinding.ActivityPlayBinding;
/**
 * Clase que hace que el usuario adivine el numero con dos botones uno para comprobar y otro para borrar
 * Despues se inicializa un TextView @see {@link PlayActivity#onCreate(Bundle)}
 */

public class PlayActivity extends AppCompatActivity {
    private static final String TAG = "PlayActivity";
    ActivityPlayBinding binding;
    private Data data = new Data();
    private int numRand =0;
    private int remainingAttempts=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(numRand ==0)
        numRand = (int)(Math.random()*99+1);
        Intent intent = getIntent();
        //2.-Recoger el objeto Bundle con el mismo método que se ha introducido en el Intent
        Bundle bundle = intent.getExtras();
        // CASTIN -> (Data)
        data = (Data) bundle.getSerializable("data");
        remainingAttempts= data.getAttempts();
        Log.i(TAG, "PlayActivity-> 0n.Start()");
    }

    //region Método del ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "PlayActivity-> ->0n.Start()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "PlayActivity-> 0n.Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "PlayActivity-> 0n.Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "PlayActivity-> 0n.Stop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "PlayActivity-> 0n.Destroy()");
    }

    // endregion
    /**
     * El getOnClick se conecta con el metodo comprobar, Realiza El envio y cambia el txEstado
     */
    @SuppressLint({"ResourceType", "SetTextI18n"})
    public void getOnclick(View view) {
        switch (view.getId()) {
            case R.id.btComprobar:
                try {
                    remainingAttempts--;

                    binding.txEstado.setText((String)getApplicationContext().getText(R.string.txEstadoIn) + remainingAttempts + " " + Comprueba(Integer.parseInt(binding.edNumero.getText().toString())));
                }
                catch (Exception e){
                    binding.txEstado.setText(R.string.txEstado_errInt);
                    break;
                }
                if(numRand == Integer.parseInt(binding.edNumero.getText().toString())|| remainingAttempts<=0){
                    Bundle bundle = new Bundle();
                    if(numRand == Integer.parseInt(binding.edNumero.getText().toString())) {
                        data.setNumRand(data.getAttempts()-remainingAttempts);
                        data.setState((String)getApplicationContext().getText(R.string.tvFin2));
                    }
                    else {
                        data.setNumRand(numRand);
                    }
                    bundle.putSerializable("data", data);
                    Intent intent = new Intent(this, EndPlayActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.btBorra:
                binding.edNumero.setText("");
                break;
        }
    }
    /**
     * Este método Comprueba el valor y devuelve es menor , es mayor o acertaste
     */
    private String Comprueba(int intento){
        String resultado= (String)getApplicationContext().getText(R.string.txEstado1);
        if(numRand < intento)
            resultado = (String)getApplicationContext().getText(R.string.txEstado2);
        else if(numRand > intento)
            resultado = (String)getApplicationContext().getText(R.string.txEstado3);
        return resultado;
    }
}
