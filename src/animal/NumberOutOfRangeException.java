/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author stephenjones
 */
public class NumberOutOfRangeException extends Exception {

    /**
     * Creates a new instance of <code>NumberOutOfRangeException</code> without
     * detail message.
     */
    public NumberOutOfRangeException() {
    }

    /**
     * Constructs an instance of <code>NumberOutOfRangeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NumberOutOfRangeException(String msg) {
        super(msg);
    }
}
