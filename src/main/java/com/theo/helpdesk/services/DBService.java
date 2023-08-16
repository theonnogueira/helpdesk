package com.theo.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theo.helpdesk.domain.Chamado;
import com.theo.helpdesk.domain.Cliente;
import com.theo.helpdesk.domain.Tecnico;
import com.theo.helpdesk.domain.enums.Perfil;
import com.theo.helpdesk.domain.enums.Prioridade;
import com.theo.helpdesk.domain.enums.Status;
import com.theo.helpdesk.repositories.ChamadoRepository;
import com.theo.helpdesk.repositories.ClienteRepository;
import com.theo.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tecnico1 = new Tecnico(null, "Théo Nogueira", "72926550090", "theo@email.com", "123");
		tecnico1.addPerfil(Perfil.ADMIN);

		Tecnico tecnico2 = new Tecnico(null, "Eduardo Marinho", "02310504566", "marinho@email.com", "321");
		tecnico2.addPerfil(Perfil.ADMIN);

		Cliente cliente1 = new Cliente(null, "Linus Trovals", "70139629025", "linus@email.com", "123");

		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado",
				tecnico1, cliente1);

		tecnicoRepository.saveAll(Arrays.asList(tecnico1));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		chamadoRepository.saveAll(Arrays.asList(chamado1));
		tecnicoRepository.saveAll(Arrays.asList(tecnico2));
	}
}
