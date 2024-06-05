package br.com.greenfarm_api.farmer.service;

import br.com.greenfarm_api.farmer.entity.Farmer;
import br.com.greenfarm_api.farmer.exception.FarmerNotFoundException;
import br.com.greenfarm_api.farmer.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetFarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public Farmer findById(UUID id) {
        return farmerRepository.findById(id)
                .orElseThrow(FarmerNotFoundException::new);
    }
}
