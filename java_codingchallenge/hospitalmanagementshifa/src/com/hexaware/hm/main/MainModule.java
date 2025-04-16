package com.hexaware.hm.main;

import com.hexaware.hm.dao.HospitalServiceImpl;
import com.hexaware.hm.dao.IHospitalService;
import com.hexaware.hm.entity.Appointment;
import com.hexaware.hm.exception.PatientNumberNotFoundException;
import com.hexaware.hm.util.DBConnUtil;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        // ✅ Check DB connection first
        try {
            Connection conn = DBConnUtil.getConnection();  // Removed the argument "db.properties"
            if (conn != null) {
                System.out.println("✅ Database connected successfully!");
            } else {
                System.out.println("❌ Database connection failed. Exiting...");
                return;
            }
        } catch (Exception e) {
            System.out.println("❌ Error connecting to database:");
            e.printStackTrace();
            return;
        }

        Scanner sc = new Scanner(System.in);
        IHospitalService service = new HospitalServiceImpl();

        int choice;
        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. Get Appointment by ID");
            System.out.println("3. Get Appointments for Patient");
            System.out.println("4. Get Appointments for Doctor");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Appointment ID: ");
                        int aId = sc.nextInt();
                        System.out.print("Enter Patient ID: ");
                        int pId = sc.nextInt();
                        System.out.print("Enter Doctor ID: ");
                        int dId = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
                        String date = sc.nextLine();
                        System.out.print("Enter Description: ");
                        String desc = sc.nextLine();

                        Appointment newAppt = new Appointment(aId, pId, dId, LocalDate.parse(date), desc);
                        if (service.scheduleAppointment(newAppt)) {
                            System.out.println("✅ Appointment scheduled successfully.");
                        } else {
                            System.out.println("❌ Failed to schedule appointment.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Appointment ID: ");
                        int id = sc.nextInt();
                        Appointment appt = service.getAppointmentById(id);
                        if (appt != null) {
                            System.out.println("✅ Appointment Details:\n" + appt);
                        } else {
                            System.out.println("❌ No appointment found with ID: " + id);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Patient ID: ");
                        int pid = sc.nextInt();
                        List<Appointment> patientList = service.getAppointmentsForPatient(pid);
                        if (!patientList.isEmpty()) {
                            System.out.println("✅ Appointments for Patient:");
                            for (Appointment a : patientList) {
                                System.out.println(a);
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter Doctor ID: ");
                        int did = sc.nextInt();
                        List<Appointment> doctorList = service.getAppointmentsForDoctor(did);
                        if (!doctorList.isEmpty()) {
                            System.out.println("✅ Appointments for Doctor:");
                            for (Appointment a : doctorList) {
                                System.out.println(a);
                            }
                        } else {
                            System.out.println("❌ No appointments found for Doctor ID: " + did);
                        }
                        break;

                    case 5:
                        System.out.print("Enter Appointment ID to update: ");
                        int uaid = sc.nextInt();
                        System.out.print("Enter new Patient ID: ");
                        int upid = sc.nextInt();
                        System.out.print("Enter new Doctor ID: ");
                        int udid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Date (yyyy-mm-dd): ");
                        String udate = sc.nextLine();
                        System.out.print("Enter new Description: ");
                        String udesc = sc.nextLine();

                        Appointment updated = new Appointment(uaid, upid, udid, LocalDate.parse(udate), udesc);
                        if (service.updateAppointment(updated)) {
                            System.out.println("✅ Appointment updated successfully.");
                        } else {
                            System.out.println("❌ Failed to update appointment.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter Appointment ID to cancel: ");
                        int caid = sc.nextInt();
                        if (service.cancelAppointment(caid)) {
                            System.out.println("✅ Appointment cancelled successfully.");
                        } else {
                            System.out.println("❌ Failed to cancel appointment.");
                        }
                        break;

                    case 7:
                        System.out.println("👋 Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("⚠️ Invalid choice. Please try again.");
                }

            } catch (PatientNumberNotFoundException pnfe) {
                System.out.println("❗ " + pnfe.getMessage());
            } catch (Exception e) {
                System.out.println("❗ Something went wrong: " + e.getMessage());
            }

        } while (choice != 7);
    }
}
