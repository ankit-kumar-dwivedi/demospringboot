package com.example.demoapi.Service;

import com.example.demoapi.DTO.FastagDataDTO;
import com.example.demoapi.DTO.FilterResponseDTO;
import com.example.demoapi.DTO.VehicleFastagFilterRequest;
import com.example.demoapi.Exception.ApiException;
import com.example.demoapi.Response.CommonResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.*;


@Service
public class FastService {

    @Autowired
    private RestTemplate restTemplate;

    public <T> CommonResponse<T> restTemplateCall(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<CommonResponse<T>> type) {
        ResponseEntity<CommonResponse<T>> response = restTemplate.exchange(url, method, requestEntity, type);
        if(!response.getBody().getStatusCode().equals("200"))
        {
            throw new ApiException(response.getBody().getStatusCode(),response.getBody().getMessage());
        }
        else {
           return new CommonResponse<>(response.getBody().getData());
        }
    }
    private class ExpensiveTask<T> implements Callable<CommonResponse<T>> {

        public ExpensiveTask(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<CommonResponse<T>> type) {
            this.url = url;
            this.method = method;
            this.requestEntity = requestEntity;
            this.type = type;
        }

        private String url;
        private HttpMethod method;
        private HttpEntity<?> requestEntity;
        private ParameterizedTypeReference<CommonResponse<T>> type;


        @Override
        public CommonResponse<T> call() throws Exception {
            return restTemplateCall(url,method,requestEntity,type);
        }

    }

    public CommonResponse<FastagDataDTO> getVehicleFastagById(Long fastagId, Long vehicleId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://ocms.staging-we.com/vehicles/fastags?" + "fastagId=" + fastagId + "&vehicleId=" + vehicleId;
        HttpEntity<VehicleFastagFilterRequest> requestHttpEntity = new HttpEntity<>(null, headers);
        return restTemplateCall(url, HttpMethod.GET, requestHttpEntity, new ParameterizedTypeReference<CommonResponse<FastagDataDTO>>() {
        });
        }

    public CommonResponse<FastagDataDTO> postFastagFilter(VehicleFastagFilterRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://ocms.staging-we.com/vehicles/fastags/filter?paged=true";

        HttpEntity<VehicleFastagFilterRequest> requestHttpEntity = new HttpEntity<>(request, headers);
        return restTemplateCall(url, HttpMethod.POST, requestHttpEntity, new ParameterizedTypeReference<CommonResponse<FastagDataDTO>>() {
        });
    }

    public CommonResponse<FilterResponseDTO> getVehicleById(List<Long> fastagId) throws ExecutionException, InterruptedException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<VehicleFastagFilterRequest> requestHttpEntity = new HttpEntity<>(null, headers);
        CommonResponse<FilterResponseDTO> response = new CommonResponse<>();
        response.setData(new FilterResponseDTO());
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<fastagId.size();i+=25){
            List<Long > longList = fastagId.subList(i,i + Math.min(25, fastagId.size() - i));
            String url =  "http://ocms.staging-we.com/vehicles/fastags/id/in?fastagIds=" + StringUtils.join(longList,"&fastagIds=");
            Future<CommonResponse<FilterResponseDTO>> commonResponseFuture = executorService.submit(
                    new ExpensiveTask<FilterResponseDTO>(url, HttpMethod.GET, requestHttpEntity, new ParameterizedTypeReference<CommonResponse<FilterResponseDTO>>() {}));
            if(commonResponseFuture.get().getData().getVehicleFastags() != null)
            {
                response.getData().setVehicleFastags (commonResponseFuture.get().getData().getVehicleFastags());
            }
        }
        return response;
    }
}
