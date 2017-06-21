package com.dh.demo.service;

import com.dh.demo.domain.Seller;
import com.dh.demo.repository.SellerRepository;
import com.dh.demo.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO sellerRequestDTO){
        sellerRepository.save(changeDTOToObject(new Seller(),sellerRequestDTO));
    }

    public void update(Long id,SellerController.SellerRequestDTO sellerRequestDTO){
        sellerRepository.save(changeDTOToObject(sellerRepository.findOne(id),sellerRequestDTO));
    }

    public void delete(long id){
        sellerRepository.delete(id);
    }

    private Seller changeDTOToObject(Seller temp , SellerController.SellerRequestDTO dto){
        temp.setName(dto.getName());
        temp.setAge(dto.getAge());
        temp.setCi(dto.getCi());
        temp.setNumCarsSold(dto.getNumCarsSold());
        return temp;
    }
}
