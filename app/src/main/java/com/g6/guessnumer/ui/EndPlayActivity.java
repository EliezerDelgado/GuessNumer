package com.g6.guessnumer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.g6.guessnumer.R;
import com.g6.guessnumer.data.model.Data;
import com.g6.guessnumer.databinding.ActivityConfigBinding;
import com.g6.guessnumer.databinding.ActivityEndPlayBinding;
/**
 * Clase que muestra el resultado
 * Despues se inicializa un TextView @see {@link EndPlayActivity#onCreate(Bundle)}
 */
public class EndPlayActivity extends AppCompatActivity {

    private static final String TAG = "EndPlayActivity";
    ActivityEndPlayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Data data = new Data();
        Intent intent = getIntent();
        //2.-Recoger el objeto Bundle con el mismo método que se ha introducido en el Intent
        Bundle bundle = intent.getExtras();
        // CASTIN -> (Data)
        data = (Data) bundle.getSerializable("data");
        binding.tvNombre.setText(data.getUser());
            if (data.getState().equals(getApplicationContext().getText(R.string.tvFin2))) {
                binding.tvResultado.setText(getApplicationContext().getText(R.string.tvResultadoGanaste)+data.getNumRand().toString());
                binding.tvFin.setText(data.getState());
            }
            else
            {

                binding.tvResultado.setText(binding.tvResultado.getText().toString()+data.getNumRand().toString());
            }
        Log.i(TAG, "EndPlayActivity-> ->0n.Create()");
    }
    //region Método del ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "EndPlayActivity-> ->0n.Start()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "EndPlayActivity-> 0n.Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "EndPlayActivity-> 0n.Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "EndPlayActivity-> 0n.Stop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "EndPlayActivity-> 0n.Destroy()");
    }

    // endregion
}