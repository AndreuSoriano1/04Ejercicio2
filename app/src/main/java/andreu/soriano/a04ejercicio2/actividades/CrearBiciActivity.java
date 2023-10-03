package andreu.soriano.a04ejercicio2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andreu.soriano.a04ejercicio2.R;
import andreu.soriano.a04ejercicio2.modelos.Bici;
import andreu.soriano.a04ejercicio2.modelos.Moto;

public class CrearBiciActivity extends AppCompatActivity {

    //ATRIBUTOS DE LA VISTA
    private EditText txtMarca;
    private EditText txtPulgadas;

    private Button btnCancelar;
    private Button btnCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

        inicializarVariables();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recoger la informacion de los EditText
                String marca = txtMarca.getText().toString();
                String pulgadas = txtPulgadas.getText().toString();

                //Comprobar si esta toda la infromacion
                if (marca.isEmpty() || pulgadas.isEmpty()){
                    //Si no esta aviso y espero a que rellenen
                    Toast.makeText(CrearBiciActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else {
                    //Crear un objeto coche con esta infromacion
                    Bici bici = new Bici(marca, pulgadas);


                    //Lo meto en la maleta (bundle) y la maleta en el taxi (Intent)
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    //Informare resultado exitoso
                    setResult(RESULT_OK, intent);

                    //Fin
                    finish();
                }
            }
        });

    }

    private void inicializarVariables() {

        txtMarca = findViewById(R.id.txtMarcaCrearBici);
        txtPulgadas = findViewById(R.id.txtPulgadasCrearBici);

        btnCrear = findViewById(R.id.btnCrearBici);
        btnCancelar = findViewById(R.id.btnCancelarBici);

    }
}