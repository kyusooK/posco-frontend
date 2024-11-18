package com.posco.carmanagement.s20a01.domain.car;

import com.posco.carmanagement.s20a01.domain.AcquisitionAmt;
import com.posco.carmanagement.s20a01.domain.DriverIds;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Car_table")
@Data
public class Car {

    @Id
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

    private String assetNumber;

    private String organizationName;

    @Embedded
    private Money acquisitionAmt;

    private String driverEmpNo;

    private String userName;

    private Date registDate;

    private Date reversalDate;

    private String managementNumber;

    private String type;

    private String yearTp;

    private String mdOutputValue;

    private Integer lcaHeight;

    private Long quantity;

    private Integer personCount;

    private Long standardValue;

    private Integer maxCapacity;

    private Integer shortDistance;

    private Integer laneDistance;

    private Integer loadedTravelDistance;

    private Date inspectionDate;

    private String description;

    private Date lastUpdateDate;

    private Long lastUpdatedBy;

    private Date creationDate;

    private Long createdBy;

    private String createdObjectType;

    private String createdObjectId;

    private String createdProgramId;

    private Date creationTimestamp;

    private String lastUpdatedObjectType;

    private String lastUpdatedObjectId;

    private String lastUpdateProgramId;

    private Date lastUpdateTimestamp;

    private String dataEndStatus;

    private String dataEndObjectType;

    private String dataEndObjectId;

    private String dataEndProgramId;

    private Date dataEndTimestamp;

    private Integer weight40Max;

    private Integer width40Max;

    private Integer lengthConstraintKan;

    private Long usedWeight;

    @ElementCollection
    private List<DriverId> driverIds;

    @Enumerated(EnumType.STRING)
    private Usage usage;
}
