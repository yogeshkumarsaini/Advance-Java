package Service;

import Dao.AppointmentDao;
import Models.Appointments;

import java.sql.SQLException;
import java.util.List;

public class AppointmentService {
    private AppointmentDao appointmentDao;

    public AppointmentService(){
        appointmentDao=new AppointmentDao();
    }
    public void addAppointment(Appointments appointments) throws SQLException {
        appointmentDao.addAppointment(appointments);
    }
    public List<Appointments> getAllAppointments() throws SQLException{
        return appointmentDao.getAllAppointments();
    }
    public List<String> getDetailedAppointments() throws SQLException {
      return appointmentDao.getDetailedAppointments();
    }
    public Appointments getAppointmentById(int id) throws SQLException {
        return appointmentDao.getAppointmentById(id);
    }
    public void updateAppointment(Appointments appointment) throws SQLException {
        appointmentDao.updateAppointment(appointment);
    }
    public void deleteAppointment(int id) throws SQLException {
        appointmentDao.deleteAppointment(id);
    }
}
