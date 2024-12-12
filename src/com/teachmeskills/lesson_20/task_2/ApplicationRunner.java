package com.teachmeskills.lesson_20.task_2;

import com.teachmeskills.lesson_20.task_2.model.CarAdder;
import com.teachmeskills.lesson_20.task_2.model.CarRemover;
import com.teachmeskills.lesson_20.task_2.model.ServiceStation;

/**
 * Task 2
 * 2. There is a HUNDRED. At a service station, a maximum of a certain ring of the machine can be in service.
 * 	Create a class that will run in a separate thread and will add machines for maintenance to the service station.
 * 	Create a class that will run in a separate thread and will pick up fixed machines from the service station.
 * 	The empty maximum ring of machines available for maintenance is set in the interface for storing constants.
 * 	Use synchronized, wait, notify.
 */

public class ApplicationRunner {
    public static void main(String[] args) {
        ServiceStation serviceStation = new ServiceStation();

        Thread adderThread = new Thread(new CarAdder(serviceStation));
        Thread removerThread = new Thread(new CarRemover(serviceStation));

        adderThread.start();
        removerThread.start();
    }
}
