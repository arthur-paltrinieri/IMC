package br.com.fecapccp.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private Button calculate, reset, back;
    private EditText editHeight, editWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        calculate = findViewById(R.id.calculate);
        reset = findViewById(R.id.reset);
        back = findViewById(R.id.back);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S_heigth = editHeight.getText().toString();
                String S_weigth = editWeight.getText().toString();

                double height = Double.parseDouble(S_heigth);
                double weight = Double.parseDouble(S_weigth);

                double imc = weight / (height * height);

                imc = Double.parseDouble(String.format("%.2f", imc));

                Bundle bundle = new Bundle();
                bundle.putDouble("height", height);
                bundle.putDouble("weight", weight);
                bundle.putDouble("imc", imc);

                if (imc < 18.5) {
                    Intent intent = new Intent(MainActivity2.this, AbaixoDoPesoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(imc >= 18.5 && imc < 25){
                    Intent intent = new Intent(MainActivity2.this, PesoNormalActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (imc >= 25 && imc <30){
                    Intent intent = new Intent(MainActivity2.this, SobrepesoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(imc >= 30 && imc <35){
                    Intent intent = new Intent(MainActivity2.this, Obesidade1Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(imc>= 35 && imc < 40){
                    Intent intent = new Intent(MainActivity2.this, Obesidade2Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity2.this, Obesidade3Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editHeight.setText("");
                editWeight.setText("");
            }
        });
    }
}