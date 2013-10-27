package com.example.clientes;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends Activity implements Runnable {

	//Barra de progresso. Thread
	private ProgressDialog pd;
	private String valor;
	private EditText editTextNome;
	private EditText editTextEmail;
	private EditText editTextLogin;
	private EditText editTextSenha;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);//Exibe o view de cadastro
		
		Button botaoCadastrar = (Button) findViewById(R.id.botaoCadastrar);
		editTextNome = (EditText) findViewById(R.id.editTextNome); //A minha variavel vai apontar pro form da tela
		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		editTextLogin = (EditText) findViewById(R.id.editTextLogin);
		editTextSenha = (EditText) findViewById(R.id.editTextSenha);
		
		//Captura o evento do botão e exibe os valores informados nos campos de EditText.
		botaoCadastrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//fazendo thread pq o Android as vezes não vai conseguir atualizar a interface
				//antes de solicitar uma requisição. Passei cadastro.this geralmente é passado a base do contexto, mas o ProgressDialog tem
				//que passar toda a activity. Botei "true" para tempo indeterminado pois não sei quanto tempo vai levar.
				pd = ProgressDialog.show(Cadastro.this, "Aguarde.", "Cadastrando informações", true, false);
				Thread thread =  new Thread(Cadastro.this); //irá criar a Thread no cadastro 
				thread.start(); //vai executar o run()
			}
		});
		
		
		
		
	}

	@Override
	public void run() {
		//Criando conexão
		SQLiteDatabase db = openOrCreateDatabase("CONTATOS.db", Context.MODE_PRIVATE, null);
		ContentValues ctv = new ContentValues();
		ctv.put("NOME", editTextNome.getText().toString());
		ctv.put("EMAIL", editTextEmail.getText().toString());
		ctv.put("LOGIN", editTextLogin.getText().toString());
		ctv.put("SENHA", editTextSenha.getText().toString());
		//
		
		//Se for > q 0 é pq inseriu
		if( db.insert("CONTATOS", null, ctv) > 0 ){
			handlerSucesso.sendEmptyMessage(0);
		}
		
		valor = editTextNome.getText().toString();
		if(editTextNome.getText().toString().equals("")){
			handlerNome.sendEmptyMessage(0);
		}
		if(editTextEmail.getText().toString().equals("")){
			handlerEmail.sendEmptyMessage(0);
		}
		if(editTextLogin.getText().toString().equals("")){
			handlerLogin.sendEmptyMessage(0);
		}
		if(editTextSenha.getText().toString().equals("")){
			handlerSenha.sendEmptyMessage(0);
		}
		else if(!editTextNome.getText().toString().equals("") && !editTextEmail.getText().toString().equals("") && !editTextLogin.getText().toString().equals("")
				&& !editTextSenha.getText().toString().equals("")){
			handlerSucesso.sendEmptyMessage(0);
		}
		
		
		
		
	//	h.sendEmptyMessage(0); //Chama o meu método handle que irá exibr a messagem.
	}
	
	private Handler handlerSucesso = new Handler(){
		@Override 
		public void handleMessage(Message msg){ // handleMessage = Metodo serve para atualizar uma interface de uma activity
			pd.dismiss(); //Encerra o processo Dialog
			//Toast exibe uma caixa com a msg. Parametro passado: Base do context, o texto que quero q seja exibido, e a duração.
			Toast toast = Toast.makeText(getBaseContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT);
			toast.show(); //vai exibir o toast		
			
		}
	};
	
	private Handler handlerNome = new Handler(){
		@Override 
		public void handleMessage(Message msg){ // handleMessage = Metodo serve para atualizar uma interface de uma activity
			pd.dismiss(); //Encerra o processo Dialog
			//Toast exibe uma caixa com a msg. Parametro passado: Base do context, o texto que quero q seja exibido, e a duração.
			Toast toast = Toast.makeText(getBaseContext(), "Preencha o campo Nome", Toast.LENGTH_SHORT);
			toast.show(); //vai exibir o toast		
			editTextNome.setBackgroundColor(Color.RED); //no momento que executar esse método, vai mudar o background do EditText
		}
	};
	
	private Handler handlerEmail = new Handler(){
		@Override 
		public void handleMessage(Message msg){ // handleMessage = Metodo serve para atualizar uma interface de uma activity
			pd.dismiss(); //Encerra o processo Dialog
			//Toast exibe uma caixa com a msg. Parametro passado: Base do context, o texto que quero q seja exibido, e a duração.
			Toast toast = Toast.makeText(getBaseContext(), "Preencha o campo Email", Toast.LENGTH_SHORT);
			toast.show(); //vai exibir o toast		
			editTextEmail.setBackgroundColor(Color.RED); //no momento que executar esse método, vai mudar o background do EditText
		}
	};
	
	private Handler handlerLogin = new Handler(){
		@Override 
		public void handleMessage(Message msg){ // handleMessage = Metodo serve para atualizar uma interface de uma activity
			pd.dismiss(); //Encerra o processo Dialog
			//Toast exibe uma caixa com a msg. Parametro passado: Base do context, o texto que quero q seja exibido, e a duração.
			Toast toast = Toast.makeText(getBaseContext(), "Preencha o campo Login", Toast.LENGTH_SHORT);
			toast.show(); //vai exibir o toast		
			editTextLogin.setBackgroundColor(Color.RED); //no momento que executar esse método, vai mudar o background do EditText
		}
	};
	
	private Handler handlerSenha = new Handler(){
		@Override 
		public void handleMessage(Message msg){ // handleMessage = Metodo serve para atualizar uma interface de uma activity
			pd.dismiss(); //Encerra o processo Dialog
			//Toast exibe uma caixa com a msg. Parametro passado: Base do context, o texto que quero q seja exibido, e a duração.
			Toast toast = Toast.makeText(getBaseContext(), "Preencha o campo Senha", Toast.LENGTH_SHORT);
			toast.show(); //vai exibir o toast		
			editTextSenha.setBackgroundColor(Color.RED); //no momento que executar esse método, vai mudar o background do EditText
		}
	};

}
