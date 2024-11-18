package com.posco.carmanagement.s20a01.domain.car;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateCarCommand {

    private Long resourceId;
    private String carrierNo;
    private String worksCode;
    private String companyCode;
    private String carType;
    private String carModel;
    private String usage;
    private String fuelFlag;
    private String partCompanyCd;
    private String ownerTypeCode;
}
