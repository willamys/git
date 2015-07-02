package bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author italobruno
 */
@ManagedBean
@RequestScoped
public class RedirectBean {

    public RedirectBean() {
    }

    private ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public String getRoot() {
        return getExternalContext().getRequestContextPath();
    }

    public String getResource() {
        return "/resource";
    }

    public void redirect() throws IOException {
        getExternalContext().redirect(getRoot());
    }

    public void redirect(String url) throws IOException {
        getExternalContext().redirect("/" + getRoot() + "/" + url);
    }
}
