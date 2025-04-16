package com.hexaware.hm.dao;

import com.hexaware.hm.entity.Appointment;
import com.hexaware.hm.exception.PatientNumberNotFoundException;
import java.util.List;

public interface IHospitalService {
    Appointment getAppointmentById(int appointmentId);
    List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException;
    List<Appointment> getAppointmentsForDoctor(int doctorId);
    boolean scheduleAppointment(Appointment appointment);
    boolean updateAppointment(Appointment appointment);
    boolean cancelAppointment(int appointmentId);
}

