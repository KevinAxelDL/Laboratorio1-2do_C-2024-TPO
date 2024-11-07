/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turnera_medica;

import Turnera_medica.BD.DBManager;
import Turnera_medica.Utiles.TableManager;

/**
 *
 * @author KevinDL
 */

public class Main {
    public static void main(String[] args) {
        TableManager tm = new TableManager();
        tm.createUserTable();
        tm.dropUserTable();
    }
}
