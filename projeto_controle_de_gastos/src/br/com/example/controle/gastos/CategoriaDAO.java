package br.com.example.controle.gastos;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**@author Willamys Araújo
 **Generate for Implementor**/

public class CategoriaDAO {

	public static final String KEY_IDCATEGORIA = "idCategoria";
	public static final String KEY_NOME = "nome";

	/***@return
			int idCategoria	
			String nome	
	 **/
	private static final String DATABASE_TABLE = "tcategoria";

	private SQLiteDatabase db;

	private long result = 0;

	private Context context;


	public CategoriaDAO (Context ctx){
		Connection dbHelper = new Connection(ctx);
		this.context = ctx;
		db = dbHelper.getWritableDatabase();
	}

	//---insert Categoria---//
	/***
	 * @return long
	 * db.insert()
	 * @param table
	 * @param column
	 * @param initialvalues
	 * **/
	public long insertCategoria(CategoriaVO objCategoria) 
	{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objCategoria.nome);
			result = db.insert(DATABASE_TABLE, null, initialValues);
			db.close();
		}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar inserir os dados.\n Erro:\n" + e.toString());
		}
		return result;
	}

	//---deletes a particular Categoria---
	/**
	 * @return boolean
	 * db.delete()
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * **/
	public long deleteCategoria(long rowId) 
	{
		try{
			result = db.delete(DATABASE_TABLE, KEY_IDCATEGORIA + "=" + rowId, null);
			db.close();
		}catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar excluir os dados.\n Erro:\n" + e.toString());
		}
		return result;
	}

	//---retrieves all the Categoria---

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
	public ArrayList<CategoriaVO> getAllCategoria() 
	{
		ArrayList<CategoriaVO> arrayCategoriaVO = new ArrayList<CategoriaVO>();
		try{
			Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " ; ",null);
			if(c.moveToFirst()){
				do{
					CategoriaVO objCategoria = new CategoriaVO();
					objCategoria.idCategoria = Integer.parseInt(c.getString(0).toString());
					objCategoria.nome = c.getString(1).toString();
					arrayCategoriaVO .add(objCategoria);
				} while (c.moveToNext());
			}
			c.close();		
			db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de listar os dados.\n Erro:\n" + e.toString());
		}

		return arrayCategoriaVO;
	}


	//---retrieves a particular Categoria---
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
	public CategoriaVO getCategoriaById(long rowId) throws SQLException 
	{
		CategoriaVO objCategoria = new CategoriaVO();
		try{
			Cursor c = db.rawQuery("SELECT * FROM "+ DATABASE_TABLE + " WHERE "+
					KEY_IDCATEGORIA + "=" + rowId + ";", null);
			if (c != null) {
				c.moveToFirst();
				objCategoria.idCategoria = Integer.parseInt(c.getString(0).toString());
				objCategoria.nome = c.getString(1).toString();
			}
			c.close();
			db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro no processo de buscar as informações para alteração.\n Erro:\n" + e.toString());
		}
		return objCategoria;
	}

	//---updates a Categoria---
	/**@return boolean
	 * @param table
	 * @param values
	 * @param whereClause
	 * @param whereArgs 
	 * **/
	public long updateCategoria(CategoriaVO objCategoria) 
	{
		try{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_NOME, objCategoria.nome);
			result = db.update(DATABASE_TABLE, initialValues, 
					KEY_IDCATEGORIA + "=" + objCategoria.idCategoria, null);
			db.close();
		} catch (Exception e) {
			ConnectionException.erro(context, "Ocorreu um erro ao tentar alterar os dados." + e.toString());
		}
		return result;
	}
}

