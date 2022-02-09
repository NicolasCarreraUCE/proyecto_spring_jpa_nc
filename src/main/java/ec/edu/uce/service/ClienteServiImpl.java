package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.server.Client;
import ec.edu.uce.repository.jpa.IClienteRepo;

@Service
public class ClienteServiImpl implements IClienteServi {

	@Autowired
	private IClienteRepo clienteRepo;
	
	@Override
	public void guardarCliente(Client client) {
		// TODO Auto-generated method stub
		this.clienteRepo.guardarCliente(client);
	}

}
