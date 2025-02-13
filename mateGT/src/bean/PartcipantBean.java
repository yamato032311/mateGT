package bean;

import java.io.Serializable;
import java.util.Date;

public class PartcipantBean implements Serializable {

    private int participantId;
    private int roomId;
    private int userId;
    private Integer entryRate;
    private Integer exitRate;
    private int userWinFlag;
    private Date roomStartTime;
    private Date roomEndTime;

    // コンストラクタ
    public PartcipantBean() {}

    // Getter & Setter
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

    public int getUserWinFlag() { return userWinFlag; }
    public void setUserWinFlag(int userWinFlag) { this.userWinFlag = userWinFlag; }

    public Date getRoomStartTime() { return roomStartTime; }
    public void setRoomStartTime(Date roomStartTime) { this.roomStartTime = roomStartTime; }

    public Date getRoomEndTime() { return roomEndTime; }
    public void setRoomEndTime(Date roomEndTime) { this.roomEndTime = roomEndTime; }
}
