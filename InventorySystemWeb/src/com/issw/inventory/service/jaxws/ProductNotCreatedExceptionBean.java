
package com.issw.inventory.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI IBM 2.0_03-06/12/2007 07:44 PM(Raja)-fcs
 * Generated source version: 2.0_03
 * 
 */
@XmlRootElement(name = "ProductNotCreatedException", namespace = "http://service.inventory.issw.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductNotCreatedException", namespace = "http://service.inventory.issw.com/")
public class ProductNotCreatedExceptionBean {

    private String message;

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
