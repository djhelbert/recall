package com.recall.api;

import com.recall.model.Address;
import com.recall.model.Statistics;

public class AddressResponse extends Address {

    private Statistics statistics = new Statistics();

    public AddressResponse(Address address) {
        setApartmentNum(address.getApartmentNum());
        setCity(address.getCity());
        setPostal(address.getPostal());
        setState(address.getState());
        setStreet(address.getStreet());
        setZip(address.getZip());
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
