package uz.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookshop.entity.model.Prices;
import uz.bookshop.service.PricesService;

import java.util.Optional;

@RestController
@RequestMapping("/api/price")
public class PricesController {
    //
    @Autowired
    private PricesService pricesService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody Prices prices){
        return ResponseEntity.ok(pricesService.save(prices));
    }
    @GetMapping("/showAll")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(pricesService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showById(@RequestParam("id") Long id){
        return ResponseEntity.ok(pricesService.findById(id));
    }
    @PutMapping("/change")
    public ResponseEntity changeInfo(@RequestBody Prices prices){
        Optional<Prices> info = pricesService.findById(prices.getId());
        if(prices.getPrice() != null){
            info.get().setPrice(prices.getPrice());
        }
        return ResponseEntity.ok(pricesService.save(info.get()));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInfo(){
        return ResponseEntity.ok(pricesService.deleteAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(pricesService.deleteId(id));
    }
}
