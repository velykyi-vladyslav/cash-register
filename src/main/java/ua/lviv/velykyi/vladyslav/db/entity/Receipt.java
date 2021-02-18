package ua.lviv.velykyi.vladyslav.db.entity;

import java.math.BigDecimal;

public class Receipt extends Entity {
    private BigDecimal bill;
    private long employeeId;
    private long statusId;

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "bill=" + bill +
                ", employeeId=" + employeeId +
                ", statusId=" + statusId +
                '}';
    }
}
