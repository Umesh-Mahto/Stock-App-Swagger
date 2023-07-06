package com.geekster.StockApp.services;

import com.geekster.StockApp.model.Stock;
import com.geekster.StockApp.model.StockType;
import com.geekster.StockApp.repository.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepo iStockRepo;

    public List<Stock> getAllStock() {
        return (List<Stock>) iStockRepo.findAll();
    }

    public String createStock(List<Stock> stockList) {
       iStockRepo.saveAll(stockList);
        return "stocks added";
    }

    public String deleteStock(Long id) {
         iStockRepo.deleteById(id);
        return "stockId deleted Successfully";
    }

    public List<Stock> getStockByTypePriceDescSorted(StockType type) {
   return iStockRepo.findByStockTypeOrderByStockPriceDesc(type);
    }

    public List<Stock> getStockByBirthTimeDesc() {
       return iStockRepo.findByOrderByStockBirthTimeStamp();
    }

    @Transactional
    public void updateStockByType(StockType type, Float hike) {
      iStockRepo.updateStockByType(type.name(),hike);
    }
}
