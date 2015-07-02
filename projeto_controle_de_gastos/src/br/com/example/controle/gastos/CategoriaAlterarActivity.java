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
import android.widget.Toast;
 /**@author Willamys Araújo
 **Generate for Implementor**/

public class CategoriaAlterarActivity extends Activity{

	public static final String tag = "CategoriaAlterarActivity";

		public  TextView  idCategoriaField;
		public  EditText  nomeField;
		String message;
		long idB;
	String valor ;
	CategoriaVO objCategoria = new CategoriaVO();
	//objeto criado com o intuito de obter os dados alterados
	CategoriaVO objCategoriaInserir = new CategoriaVO();

	private void initControls() {
	idCategoriaField =  (TextView) findViewById(R.id.TextViewidCategoria); 	nomeField = (EditText) findViewById(R.id.EditTextnome); }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categoriaalteraractivity);
		initControls();
		//pegar valor passado como parametro
		Intent intr = getIntent();
		valor = intr.getStringExtra("valor");

		Log.i(tag, " Valor passado " + "[ " + valor + " ]");

		objCategoria = Fachada.getInstance().getCategoriaById(this,Integer.parseInt(valor));
		
		objCategoriaInserir = new CategoriaVO();



						
								
		Button botao = (Button) findViewById(R.id.ButtonSendFeedback);
		botao.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				update();
			}
		});

		Button botaoVoltar = (Button) findViewById(R.id.ButtonBack);
		botaoVoltar.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				back();
			}
		});
		// INICIO adicionando os valores dos campos quando for feita a alteração
		if(objCategoria != null){
			nomeField.setText(String.valueOf(objCategoria.nome.toString()));		}else{
			Toast.makeText(this, "Nenhum dado foi encontrado.", 
					Toast.LENGTH_LONG).show();
		}
		//FIM adicionando os valores dos campos quando for feita a alteração
	}
protected boolean validation(CategoriaVO objcategoriaInserir) {
String campos="";
		if(!(String.valueOf(objCategoriaInserir.nome).toString().equals("")
	)){
	return true;
		}
		else{
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


	private void update(){
	try {
		Intent data = new Intent();
		Log.i(tag,"onClick invoked.");

		/*******INSERÇÃO NO BD********/
			objCategoriaInserir.idCategoria = Integer.parseInt(valor);
			objCategoriaInserir.nome = nomeField.getText().toString();

		if(validation(objCategoriaInserir)){

			idB = Fachada.getInstance().updateCategoria(this,objCategoriaInserir);

			Log.i(tag, "The update have a return equal ["+ idB +"]");

			if(idB == -1 || idB == 0){
				message = "Não foi possivel efetuar a alteração.";
			}else{
				message = "Alteração efetuada com sucesso.";
				data.putExtra("valor", message);
				setResult(2,data);
				finish();
			}
		}else{
			message = "Complete todos os campos. Tente novamente.";
		}
		} catch (Exception e) {
				ConnectionException.erro(this, e.toString());
			}		
	}

	private void back() {
		Intent data = new Intent();
		data.putExtra("valor", "Voltar");
		setResult(2,data);
		finish();

	}

	//metodo para enviar o resultado para a tela anterior
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				idCategoriaField.setText(data.getExtras().getString("valor"));
								}

}
