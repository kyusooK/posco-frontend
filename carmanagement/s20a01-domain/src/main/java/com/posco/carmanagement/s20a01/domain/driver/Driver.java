package com.posco.carmanagement.s20a01.domain.driver;

import com.posco.carmanagement.s20a01.domain.Image;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Driver_table")
@Data
public class Driver {

    @Id
    private String driverEmpNo;

    private String name;

    private String companyCode;

    private String worksCode;

    private String hrAccessLevel;

    private String supervisorType;

    private String currentJob;

    private String handPhone;

    private String licenseNumber;

    private String nationalIdentifier;

    private Long resourceId;

    private String carType;

    private String retirementFlag;

    private Date retiredDate;

    @Embedded
    private Photo image;

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
}
