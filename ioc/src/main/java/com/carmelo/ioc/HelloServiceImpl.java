/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carmelo.ioc;


/**
 *
 * @author Carmelo Marin Abrego
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String saludar() {
        return "Hola Mundo.";
    }
    
}
