package com.example.clientes;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends Activity {

	//Barra de progresso. Thread
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);//Exibe o view de cadastro
		
		Button botaoCadastrar = (Button) findViewById(R.id.botaoCadastrar);
		final EditText editTextNome = (EditText) findViewById(R.id.editTextEmail);
		final EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		final EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
		final EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);
		
		//Captura o evento do bot�o e exibe os valores informados nos campos de EditText.
		botaoCadastrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//fazendo thread pq o Android as vezes n�o vai conseguir atualizar a interface
				//antes que tiver solictado uma requisi��o. Passei geralmente � passado a base do contexto, mas o ProgressDialog tem
				//que passar toda a activity. Botei "true" para tempo indeterminado pois n�o sei quanto tempo vai levar.
				pd = ProgressDialog.show(Cadastro.this, "Aguarde.", "Cadastrando informa��es", true, false);
				
			}
		});
		
		
		
		
	}

}
