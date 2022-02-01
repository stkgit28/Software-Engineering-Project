package com.example.smartfarming.controller;

import com.example.smartfarming.dto.CropDto;
import com.example.smartfarming.service.CropService;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/crop")
@RequiredArgsConstructor
public class CropController {

    final CropService cropService;

    @PostMapping("/addCrop/{sensorId}")
    public ResponseEntity<String> saveCrops(@PathVariable String sensorId, @RequestBody CropDto cropDto) throws MqttException {
        return ResponseEntity.ok().body(cropService.saveCrop(sensorId, cropDto));
    }

    @GetMapping("/showCropsUser")
    public List<CropDto> showCropsUser(Principal principal) {
        return cropService.showCropsUser(principal.getName());
    }

}
