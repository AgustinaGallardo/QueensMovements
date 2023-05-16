package ar.edu.utn.frc.tup.lciii;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.StreamSupport;

public class Queen {


    public Integer queensAttack(Integer n, Integer k, Integer r_q, Integer c_q, List<List<Integer>> obstacles) {

        Integer[][] board = new Integer[n][n]; //definimos tamaño de row y colum del board

        Integer cells = 0;

        if (k != 0) {
            for (List<Integer> obs : obstacles) {
//por cada obs(de tipo List<Integer>) dentro de la lista Obstaculos, leo los valores de la lista que tiene dos posiciones
                board[obs.get(0).intValue() - 1][obs.get(1).intValue() - 1] = 1;
            }
        }

            for (int col = c_q-1; col < board.length; col++) {
                if (col != c_q-1) { //Aca en la primera iteracion evitamos q sume al contador la posicion de la reyna
                    if (board[r_q-1][col] != null) {
                        break;
                    }
                    cells++;
                }//Derecha
            }

            for (int col = c_q- 1; col >= 0; col--) {
                if (col != c_q - 1) {
                    if (board[r_q - 1][col] != null) {
                        break;
                    }
                    cells++;
                }//Izquierda
            }

            for (int row = r_q - 1; row < board.length; row++) {
                if (row != r_q - 1) {
                    if (board[row][c_q - 1] != null) {
                        break;
                    }
                    cells++;
                }//Arriba
            }

            for (int row = r_q - 1; row >= 0; row--) {
                if (row != r_q - 1) {
                    if (board[row][c_q - 1] != null) {
                        break;
                    }
                    cells++;
                }//Abajo
            }

            /*
            * iteramos por columna o fila. Ejemplo en columna
             * int rowDiagonal = r_q(declarar antes de iterar)
            * for col=c_q ..... (con incremento o decremento segun para donde se quiera validar
            * rowDiagonal+= o -=
            * if (col rowDiagonal que no haya nada y que no se pase del maximo del tablero)
            *
             */


            for(int diagonalCol = c_q-1,rowDiagonal = r_q-1 ;rowDiagonal < board.length && diagonalCol< board.length;diagonalCol++,rowDiagonal++){
             if(rowDiagonal != r_q-1 && diagonalCol != c_q-1){
                    if(board[rowDiagonal][diagonalCol]!=null){
                        break;
                    }
                    cells++;
                }
            } // derecha arriba


            for(int diagonalCol = c_q-1,rowDiagonal = r_q-1 ;rowDiagonal < board.length && diagonalCol>=0;diagonalCol--,rowDiagonal++){
              if(rowDiagonal != r_q-1 && diagonalCol != c_q-1){
                    if(board[rowDiagonal][diagonalCol]!=null){
                        break;
                    }
                    cells++;
                }
            } // Izquierda arriba


            for(int diagonalCol = c_q-1,rowDiagonal = r_q-1 ;rowDiagonal >=0 && diagonalCol< board.length;diagonalCol++,rowDiagonal--){
               if(rowDiagonal != r_q-1 && diagonalCol != c_q-1){
                    if(board[rowDiagonal][diagonalCol]!=null){
                        break;
                    }
                    cells++;
                }
            } // Derecha abajo


            for(int diagonalCol = c_q-1,rowDiagonal = r_q-1 ;rowDiagonal >= 0 && diagonalCol>=0;diagonalCol--,rowDiagonal--){
              if(rowDiagonal != r_q-1 && diagonalCol != c_q-1){
                    if(board[rowDiagonal][diagonalCol]!=null){
                        break;
                    }
                    cells++;
                }
            }//Izquierda abajo
        return cells;
    }
}