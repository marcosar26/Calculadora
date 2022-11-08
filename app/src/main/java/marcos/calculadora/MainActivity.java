package marcos.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private double num1 = 0, num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sumar = findViewById(R.id.button);
        Button restar = findViewById(R.id.button2);
        Button multiplicar = findViewById(R.id.button3);
        Button dividir = findViewById(R.id.button4);
        Button reset = findViewById(R.id.button5);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(0);
            }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(1);
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(2);
            }
        });

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(3);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cajaNum1 = findViewById(R.id.editTextNumber);
                EditText cajaNum2 = findViewById(R.id.editTextNumber2);

                cajaNum1.setText("");
                cajaNum2.setText("");

                MainActivity.this.recreate();
            }
        });

    }

    private void calcular(int op) {
        update();

        switch (op) {
            case 0:
                resultado(num1 + num2);
                break;
            case 1:
                resultado(num1 - num2);
                break;
            case 2:
                resultado(num1 * num2);
                break;
            case 3:
                resultado(num1 / num2);
                break;
        }
    }

    private void resultado(double num) {
        TextView resultado = findViewById(R.id.textView);
        String str = String.valueOf(num);
        resultado.setText(str);
    }

    private void update() {
        EditText cajaNum1 = findViewById(R.id.editTextNumber);
        EditText cajaNum2 = findViewById(R.id.editTextNumber2);

        try {
            this.num1 = Double.parseDouble(cajaNum1.getText().toString());
            this.num2 = Double.parseDouble(cajaNum2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Detectados caracteres inválidos", Toast.LENGTH_SHORT).show();
        }
    }
}