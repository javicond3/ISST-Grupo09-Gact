package es.upm.dit.isst.gestionDoc.dao;

import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.gestionDoc.dao.SessionFactoryService;

public class AsignacionDAOImplementation implements AsignacionDAO{

	public static AsignacionDAOImplementation instance;

	private AsignacionDAOImplementation() {
	}

	public static AsignacionDAOImplementation getInstance() {
		if (null == instance)
			instance = new AsignacionDAOImplementation();
		return instance;
	}
	@Override
	public void createAsignacion(Asignacion asignacion) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(asignacion);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
	}

	@Override
	public Asignacion readAsociacion(long id) {
		Session session = SessionFactoryService.get().openSession();
		Asignacion asignacion = null;
		try {
			asignacion = session.get(Asignacion.class, id);
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return asignacion;
	}

	@Override
	public void updateAsignacion(Asignacion asignacion) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(asignacion);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		
	}

	@Override
	public void deleteAsignacion(Asignacion asignacion) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(asignacion);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}		
		
	}

	@Override
	public List<Asignatura> readAsignaturas(Profesor profesor) {
		Session session = SessionFactoryService.get().openSession();
		List<Asignatura> asignaturas = new ArrayList<>();
		try {
			session.beginTransaction();
			
			asignaturas.addAll(session.createQuery("select a.asignatura from Asignacion a where a.profesor= :profesor")
					.setParameter("profesor", profesor).getResultList());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
		return asignaturas;
	}
	

	@Override
	public List<Profesor> readProfesor(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
