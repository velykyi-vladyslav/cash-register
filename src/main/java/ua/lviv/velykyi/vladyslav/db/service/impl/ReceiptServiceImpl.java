package ua.lviv.velykyi.vladyslav.db.service.impl;

import ua.lviv.velykyi.vladyslav.db.dao.impl.ReceiptDAO;
import ua.lviv.velykyi.vladyslav.db.entity.Receipt;
import ua.lviv.velykyi.vladyslav.db.service.ReceiptService;

import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private ReceiptDAO dao;

    public ReceiptServiceImpl() {
        dao = new ReceiptDAO();
    }

    @Override
    public List<Receipt> findAll() {
        return dao.findAll();
    }

    @Override
    public Receipt findById(Long id) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Receipt findByStatusId(Long statusId) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getStatusId()==statusId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Receipt findByEmployeeId(Long employeeId) {
        return dao.findAll()
                .stream()
                .filter(receipt -> receipt.getEmployeeId()==employeeId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Receipt receipt) {
    dao.update(receipt);
    }

    @Override
    public void insert(Receipt receipt) {
    dao.insert(receipt);
    }

    @Override
    public void delete(Receipt receipt) {
    dao.delete(receipt);
    }

}
