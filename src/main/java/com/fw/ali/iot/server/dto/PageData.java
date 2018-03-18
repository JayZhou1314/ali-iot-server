package com.fw.ali.iot.server.dto;

import java.util.List;
import lombok.Data;

@Data
public class PageData<T> {

    private Integer total;
    private List<T> data;

}
