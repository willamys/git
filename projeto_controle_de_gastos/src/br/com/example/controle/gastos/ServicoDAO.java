	package br.com.example.controle.gastos;
	import java.util.ArrayList;
	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.SQLException;
	import android.database.sqlite.SQLiteDatabase;

	/**@author Willamys Araújo
	**Generate for Implementor**/

	public class ServicoDAO {

		public static final String KEY_IDSERVICO = "idServico";
		public static final String KEY_NOME = "nome";
		public static final String KEY_IDCATEGORIA = "categoria";
		
		/***@return
			int idServico	
			String nome	
			int idCategoria	
	**/
		private static final String DATABASE_TABLE = "tservico";

		private SQLiteDatabase db;
		
		private long result = 0;
		
		private Context context;

		
		public ServicoDAO (Context ctx){
			Connection dbHelper = new Connection(ctx);
			this.context = ctx;
			db = dbHelper.getWritableDatabase();
		}

		//---insert Servico---//
		/***
		 * @return long
		 * db.insert()
		 * @param table
		 * @param column
		 * @param initialvalues
		 * **/
		public long insertServico(ServicoVO objServico) 
		{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objServico.nome);
			initialValues.put(KEY_IDCATEGORIA, objServico.idCategoria);
			result = db.insert(DATABASE_TABLE, null, initialValues);
			db.close();
			}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar inserir os dados.\n Erro:\n" + e.toString());
		}
			return result;
		}

		//---deletes a particular Servico---
		/**
		 * @return boolean
		 * db.delete()
		 * @param table
		 * @param whereClause
		 * @param whereArgs
		 * **/
		public long deleteServico(long rowId) 
		{
		try{
			result = db.delete(DATABASE_TABLE, KEY_IDSERVICO + "=" + rowId, null);
			db.close();
			}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar excluir os dados.\n Erro:\n" + e.toString());
		}
			return result;
		}

		//---retrieves all the Servico---

		/**método query 
		 * @return Cursor
		 * db.query
		 * @param table
		 * @param String[] columns
		 * @param String selection
		 * @param selectionArgs
		 * @param groupby
		 * @param having
		 * @param orderby
		 * **/
		public ArrayList<ServicoVO> getAllServico() 
		{
		ArrayList<ServicoVO> arrayServicoVO = new ArrayList<ServicoVO>();
		try{
		Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " ; ",null);
		if(c.moveToFirst()){
			do{
				ServicoVO objServico = new ServicoVO();
				objServico.idServico = Integer.parseInt(c.getString(0).toString());
									objServico.nome = c.getString(1).toString();
				objServico.idCategoria = Integer.parseInt(c.getString(2).toString());
			arrayServicoVO .add(objServico);
			} while (c.moveToNext());
		}
				c.close();		
		db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de listar os dados.\n Erro:\n" + e.toString());
		}

		return arrayServicoVO;
		}


		//---retrieves a particular Servico---
		/**método query 
		 * @return Cursor
		 * db.query
		 * @param table
		 * @param String[] columns
		 * @param String selection
		 * @param selectionArgs
		 * @param groupby
		 * @param having
		 * @param orderby
		 * **/
		public ServicoVO getServicoById(long rowId) throws SQLException 
		{
		ServicoVO objServico = new ServicoVO();
		try{
			Cursor c = db.rawQuery("SELECT * FROM "+ DATABASE_TABLE + " WHERE "+
					KEY_IDSERVICO + "=" + rowId + ";", null);
			if (c != null) {
			c.moveToFirst();
				objServico.idServico = Integer.parseInt(c.getString(0).toString());
									objServico.nome = c.getString(1).toString();
				objServico.idCategoria = Integer.parseInt(c.getString(2).toString());
			}
		c.close();
		db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de buscar as informações para alteração.\n Erro:\n" + e.toString());
		}
		return objServico;
		}

		//---updates a Servico---
		/**@return boolean
		 * @param table
		 * @param values
		 * @param whereClause
		 * @param whereArgs 
		 * **/
		public long updateServico(ServicoVO objServico) 
		{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objServico.nome);
			initialValues.put(KEY_IDCATEGORIA, objServico.idCategoria);
			result = db.update(DATABASE_TABLE, initialValues, 
			KEY_IDSERVICO + "=" + objServico.idServico, null);
			db.close();
			} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar alterar os dados." + e.toString());
		}
			return result;
		}
	}
	
