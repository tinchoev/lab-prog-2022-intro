/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.punto1;

/**
 *
 * @author Martín
 */
public class CuentaBanco {
    private int balance = 50;

    public CuentaBanco() {
    }

    public int getBalance() {
        return balance;
    }
    
    private void retiroBancario(int retiro) {
        balance = balance - retiro;
    }
    
    public synchronized void HacerRetiro(int cantidad) throws InterruptedException {
        if (balance >= cantidad) {
            System.out.println(Thread.currentThread().getName()+ " está realizando"
                    + " retiro de: " +cantidad+ ".");
            Thread.sleep(1000);
            this.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName()+ ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName()+ ": Los fondos son de: " +this.balance);
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr. "
            +Thread.currentThread().getName());
            System.out.println("Su saldo actual es de " +this.balance);
        } //de hacer retiro
    }
}
