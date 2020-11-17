package qtx.rabbitmq;

public class EmisorRabbitmq{
	protected String hostRabbitMQ;
	
	public EmisorRabbitmq() {
		super();
		this.hostRabbitMQ = "localhost";
	}
	public static EmisorTareas getEmisorTareas() {
		EmisorTareas emisorTarea = new EmisorTareas("colaTareas01");
		emisorTarea.hostRabbitMQ = "localhost";
		return emisorTarea;
	}
	public static EmisorRabbitmq getEmisorTareas(String hostRabbitmq, String nomColaTareas) {
		EmisorTareas emisorTarea = new EmisorTareas(nomColaTareas);
		emisorTarea.hostRabbitMQ = hostRabbitmq;
		return emisorTarea;
	}
	
	public static EmisorNotificacion getEmisorNotificacion(String nomIntermediario) {
		EmisorNotificacion emisorTarea = new EmisorNotificacion(nomIntermediario);
		emisorTarea.hostRabbitMQ = "localhost";
		return emisorTarea;
	}
	
	public static EmisorNotificacion getEmisorNotificacion(String hostRabbitmq, String nomIntermediario) {
		EmisorNotificacion emisorTarea = new EmisorNotificacion(nomIntermediario);
		emisorTarea.hostRabbitMQ = hostRabbitmq;
		return emisorTarea;
	}
	public String getHostRabbitMQ() {
		return hostRabbitMQ;
	}
	public void setHostRabbitMQ(String hostRabbitMQ) {
		this.hostRabbitMQ = hostRabbitMQ;
	}

}
