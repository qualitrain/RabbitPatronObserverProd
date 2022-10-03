package qtx.test;

import qtx.rabbitmq.EmisorNotificacion;

public class TestEmision {
	public static String nombres[] = {
			"Jorge Parra Morales",
			"Mario Mora Karam",
			"Norma Isela Vera Herrera",
			"Olga Iturralde Garza",
			"Ernesto Goya Zedillo",
			"Isabel Narro Peza",
			"Jairo Corral Jara",
	};

	public static void main(String[] args) {
		EmisorNotificacion emisor = new EmisorNotificacion("exClientesNuevos");
		for(int i = 0; i < nombres.length; i++) {
			String mensaje = "{\"nombre\": \"" + nombres[i] + "\", \"numCte\":" + (i + 100) + "}";
			emisor.emitirNotificacion(mensaje);			
		}
	}

}
