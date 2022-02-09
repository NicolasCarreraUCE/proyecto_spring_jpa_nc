package ec.edu.uce.repository.jpa;

import ch.qos.logback.core.net.server.Client;

public interface IClienteRepo {
	void guardarCliente(Client client);
}
