import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Bill {
    private int id;
    private String name;
    private double amount;

    public Bill(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

class Patient extends User {
    private Bill bill;

    public Patient(int id, String name) {
        super(id, name);
    }

    public void payBill() {
        if (bill != null) {
            System.out.println("Patient " + getName() + " paid the bill of amount " + bill.getAmount());
            bill = null;
        } else {
            System.out.println("Patient " + getName() + " has no bill to pay.");
        }
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}

class Receptionist extends User {
    private List<Appointment> appointments;

    public Receptionist(int id, String name) {
        super(id, name);
        this.appointments = new ArrayList<>();
    }

    public void giveAppointment(Patient patient, Doctor doctor, Date appointmentDate) {
        Appointment appointment = new Appointment(appointments.size() + 1, patient, doctor, appointmentDate);
        appointments.add(appointment);
        System.out.println("Appointment given to " + patient.getName() + " with " + doctor.getName() + " on " + appointmentDate);
    }

    public void generateBill(Patient patient, double amount) {
        Bill bill = new Bill(appointments.size() + 1, patient.getName(), amount);
        patient.setBill(bill);
        System.out.println("Bill generated for " + patient.getName() + " with amount " + amount);
    }
}

class Doctor extends User {
    private List<Patient> patients;

    public Doctor(int id, String name) {
        super(id, name);
        this.patients = new ArrayList<>();
    }

    public void checkPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Doctor " + getName() + " checked patient " + patient.getName());
    }
}

class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;

    public Appointment(int id, Patient patient, Doctor doctor, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }
}

public class ex_2 {
    public static void main(String[] args) {
        Patient patient1 = new Patient(1, "Alice");
        Doctor doctor1 = new Doctor(1, "Dr. Smith");
        Receptionist receptionist1 = new Receptionist(1, "John");

        receptionist1.giveAppointment(patient1, doctor1, new Date());
        receptionist1.generateBill(patient1, 150.0);
        patient1.payBill();
        doctor1.checkPatient(patient1);
    }
}
