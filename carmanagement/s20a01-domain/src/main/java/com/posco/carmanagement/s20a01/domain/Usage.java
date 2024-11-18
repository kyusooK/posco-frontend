package com.posco.carmanagement.s20a01.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Data
public class Usage {

    private Long id;

    private String a;

    private String b;

    private String c;
}
