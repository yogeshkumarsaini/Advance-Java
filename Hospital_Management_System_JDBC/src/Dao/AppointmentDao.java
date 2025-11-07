package Dao;

import Models.Appointments;
import Utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    public void addAppointment(Appointments appointments) throws SQLException {
        String sql = "Insert into appointments (patient_id, doctor_id, appointment_date, appointment_reason) values (?,?,?,?)";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointments.getPatientId());
            ps.setInt(2, appointments.getDoctorId());
            ps.setString(3, appointments.getAppointmentDate());
            ps.setString(4, appointments.getAppointmentReason());
            ps.executeUpdate();
        }
    }

    public List<Appointments> getAllAppointments() throws SQLException {
        List<Appointments> appointments = new ArrayList<>();
        String sql = "SELECT * from appointments";

        try (Connection conn = DBUtil.getConnection(); Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Appointments appointment = new Appointments();
                appointment.setId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getString("appointment_date"));
                appointment.setAppointmentReason(rs.getString("appointment_reason"));
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public List<String> getDetailedAppointments() throws SQLException {
        List<String> detailedAppointments = new ArrayList<>();
        String sql = "SELECT a.appointment_id, a.appointment_date, a.appointment_reason, " +
                "p.name , p.date_of_birth, p.gender, p.contact_number , p.address, " +
                "d.dname, d.specialization, d.contactNumber , d.email " +
                "FROM appointments a " +
                "JOIN patients p ON a.patient_id = p.patient_id " +
                "JOIN doctors d ON a.doctor_id = d.doctor_id";

        try (Connection conn = DBUtil.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int appointmentId = rs.getInt("appointment_id");
                String appointmentDate = rs.getString("appointment_date");
                String appointmentReason = rs.getString("appointment_reason");

                String patientName = rs.getString("name");
                String patientDateOfBirth = rs.getString("date_of_birth");
                String patientGender = rs.getString("gender");
                String patientContact = rs.getString("contact_number");
                String patientAddress = rs.getString("address");

                String doctorName = rs.getString("dname");
                String doctorSpecialization = rs.getString("specialization");
                String doctorContact = rs.getString("contactNumber");
                String doctorEmail = rs.getString("email");

                String detailedAppointment = "Appointment ID: " + appointmentId +
                        ", Date: " + appointmentDate +
                        ", Reason: " + appointmentReason +
                        ", Patient: " + patientName +
                        ", DOB: " + patientDateOfBirth +
                        ", Gender: " + patientGender +
                        ", Contact: " + patientContact +
                        ", Address: " + patientAddress +
                        ", Doctor: " + doctorName +
                        ", Specialization: " + doctorSpecialization +
                        ", Contact: " + doctorContact +
                        ", Email: " + doctorEmail;

                detailedAppointments.add(detailedAppointment);
            }
        }
        return detailedAppointments;
    }
    public Appointments getAppointmentById(int id) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?";
        Appointments appointment = null;

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    appointment = new Appointments();
                    appointment.setId(rs.getInt("appointment_id"));
                    appointment.setPatientId(rs.getInt("patient_id"));
                    appointment.setDoctorId(rs.getInt("doctor_id"));
                    appointment.setAppointmentDate(rs.getString("appointment_date"));
                    appointment.setAppointmentReason(rs.getString("appointment_reason"));
                }
            }
        }
        return appointment;
    }
    public void updateAppointment(Appointments appointment) throws SQLException {
        String sql = "UPDATE appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, appointment_reason = ? WHERE appointment_id = ?";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getAppointmentReason());
            ps.setInt(5, appointment.getId());
            ps.executeUpdate();
        }
    }
    public void deleteAppointment(int id) throws SQLException {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
