package bean;

import java.io.Serializable;

public class CharacterBean implements Serializable {

    private int charaId;
    private String charaName;
    private String charaicon;

    // ゲッター・セッター
    public int getCharaId() { return charaId; }
    public void setCharaId(int charaId) { this.charaId = charaId; }

    public String getCharaName() { return charaName; }
    public void setCharaName(String charaName) { this.charaName = charaName; }

    public String getCharaIcon() { return charaicon; }
    public void setCharaIcon(String charaicon) { this.charaicon = charaicon; }
}
