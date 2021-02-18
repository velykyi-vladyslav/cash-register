package ua.lviv.velykyi.vladyslav.db.service;

import ua.lviv.velykyi.vladyslav.db.entity.Category;
import ua.lviv.velykyi.vladyslav.db.entity.Receipt;

import java.util.List;
import java.util.logging.Logger;

public interface ReceiptService {
    List<Receipt> findAll();
    Receipt findById(Long id);
    Receipt findByStatusId(Long statusId);
    Receipt findByEmployeeId(Long employeeId);
    void update(Receipt receipt);
    void insert(Receipt receipt);
    void delete(Receipt receipt);
}
