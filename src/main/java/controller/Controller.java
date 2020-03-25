package controller;

import application.BookingPageCommands;
import application.LogInPageCommands;

public class Controller {
    public void controlApp() {
        LogInPageCommands.commands();
        //BookingPageCommands.commands(1);
    }
}
