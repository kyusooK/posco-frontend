package com.posco.carmanagement.s20a01.domain.driver;

import com.posco.carmanagement.s20a01.domain.Photo;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDriverCommand {

    private String retirementFlag;
    private Date retiredDate;
    private Photo image;
}
