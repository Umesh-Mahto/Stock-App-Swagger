package com.geekster.StockApp.controllers;

import com.geekster.StockApp.model.Stock;
import com.geekster.StockApp.model.StockType;
import com.geekster.StockApp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/stocks")
    public List<Stock>getAllStock(){
       return  stockService.getAllStock();
    }
    @PostMapping("/stock")
    public String createStock(@RequestBody List<Stock>stockList){
        return stockService.createStock(stockList);
    }
    @DeleteMapping("stocks/{id}")
    public String deleteStock(@PathVariable Long id){
        return stockService.deleteStock(id);
    }
    @GetMapping("stock/type/{type}")
    public List<Stock>getStockByTypePriceDescSorted(@PathVariable StockType type){
        return stockService.getStockByTypePriceDescSorted(type);
    }
    @GetMapping("stock/timeStamp")
    public List<Stock>getStockByBirthTimeDesc(){
        return stockService.getStockByBirthTimeDesc();
    }
    @PutMapping("stock/type/{type}/increment/{hike}")
    public String updateStockByType(@PathVariable StockType type,@PathVariable Float hike){
         stockService.updateStockByType(type,hike);
         return "updated";
    }
}
