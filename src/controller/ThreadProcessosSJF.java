package controller;

import java.util.concurrent.Semaphore;

public class ThreadProcessosSJF extends Thread {

    int id;
    int tempoExecucao;
    Semaphore semaforo;

    public ThreadProcessosSJF(int id, int tempoExecucao, Semaphore semaforo) {
        this.id = id;
        this.tempoExecucao = tempoExecucao;
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            semaforo.acquire();
            execucao();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

    public void execucao() {
        System.out.println("O processo " + id + " está em execução por " + tempoExecucao + " segundos");
        int tempoMili = tempoExecucao * 1000;
        try {
            sleep(tempoMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("O processo "+ id+ " terminou a execução ");
    }
}
