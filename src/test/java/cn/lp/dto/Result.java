package cn.lp.dto;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Data
public class Result {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime failDate = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        LocalDateTime  failDatePlus= failDate.plusMinutes(120);
        Duration duration = Duration.between(failDate,localDateTime);
        System.out.println(duration.toMinutes());
        System.out.println(failDatePlus);
        System.out.println(failDate);
    }
    private String historyNames;
    private String cancelDate;
    private String regStatus;
    private String regCapital;
    private String city;
    private String staffNumRange;
    private String bondNum;
    private List<String> historyNameList;
    private String industry;
    private String bondName;
    private String revokeDate;
    private String type;
    private String updateTimes;
    private String legalPersonName;
    private String revokeReason;
    private String compForm;
    private String regNumber;
    private String creditCode;
    private String property3;
    private String usedBondName;
    private String approvedTime;
    private String fromTime;
    private String socialStaffNum;
    private String actualCapitalCurrency;
    private String alias;
    private String companyOrgType;
    private String id;
    private String cancelReason;
    private String orgNumber;
    private String toTime;
    private String actualCapital;
    private String estiblishTime;
    private String regInstitute;
    private String businessScope;
    private String taxNumber;
    private String regLocation;
    private String regCapitalCurrency;
    private String tags;
    private String district;
    private String bondType;
    private String name;
    private String percentileScore;
    private IndustryAll industryAll;
    private String isMicroEnt;
    private String base;
}
