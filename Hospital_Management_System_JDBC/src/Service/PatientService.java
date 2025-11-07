package Service;

import Dao.PatientDao;
import Models.Patients;

import java.sql.SQLException;
import java.util.List;

public class PatientService {
    private PatientDao patientDao;

    public PatientService(){
        patientDao=new PatientDao();
    }

    public void addPatient(Patients patients) throws SQLException{
        patientDao.addPatient(patients);
    }

    public List<Patients> getAllPatient() throws SQLException{
      return patientDao.getAllPatient();
    }

    public Patients getPatientById(int id) throws SQLException {
        return patientDao.getPatientById(id);
    }
    public void updatePatient(Patients patients) throws SQLException{
        patientDao.updatePatient(patients);
    }
    public void deletePatient(int id) throws SQLException{
        patientDao.deletePatient(id);
    }
}
