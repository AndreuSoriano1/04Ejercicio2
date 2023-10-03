package andreu.soriano.a04ejercicio2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andreu.soriano.a04ejercicio2.R;
import andreu.soriano.a04ejercicio2.modelos.Coche;

public class CrearCocheActivity extends AppCompatActivity {

    //ATRIBUTOS DE LA VISTA
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;

    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);

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
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                //Comprobar si esta toda la infromacion
                if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    //Si no esta aviso y espero a que rellenen
                    Toast.makeText(CrearCocheActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else {
                    //Crear un objeto coche con esta infromacion
                    Coche coche = new Coche(marca, modelo, color);


                    //Lo meto en la maleta (bundle) y la maleta en el taxi (Intent)
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);
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

        txtMarca = findViewById(R.id.txtMarcaCrearCoche);
        txtModelo = findViewById(R.id.txtModeloCrearCoche);
        txtColor = findViewById(R.id.txtColorCrearCoche);

        btnCrear = findViewById(R.id.btnCrearCoche);
        btnCancelar = findViewById(R.id.btnCancelarCoche);

    }
}