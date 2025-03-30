package br.com.fecapccp.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoDoPesoActivity extends AppCompatActivity {
    private TextView heightResult, weightResult, imcResult;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);

        heightResult = findViewById(R.id.Height1);
        weightResult = findViewById(R.id.Weight1);
        imcResult = findViewById(R.id.underweightResult);
        back = findViewById(R.id.voltar);

        Bundle bundle = getIntent().getExtras();
        double height = bundle.getDouble("height");
        double weight = bundle.getDouble("weight");
        double imc = bundle.getDouble("imc");

        String altura = "Altura: " + height;
        String peso = "Peso: " + weight;
        String resultado = "IMC: " + imc;

        heightResult.setText(altura);
        weightResult.setText(peso);
        imcResult.setText(resultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbaixoDoPesoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}