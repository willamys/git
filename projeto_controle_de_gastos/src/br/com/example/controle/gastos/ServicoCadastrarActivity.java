package br.com.example.controle.gastos;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Vector;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
/**@author Willamys Araújo
 **Generate for Implementor**/

public class ServicoCadastrarActivity extends Activity{

	//Definindo Tag para a classe
	public static final String tag = "ServicoCadastrarActivity";
	public  TextView  idServicoField;
	public EditText  nomeField;
	public  Spinner  idCategoriaField;
	String message;
	long idB;

	ServicoVO objServico = new ServicoVO();
	//objeto criado com o intuito de obter os dados alterados
	ServicoVO objServicoInserir = new ServicoVO();

	private void initControls() {

		idServicoField =  (TextView) findViewById(R.id.TextViewidServico); 	
		nomeField = (EditText) findViewById(R.id.EditTextnome); 	
		idCategoriaField =  (Spinner) findViewById(R.id.SpinneridCategoria); }


	public ServicoCadastrarActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicocadastraractivity);
		initControls();

		objServicoInserir = new ServicoVO();


		/***INICIO Código usado quando houver um spinner do tipo Int**/
		ArrayList<CategoriaVO> arrayCategoria = new ArrayList<CategoriaVO>();
		arrayCategoria = Fachada.getInstance().getAllCategoria (ServicoCadastrarActivity .this);
		List<String> idCategoriaList = new ArrayList<String>();		
		if(arrayCategoria.size() > 0 && arrayCategoria !=null){
			for (int i = 0; i < arrayCategoria.size(); i++) {
				//passando o nome para o select(spinner)
				idCategoriaList.add(arrayCategoria.get(i).idCategoria + "-" +arrayCategoria.get(i).nome);
			}
		}

		ArrayAdapter idCategoriaArrayAdapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_dropdown_item, idCategoriaList);
		//adicionando arraylist ao select(spinner)
		idCategoriaField.setAdapter(idCategoriaArrayAdapter);

		idCategoriaField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				objServicoInserir.idCategoria = Integer.parseInt(arg0.getSelectedItem().toString().substring(0, arg0.getSelectedItem().toString().indexOf("-")));
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				System.out.println("Nothing selected: " + arg0);
			}
		});
		/***FIM Spinner para tipo Int**/

		Button botao = (Button) findViewById(R.id.ButtonSendFeedback);
		botao.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				try {
					Intent data = new Intent();

					Log.i(tag,"onClick invoked.");

					/*******INSERÇÃO NO BD********/
					objServicoInserir.nome = nomeField.getText().toString();

					if(validation(objServicoInserir)){

						idB = Fachada.getInstance().insertServico(ServicoCadastrarActivity.this, objServicoInserir);

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
					ConnectionException.erro(ServicoCadastrarActivity.this, "Erro ao inserir.\n Erro:\n " + e.toString());
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

	protected boolean validation(ServicoVO objservicoInserir) {
		String campos="";
		if(!(String.valueOf(objServicoInserir.nome).toString().equals("")
				||
				objServicoInserir.idCategoria == 0
				)){
			return true;
		}else{
			if(String.valueOf(objServicoInserir.nome).toString().equals("")){
				campos = campos + "- nome\n";}
			if(objServicoInserir.idCategoria == 0){
				campos = campos + "- categoria\n";}
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
