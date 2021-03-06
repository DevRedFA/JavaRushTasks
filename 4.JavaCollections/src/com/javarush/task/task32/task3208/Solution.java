package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                final String DOG_BINDING_NAME = "server.dog";
                final String CAT_BINDING_NAME = "server.cat";
                Cat cat = new Cat("Vaska");
                Dog dog = new Dog("Sobaken");
                registry = LocateRegistry.createRegistry(2099);
                Remote catRem = UnicastRemoteObject.exportObject(cat, 0);
                Remote dogRem = UnicastRemoteObject.exportObject(dog, 0);
                registry.bind(DOG_BINDING_NAME, dogRem);
                registry.bind(CAT_BINDING_NAME, catRem);
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            } catch (RemoteException a) {
                a.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}