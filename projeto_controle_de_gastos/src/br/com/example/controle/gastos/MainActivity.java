package br.com.example.controle.gastos;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		// Tab for Resumo
		TabSpec resumo = tabHost.newTabSpec("Resumo");
		resumo.setIndicator("Resumo", getResources().getDrawable(R.drawable.resumo));
		resumo.setContent(new Intent(this, ResumoView.class));

		// Tab for Grafico geral
		TabSpec graficoGeral = tabHost.newTabSpec("graficogeral");
		graficoGeral.setIndicator("Gráfico Geral", getResources().getDrawable(R.drawable.grafico_geral));
		graficoGeral.setContent(new Intent(this, GraficoGeral.class));

		// Tab for Grafico geral
		TabSpec graficocategoria = tabHost.newTabSpec("graficocategoria");
		graficocategoria.setIndicator("Gráfico por categoria", getResources().getDrawable(R.drawable.grafico_detalhes));
		graficocategoria.setContent(new Intent(this, GraficoCategoriaView.class));
		//
		// Tab for Grafico geral
		TabSpec servicos = tabHost.newTabSpec("servicos");
		servicos.setIndicator("Serviços", getResources().getDrawable(R.drawable.servicos));
		servicos.setContent(new Intent(this, ServicosView.class));

		//add tabs
		tabHost.addTab(resumo);
		tabHost.addTab(servicos);
		tabHost.addTab(graficoGeral);
		tabHost.addTab(graficocategoria);


		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_categoria:
			Intent i = new Intent(MainActivity.this, CategoriaCadastrarActivity.class);
			startActivity(i);
			break;
		case R.id.add_servico:     
			Intent j = new Intent(MainActivity.this, ServicoCadastrarActivity.class);
			startActivity(j);
		break;
		case R.id.menu_sobre: Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
		break;
		case R.id.menu_categorias: 
			Intent k = new Intent(MainActivity.this, CategoriaListarActivity.class);
			startActivity(k);
			break;
		}
		return true;
	}


}
