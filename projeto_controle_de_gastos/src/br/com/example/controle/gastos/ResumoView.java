package br.com.example.controle.gastos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ResumoView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resumo_view);
		
		
		ProgressBar barraReceitas = (ProgressBar) findViewById(R.id.progressBarReceitas);
		barraReceitas.setProgress(25);
	}
}
