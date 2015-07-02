package bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.UserDAOImpl;

import entity.User;

import util.Utilities;
@ManagedBean
@SessionScoped
public class UserBean {

	private String login;

	private String password;

	private boolean autenticate = false;

	private User user;

	public UserBean(){}

	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	private HttpSession getSession() {
		return (HttpSession) getExternalContext().getSession(false);
	}

	public User getUser(){
		UserDAOImpl udao = new UserDAOImpl();
		user = udao.searchBy("login", login.toLowerCase());
		System.out.println(user.getLogin()+user.getPassword());

		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAutenticate() {
		return autenticate;
	}

	public void setAutenticate(boolean autenticate) {
		this.autenticate = autenticate;
	}


	public void newAccess(){
		password = null;
		user = new User();
	}

	public String login(){
		String ret = "";
		if(getUser() == null) {
			newAccess();
			new MessageBean().add(FacesMessage.SEVERITY_INFO, "Login Failed", "User not found!");
			ret = "/index.jsf";
		}else{
			if (user.getPassword().equals(password)) {
				enter();
				putOnSession();
				ret = "/exec/index.jsf";
			}else{
				newAccess();
				new MessageBean().add(FacesMessage.SEVERITY_ERROR, "Login Failed", "User not found!");
				ret = "/index.jsf";
			}
		}
		return ret;
	}

	public void logout() {
		leave();
		getSession().invalidate();
	}

	private void leave() {
		autenticate = false;
	}

	private void putOnSession() {
		getSession().setAttribute("user", user);
	}

	private void enter() {
		autenticate = true;
	}

	public String verifyLogin(){
		if(Utilities.isUsuarioValido(login, password)){
			return "/exec/index.jsf";
		}else{
			return "/login.jsf";
		}
	}
}

