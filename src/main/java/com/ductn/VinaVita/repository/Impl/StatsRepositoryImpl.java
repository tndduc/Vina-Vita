/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.repository.Impl;

import com.ductn.VinaVita.repository.StatsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<?> statsBookingByUser() {
        String jpql = "SELECT u.userId, CONCAT(u.lastname, ' ', u.firstname), COUNT(b.bookingId) "
                + "FROM Booking b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "GROUP BY u.userId";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsServicePricePaid() {
        String jpql = "SELECT u.userId, CONCAT(u.lastname, ' ', u.firstname), SUM(p.servicePrice) "
                + "FROM Prescriptions p "
                + "JOIN p.bookingId b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "WHERE p.servicePaymentStatusId.servicePaymentStatusId = 2 "
                + "GROUP BY u.userId";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsServicePriceUnpaid() {
        String jpql = "SELECT u.userId, CONCAT(u.lastname, ' ', u.firstname), SUM(p.servicePrice) "
                + "FROM Prescriptions p "
                + "JOIN p.bookingId b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "WHERE p.servicePaymentStatusId.servicePaymentStatusId = 1 "
                + "GROUP BY u.userId";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsServicePriceAllpaid() {

        String jpql = "SELECT u.userId, CONCAT(u.lastname, ' ', u.firstname), SUM(p.servicePrice) "
                + "FROM Prescriptions p "
                + "JOIN p.bookingId b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "GROUP BY u.userId";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsMedicinePrescriptionPaid() {
        String jpql = "SELECT u.firstname, SUM(pres_d.unitPrice * pres_d.quantity) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.prescriptionId pres "
                + "JOIN pres.bookingId b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "WHERE pres.medicinePaymentStatusId.medicinePaymentStatusId = 2 "
                + "GROUP BY u.firstname";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsMedicinePrescriptionUnpaid() {
        String jpql = "SELECT u.firstname, SUM(pres_d.unitPrice * pres_d.quantity) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.prescriptionId pres "
                + "JOIN pres.bookingId b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "WHERE pres.medicinePaymentStatusId.medicinePaymentStatusId = 1 "
                + "GROUP BY u.firstname";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsMedicinePrescriptionAllPaid() {
        String jpql = "SELECT u.firstname, SUM(pres_d.unitPrice * pres_d.quantity) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.prescriptionId pres "
                + "JOIN pres.bookingId b "
                + "JOIN b.scheduleId s "
                + "JOIN s.profileDoctorId pd "
                + "JOIN pd.userId u "
                + "GROUP BY u.firstname";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsCountMedicineAllPaid() {
        String jpql = "SELECT m.medicineId, m.medicineName, SUM(pres_d.quantity) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.medicineId m "
                + "JOIN pres_d.prescriptionId pres "
                + "GROUP BY m.medicineId, m.medicineName";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsCountMedicinePaid() {
        String jpql = "SELECT m.medicineId, m.medicineName, SUM(pres_d.quantity) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.medicineId m "
                + "JOIN pres_d.prescriptionId pres "
                + "WHERE pres.medicinePaymentStatusId.medicinePaymentStatusId = 2 "
                + "GROUP BY m.medicineId, m.medicineName";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsCountMedicineUnpaid() {
        String jpql = "SELECT m.medicineId, m.medicineName, SUM(pres_d.quantity) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.medicineId m "
                + "JOIN pres_d.prescriptionId pres "
                + "WHERE pres.medicinePaymentStatusId.medicinePaymentStatusId = 1 "
                + "GROUP BY m.medicineId, m.medicineName";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsRevenueMedicineAllpaid() {
        String jpql = "SELECT m.medicineId, m.medicineName, SUM(pres_d.quantity * m.unitPrice) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.medicineId m "
                + "JOIN pres_d.prescriptionId pres "
                + "GROUP BY m.medicineId, m.medicineName";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsRevenueMedicinePaid() {
        String jpql = "SELECT m.medicineId, m.medicineName, SUM(pres_d.quantity * m.unitPrice) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.medicineId m "
                + "JOIN pres_d.prescriptionId pres "
                + "WHERE pres.medicinePaymentStatusId.medicinePaymentStatusId = 2 "
                + "GROUP BY m.medicineId, m.medicineName";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<?> statsRevenueMedicineUnpaid() {
        String jpql = "SELECT m.medicineId, m.medicineName, SUM(pres_d.quantity * m.unitPrice) "
                + "FROM PrescriptionDetail pres_d "
                + "JOIN pres_d.medicineId m "
                + "JOIN pres_d.prescriptionId pres "
                + "WHERE pres.medicinePaymentStatusId.medicinePaymentStatusId = 1 "
                + "GROUP BY m.medicineId, m.medicineName";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

}
