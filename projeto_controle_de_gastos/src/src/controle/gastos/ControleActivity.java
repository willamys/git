package src.controle.gastos;

import src.controle.gastos.tabs.Resumo;
import src.controle.gastos.tabs.Tab2;
import src.controle.gastos.tabs.Tab3;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class ControleActivity extends TabActivity {
    /** Called when the activity is first created. */
	TabHost tabHost;
	Resources res;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tabHost = getTabHost();
        res = getResources();
        addResumoTab(tabHost, res);
        add2Tab(tabHost, res);
        add3Tab(tabHost, res);
    //    add4Tab(tabHost, res);
    }
    
    private void addResumoTab(TabHost tabHost, Resources res)
			throws NotFoundException {
		Intent intent = new Intent().setClass(this, Resumo.class);
		TabHost.TabSpec spec = tabHost.newTabSpec("Resumo").setIndicator("Resumo",
				res.getDrawable(R.drawable.ic_launcher)).setContent(intent);
		tabHost.addTab(spec);
	}
    
    private void add2Tab(TabHost tabHost, Resources res)
			throws NotFoundException {
		Intent intent = new Intent().setClass(this, Tab2.class);
		TabHost.TabSpec spec = tabHost.newTabSpec("Tab2").setIndicator("Tab2",
				res.getDrawable(R.drawable.ic_launcher)).setContent(intent);
		tabHost.addTab(spec);
	}
    
    private void add3Tab(TabHost tabHost, Resources res)
			throws NotFoundException {
		Intent intent = new Intent().setClass(this, Tab3.class);
		TabHost.TabSpec spec = tabHost.newTabSpec("Tab3").setIndicator("Tab3",
				res.getDrawable(R.drawable.ic_launcher)).setContent(intent);
		tabHost.addTab(spec);
	}
    
 /*   private void add4Tab(TabHost tabHost, Resources res)
			throws NotFoundException {
		Intent intent = new Intent().setClass(this, Tab4.class);
		TabHost.TabSpec spec = tabHost.newTabSpec("Tab4").setIndicator("Tab4",
				res.getDrawable(R.drawable.ic_launcher)).setContent(intent);
		tabHost.addTab(spec);
	}
	*/
}