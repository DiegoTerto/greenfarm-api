package br.com.greenfarm_api.farmer.service;

import br.com.greenfarm_api.farmer.dto.FarmerDTO;
import br.com.greenfarm_api.farmer.dto.FarmerLoginDTO;
import br.com.greenfarm_api.farmer.repository.FarmerRepository;
import br.com.greenfarm_api.user.exception.UserInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerLoginService {

    @Autowired
    private FarmerRepository farmerRepository;

    public FarmerDTO login(FarmerLoginDTO dto) {
        var farmer = farmerRepository.findByUserEmailAndUserPassword(dto.getEmail(), dto.getPassword())
                .orElseThrow(UserInvalidException::new);
        return new FarmerDTO(farmer);
    }
}
