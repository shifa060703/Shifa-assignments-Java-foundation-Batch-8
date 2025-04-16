package com.hexaware.hm.dao;

import com.hexaware.hm.entity.Appointment;
import com.hexaware.hm.exception.PatientNumberNotFoundException;
import com.hexaware.hm.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements IHospitalService {

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Appointment appt = null;
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "SELECT * FROM Appointment WHERE appointmentId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                appt = new Appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getDate("appointmentDate").toLocalDate(),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appt;
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException {
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "SELECT * FROM Appointment WHERE patientId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appt = new Appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getDate("appointmentDate").toLocalDate(),
                        rs.getString("description")
                );
                list.add(appt);
            }

            if (list.isEmpty()) {
                throw new PatientNumberNotFoundException("No appointments found for patient ID: " + patientId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "SELECT * FROM Appointment WHERE doctorId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appt = new Appointment(
                        rs.getInt("appointmentId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getDate("appointmentDate").toLocalDate(),
                        rs.getString("description")
                );
                list.add(appt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) {
        boolean result = false;
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "INSERT INTO Appointment (appointmentId, patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, appointment.getAppointmentId());
            ps.setInt(2, appointment.getPatientId());
            ps.setInt(3, appointment.getDoctorId());
            ps.setDate(4, Date.valueOf(appointment.getAppointmentDate()));
            ps.setString(5, appointment.getDescription());

            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        boolean result = false;
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "UPDATE Appointment SET patientId=?, doctorId=?, appointmentDate=?, description=? WHERE appointmentId=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, Date.valueOf(appointment.getAppointmentDate()));
            ps.setString(4, appointment.getDescription());
            ps.setInt(5, appointment.getAppointmentId());

            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    
    @Override
    public boolean cancelAppointment(int appointmentId) {
        boolean result = false;
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "DELETE FROM Appointment WHERE appointmentId = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, appointmentId);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
