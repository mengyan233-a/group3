package cn.zhentao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dto {

    private Integer stationId;
    private Integer userId;

    private BigDecimal amount;
}
