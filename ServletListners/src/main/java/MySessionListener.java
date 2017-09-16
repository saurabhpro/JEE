import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Saurabh on 4/3/2016.
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		HttpSession session = httpSessionEvent.getSession();
		session.setAttribute("name", "saurabh");
		System.out.println("Session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("Session Destroyed");
	}
}
