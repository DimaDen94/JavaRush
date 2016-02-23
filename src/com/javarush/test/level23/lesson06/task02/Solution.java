package com.javarush.test.level23.lesson06.task02;

public class Solution {

    /* Рефакторинг
    Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
    Запретите наследоваться от Constants.
    */
    public final static class Constants {
        final static String ServerIsNotAccessibleForNow = "Server is not accessible for now.";
        final static String UserIsNoAuthorized  = "User is not authorized.";
        final static String UserIsBanned  = "User is banned.";
        final static String AccessIsDenied  = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {

        public ServerNotAccessibleException() {
            super(Constants.ServerIsNotAccessibleForNow);
        }
        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.ServerIsNotAccessibleForNow, cause);
        }

    }
    public class UnauthorizedUserException extends Exception {

        public UnauthorizedUserException() {
            super(Constants.UserIsNoAuthorized);
        }
        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UserIsNoAuthorized, cause);
        }

    }
    public class BannedUserException extends Exception {

        public BannedUserException() {
            super(Constants.UserIsBanned);
        }
        public BannedUserException(Throwable cause) {
            super(Constants.UserIsBanned, cause);
        }

    }
    public class RestrictionException extends Exception {

        public RestrictionException() {
            super(Constants.AccessIsDenied);
        }
        public RestrictionException(Throwable cause) {
            super(Constants.AccessIsDenied, cause);
        }
    }
}
