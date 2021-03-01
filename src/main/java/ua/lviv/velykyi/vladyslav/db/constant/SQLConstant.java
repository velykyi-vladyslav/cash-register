package ua.lviv.velykyi.vladyslav.db.constant;

public class SQLConstant {
    public static final String SQL_SELECT = "SELECT * FROM ";

    //RECEIPTS
    public static final String SQL_RECEIPTS_UPDATE = "update receipts set bill=?, employee_id=?, status_id=? where id=?;";
    public static final String SQL_RECEIPTS_INSERT = "insert into receipts(bill, employee_id, status_id) values (?,?,?);";
    public static final String SQL_RECEIPTS_DELETE = "delete from receipts where id=?;";

    //CATEGORIES
    public static final String SQL_CATEGORIES_INSERT = "insert into categories(name) value(?);";
    public static final String SQL_CATEGORIES_UPDATE = "update categories set name=? where id=?;";
    public static final String SQL_CATEGORIES_DELETE = "delete from categories where name=?;";

    //ROLES
    public static final String SQL_ROLES_INSERT ="insert into roles(name) value(?);";
    public static final String SQL_ROLES_UPDATE ="update roles set name=? where id=?;";
    public static final String SQL_ROLES_DELETE ="delete from roles where id=?;";


    //EMPLOYEES
    public static final String SQL_EMPLOYEES_INSERT = "insert into employees(login, password, first_name, last_name," +
            " role_id, locale_id) values(?, ?, ?, ?, ?, ?);";
    public static final String SQL_EMPLOYEES_UPDATE = "update table_name set login=?, password=?, " +
            "first_name=?, last_name=?, role_id=?, locale_id=? where id=?;";
    public static final String SQL_EMPLOYEES_DELETE ="delete from employees where id=?;";

    //PRODUCTS
    public static final String SQL_PRODUCTS_INSERT = "insert into products(name, price, quantity, category_id) " +
            "values(?, ?, ?, ?);";
    public static final String SQL_PRODUCTS_UPDATE = "update products set name=?, price=?, quantity=?, category_id=? " +
            "where id=?;";
    public static final String SQL_PRODUCTS_DELETE ="delete from products where id=?;";
}


