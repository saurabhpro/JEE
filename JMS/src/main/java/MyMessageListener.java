import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Saurabh on 4/2/2016.
 */
public class MyMessageListener implements MessageListener {
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;

				String string = textMessage.getText();
				System.out.println(string);
			} else {
				System.out.println("Message in Unknown Format");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
