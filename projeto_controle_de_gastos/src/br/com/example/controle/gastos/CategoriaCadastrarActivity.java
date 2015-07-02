package br.com.example.controle.gastos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**@author Willamys Araújo
 **Generate for Implementor**/

public class CategoriaCadastrarActivity extends Activity{

	//Definindo Tag para a classe
	public static final String tag = "CategoriaCadastrarActivity";
	public  TextView  idCategoriaField;
	public EditText  nomeField;
	String message;
	long idB;

	CategoriaVO objCategoria = new CategoriaVO();
	//objeto criado com o intuito de obter os dados alterados
	CategoriaVO objCategoriaInserir = new CategoriaVO();

	private void initControls() {

		idCategoriaField =  (TextView) findViewById(R.id.TextViewidCategoria); 	
		nomeField = (EditText) findViewById(R.id.EditTextnome); 
	}


	public CategoriaCadastrarActivity() {
		// TODO Auto-generated constructor stub
	}

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categoriacadastraractivity);
		initControls();

		objCategoriaInserir = new CategoriaVO();


		Button botao = (Button) findViewById(R.id.ButtonSendFeedback);
		botao.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				try {
					Intent data = new Intent();

					Log.i(tag,"onClick invoked.");

					/*******INSERÇÃO NO BD********/
					objCategoriaInserir.nome = nomeField.getText().toString();

					if(validation(objCategoriaInserir)){

						idB = Fachada.getInstance().insertCategoria(CategoriaCadastrarActivity.this, objCategoriaInserir);

						Log.i(tag, "The insert have a return equal ["+ idB +"]");

						if(idB == -1 || idB == 0){
							message = "Não foi possivel efetuar o cadastro.";
						}else{
							message = "Cadastro efetuado com sucesso.";
							data.putExtra("valor", message);
							setResult(2,data);
							finish();
						}
					}else{
						message = "Complete todos os campos.Tente novamente.";
					}
				} catch (Exception e) {
					ConnectionException.erro(CategoriaCadastrarActivity.this, "Erro ao inserir.\n Erro:\n " + e.toString());
				}	
			}
		});

		Button botaoVoltar = (Button) findViewById(R.id.ButtonBack);
		botaoVoltar.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("valor", "Voltar");
				setResult(2,data);
				finish();
			}
		});
	}

	protected boolean validation(CategoriaVO objcategoriaInserir) {
		String campos="";
		if(!(String.valueOf(objCategoriaInserir.nome).toString().equals("")
				)){
			return true;
		}else{
			if(String.valueOf(objCategoriaInserir.nome).toString().equals("")){
				campos = campos + "- nome\n";}
			new AlertDialog.Builder(this).setTitle(this.getResources()
					.getString(R.string.app_name)).setMessage(
							"Os campos:\n" + campos + " esta(ão) vazios.\n" +
							"Complete todos os campos. Tente novamente.")
							.setPositiveButton("continue", 
									new android.content.DialogInterface.OnClickListener(){
								public void onClick(DialogInterface arg0,
										int arg1) {
								}
							}).show();
			return false;
		}
	}

	//metodo para enviar o resultado para a tela anterior
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		TextView t = (TextView) findViewById(R.id.textomain);
		t.setText(data.getExtras().getString("valor"));
	}

}
