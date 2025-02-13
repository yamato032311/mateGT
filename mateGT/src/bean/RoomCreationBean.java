package bean;

import java.io.Serializable;

public class RoomCreationBean implements Serializable {
    private int roomId;
    private String roomNum;
    private String pass;
    private int createdBy;
    private int numberApplicants;
    private Integer rateUpper;
    private Integer rateLower;
    private int roomIdentification;
    private String startedAt;
    private String finishedAt;

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getRoomNum() { return roomNum; }
    public void setRoomNum(String roomNum) { this.roomNum = roomNum; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public int getCreatedBy() { return createdBy; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }

    public int getNumberApplicants() { return numberApplicants; }
    public void setNumberApplicants(int numberApplicants) { this.numberApplicants = numberApplicants; }

    public Integer getRateUpper() { return rateUpper; }
    public void setRateUpper(Integer rateUpper) { this.rateUpper = rateUpper; }

    public Integer getRateLower() { return rateLower; }
    public void setRateLower(Integer rateLower) { this.rateLower = rateLower; }

    public int getRoomIdentification() { return roomIdentification; }
    public void setRoomIdentification(int roomIdentification) { this.roomIdentification = roomIdentification; }

    public String getStartedAt() { return startedAt; }
    public void setStartedAt(String startedAt) { this.startedAt = startedAt; }

    public String getFinishedAt() { return finishedAt; }
    public void setFinishedAt(String finishedAt) { this.finishedAt = finishedAt; }
}