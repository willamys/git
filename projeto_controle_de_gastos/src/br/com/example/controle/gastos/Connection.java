package br.com.example.controle.gastos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**@author Willamys Araújo
	**Generate for Implementor**/

public class Connection extends SQLiteOpenHelper{
	
	/**Criando a Tabela do Banco de Dados**/
	private String SCRIPTCREATE;
	private String SCRIPTDELETE;
	
	private static final String TAG = "SQLiteHelper";
	
		/**Nome do Banco de Dados**/
	private static final String DATABASE_NAME = "bd_Controle de Gastos";
	   
	/**Versão do Banco de Dados**/
	private static final int DATABASE_VERSION = 1;	



			private static final String SCRIPT_DB_DELETE_SERVICO = 
			"DROP TABLE IF EXISTS tservico";
			
			private static final String SCRIPT_DB_CREATE_SERVICO = 
			"create table tservico("
			+"idServico integer primary key autoincrement not null ,"
			+"nome  text  not null ,"
			+"categoria  integer  not null "
			+");";
			
			private static final String SCRIPT_DB_DELETE_CATEGORIA = 
			"DROP TABLE IF EXISTS tcategoria";
			
			private static final String SCRIPT_DB_CREATE_CATEGORIA = 
			"create table tcategoria("
			+"idCategoria integer primary key autoincrement not null ,"
			+"nome  text  not null "
			+");";
			

	public Connection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	
			db.execSQL(SCRIPT_DB_CREATE_SERVICO);		db.execSQL(SCRIPT_DB_CREATE_CATEGORIA);	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TAG, "Upgrading database from version " + oldVersion 
                + " to "
                + newVersion + ", which will destroy all old data");
	 db.execSQL(SCRIPT_DB_DELETE_SERVICO); db.execSQL(SCRIPT_DB_DELETE_CATEGORIA);		onCreate(db);
	}
	

}
