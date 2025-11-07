package Dao;

import Models.Doctors;
import Utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public  void  addDoctor(Doctors doctors) throws SQLException{
        String sql ="INSERT INTO doctors (dname, specialization, contactNumber,email) VALUES(?,?,?,?)";

        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,doctors.getName());
            ps.setString(2,doctors.getSpecialization());
            ps.setString(3,doctors.getContactNumber());
            ps.setString(4,doctors.getEmail());
            ps.execute();
        }
    }
    public List<Doctors> getAllDoctors() throws SQLException{
        List<Doctors> doctors =new ArrayList<>();
        String sql ="SELECT * from doctors";
        try(Connection conn =DBUtil.getConnection();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(sql)){
            while (rs.next()){
                Doctors doctor =new Doctors();
                doctor.setId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("dname"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setContactNumber(rs.getString("contactNumber"));
                doctor.setEmail(rs.getString("email"));
                doctors.add(doctor);
            }
        }
        return doctors;
    }
    public Doctors getDoctorByID(int id) throws SQLException{
        String sql ="SELECT * FROM doctors where doctor_id=?";
        Doctors doctors=null;
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps =conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    doctors = new Doctors();
                    doctors.setId(rs.getInt("doctor_id"));
                    doctors.setName(rs.getString("dname"));
                    doctors.setSpecialization(rs.getString("specialization"));
                    doctors.setContactNumber(rs.getString("contactNumber"));
                    doctors.setEmail(rs.getString("email"));
                }
            }
        }
        return doctors;
    }
    public  void updateDoctor(Doctors doctors) throws SQLException{
        String sql ="UPDATE doctors SET dname=?, specialization=?, contactNumber=?,email=? where doctor_id=?";

        try(Connection conn = DBUtil.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,doctors.getName());
            ps.setString(2,doctors.getSpecialization());
            ps.setString(3,doctors.getContactNumber());
            ps.setString(4,doctors.getEmail());
            ps.setInt(5,doctors.getId());
            ps.executeUpdate();
        }
    }
    public void deleteDoctor(int id) throws SQLException{
        String sql ="DELETE from doctors where doctor_id=?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }
}
