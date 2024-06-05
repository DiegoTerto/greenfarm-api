package br.com.greenfarm_api.farmer.service;

import br.com.greenfarm_api.farmer.dto.CreateFarmerDTO;
import br.com.greenfarm_api.farmer.entity.Farmer;
import br.com.greenfarm_api.farmer.repository.FarmerRepository;
import br.com.greenfarm_api.user.exception.UserInvalidException;
import br.com.greenfarm_api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFarmerService {

    @Autowired
    private FarmerRepository farmerRepository;
    @Autowired
    private UserRepository userRepository;

    public void execute(CreateFarmerDTO dto) {
        var exists = userRepository.existsByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (exists) throw new UserInvalidException();
        var farmer = new Farmer(dto);
        farmerRepository.save(farmer);
    }
}
