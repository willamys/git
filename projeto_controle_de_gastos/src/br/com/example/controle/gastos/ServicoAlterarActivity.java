package br.com.example.controle.gastos;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Vector;
import android.widget.ArrayAdapter;
 /**@author Willamys Araújo
 **Generate for Implementor**/

public class ServicoAlterarActivity extends Activity{

	public static final String tag = "ServicoAlterarActivity";

		public  TextView  idServicoField;
		public  EditText  nomeField;
		public  Spinner  idCategoriaField;
		String message;
		long idB;
	String valor ;
	ServicoVO objServico = new ServicoVO();
	//objeto criado com o intuito de obter os dados alterados
	ServicoVO objServicoInserir = new ServicoVO();

	private void initControls() {
	idServicoField =  (TextView) findViewById(R.id.TextViewidServico); 	nomeField = (EditText) findViewById(R.id.EditTextnome); 	idCategoriaField =  (Spinner) findViewById(R.id.SpinneridCategoria); }

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicoalteraractivity);
		initControls();
		//pegar valor passado como parametro
		Intent intr = getIntent();
		valor = intr.getStringExtra("valor");

		Log.i(tag, " Valor passado " + "[ " + valor + " ]");

		objServico = Fachada.getInstance().getServicoById(this,Integer.parseInt(valor));
		
		objServicoInserir = new ServicoVO();



				
			/***INICIO Código usado quando houver um spinner do tipo Int**/
			ArrayList<CategoriaVO> arrayCategoria = new ArrayList<CategoriaVO>();
		arrayCategoria = Fachada.getInstance().getAllCategoria (ServicoAlterarActivity.this);
		Vector idCategoriaList = new Vector();		
		if(arrayCategoria.size() > 0 && arrayCategoria !=null){
		for (int i = 0; i < arrayCategoria.size(); i++) {
			//passando o nome para o select(spinner)
			idCategoriaList.addElement(arrayCategoria.get(i).idCategoria);
		}
			}
			
		ArrayAdapter idCategoriaArrayAdapter = new ArrayAdapter(this,
               android.R.layout.simple_spinner_dropdown_item, idCategoriaList);
        //adicionando arraylist ao select(spinner)
		idCategoriaField.setAdapter(idCategoriaArrayAdapter);
		
        idCategoriaField .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
						objServicoInserir.idCategoria  = Integer.parseInt(arg0.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                System.out.println("Nothing selected: " + arg0);
            }
        });
	/***FIM Spinner para tipo Int**/
				
										
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
		if(objServico != null){
			nomeField.setText(String.valueOf(objServico.nome.toString()));
		// selecionar o que foi selecionado no cadastro
			for (int i = 0; i < arrayCategoria.size(); i++) {
			if(arrayCategoria.get(i).idCategoria == objServico.idCategoria){
				idCategoriaField.setSelection(i);
			}
		}
		}else{
			Toast.makeText(this, "Nenhum dado foi encontrado.", 
					Toast.LENGTH_LONG).show();
		}
		//FIM adicionando os valores dos campos quando for feita a alteração
	}
protected boolean validation(ServicoVO objservicoInserir) {
String campos="";
		if(!(String.valueOf(objServicoInserir.nome).toString().equals("")
	||
	 objServicoInserir.idCategoria == 0
	)){
	return true;
		}
		else{
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


	private void update(){
	try {
		Intent data = new Intent();
		Log.i(tag,"onClick invoked.");

		/*******INSERÇÃO NO BD********/
			objServicoInserir.idServico = Integer.parseInt(valor);
			objServicoInserir.nome = nomeField.getText().toString();

		if(validation(objServicoInserir)){

			idB = Fachada.getInstance().updateServico(this,objServicoInserir);

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
				idServicoField.setText(data.getExtras().getString("valor"));
											}

}
