package com.port.lagarto;

public class Const {
    public static final String UPLOAD_IMG_PATH = "D:/upload/images";

    public static final String LOGIN_USER = "loginUser";


    public static final String UID = "^(?=.{8,50}$)([0-9a-z]([_]?[0-9a-z])*?)@([0-9a-z][0-9a-z\\-]*[0-9a-z]\\.)?([0-9a-z][0-9a-z\\-]*[0-9a-z])\\.([a-z]{2,15})(\\.[a-z]{2})?$";
    public static final String CONTACT_FIRST = "^(010|011|016|017|018|019)$";
    public static final String CONTACT_SECOND = "^([0-9]{4})$";
    public static final String CONTACT_THIRD = "^([0-9]{4})$";


    public static boolean checkUid(String email) {
        return email.matches(UID);
    }
}
