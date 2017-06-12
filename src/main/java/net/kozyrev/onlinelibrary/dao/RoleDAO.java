package net.kozyrev.onlinelibrary.dao;


import net.kozyrev.onlinelibrary.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,Long> {

}
