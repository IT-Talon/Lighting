package com.trust.lighting.app;

/**
 * Created by Talon on 2018-05-31.
 */
public class AppCache {

//    private static String sToken;
//
//    private static UserInfoEntity sUserInfo;
//
//
//    public static void setUserToken(String token) {
//        sToken = token;
//        SpUtil.saveString("Token", token);
//    }
//
//    public static String getUserToken() {
//        if (sToken == null) {
//            sToken = SpUtil.getString("Token");
//        }
//
//        return sToken;
//    }
//
//
//    public static UserInfoEntity getUserInfo() {
//        if (sUserInfo == null) {
//            sUserInfo = DBManager.getInstance(WyyApplication.getInstance()).getLiteOrm().queryById(1L, UserInfoEntity.class);
//        }
//        return sUserInfo;
//    }
//
//    public static void setUserSelf(UserInfoEntity userInfo) {
//        sUserInfo = userInfo;
//        if (userInfo == null) {
//            WhereBuilder builder = WhereBuilder.create(UserInfoEntity.class).andEquals("dbId", 1L);
//            DBManager.getInstance(WyyApplication.getInstance()).getLiteOrm().delete(builder);
//        } else {
//            DBManager.getInstance(WyyApplication.getInstance()).getLiteOrm().save(userInfo);
//        }
//    }
//
//    public static void clearCache() {
//        setUserToken("");
//        sUserInfo = null;
//    }
}