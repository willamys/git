package br.com.example.controle.gastos;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**@author Willamys Araújo
 **Generate for Implementor**/

public class  ServicoActivity extends Activity {
	/** Called when the activity is first created. */


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicoactivity);
		//initControls();

		Button buttonCad = (Button) findViewById(R.id.ButtonSendFeedbackCadastrar);
		buttonCad.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0) {
				Intent i = new Intent(ServicoActivity.this, ServicoCadastrarActivity.class);
				startActivityForResult(i, 1);
			}
		});

		Button buttonList = (Button) findViewById(R.id.ButtonSendFeedbackListar);
		buttonList.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0) {
				Intent i =  new Intent(ServicoActivity.this, ServicoListarActivity.class);
				startActivityForResult(i, 1);
			}
		});

		Button buttonBack = (Button) findViewById(R.id.ButtonBack);
		buttonBack.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("valor", "voltar");
				setResult(2,data);
				finish();
			}
		});

	} 

	public void onActivityResult(int requestCode, int resultCode,
			Intent data) {
		Toast.makeText(this,data.getExtras().getString("valor"), Toast.LENGTH_LONG).show();
	}

}