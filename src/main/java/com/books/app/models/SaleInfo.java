package com.books.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SaleInfo {

    String country;
    String saleability;
    boolean isEbook;
    ListPrice listPrice;
    RetailPrice retailPrice;
    String buyLink;
    Offers[] offers;

    public SaleInfo() {
    }

    public SaleInfo(String country, String saleability, boolean isEbook, ListPrice listPrice, RetailPrice retailPrice,
                    String buyLink, Offers[] offers) {
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
        this.buyLink = buyLink;
        this.offers = offers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean ebook) {
        isEbook = ebook;
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

    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }

    public Offers[] getOffers() {
        return offers;
    }

    public void setOffers(Offers[] offers) {
        this.offers = offers;
    }
}
