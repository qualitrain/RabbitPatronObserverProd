package qtx.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmisorNotificacion {
	protected String nombreExchange;
	protected String hostRabbitMQ;
	
	public EmisorNotificacion(String nombreIntermediario) {
		super();
		this.nombreExchange = nombreIntermediario;
		this.hostRabbitMQ = "localhost";
	}
	public EmisorNotificacion(String nombreIntermediario, String hostRabbitMQ) {
		super();
		this.nombreExchange = nombreIntermediario;
		this.hostRabbitMQ = hostRabbitMQ;
	}
	public String getHostRabbitMQ() {
		return hostRabbitMQ;
	}
	public void setHostRabbitMQ(String hostRabbitMQ) {
		this.hostRabbitMQ = hostRabbitMQ;
	}
	public String getNombreExchange() {
		return nombreExchange;
	}
	public void setNombreExchange(String nombreExchange) {
		this.nombreExchange = nombreExchange;
	}
	
	public void emitirNotificacion(String mensaje) {
		ConnectionFactory fabricaConexiones = new ConnectionFactory();
		fabricaConexiones.setHost(this.hostRabbitMQ);
		try(Connection conexion = fabricaConexiones.newConnection();
			Channel canal = conexion.createChannel()	){
			
			canal.exchangeDeclare(this.nombreExchange, "fanout");
			
//			 void basicPublish​(String exchange, String routingKey, AMQP.BasicProperties props, byte[] body) throws IOException
			canal.basicPublish(this.nombreExchange, "", 
					          null, mensaje.getBytes("UTF-8"));
			
			System.out.println("Mensaje general enviado: " + mensaje);
		} 
		catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}
