package com.example.demoapi.DTO;

import java.util.List;

public class FilterResponseDTO {

    private Integer pageNo;
    private Integer pageSize;
    private Integer totalCount;
    private List<FastagDataDTO> vehicleFastags;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<FastagDataDTO> getVehicleFastags() {
        return vehicleFastags;
    }

    public void setVehicleFastags(List<FastagDataDTO> vehicleFastags) {
        this.vehicleFastags = vehicleFastags;
    }

}
