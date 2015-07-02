package session;


import bean.UtilBean;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import entity.User;

import logger.SystemLogger;

/**
 *
 * @author
 */
public class SessionFilter implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Create a session
        SystemLogger.save(Level.INFO, "Sess�o criada: " + new UtilBean().formatDateAndHour(new Date()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Destroy a session        
        User c = (User) se.getSession().getAttribute("user");
        if (c != null) {
            SystemLogger.save(Level.INFO, c.getLogin() + " encerrou sua sessao: " + new UtilBean().formatDateAndHour(new Date()));
        } else {
            SystemLogger.save(Level.INFO, "Usu�rio n�o autenticado encerrou uma sess�o: " + new UtilBean().formatDateAndHour(new Date()));
        }
    }
}
