
package com.issw.inventory.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "updateProduct", namespace = "http://service.inventory.issw.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateProduct", namespace = "http://service.inventory.issw.com/")
public class UpdateProduct {

    @XmlElement(name = "arg0", namespace = "")
    private com.issw.inventory.data.Product arg0;

    /**
     * 
     * @return
     *     returns Product
     */
    public com.issw.inventory.data.Product getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.issw.inventory.data.Product arg0) {
        this.arg0 = arg0;
    }

}
