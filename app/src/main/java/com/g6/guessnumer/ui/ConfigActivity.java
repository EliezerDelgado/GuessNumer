package com.g6.guessnumer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.g6.guessnumer.R;
import com.g6.guessnumer.data.model.Data;
import com.g6.guessnumer.databinding.ActivityConfigBinding;
/**
 * Clase que hace que el usuario adivine el numero debe introducir el nombre y los intentos para adivinar
 * Despues se inicializa un TextView @see {@link ConfigActivity#onCreate(Bundle)}
 */
public class ConfigActivity extends AppCompatActivity {
    private static final String TAG = "ConfigActivity";
    ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.i(TAG, "ConfigActivity -> 0n.Start()");
    }
    //region Método del ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ConfigActivity -> 0n.Start()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ConfigActivity -> 0n.Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ConfigActivity -> 0n.Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ConfigActivity -> 0n.Stop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ConfigActivity -> 0n.Destroy()");
    }
    // endregion
    /**
     * Este método crea el Intent con los datos que pasa la actividad ConfigActivity a EndPlayActivity
     * Inicializar ....
     */
    private void sendDatos() {
        if(binding.edIntentos.getText().toString().isEmpty() || binding.edNombre.getText().toString().isEmpty()) {
            binding.tvTitulo.setText(R.string.tvTitulo_errEmpt);
            return;
        }
        try {
            int prueba = Integer.parseInt(binding.edIntentos.getText().toString());
        }
        catch(Exception e){
            binding.tvTitulo.setText(R.string.tvTitulo_errInt);
            return;
        }
        //1.1 Crear un objeto contenedor o Budle para añadir los datos
        Bundle bundle = new Bundle();
        //1.1.2 Ejemplo  con la clase modelo Data
        Data data = new Data();
        data.setUser(binding.edNombre.getText().toString());
        data.setAttempts(Integer.parseInt(binding.edIntentos.getText().toString()));
        bundle.putSerializable("data", data);
        //1.2 Se crea los datos a enviar o Intent explicito ya que se conoce la Activity origen y Activity destino.
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    /**
     * Este método es el que utilizamos en la propiedad
     * android:onclick dentro del componente Button btSend
     *
     * @param view
     */
    public void getOnclick(View view) {
        switch (view.getId()) {
            case R.id.btJuega:
                sendDatos();
                break;
        }
    }
}