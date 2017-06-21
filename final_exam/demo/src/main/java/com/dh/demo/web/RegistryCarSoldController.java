package com.dh.demo.web;

import com.dh.demo.domain.RegistryCarSold;
import com.dh.demo.domain.Seller;
import com.dh.demo.service.RegistryCarSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registries")
public class RegistryCarSoldController {

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSold> getAllRegistryCarSolds(){
        return  registryCarSoldService.getAllRegistryCarSold();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRegistryCarSold(@RequestBody RegistryCarSoldRequestDTO registryCarSoldRequestDTO){
        registryCarSoldService.addRegistryCarSold(registryCarSoldRequestDTO);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateRegistryCarSold(@RequestBody RegistryCarSoldRequestDTO registryCarSoldRequestDTO,@PathVariable Long id){
        registryCarSoldService.update(id,registryCarSoldRequestDTO);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteRegistryCarSold(@PathVariable Long id){
        registryCarSoldService.delete(id);
    }

    @RequestMapping(value = "canCarsSoldBySeller/{id}",method = RequestMethod.GET)
    public Seller canCarsSoldBySeller(@PathVariable Long id){
        return registryCarSoldService.getCarsSoldBySeller(id);
    }

    public static class RegistryCarSoldRequestDTO{
        private Long sellerId;
        private Long buyerId;
        private Long carId;

        public Long getSellerId() {
            return sellerId;
        }

        public void setSellerId(Long sellerId) {
            this.sellerId = sellerId;
        }

        public Long getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(Long buyerId) {
            this.buyerId = buyerId;
        }

        public Long getCarId() {
            return carId;
        }

        public void setCarId(Long carId) {
            this.carId = carId;
        }
    }
}
