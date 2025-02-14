package bean;

import java.io.Serializable;

public class PartcipantBean implements Serializable {
    private int participantId;
    private int roomId;
    private int userId;
    private Integer entryRate;
    private Integer exitRate;
    private Integer userWinFlag;
    private String roomStartTime;
    private String roomEndTime;

    public int getParticipantId() { return participantId; }
    public void setParticipantId(int participantId) { this.participantId = participantId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Integer getEntryRate() { return entryRate; }
    public void setEntryRate(Integer entryRate) { this.entryRate = entryRate; }

    public Integer getExitRate() { return exitRate; }
    public void setExitRate(Integer exitRate) { this.exitRate = exitRate; }

    public Integer getUserWinFlag() { return userWinFlag; }
    public void setUserWinFlag(Integer userWinFlag) { this.userWinFlag = userWinFlag; }

    public String getRoomStartTime() { return roomStartTime; }
    public void setRoomStartTime(String roomStartTime) { this.roomStartTime = roomStartTime; }

    public String getRoomEndTime() { return roomEndTime; }
    public void setRoomEndTime(String roomEndTime) { this.roomEndTime = roomEndTime; }
}
