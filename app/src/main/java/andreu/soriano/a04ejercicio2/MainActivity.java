package andreu.soriano.a04ejercicio2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import andreu.soriano.a04ejercicio2.actividades.CrearCocheActivity;
import andreu.soriano.a04ejercicio2.modelos.Bici;
import andreu.soriano.a04ejercicio2.modelos.Coche;
import andreu.soriano.a04ejercicio2.modelos.Moto;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS DE LA VISTA
    private TextView txtCantidadCoches;
    private TextView txtCantidadMotos;
    private TextView txtCantidadBicis;

    private Button btnCrearCoches;
    private Button btnCrearMotos;
    private Button btnCrearBicis;

    //ATRIBUTOS DE LA LÓGICA
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;

    //ATRIBUTOS PARA LOS LAUCHERS
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();

        btnCrearCoches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this, CrearCocheActivity.class));
            }
        });

        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){

                                Coche coche = (Coche)result.getData().getExtras().getSerializable("COCHE");
                                listaCoches.add(coche);
                                txtCantidadCoches.setText("Coches: "+ listaCoches.size());
                            }else{
                                Toast.makeText(MainActivity.this, "NO SE HAN PASADO LOS DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){

                                Moto moto = (Moto)result.getData().getExtras().getSerializable("MOTOS");
                                listaMotos.add(moto);
                                txtCantidadMotos.setText("Motos: "+ listaMotos.size());
                            }else{
                                Toast.makeText(MainActivity.this, "NO SE HAN PASADO LOS DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){

                                Bici bici = (Bici)result.getData().getExtras().getSerializable("COCHE");
                                listaBicis.add(bici);
                                txtCantidadBicis.setText("Bicis: "+ listaBicis.size());
                            }else{
                                Toast.makeText(MainActivity.this, "NO SE HAN PASADO LOS DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void inicializarVariables() {

        txtCantidadCoches = findViewById(R.id.txtCantidadCochesMain);
        txtCantidadMotos = findViewById(R.id.txtCantidadMotosMain);
        txtCantidadBicis = findViewById(R.id.txtCanitdadBicisMain);

        btnCrearCoches = findViewById(R.id.btnContarCochesMain);
        btnCrearMotos = findViewById(R.id.btnContarMotosMain);
        btnCrearBicis = findViewById(R.id.btnContarBicisMain);

        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();

    }
}