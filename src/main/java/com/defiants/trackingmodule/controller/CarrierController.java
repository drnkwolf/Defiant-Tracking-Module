package com.defiants.trackingmodule.controller;

import com.defiants.trackingmodule.model.Carrier;
import com.defiants.trackingmodule.model.Package;
import com.defiants.trackingmodule.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class CarrierController {

    @Autowired
    private CarrierRepository carrierRepository;

    @PutMapping("/{carrierId}/updateLocation")
    public void updatePackageLocation(@PathVariable int carrierId, @RequestBody Package inputPackage) {
        Optional<Carrier> carrierOptional = carrierRepository.findById(carrierId);

        if (carrierOptional.isPresent()) {
            Carrier carrier = carrierOptional.get();
            Set<Package> packageSet = carrier.getPackages();

            for (Package p :
                    packageSet) {
                if (p.getId() == inputPackage.getId()) {
                    p.setCurrentLocation(inputPackage.getCurrentLocation());
                }
            }

            carrier.setPackages(packageSet);

            carrierRepository.save(carrier);
        }
    }

    @PutMapping("/{carrierId}/updateAllLocations")
    public void updateAllPackageLocation(@PathVariable int carrierId, @RequestBody Set<Package> inputPackageSet) {
        Optional<Carrier> carrierOptional = carrierRepository.findById(carrierId);

        if (carrierOptional.isPresent()) {
            Carrier carrier = carrierOptional.get();

            Set<Package> packageSet = carrier.getPackages();

            for (Package packages :
                    packageSet) {
                for (Package inputPack :
                        inputPackageSet) {
                    if (packages.getId() == inputPack.getId()){
                        packages.setCurrentLocation(inputPack.getCurrentLocation());
                    }
                }
            }

            carrier.setPackages(packageSet);

            carrierRepository.save(carrier);
        }
    }
}
