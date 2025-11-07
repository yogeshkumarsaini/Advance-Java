package Service;

import Dao.DoctorDao;
import Models.Doctors;

import java.sql.SQLException;
import java.util.List;

public class DoctorService {
    private DoctorDao doctorDao;

    public DoctorService(){
        doctorDao=new DoctorDao();

    }
    public  void  addDoctor(Doctors doctors) throws SQLException {
        doctorDao.addDoctor(doctors);
    }
    public List<Doctors> getAllDoctors() throws SQLException{
        return doctorDao.getAllDoctors();
    }
    public Doctors getDoctorByID(int id) throws SQLException{
        return doctorDao.getDoctorByID(id);
    }

    public  void updateDoctor(Doctors doctors) throws SQLException{
        doctorDao.updateDoctor(doctors);
    }
    public void deleteDoctor(int id) throws SQLException{
        doctorDao.deleteDoctor(id);
    }
}
