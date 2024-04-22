package view;

import java.util.concurrent.Semaphore;
import java.util.Arrays;
import controller.ThreadProcessosSJF;

public class Principal {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);
        int[] temposDeExecucao = new int[21];

        for (int i = 1; i < 21; i++) {
            temposDeExecucao[i] = (int) ((Math.random() * 116) + 4);
        }

        Arrays.sort(temposDeExecucao);

        for (int id = 1; id < 21; id++) {
            ThreadProcessosSJF tc = new ThreadProcessosSJF(id, temposDeExecucao[id], semaforo);
            tc.start();
        }
    }
}
