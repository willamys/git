package bean;


import java.util.Date;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import logger.SystemLogger;

import dao.UserDAOImpl;

import entity.User;

import bean.MessageBean;
import bean.UtilBean;

/**
 *
 * @author 
 */
@ManagedBean
@SessionScoped
public class LogonBean {

    private User user;
    private String usuario;
    private String senha;
    private boolean autenticado = false;
    private Date ultimoAcesso;

    public LogonBean() {
    }

    private ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    private HttpSession getSession() {
        return (HttpSession) getExternalContext().getSession(false);
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public User getUser() {
        user = new UserDAOImpl().searchBy("login", usuario.toLowerCase());
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void newAccess() {
        senha = null;
        user = new User();
    }

    public void login() {
        if (getUser() == null) {
            newAccess();
            new MessageBean().add(FacesMessage.SEVERITY_WARN,
                    "Usuário não encontrado",
                    "Não foi possível localizar este usuário nos nossos registros, confira se tudo foi digitado corretamente...");
        } else {
            if (user.getPassword().equals(senha)) {
                enter();
                //ultimoAcesso = user.getUltimoAcesso();
                putOnSession();
                updateLastAccess();

            } else {
                newAccess();
                new MessageBean().add(FacesMessage.SEVERITY_ERROR,
                        "Senha incorreta",
                        "A senha que você digitou parece estar incorreta, tente novamente...");
            }
        }
    }

    public void logout() {
        leave();
        SystemLogger.save(Level.INFO, user.getLogin() + " efetuou logoff: " + new UtilBean().formatDateAndHour(new Date()));
        getSession().invalidate();
    }

    public void enter() {
        autenticado = true;
    }

    public void leave() {
        autenticado = false;
    }

    public void putOnSession() {
        getSession().setAttribute("user", user);
        SystemLogger.save(Level.INFO, user.getLogin() + " efetuou logon: " + new UtilBean().formatDateAndHour(new Date()));
    }

    public void updateLastAccess() {
       // user.setUltimoAcesso(new Date());
        //new ContaDAOImpl().update(user);
    }
}
