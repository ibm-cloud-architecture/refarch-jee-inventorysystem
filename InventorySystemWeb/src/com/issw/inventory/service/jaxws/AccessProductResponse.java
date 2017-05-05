
package com.issw.inventory.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "accessProductResponse", namespace = "http://service.inventory.issw.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessProductResponse", namespace = "http://service.inventory.issw.com/")
public class AccessProductResponse {

    @XmlElement(name = "return", namespace = "")
    private com.issw.inventory.data.Product _return;

    /**
     * 
     * @return
     *     returns Product
     */
    public com.issw.inventory.data.Product get_return() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void set_return(com.issw.inventory.data.Product _return) {
        this._return = _return;
    }

}
