package com.books.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Offers {

    int finskyOfferType;
    ListPrice listPrice;
    RetailPrice retailPrice;

    public Offers() {
    }

    public Offers(int finskyOfferType, ListPrice listPrice, RetailPrice retailPrice) {
        this.finskyOfferType = finskyOfferType;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
    }

    public int getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(int finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }
}
