package br.com.example.controle.gastos;

import android.content.Context;
import java.util.ArrayList;

 /**@author Willamys Araújo
 **Generate for Implementor**/
 
public class Fachada{

	public static Fachada fachada = null; 

	public Fachada() {
	}
	/***método estático para obter a instância da classe Fachada ***/
	public static Fachada getInstance() {
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	/***INICIO Servico**/

	/***metodo de insercao de Servico*
	* @param ctx passar contexto do view que esta em uso
	* @param servico passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "insercao falhou"
	*  1 a "inserido com sucesso" **/
	public long insertServico(Context ctx, ServicoVO servico) {
	ServicoDAO servicoDao = new ServicoDAO(ctx);
		if(servico == null){
			return -1;
		}else{
			return servicoDao. insertServico (servico);
		}
	}
	/***metodo de alteracao de Servico*
	* @param ctx passar contexto do view que esta em uso**
	* @param servico passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "alteracao falhou"
	*  1 a "alterado com sucesso" ***/
	public long updateServico(Context ctx, ServicoVO servico) {
		ServicoDAO servicoDao = new ServicoDAO(ctx);
		if(servico == null){
			return -1;
		}else{
			return servicoDao. updateServico (servico);
		}
	}
	/***metodo de insercao de Servico**
	* @param ctx passar contexto do view que esta em uso**
	* @param id passar o id que do registro a ser deletado
	* @return long - se o valor retornado for:
	* -1 a "delete falhou"
	*  1 a "delete com sucesso" **/
	public long deleteServico(Context ctx, long id) {
	ServicoDAO servicoDao = new ServicoDAO(ctx);
		if(id == 0 || id < 0){
			return -1;
		}else{
			return servicoDao. deleteServico (id);
		}
	}
	/***metodo de listar todos os registros de Servico**
	* @param ctx passar contexto do view que esta em uso
	* @return ArrayList de Objeto da classe Servico preenchidos**/
	public ArrayList<ServicoVO> getAllServico(Context ctx) {
	ServicoDAO servicoDao = new ServicoDAO(ctx);
		return servicoDao. getAllServico (); 
	}
	/***metodo de listar registro por Id de Servico**
	* @param ctx passar contexto do view que esta em uso**
	* @param id passar o id que do registro a ser buscado
	* @return Objeto da classe Servico preenchido**/
	public ServicoVO getServicoById(Context ctx, long id) {
	ServicoDAO servicoDao = new ServicoDAO(ctx);
		if(id == 0 || id < 0){
			return null;
		}else{
			return servicoDao. getServicoById (id);
		}
	}
	/***FIM Servico****/

/***INICIO Categoria**/

	/***metodo de insercao de Categoria*
	* @param ctx passar contexto do view que esta em uso
	* @param categoria passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "insercao falhou"
	*  1 a "inserido com sucesso" **/
	public long insertCategoria(Context ctx, CategoriaVO categoria) {
	CategoriaDAO categoriaDao = new CategoriaDAO(ctx);
		if(categoria == null){
			return -1;
		}else{
			return categoriaDao. insertCategoria (categoria);
		}
	}
	/***metodo de alteracao de Categoria*
	* @param ctx passar contexto do view que esta em uso**
	* @param categoria passar o objeto prenchido com valores dos atributos
	* @return long - se o valor retornado for:
	* -1 a "alteracao falhou"
	*  1 a "alterado com sucesso" ***/
	public long updateCategoria(Context ctx, CategoriaVO categoria) {
		CategoriaDAO categoriaDao = new CategoriaDAO(ctx);
		if(categoria == null){
			return -1;
		}else{
			return categoriaDao. updateCategoria (categoria);
		}
	}
	/***metodo de insercao de Categoria**
	* @param ctx passar contexto do view que esta em uso**
	* @param id passar o id que do registro a ser deletado
	* @return long - se o valor retornado for:
	* -1 a "delete falhou"
	*  1 a "delete com sucesso" **/
	public long deleteCategoria(Context ctx, long id) {
	CategoriaDAO categoriaDao = new CategoriaDAO(ctx);
		if(id == 0 || id < 0){
			return -1;
		}else{
			return categoriaDao. deleteCategoria (id);
		}
	}
	/***metodo de listar todos os registros de Categoria**
	* @param ctx passar contexto do view que esta em uso
	* @return ArrayList de Objeto da classe Categoria preenchidos**/
	public ArrayList<CategoriaVO> getAllCategoria(Context ctx) {
	CategoriaDAO categoriaDao = new CategoriaDAO(ctx);
		return categoriaDao. getAllCategoria (); 
	}
	/***metodo de listar registro por Id de Categoria**
	* @param ctx passar contexto do view que esta em uso**
	* @param id passar o id que do registro a ser buscado
	* @return Objeto da classe Categoria preenchido**/
	public CategoriaVO getCategoriaById(Context ctx, long id) {
	CategoriaDAO categoriaDao = new CategoriaDAO(ctx);
		if(id == 0 || id < 0){
			return null;
		}else{
			return categoriaDao. getCategoriaById (id);
		}
	}
	/***FIM Categoria****/

	}