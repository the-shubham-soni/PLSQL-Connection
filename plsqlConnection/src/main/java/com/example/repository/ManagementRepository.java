package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Repository
public class ManagementRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Call the "ProcessManagementShort" stored procedure
    public List<Object[]> processManagementShort() {
        Query query = entityManager.createNativeQuery("CALL ProcessManagementShort()");
        return query.getResultList();
    }

    // Call the "FetchDeveloperByRole" stored procedure
    public List<Object[]> fetchDeveloperByRole(String role) {
        Query query = entityManager.createNativeQuery("CALL FetchDeveloperByRole(:role)");
        query.setParameter("role", role);
        return query.getResultList();
    }
}
