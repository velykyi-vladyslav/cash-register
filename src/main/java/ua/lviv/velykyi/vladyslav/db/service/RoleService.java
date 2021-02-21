package ua.lviv.velykyi.vladyslav.db.service;


import ua.lviv.velykyi.vladyslav.db.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findByName(String name);
    void update(Role role);
    void insert(Role role);
    void delete(Role role);
    Role findById(long id);
}
