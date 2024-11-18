package com.posco.carmanagement.s20a01.domain.car;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteCarCommand {

    private Long resourceId;
}
