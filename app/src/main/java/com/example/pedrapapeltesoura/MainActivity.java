package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private void verificarGanhador(String escolhaUsu){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView resultado = findViewById(R.id.txtResultado);

        if((escolhaApp == "pedra" && escolhaUsu == "tesoura") ||
        (escolhaApp == "papel" && escolhaUsu == "pedra") ||
        (escolhaApp == "tesoura" && escolhaUsu == "papel") ){
                resultado.setText("Você perdeu!");
        } else if ((escolhaUsu == "pedra" && escolhaApp == "tesoura") ||
        (escolhaUsu == "papel" && escolhaApp == "pedra") ||
        (escolhaUsu == "tesoura" && escolhaApp == "papel") ) {
            resultado.setText("Você venceu!");
        }else{
            resultado.setText("EMPATE!");
        }
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"} ;
        int numAleatorio = new Random().nextInt(3);
        String escolhaApp = opcoes[numAleatorio];
        ImageView imagemApp = findViewById(R.id.imgEcolhaApp);

        switch(escolhaApp){
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    public void resetarJogo(View view){
        ImageView imagemApp = findViewById(R.id.imgEcolhaApp);
        imagemApp.setImageResource(R.drawable.padrao);
        TextView resultado = findViewById(R.id.txtResultado);
        resultado.setText("Resultado");
    }
}