package src.controle.gastos.tabs;

import src.controle.gastos.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Resumo extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       setContentView(R.layout.tab1);
	       atualizarProgressbarReceitaeDespesa();
	}
	
	private void atualizarProgressbarReceitaeDespesa() {
		ProgressBar pbReceita = (ProgressBar) findViewById(R.id.ProgressBarReceita);
		ProgressBar pbDespesa = (ProgressBar) findViewById(R.id.ProgressBarDespesa);
		pbReceita.setProgress(40);
		pbDespesa.setProgress(40);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater =  getMenuInflater();
		inflater.inflate(R.menu.menu_add, menu);
		return true;
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon:     Toast.makeText(this, "You pressed the icon!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.text:     Toast.makeText(this, "You pressed the text!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.icontext: Toast.makeText(this, "You pressed the icon and text!", Toast.LENGTH_LONG).show();
                                break;
        }
        return true;
    }
}
