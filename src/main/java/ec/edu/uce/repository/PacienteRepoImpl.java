package ec.edu.uce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;

@Repository
public class PacienteRepoImpl implements IPacienteRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		// INSERT INTO paciente (id, nombre, apellido, edad) VALUES (1, 'Nicolas', 'Carrera', 23)
		Object[] datosAInsertar = new Object[] {
				paciente.getId(),
				paciente.getNombre(),
				paciente.getApellido(),
				paciente.getEdad()
		};
		this.jdbcTemplate.update("INSERT INTO paciente (id, nombre, apellido, edad) VALUES (?,?,?,?)", datosAInsertar);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		Object[] datosABuscar = new Object[] {
				id
		};
		return this.jdbcTemplate.queryForObject("select * from paciente where id=?", datosABuscar,
				new BeanPropertyRowMapper<Paciente>(Paciente.class));
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		// UPDATE paciente SET id=1, nombre='Nicolas', apellido='Carrera', edad=23 WHERE id=1
		Object[] datosAActualizar = new Object[] {
				paciente.getId(),
				paciente.getNombre(),
				paciente.getApellido(),
				paciente.getEdad(),
				paciente.getId()
		};
		this.jdbcTemplate.update("UPDATE public.paciente SET id=?, nombre=?, apellido=?, edad=?	WHERE id=?;", datosAActualizar);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		// DELETE FROM paciente WHERE id=1
		Object[] datoABorrar = new Object[] {
				id
		};
		this.jdbcTemplate.update("DELETE FROM paciente WHERE id=?", datoABorrar);
	}

}
