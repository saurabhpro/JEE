import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Saurabh on 4/2/2016.
 */
public class Publisher {
	public static void main(String[] args) {
		try {
			Properties parm = new Properties();
			parm.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
			parm.setProperty("java.naming.provider.url", "t3://localhost:7002");
			parm.setProperty("java.naming.security.principal", "weblogic");
			parm.setProperty("java.naming.security.credentials", "weblogic16");

			InitialContext ctx = new InitialContext(parm);

			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory3");

			TopicConnection conn = topicConnectionFactory.createTopicConnection();
			conn.start();

			TopicSession session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);

			Topic topic = (Topic) ctx.lookup("MyTopic3");
			TopicPublisher publisher = session.createPublisher(topic);

			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("Saurabh Welcomes You");

			publisher.publish(textMessage);
			System.out.println("Message Is Sent Successfully");

			session.close();
			conn.close();

		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}


	}
}
