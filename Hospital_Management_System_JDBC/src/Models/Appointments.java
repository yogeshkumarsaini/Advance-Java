package Models;

public class Appointments {
    private int id;
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    private String appointmentReason;

    public Appointments() {
    }

    public Appointments(int id, int patientId, int doctorId, String appointmentDate, String appointmentReason) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentReason = appointmentReason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentReason='" + appointmentReason + '\'' +
                '}';
    }
}
