package com.sqlsamples;

public class AppStart {
    public static DatabaseConnection dbo;
    private Controller controller;


    public void initialise() {
        dbo = new DatabaseConnection();
        controller = new Controller();
    }

    public static void main(String[] args) {
        AppStart start = new AppStart();
        start.initialise();
    }
}
