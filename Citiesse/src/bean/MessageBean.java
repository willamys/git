package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author
 */
@ManagedBean
@RequestScoped
public class MessageBean {

    private FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void add(FacesMessage.Severity sv, String msg) {
        getFacesContext().addMessage(null, new FacesMessage(sv, msg, msg));
    }

    public void add(FacesMessage.Severity sv, String msg, String desc) {
        getFacesContext().addMessage(null, new FacesMessage(sv, msg, desc));
    }

    public void success() {
        add(FacesMessage.SEVERITY_INFO,
                "Transação executada com sucesso!");
    }

    public void error() {
        add(FacesMessage.SEVERITY_ERROR,
                "Houve algum problema ao tentar executar a transação!");
    }
}
