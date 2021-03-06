package br.com.example.controle.gastos;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

 /**@author Willamys Ara�jo
 **Generate for Implementor**/

public class CategoriaListarActivity extends Activity{


	public static final String tag = "CategoriaListarActivity";
		TextView tviewColumnIdCategoria;
	TextView tviewColumnNome;
	long aux;
	TableRow row;
	TableLayout tableLayout;
	ArrayList<CategoriaVO> arrayCategoria = new ArrayList<CategoriaVO>();
	ArrayList<View> arrayView = new ArrayList<View>();
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categorialistaractivity);
		clearTable();
		createTable();
		addBotaoVoltar();
	}
	
	private void addBotaoVoltar() {
		
		TableRow row =  new TableRow(this);
		Button botao = new Button(this);
		botao.setText("voltar");
		botao.setTextSize(10);
		botao.setPadding(0, 0, 5, 0);
		botao.setHeight(5);
		botao.setWidth(5);
		botao.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("valor", "voltar");
				setResult(2,data);
				finish();
			}
		});
		row.addView(botao);
		tableLayout.addView(row);
		
	}
	
	private void createTable() {
arrayCategoria = Fachada.getInstance().getAllCategoria(this);
		
				tviewColumnIdCategoria = (TextView) findViewById(R.id.TextViewidCategoria);
		tviewColumnIdCategoria.setTextSize(10f);
		tviewColumnIdCategoria.setLines(2);
				tviewColumnNome = (TextView) findViewById(R.id.TextViewnome);
		tviewColumnNome.setTextSize(10f);
		tviewColumnNome.setLines(2);
				tableLayout =  new TableLayout(this);
		tableLayout = (TableLayout) findViewById(R.id.table);
		tableLayout.setPadding(20,10,20,0);
		arrayView = new ArrayList<View>();
		//escrevendo dados que buscados no BD
if(arrayCategoria.size() > 0 && arrayCategoria != null){
			for (int i = 0; i < arrayCategoria.size(); i++) {
				
				TableRow trow = new TableRow(this);
				trow.setTag("trow"+i);
				arrayView.add(trow);
				
								//**coluna1
				TextView tview1 = new TextView(this);
				tview1.setTextSize(12);
				tview1.setPadding(0, 0, 5, 0);
				tview1.setText(String.valueOf(arrayCategoria.get(i).idCategoria));
				tview1.setTag("view1"+arrayCategoria.get(i));
				tview1.setMaxWidth(5);
								//**coluna2
				TextView tview2 = new TextView(this);
				tview2.setTextSize(12);
				tview2.setPadding(0, 0, 5, 0);
				tview2.setText(String.valueOf(arrayCategoria.get(i).nome));
				tview2.setTag("view2"+arrayCategoria.get(i));
				tview2.setMaxWidth(5);
								final Button update = new Button(this);
				update.setText("Alterar");
				update.setTextSize(12);
				update.setPadding(0, 0, 5, 0);
				update.setHeight(5);
				update.setWidth(5);
				update.setTag("view${velocityCount}"+arrayCategoria.get(i));
			update.setId(arrayCategoria.get(i).  idCategoria); 				
				update.setOnClickListener(new View.OnClickListener()
				{
					public void onClick(View v) {
						Log.i(tag, "on click " + update.getId());
						Intent i =  new Intent(CategoriaListarActivity.this, CategoriaAlterarActivity.class);
		        		i.putExtra("valor", String.valueOf(update.getId()));
		        		startActivityForResult(i, 1);
					}
				});
				
				
				final Button delete = new Button(this);
				delete.setText("Delete");
				delete.setTextSize(12);
				delete.setPadding(0, 0, 5, 0);
				delete.setHeight(5);
				delete.setWidth(5);
				delete.setTag("view${velocityCount}"+arrayCategoria.get(i));
			delete.setId(arrayCategoria.get(i).  idCategoria); 				
				
				delete.setOnClickListener(new View.OnClickListener()
				{
					public void onClick(View v) {
						Log.i(tag, "on click " + delete.getId());
							delete(delete.getId());
					}
				});
								//adicionando a linha
				trow.addView(tview1);
				//adicionando a linha
				trow.addView(tview2);
		trow.addView(update);
		trow.addView(delete);
				//adicionando a coluna
				tableLayout.addView(trow);
			}
			}
	}
	
	private void clearTable() {
		int tam =  arrayView.size();
		for (int i = 0; i < arrayView.size(); i++) {
			tableLayout.removeView(arrayView.get(i).findViewWithTag("trow"+i));
		}
	}
	
	public boolean delete(int id){
		aux = id;
		new AlertDialog.Builder(this).setTitle(this.getResources()
				.getString(R.string.app_name)).setMessage(
				"Voc� realmente deseja deletar?").setPositiveButton("SIM", 
				new android.content.DialogInterface.OnClickListener(){
							public void onClick(DialogInterface arg0,
									int arg1) {
								String message = "";
								long ret = Fachada.getInstance().deleteCategoria(CategoriaListarActivity.this, aux);
								if( ret != -1 && ret != 0){
									message = "Delete efetuado com sucesso.";
									clearTable();
							createTable();
								}else{
									message = "N�o foi possivel efetuar o delete.";
								}
								Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
							}
						}).setNegativeButton("No", new android.content.DialogInterface.OnClickListener(){
							public void onClick(DialogInterface dialog,
									int which) {
							}
						}).show();
		return false;
	}
	
	 public void onActivityResult(int requestCode, int resultCode,
			 Intent data) {
		 	Toast.makeText(this,data.getExtras().getString("valor"), Toast.LENGTH_LONG).show();
	clearTable();
		createTable();
	}
}
