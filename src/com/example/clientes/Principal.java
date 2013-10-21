package com.example.clientes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		//Vou recuperar cada botão do meu view
		Button botaoCadastro = (Button) findViewById(R.id.botaoCadastrar);
		Button botaoCancelar = (Button) findViewById(R.id.botaoCancelar);
		Button botaoListar = (Button) findViewById(R.id.botaoListar);
		Button botaoApagar = (Button) findViewById(R.id.botaoApagar);
		
		//Implementando os botões
		botaoCadastro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Invocando a tela de cadastro. O contexto e a minha activity q no caso é
				// o Cadastro.class. Para isso TEM QUE FICAR REGISTRO no Manisfest.xml a minha Activity que no caso é o Cadastro
				startActivity(new Intent(getBaseContext(), Cadastro.class));
			}
		});
		
		botaoCancelar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Invocando a tela de cadastro. O contexto e a minha activity q
				// no caso é o Cadastro.class. Para isso TEM QUE FICAR REGISTRO no
				// Manisfest.xml a minha Activity que no caso é o Cadastro
				startActivity(new Intent(getBaseContext(), Cadastro.class));
			}
		});
		
		botaoListar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Invocando a tela de cadastro. O contexto e a minha activity q
				// no caso é o Cadastro.class. Para isso TEM QUE FICAR REGISTRO no
				// Manisfest.xml a minha Activity que no caso é o Cadastro
				startActivity(new Intent(getBaseContext(), Cadastro.class));
			}
		});

		botaoApagar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Invocando a tela de cadastro. O contexto e a minha activity q
				// no caso é o Cadastro.class. Para isso TEM QUE FICAR REGISTRO no
				// Manisfest.xml a minha Activity que no caso é o Cadastro
				startActivity(new Intent(getBaseContext(), Cadastro.class));
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
