package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CuentaCorrienteTest {

    static CuentaCorriente cuenta;
    static CuentaCorriente cuenta2;

    @BeforeAll
    public static void init(){
        cuenta = new CuentaCorriente("Javi", 00000, 100);
        cuenta2 = new CuentaCorriente("Javi", 00000, 100);
        System.out.println("Cuenta corriente creada");
    }

    @Test
    @DisplayName("DepositoTrue")
    void depositTrue() {
        assertEquals(true, cuenta.deposit(10), "Debe devolver verdadero al añadir 10 euros a la cuenta");
    }

    @Test
    @DisplayName("DepositoFalse")
    void depositFalse(){
        assertEquals(false,cuenta.deposit(-10), "Debe devolver false al intentar añadir una cantidad negativa");
    }

    @Test
    @DisplayName("RetirarTrue")
    void retirarTrue(){
        assertEquals(true, cuenta.withdraw(10, 1), "Debe deovlver true si la retirada es exitosa");
    }

    @Test
    @DisplayName("RetirarFalse1")
    void retirarFalse1(){
        assertEquals(false, cuenta.withdraw(-10, 1), "Debe devolver false si la cantidad a retirar es negativa");

    }

    @Test
    @DisplayName("RetirarFalse2")
    void retirarFalse2(){
        assertEquals(false, cuenta.withdraw(10, -1), "Debe devolver false si la fee introducida es negativa");
    }

    @Test
    @DisplayName("RetirarFalse3")
    void retirarFalse3(){
        assertEquals(false, cuenta.withdraw(200, 1), "Debe devolver false si la cantidad a retirar es mayor al saldo de la cuenta");
    }

    @Test
    @DisplayName("AgregarInteres")
    void agregarInteres(){
        cuenta2.addInterest();
        assertNotEquals(cuenta.getSaldo(), cuenta2.getSaldo());
    }
}
