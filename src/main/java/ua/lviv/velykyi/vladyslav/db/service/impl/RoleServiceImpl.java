package ua.lviv.velykyi.vladyslav.db.service.impl;

import ua.lviv.velykyi.vladyslav.db.dao.impl.RoleDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Role;
import ua.lviv.velykyi.vladyslav.db.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDAO dao;

    public RoleServiceImpl() {
        dao = new RoleDAO();
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public Role findByName(String name) {
        return dao.findAll()
                .stream()
                .filter(role -> role.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Role role) {
        dao.update(role);
    }

    @Override
    public void insert(Role role) {
        dao.insert(role);
    }

    @Override
    public void delete(Role role) {
        dao.delete(role);
    }
}
