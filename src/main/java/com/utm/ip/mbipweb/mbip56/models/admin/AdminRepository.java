package com.utm.ip.mbipweb.mbip56.models.admin;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository {
    List<AdminDAO> getAllAdmin();
    AdminDAO addAdmin(final AdminDAO admin);
    AdminDAO getAdminById(String id);
    AdminDAO updateAdmin(final AdminDAO admin);
    public boolean deleteAdmin(String id);
}
