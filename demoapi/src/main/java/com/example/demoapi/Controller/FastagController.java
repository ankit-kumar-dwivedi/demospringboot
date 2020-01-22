package com.example.demoapi.Controller;

import com.example.demoapi.DTO.FastagDataDTO;
import com.example.demoapi.DTO.FilterResponseDTO;
import com.example.demoapi.DTO.VehicleFastagFilterRequest;
import com.example.demoapi.Response.CommonResponse;
import com.example.demoapi.Service.FastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/fastag")
public class FastagController {

    @Autowired
    private FastService fastService;

    @GetMapping("")
    public CommonResponse<FastagDataDTO> getVehicleFastagById(@RequestParam("fastagId") Long fastagId, @RequestParam("vehicleId")Long vehicleId){
        return fastService.getVehicleFastagById(fastagId,vehicleId);
    }

    @PostMapping("/fastagfilter")
    public CommonResponse<FastagDataDTO> postFastagFilter(@RequestParam("paged") Boolean paged, @RequestBody VehicleFastagFilterRequest request){
        return fastService.postFastagFilter(request);
    }

    @GetMapping("/id/in")
    public CommonResponse<FilterResponseDTO> getVehicleById(@RequestParam("fastagIds") List<Long> fastagId) throws ExecutionException, InterruptedException {
        return fastService.getVehicleById(fastagId);
    }
}
