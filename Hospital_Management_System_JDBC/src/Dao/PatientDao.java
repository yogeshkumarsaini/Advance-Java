package Dao;

import Models.Patients;
import Utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    public void addPatient(Patients patients) throws SQLException {
        String sql = "INSERT INTO patients(name,date_of_birth,gender,contact_number,address) VALUES(?,?,?,?,?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, patients.getName());
            ps.setString(2, patients.getDateOfBirth());
            ps.setString(3, patients.getGender());
            ps.setString(4, patients.getContactNumber());
            ps.setString(5, patients.getAddress());
            ps.execute();

        }
    }

    public List<Patients> getAllPatient() throws SQLException {
        List<Patients> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Patients patient = new Patients();
                patient.setId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setDateOfBirth(rs.getString("date_of_birth"));
                patient.setGender(rs.getString("gender"));
                patient.setContactNumber(rs.getString("contact_number"));
                patient.setAddress(rs.getString("address"));
                patients.add(patient);

            }
        }
        return patients;
    }

    public Patients getPatientById(int id) throws SQLException {
        String sql = "SELECT * from patients where patient_id=?";
        Patients patients = null;

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    patients = new Patients();
                    patients.setId(rs.getInt("patient_id"));
                    patients.setName(rs.getString("name"));
                    patients.setDateOfBirth(rs.getString("date_of_birth"));
                    patients.setGender(rs.getString("gender"));
                    patients.setContactNumber(rs.getString("contact_number"));
                    patients.setAddress(rs.getString("address"));

                }
            }
        }
        return patients;
    }
    public void updatePatient(Patients patients) throws SQLException{
        String sql = "UPDATE patients SET name =?, date_of_birth =?, gender=?, contact_number=?, address=? where patient_id=?" ;

        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,patients.getName());
            ps.setString(2,patients.getDateOfBirth());
            ps.setString(3,patients.getGender());
            ps.setString(4,patients.getContactNumber());
            ps.setString(5,patients.getAddress());
            ps.setInt(6,patients.getId());
            ps.executeUpdate();
        }
    }
    public void deletePatient(int id) throws SQLException{
        String sql = "DELETE from patients where patient_id=?";
        try(Connection conn =DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }
}
