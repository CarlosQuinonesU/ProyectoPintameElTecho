/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.pintameeltecho.model.review;

/**
 *
 * @author Carlos
 */
public class ReviewList {

    private Nodo cabeza;
    private int tamaño;
    private String listName;

    public ReviewList(String listName) {
        this.listName = listName;
        tamaño = 0;
        cabeza = null;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void add(Review review) {
        Nodo nuevo = new Nodo(review);
        if (cabeza == null) {
            cabeza = nuevo;
            tamaño++;
        } else {
            Nodo puntero = cabeza;
            while (puntero.getSiguiente() != null) {
                puntero = puntero.getSiguiente();
            }
            puntero.setSiguiente(nuevo);
            tamaño++;
        }
    }// Fin add

    public Review getReview(int posicion) {
        if (cabeza == null) {
            return null;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < posicion && puntero.getSiguiente() != null) {
                puntero = puntero.getSiguiente();
                contador++;
            }
            if (contador != posicion) {
                return null;
            } else {
                return puntero.getReview();
            }
        }

    }// Fin getReview

    public int getTamaño() {
        return tamaño;
    }

    public void deleteReview(int posicion) {
        if (cabeza != null) {
            if (posicion == 0) {
                Nodo primer = cabeza;
                cabeza = cabeza.getSiguiente();
                primer.setSiguiente(null);
                tamaño--;
            } else {
                if (posicion < tamaño) {
                    Nodo puntero = cabeza;
                    int contador = 0;
                    while (contador < (posicion - 1)) {
                        puntero = puntero.getSiguiente();
                        contador++;
                    }
                    Nodo temp = puntero.getSiguiente();
                    puntero.setSiguiente(temp.getSiguiente());
                    temp.setSiguiente(null);
                    tamaño--;
                }
            }
        }
    }// Fin de delete

    public String toString() {
        String listData = "";
        Nodo nodo = null;
        Nodo aux = null;
        if (cabeza != null) {
            nodo = cabeza;
        }
        for (int elemento = 0; elemento < tamaño; elemento++) {

            listData += "\n" + nodo.getReview().toString();
            aux = nodo.getSiguiente();
            nodo = aux;
        }
        return listData;
    }// Fin de toString

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReviewList reviewList = (ReviewList) obj;
        return listName.equals(reviewList.listName);
    }
}// Fin de clase
