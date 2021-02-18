package ua.lviv.velykyi.vladyslav.db;

public final class Fields {
    public static final String ENTITY__ID = "id";
    public static final String ENTITY__NAME = "name";

    //EMPLOYEES
    public static final String EMPLOYEE__LOGIN = "login";
    public static final String EMPLOYEE__PASS = "password";
    public static final String EMPLOYEE__FIRST_NAME = "first_name";
    public static final String EMPLOYEE__LAST_NAME = "last_name";
    public static final String EMPLOYEE__ROLE_ID = "role_id";
    public static final String EMPLOYEE__LOCALE_ID = "locale_id";

    //RECEIPT
    public static final String RECEIPT__BILL = "bill";
    public static final String RECEIPT__EMPLOYEE_ID = "employee_id";
    public static final String RECEIPT__STATUS_ID = "status_id";

    //PRODUCT
    public static final String PRODUCT__PRICE = "price";
    public static final String PRODUCT__CATEGORY_ID = "category_id";

}
