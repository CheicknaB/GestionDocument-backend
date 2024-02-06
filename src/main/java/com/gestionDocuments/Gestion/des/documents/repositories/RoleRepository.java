package com.gestionDocuments.Gestion.des.documents.repositories;

import com.gestionDocuments.Gestion.des.documents.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
