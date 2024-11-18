package com.posco.carmanagement.s20a01.domain.car;

import com.posco.carmanagement.s20a01.domain.DriverId;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateCarCommand {

    private String carType;
    private String carModel;
    private String usage;
    private String fuelFlag;
    private String driverEmpNo;
    private String userName;
    private List<DriverId> driverIds;
}
